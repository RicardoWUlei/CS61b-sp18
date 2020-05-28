/** Linked list based Deque */
public class LinkedListDeque<T> {

    /** StuffNode is the single node
     * in the LinkedListDeque. */
    public static class StuffNode<T>{
        public StuffNode front;
        public T item;
        public StuffNode next;

        /** Constructor for StuffNode. */
        public StuffNode(StuffNode f,T i,StuffNode n){
            front = f;
            item = i;
            next = n;
        }
    }

    private int size;
    private StuffNode sentinel;

    /** Constructor for LinkedListDeque */
    public LinkedListDeque(){
        sentinel = new StuffNode(null,63,null);
        sentinel.front = sentinel;
        sentinel.next = sentinel;
        size = 0;
    }

    /** Adds an item of type T to the front of deque. */
    public void addFirst(T item){
        StuffNode p = new StuffNode(sentinel,item,sentinel.next);
        sentinel.next.front = p;
        sentinel.next = p;
        size += 1;
    }

    /** Adds an item of type T to the back of deque. */
    public void addLast(T item){
        StuffNode p = new StuffNode(sentinel.front,item,sentinel);
        sentinel.front.next = p;
        sentinel.front = p;
        size += 1;
    }

    /** Returns true if deque is empty, false otherwise.*/
    public boolean isEmpty(){
        if (size == 0)
            return true;
        else
            return false;
    }

    /** Returns the number of items in the deque. */
    public int size(){
        return size;
    }

    /** Prints the items in the deque from
     * first to last, separated by a space.*/
    public void printDeque(){
        StuffNode p = sentinel.next;
        while (p != sentinel){
            System.out.print(p.item);
            System.out.print(" ");
            p = p.next;
        }
    }

    /** Removes the returns the item at the
     * front of the deque. If no such item exists,
     * returns null. */
    public T removeFirst(){
        if (size==0)
            return null;
        StuffNode p = sentinel.next;
        sentinel.next.next.front = sentinel;
        sentinel.next = sentinel.next.next;
        size -= 1;
        return (T) p.item;
    }

    /** Removes and returns the item at the back of the deque.
     *  If no such item exists, returns null.*/
    public T removeLast(){
        if (size==0)
            return null;
        StuffNode p = sentinel.front;
        sentinel.front.front.next = sentinel;
        sentinel.front = sentinel.front.front;
        size -= 1;
        return (T) p.item;
    }

    /** Get the item at the given index using iteration.
     * If no such item exists, returns null.
     * Must not alter the deque!*/
    public T get(int index){
        if (index>(size-1))
            return null;
        StuffNode p = sentinel.next;
        for(int i=0;i<index;i++){
            p = p.next;
        }
        return  (T) p.item;
    }

    /** Helper method to get the given item. */
    public T get_recursive_helper(int index, StuffNode n){
        if(index==0)
            return (T) n.item;
        else
            return get_recursive_helper(index-1,n.next);
    }

    /** Get the item at the given index using recursion.
     * If no such item exists, returns null.
     * Must not alter the deque! */
    public T getRecursive(int index){
        if (index>(size-1))
            return null;
        else
            return get_recursive_helper(index,sentinel.next);
    }

    public static void main(String[] args) {
        LinkedListDeque L = new LinkedListDeque<Integer>();
        L.addFirst(10);
        L.addLast(15);
        System.out.print(L.getRecursive(1));
    }
}
