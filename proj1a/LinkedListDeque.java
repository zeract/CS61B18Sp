public class LinkedListDeque<T>{
    public class IntNode{
        public T item;
        public IntNode next;
        public IntNode prev;
        public IntNode(T i,IntNode n,IntNode p){
            item = i;
            next = n;
            prev = p;
        }
    }
    private IntNode sentinel;
    private int size;

    public  LinkedListDeque(){

        sentinel = new IntNode(null,null,null);
        size = 0;
    }
    public void addFirst(T item){
        sentinel.next = new IntNode(item,sentinel.next,sentinel.prev);
        size += 1;
    }
    public void addLast(T item){
        sentinel.prev  = new IntNode(item,null,sentinel.prev);
        size += 1;
    }
    public boolean isEmpty(){
        if (sentinel.next == null){
            return true;
        }
        return false;
    }
    public void printDeque(){
        while (sentinel.next!=null){
            IntNode p = sentinel;
            System.out.print(p.next.item);
            System.out.print(' ');
            p.next=p.next.next;
        }
    }
    public T removeFirst(){
        T i = sentinel.next.item;
        sentinel.next = sentinel.next.next;
        return i;
    }
    public T removeLast(){
        T i = sentinel.prev.item;
        sentinel.prev = sentinel.prev.prev;
        return i;
    }
    public T get(int index){
        if (index == 0){
            return sentinel.next.item;
        }
        sentinel.next = sentinel.next.next;
        return get(index-1);
    }
    public int size(){
        return size;
    }
}

