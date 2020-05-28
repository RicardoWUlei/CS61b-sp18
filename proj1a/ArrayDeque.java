/* Array based doubly list*/
public class ArrayDeque<T> {
    private T[] items;
    private int size;
    private int nextFirst;
    private int nextLast;

    /** Construction Method for an empty list.
     *  Starting length of array is 8. */
    public ArrayDeque() {
        items = (T[]) new Object[8];
        size = 0;
        nextFirst = 0;
        nextLast = 1;
    }

    /** Resize the list to the target length. */
    private void resize(int target) {
        T[] a = (T[]) new Object[target];
        for (int i = 1; i <= size; i++) {
            a[i] = items[(nextFirst + i) % items.length];
        }
        items = a;
        nextLast = (size + 1) % items.length;
        nextFirst = 0;
    }

    /** Adds an item of type T to the front
     *  of the deque. */
    public void addFirst(T item) {
        if (size == items.length) {
            resize(size * 2);
        }
        items[nextFirst % items.length] = item;
        nextFirst = (nextFirst - 1 + items.length) % items.length;
        size += 1;
    }

    /** Adds an item of type T to the back
     *  of the deque. */
    public void addLast(T item) {
        if (size == items.length) {
            resize(size * 2);
        }
        items[nextLast % items.length] = item;
        nextLast = (nextLast + 1) % items.length;
        size += 1;
    }

    /** Returns true if deque is empty, false otherwise.*/
    public boolean isEmpty() {
        return (size == 0);
    }

    /** Returns the number of items in the deque. */
    public int size() {
        return size;
    }

    /** Prints the items in the deque from first
     * to last, separated by a space. */
    public void printDeque() {
        for (int i = nextFirst + 1; i < size + nextFirst + 1; i++) {
            System.out.print(items[i % items.length]);
            System.out.print(" ");
        }
    }

    /** Removes and returns the item at the front of the deque.
     *  If no such item exists, returns null. */
    public T removeFirst() {
        if (size == 0) {
            return null;
        } else {
            T result = items[(nextFirst + 1) % items.length];
            items[(nextFirst + 1) % items.length] = null;
            nextFirst = (nextFirst + 1) % items.length;
            size -= 1;
//            if ((double) (size) / items.length < 0.25) {
//                resize((int) (items.length * 0.25) + 1);
//            }
            return result;
        }
    }

    /** Removes and returns the item at the back of the deque.
     *  If no such item exists, returns null. */
    public T removeLast() {
        if (size == 0) {
            return null;
        } else {
            T result = items[(nextLast - 1 + items.length) % items.length];
            items[(nextLast - 1 + items.length) % items.length] = null;
            nextLast = (nextLast - 1 + items.length) % items.length;
            size -= 1;
//            if ((double) (size) / items.length < 0.25) {
//                resize((int) (items.length * 0.25) + 1);
//            }
            return result;
        }
    }

    /** Gets the item at the given index, where 0 is the front, 1 is the next item, and so forth.
     * If no such item exists, returns null. Must not alter the deque!*/
    public T get(int index) {
        if (index > (size - 1)) {
            return null;
        } else {
            return items[(nextFirst + 1 + index) % items.length];
        }
    }


    public static void main(String[] args) {
        ArrayDeque A = new ArrayDeque<Integer>();
        A.addLast(0);
        A.addLast(1);
        A.addLast(2);
        A.addLast(3);
        A.addLast(4);
        A.addLast(5);
        A.addLast(6);
        A.addLast(7);
        A.addLast(8);
//        A.addLast(9);
        System.out.println(A.removeFirst());
        System.out.println(A.removeLast());
        A.printDeque();
    }
}
