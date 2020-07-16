public class LinkedListDeque<item> implements Deque<item> {
    public ItemNode<item> head;
    public int size;

    public static void main(String args[]){
        LinkedListDeque<Integer> test = new LinkedListDeque<>();
        test.addLast(1);
        test.addLast(2);
        test.addLast(3);
        test.addLast(4);
        int a = test.removeLast();
        test.printDeque();
        System.out.print(a);
    }

    public class ItemNode<item>{
        public item i;
        public ItemNode next;
        public ItemNode pre;

        public ItemNode(item ii, ItemNode n, ItemNode p){
            i= ii;
            next = n;
            pre = p;
        }
    }

    public LinkedListDeque(){
        head = null;
        size = 0;
    }

    public  LinkedListDeque(LinkedListDeque other){
        ItemNode<item> t = other.head;
        LinkedListDeque<item> tt =  new LinkedListDeque<> ();
        for(int i =0;i<other.size; ++i){
            tt.addLast(t.i);
            t = t.next;
        }
        head = tt.head;
    }
//    public item getRecursive(int index){
//        if (index == 0) return head.i;
//        return getRecursive(index-1);
//    }
    @Override
    public void addFirst(item i){
        if (head == null){
            head = new ItemNode(i,null,null);
            head.next = head;
            head.pre = head;
        }
        else {
            ItemNode t = new ItemNode(i,head,head.pre);
            head.pre.next = t;
            head.pre= t;
            head = t;
        }
        size+=1;
        return;
    }
    @Override
    public void addLast(item i){
        if (head == null) {
            head = new ItemNode(i, null, null);
            head.next = head;
            head.pre = head;
        }
        else {
            ItemNode <item> t= new ItemNode<item>(i,head,head.pre);
            head.pre.next = t;
            head.pre= t;
        }
        size += 1;
        return ;
    }
    @Override
    public boolean isEmpty(){
        return head==null;
    }
    @Override
    public int size(){
        return size;
    }
    @Override
    public void printDeque(){
        ItemNode t = head;
        for (int i=0;i<size;i++){
            System.out.print(t.i);
            System.out.print(" ");
            t = t.next;
        }
        System.out.println("");
     }
    @Override
     public item removeFirst(){
         ItemNode<item> t = head;
        if (size==0) return null;
        else if (size==1){
            head = null;
        }
        else {
            head.next.pre = head.pre;
            head.pre.next = head.next;
            head = head.next;
        }
        size -= 1;
        return t.i;
     }
    @Override
     public item removeLast(){
        ItemNode<item> t = head.pre;
        if (size==0) return null;
        else if(size ==1){
            head =null;
        }
        else {
            head.pre.pre.next = head;
            head.pre = head.pre.pre;
        }
        size -=1;
        return t.i;
     }
    @Override
     public item get(int index){
        if (index>size) return null;
        ItemNode <item>t = head;
        for (int i=0;i<index;i++){
            t = t.next;
        }
        return t.i;
     }

}
