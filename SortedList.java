package sortedlist;

import java.util.Arrays;

public class SortedList<E extends Comparable<E>> {

    private Node<E> head;  // points to the head of the list.
    private Node<E> tail;  // points to the tail of the list.
    private int size; // number of nodes (items) in the list.

    /**
     * Create a new, empty SortedList.
     */
    public SortedList() {
        head = null;
        tail = null;
        size = 0;
    }

    /**
     * Return true if this SortedList is empty, false otherwise.
     */
    public int size() {
        return size;
    }

    /**
     * Return the item at a specified index in this SortedList.
     * If index < the halfway point in the list (based on the size), the list should be traversed
     * forwards from the head.  If index > the halfway point, the traversal should start at the tail
     * and proceed in reverse.  For an index exactly halfway, you may start at either end.
     */
    public E get(int index) {
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("Index out of bounds (" + index + ") for SortedList with size=" + size);

        // Calculating the halfway point of the list
        int halfWay = size / 2;

        // If the index is smaller than halfway, traverse through the list starting at the head
        if (index < halfWay) {
            // Tracking the index of the current element
            int count = 0;
            Node<E> currNode = head;
            while (currNode != null) {
                if (count == index) {
                    return currNode.data;
                }
                count += 1;
                currNode = currNode.next;
            }
        }
        // Else if the index is bigger than halfway, traverse through the list starting at the tail
        else {
            // Tracking the index of the current element
            int count = size - 1;
            Node<E> currNode = tail;
            while (currNode != null) {
                if (count == index) {
                    return currNode.data;
                }
                count -= 1;
                currNode = currNode.prev;
            }
        }
        // This line in never executed as an element will always be returned if the index given is valid
        return null;
    }

    /**
     * Remove all the items in the SortedList.
     */
    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    /**
     * Add a new item into this SortedList.  Position will be determined automatically based on sorted order.
     * An item < head or > tail should be added in O(1) time. Other items requiring a traversal may be added
     * in O(n) time.
     * We assume this item does not already exist in the list.
     */
    public void add(E item) {
        Node<E> newNode = new Node<>();
        newNode.data = item;

        // If the list is empty, set the newNode as the head and tail
        if (size == 0) {
            head = newNode;
            tail = newNode;
        }
        // Else if the item is smaller than or equal to the head, it becomes the new head
        else if (head.data.compareTo(item) >= 0) {
            head.prev = newNode;
            newNode.next = head;
            newNode.prev = null;
            head = newNode;
        }

        // Else if the item is bigger than or equal to the tail, it becomes the new tail
        else if (tail.data.compareTo(item) <= 0) {
            tail.next = newNode;
            newNode.prev = tail;
            newNode.next = null;
            tail = newNode;
        }

        // Else traverse through the list and find the newNode's appropriate location
        else {
            Node<E> currNode = head;
            while (currNode != null) {
                // If the item is smaller than or equal to the currNode, then it's inserted as the node before
                if (currNode.data.compareTo(item) >= 0) {
                    newNode.prev = currNode.prev;
                    newNode.next = currNode;
                    currNode.prev.next = newNode;
                    currNode.prev = newNode;
                    break;
                }
                currNode = currNode.next;
            }
        }
        size++;
    }

    /**
     * Returns true if this SortedList contains item, false otherwise.
     */
    public boolean contains(E item) {
        Node<E> currNode = head;
        while (currNode != null) {
            if (currNode.data.compareTo(item) == 0) {
                return true;
            }
            currNode = currNode.next;
        }
        return false;
    }

    /**
     * Remove an item from this SortedList.  If the item occurs multiple times,
     * only one copy will be removed.
     */
    public void remove(E item) {
        // Removing an element in a list with a single element
        if (head == tail) {
            head = null;
            tail = null;
            size = 0;
        }
        // Removing the head of a list
        else if (head.data.compareTo(item) == 0) {
            head = head.next;
            head.prev = null;
            size--;
        }
        // Removing the tail of a list
        else if (tail.data.compareTo(item) == 0) {
            tail = tail.prev;
            tail.next = null;
            size--;
        }
        // Removing an element elsewhere in the list
        else {
            Node<E> currNode = head;
            while (currNode != null) {
                if (currNode.data.compareTo(item) == 0) {
                    currNode.prev.next = currNode.next;
                    currNode.next.prev = currNode.prev;
                    size--;
                }
                currNode = currNode.next;
            }
        }
    }

    /**
     * This function should return an "internal" representation of the string, which consists of the
     * list printed both head-to-tail and tail-to-head, and the size, calculated in both directions.
     * Example: For a list with the numbers 1, 2, 3, this should return "[1 2 3] size=3 [3 2 1] size=3"
     * Do this with a forwards traversal, counting the elements, followed by a backwards traversal, re-counting
     * the elements.  This is useful to detect incorrectly-pointing prev/next pointers.
     *
     * Hint: Check to make sure the forward-size and the backward-size are the same and both match the
     * size variable.  If there is a mismatch, print an error message because this is very helpful to
     * detect errors.
     *
     * (If you want, when the list is empty, you may just return "[] size=0" instead of doing the traversals.)
     */
    public String toInternalString() {
        // Creating the starter string that represents the list going forward and backward
        String forwardTraversal = "Forward traversal = [ ";
        String backwardTraversal = "Backward traversal = [ ";

        // Creating count variables to keep track of the size of the list both forward and backward
        int countForwards = 0;
        int countBackwards = 0;

        // Traversing forward through the list and adding each element at a time
        Node<E> forwardNode = head;
        while (forwardNode != null) {
            forwardTraversal += forwardNode.data + " ";
            countForwards += 1;
            forwardNode = forwardNode.next;
        }
        forwardTraversal += "] ";

        // Traversing backward through the list and adding each element at a time
        Node<E> backwardNode = tail;
        while (backwardNode != null) {
            backwardTraversal += backwardNode.data + " ";
            countBackwards += 1;
            backwardNode = backwardNode.prev;
        }
        backwardTraversal += "] ";

        // If the count variables match the size variable, there is no error and the list is correct
        if ((countBackwards == size) && (countForwards == size)) {
            return forwardTraversal + " Size = " + countForwards + " " + backwardTraversal + " Size = " + countBackwards;
        }
        // Else if the variables do not match, there is an error
        else {
            return "ERROR MESSAGE: The size variables do not match! " + forwardTraversal + " Size = " + countForwards + " " + backwardTraversal + " Size = " + countBackwards;
        }
    }

    /**
     * Return a string representation of this list from the user's perspective.
     * Should look like [item1 item2 item3...]
     */
    public String toString() {
        // Creating the starter string that represents the list
        String stringList = "[ ";

        // Traversing through the list and adding each element at a time
        Node<E> currNode = head;
        while (currNode != null) {
            stringList += currNode.data + " ";
            currNode = currNode.next;
        }
        stringList += "] ";

        return stringList;
    }

    /**
     * It is very common to have private classes nested inside other classes.  This is most commonly used when
     * the nested class has no meaning apart from being a helper class or utility class for the outside class.
     * In this case, this Node class has no meaning outside of this SortedList class, so we nest it inside here
     * so as to not prevent another class from declaring a Node class as well.
     *
     * Note that even though the members of node are public, because the class itself is private
     */
    private static class Node<E> {
        public E data = null;
        public Node<E> next = null;   // you may initialize member variables of a class when they are defined;
        public Node<E> prev = null;   // this behaves as if they were initialized in a constructor.
    }
}
