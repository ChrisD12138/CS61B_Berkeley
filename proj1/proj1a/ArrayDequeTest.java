public class ArrayDequeTest {
    public static void main(String args[]){
        isEmpty_size_addTest();
        removeTest();
    }


    public static void isEmpty_size_addTest() {
        System.out.println("running isEmpty_size_addTest");
        ArrayDeque<Integer> ad = new ArrayDeque<>();
        boolean pass = true;
        pass = ad.isEmpty()&&pass;
        ad.addFirst(1);
        ad.addFirst(2);
        ad.addLast(3);
        pass = (ad.size==3) &&pass;
        if (pass){
            System.out.println("isEmpty() and size() function passed!");
        }
        else {
            System.out.println("isEmpty() and size() function failed!");
        }
        System.out.println("we expect the ArrayDeque to be 2 1 3");
        System.out.print("And we get:");
        ad.printDeque();
    }

    public static void removeTest() {
        System.out.println("running removeTest");
        ArrayDeque<Integer> ad = new ArrayDeque<>();
        boolean pass=true;
        ad.addFirst(1);
        ad.addFirst(2);
        ad.addFirst(3);
        ad.addFirst(4);
        ad.addFirst(5);

        int r1= ad.removeFirst();
        int r2= ad.removeLast();
        pass = (r1==5) &&(r2==1)&&true;
        if (pass){
            System.out.println("removeTest passed!");
            System.out.println("we expect the ArrayDeque to be 4 3 2");
            System.out.print("And we get:");
            ad.printDeque();
        }
        else {
            System.out.println("removeTest failed!");
        }

    }

}
