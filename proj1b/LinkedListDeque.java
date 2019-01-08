public class LinkedListDeque<michigan> {
    public class DequeNode{
        public DequeNode prev;
        public michigan item;
        public DequeNode next;

        public DequeNode(DequeNode p, michigan i, DequeNode n){
            prev = p;
            item = i;
            next =n;
        }
    }

    private DequeNode sentinel;
    private int size;

    public LinkedListDeque(){
        size = 0;
        sentinel = new DequeNode(null, null, null);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
    }
    public LinkedListDeque(michigan x){
        size = 1;
        sentinel = new DequeNode(null, null, null);
        sentinel.next = new DequeNode(sentinel, x, sentinel);
        sentinel.prev = sentinel.next;
    }

    public void addFirst(michigan x){
        size += 1;
        sentinel.next.prev = new DequeNode(sentinel, x, sentinel.next);
        sentinel.next = sentinel.next.prev;
    }

    public void addLast(michigan x){
        size += 1;
        sentinel.prev.next = new DequeNode(sentinel.prev, x, sentinel);
        sentinel.prev = sentinel.prev.next;
    }

    public boolean isEmpty(){
        if(sentinel.next == sentinel){
            return true;
        }
        return false;
    }

    public int size(){
        return size;
    }

    public void printDeque(){
        DequeNode p = sentinel;
        for(int i = 0; i < size; i++){
            System.out.print(p.next.item+" ");
            p = p.next;
        }
    }

    public michigan removeFirst(){
        michigan first = sentinel.next.item;
        sentinel.next = sentinel.next.next;
        sentinel.next.prev = sentinel;
        /* alternative implemention */
        //sentinel.next.next.prev = sentinel;
        //sentinel.next = sentinel.next.next;
        return first;
    }

    public michigan removeLast(){
        michigan last = sentinel.prev.item;
        sentinel.prev = sentinel.prev.prev;
        sentinel.prev.next = sentinel;
        return last;
    }
    
    /** using iteration method */
    public michigan get(int index){
        if(index>=size){
            return null;
        }
        DequeNode p = sentinel;
        for(int i=0; i<=index; i++){
            p = p.next;
        }
        return p.item;
    }
    /** using recursion method --non-destructive */
    private michigan getRecursiveHelper(DequeNode d, int index){
        if(index == 0){
            return d.item;
        }
        return getRecursiveHelper(d.next, index-1);
    }
    public michigan getRecursive(int index){
        if(index>=size){
            return null;
        }
        return getRecursiveHelper(sentinel.next, index);
    }
}
