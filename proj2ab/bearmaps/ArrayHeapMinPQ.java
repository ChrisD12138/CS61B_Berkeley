package bearmaps;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.NoSuchElementException;

public class ArrayHeapMinPQ <T> implements ExtrinsicMinPQ<T> {

    public class Node{
        private T item;
        private double priority;
        public Node(T t,double priority){
            this.item = t;
            this.priority = priority;
        }

        public T getT(){
            return item;
        }

        public double getPriority(){
            return priority;
        }

        public void setPriority(double new_priority){
            priority = new_priority;
        }

    }

    private ArrayList <Node> MinPQ;
    private HashMap <T,Integer> item_index;

    public ArrayHeapMinPQ(){
        MinPQ = new ArrayList<>();
        item_index = new HashMap<>();
    }
    @Override
    public boolean contains(T item) {
        return item_index.containsKey(item);
    }

    @Override
    public void add(T item, double priority){
        if (item_index.containsKey(item)){
            throw new IllegalArgumentException("input already exists");
        }
        Node n = new Node(item,priority);
        MinPQ.add(n);
        item_index.put(item,size()-1);
        climb(size() - 1);
        return;
    };

    public void swap(int k,int j){
        Node temp = MinPQ.get(k);
        Node temp2 = MinPQ.get(j);
        MinPQ.set(k,temp2);
        MinPQ.set(j,temp);
        item_index.put(temp.getT(),j);
        item_index.put(temp2.getT(),k);
    } //swap two nodes of k, j;

    public boolean smaller(int k,int j){ //node k<j
        return MinPQ.get(k).getPriority()<MinPQ.get(j).getPriority();
    }

    public void climb(int k){
        if (k==0) return;
        if (MinPQ.get(k).getPriority()<MinPQ.get(parent(k)).getPriority()){
            swap(k,parent(k));
            climb(parent(k));
        }
    }

    public void sink(int k){
        int smallest = k;
        if (leftchild(k)<=size()-1 && smaller(leftchild(k),k)) smallest = leftchild(k);
        if (rightchild(k)<=size()-1 && smaller(rightchild(k),smallest)) smallest = rightchild(k);
        if (smallest != k){
            swap(smallest,k);
            sink(smallest);
        }

    }

    public int leftchild(int k){
        return 2*k+1;
    }

    public int rightchild(int k){
        return 2*k+2;
    }

    public int parent(int k){
        return (k-1)/2;
    }

    @Override
    public int size() {
        return MinPQ.size();
    }

    @Override
    public T getSmallest(){
        return MinPQ.get(0).getT();
    }

    @Override
    public T removeSmallest() {
        swap(0,size()-1);
        item_index.remove(MinPQ.get(size() - 1).getT());
        T t = MinPQ.get(size() - 1).getT();
        MinPQ.remove(size() - 1);
        return t;
    }

    @Override
    public void changePriority(T item, double priority){
        if (!contains(item)) throw new NoSuchElementException();
        int index = item_index.get(item);
        double old_priority = MinPQ.get(index).getPriority();
        MinPQ.get(index).setPriority(priority);
        if (priority>old_priority) sink(index);
        if (priority<old_priority) climb(index);
        return ;
    };
}
