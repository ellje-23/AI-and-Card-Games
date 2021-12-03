package sortedlist;

public class SortedListTester {
    public static void main(String[] args)
    {
        //testAddToEnd();
        //testAddToBeginning();
        //testAddToMiddle();
        //testGet();
        //testClear();
        //testSize();
        //testContains();
        //testRemove();
        //testToString();
        testCombination();
    }

    private static void testAddToEnd() {
        // Testing adding items to end of list.
        SortedList<Integer> mylist = new SortedList<Integer>();
        System.out.println(mylist.toInternalString());
        mylist.add(10);
        System.out.println(mylist.toInternalString());
        mylist.add(20);
        System.out.println(mylist.toInternalString());
        mylist.add(21);
        System.out.println(mylist.toInternalString());
        mylist.add(21);
        System.out.println(mylist.toInternalString());
        mylist.add(30);
        System.out.println(mylist.toInternalString());
        mylist.add(39);
        System.out.println(mylist.toInternalString());
        mylist.add(40);
        System.out.println(mylist.toInternalString());
        mylist.add(60);
        System.out.println(mylist.toInternalString());
    }

    private static void testAddToBeginning() {
        // Testing adding items to the beginning of a list
        SortedList<Integer> mylist = new SortedList<Integer>();
        System.out.println(mylist.toInternalString());
        mylist.add(100);
        System.out.println(mylist.toInternalString());
        mylist.add(80);
        System.out.println(mylist.toInternalString());
        mylist.add(60);
        System.out.println(mylist.toInternalString());
        mylist.add(40);
        System.out.println(mylist.toInternalString());
        mylist.add(40);
        System.out.println(mylist.toInternalString());
        mylist.add(39);
        System.out.println(mylist.toInternalString());

    }

    private static void testAddToMiddle() {
        // Testing adding items to the middle of a list
        SortedList<Integer> mylist = new SortedList<Integer>();
        System.out.println(mylist.toInternalString());
        mylist.add(10);
        System.out.println(mylist.toInternalString());
        mylist.add(100);
        System.out.println(mylist.toInternalString());
        mylist.add(20);
        System.out.println(mylist.toInternalString());
        mylist.add(40);
        System.out.println(mylist.toInternalString());
        mylist.add(60);
        System.out.println(mylist.toInternalString());
        mylist.add(39);
        System.out.println(mylist.toInternalString());
        mylist.add(21);
        System.out.println(mylist.toInternalString());
        mylist.add(22);
        System.out.println(mylist.toInternalString());
        mylist.add(60);
        System.out.println(mylist.toInternalString());
    }

    private static void testGet() {
        // Testing getting the item at a given index
        SortedList<Integer> mylist = new SortedList<Integer>();
        mylist.add(0);
        mylist.add(1);
        mylist.add(2);
        mylist.add(3);
        mylist.add(4);
        int result1 = mylist.get(0);
        System.out.println(result1);
        int result2 = mylist.get(2);
        System.out.println(result2);
        int result3 = mylist.get(4);
        System.out.println(result3);
    }

    private static void testClear() {
        // Testing cleaing the list
        SortedList<Integer> mylist = new SortedList<Integer>();
        mylist.add(1);
        mylist.add(2);
        mylist.add(3);
        mylist.add(4);
        mylist.add(5);
        mylist.clear();
        System.out.println(mylist.toInternalString());
    }

    private static void testSize() {
        // Testing getting the size of the list
        SortedList<Integer> mylist = new SortedList<Integer>();
        mylist.add(1);
        mylist.add(2);
        mylist.add(3);
        mylist.add(4);
        mylist.add(5);
        int size = mylist.size();
        System.out.println(size);
    }

    private static void testContains() {
        // Testing if the list contains the given item
        SortedList<Integer> mylist = new SortedList<Integer>();
        mylist.add(1);
        mylist.add(2);
        mylist.add(3);
        mylist.add(4);
        mylist.add(5);
        boolean result1 = mylist.contains(1);
        System.out.println(result1);
        boolean result2 = mylist.contains(3);
        System.out.println(result2);
        boolean result3 = mylist.contains(5);
        System.out.println(result3);
        boolean result4 = mylist.contains(-1);
        System.out.println(result4);
        boolean result5 = mylist.contains(6);
        System.out.println(result5);
    }

    private static void testRemove() {
        // Testing removing a given item from the list
        SortedList<Integer> mylist = new SortedList<Integer>();
        mylist.add(0);
        mylist.add(1);
        mylist.add(2);
        mylist.add(3);
        mylist.add(4);
        mylist.remove(0);
        System.out.println(mylist.toInternalString());
        mylist.remove(2);
        System.out.println(mylist.toInternalString());
        mylist.remove(4);
        System.out.println(mylist.toInternalString());

        mylist.remove(1);
        System.out.println(mylist.toInternalString());
        mylist.remove(3);
        System.out.println(mylist.toInternalString());

        mylist.remove(5);
        System.out.println(mylist.toInternalString());
    }

    private static void testToString() {
        // Testing the toString method
        SortedList<Integer> mylist = new SortedList<Integer>();
        mylist.add(1);
        mylist.add(2);
        mylist.add(3);
        mylist.add(4);
        mylist.add(5);
        System.out.println(mylist.toString());
    }

    private static void testCombination() {
        SortedList<Integer> mylist = new SortedList<Integer>();
        mylist.add(0);
        mylist.add(1);
        mylist.add(2);
        mylist.add(3);
        mylist.add(4);
        mylist.add(5);
        System.out.println(mylist.toInternalString());

        mylist.remove(0);
        mylist.remove(2);
        mylist.remove(4);
        System.out.println(mylist.toInternalString());

        mylist.clear();
        System.out.println(mylist.toInternalString());
        boolean result = mylist.contains(1);
        System.out.println(result);

        mylist.add(1);
        mylist.add(10);
        mylist.add(5);
        mylist.add(3);
        mylist.add(7);
        System.out.println(mylist.toInternalString());

        boolean result1 = mylist.contains(1);
        System.out.println(result1);
        boolean result2 = mylist.contains(5);
        System.out.println(result2);
        boolean result3 = mylist.contains(10);
        System.out.println(result3);

        int result4 = mylist.get(0);
        System.out.println(result4);
        int result5 = mylist.get(2);
        System.out.println(result5);
        int result6 = mylist.get(4);
        System.out.println(result6);
    }
}
