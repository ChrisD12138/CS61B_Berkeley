/*
该API并没有正确实现resize功能，当使用resize时，我们希望原数组中溢出的部分可以自动填充到新创造的空间。如
按照12345678创建一个deque，我们得到4 5 6 7 8 1 2 3；当继续输入9时我们期望得到的是  8 9 null null null 1 2 3 4 5 6 7
而实际得到的是 4 5 6 7 8 9 2 3 null null null null,正确的resize方法需要同时考虑输出的nextfirst refractor以及题目要求的
空间利用率等因素，较为复杂。
 */
public class ArrayDeque<item> implements Deque<item>{
    int size;
    int nextfirst;
    int nextlast;
    int arraysize = 8;
    double refractor = 1.25;
    private item [] items;
    public static void main(String args[]){
        ArrayDeque<Integer> ad =  new ArrayDeque<>();
        ad.addFirst(1);
        ad.addFirst(2);
        ad.addFirst(3);
        ad.addFirst(4);
        ad.addFirst(5);
        ad.addFirst(6);
        ad.addFirst(7);
        ad.addFirst(8);
        ad.addFirst(9);

        ad.printDeque();
    }
    public ArrayDeque(){
        size = 0;
        nextfirst = 4;
        nextlast = 5;
        items = (item[]) new Object[arraysize];
    }
    private void resize(int capacity) {
        item [] a = (item[]) new Object[capacity];
        System.arraycopy(items, 0, a, 0, size);
        items = a;
    }
    @Override
    public void addFirst(item i){
        if (size==arraysize) resize((int)(arraysize*refractor));
        items [nextfirst] = i;
        size+=1;
        if (nextfirst==0) nextfirst = arraysize-1;
        else nextfirst -= 1;
    }
    @Override
    public void addLast(item i){
        if (size==arraysize) resize((int)(arraysize*refractor));
        items [nextlast] = i;
        size+=1;
        if (nextlast ==arraysize-1) nextlast = 0;
        else  nextlast+=1;
    }
    @Override
    public boolean isEmpty(){
        return size==0;
    }
    @Override
    public int size() {
        return size;
    }
    @Override
    public void printDeque(){
          for(int i = nextfirst+1;i<nextfirst+1+size;i++){
              System.out.print(items[i%arraysize]);
              System.out.print(" ");
          }
    }
    @Override
    public item removeFirst(){
        item t = items[(nextfirst+1)%arraysize];
        items[(nextfirst+1)%arraysize] = null;
        nextfirst = (nextfirst+1)%arraysize;
        size--;
        return t;
    }
    @Override
    public item removeLast(){
        item t = items[(nextlast-1+arraysize)%arraysize];
        items[(nextlast-1+arraysize)%arraysize] = null;
        nextlast = (nextlast+1)%arraysize;
        size--;
        return t;
    }
    @Override
    public item get(int index){
        return items[(nextfirst+1+index)%arraysize];
    }
}
