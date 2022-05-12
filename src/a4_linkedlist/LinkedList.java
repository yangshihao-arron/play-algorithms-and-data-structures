package a4_linkedlist;

public class LinkedList<E> {

    //用户不需要知道链表内部的实现结构
    private class Node{
        public E e;
        public Node next;

        public Node(E e, Node next){
            this.e = e;
            this.next = next;
        }

        public Node (E e){
            this(e,null);
        }

        public Node(){
            this(null, null);
        }

        @Override
        public String toString(){
            return e.toString();
        }
    }

    private  Node dummyHead;
    int size;

    public LinkedList(){
        dummyHead = new Node();
        size = 0;
    }

    //获取链表中元素的个数
    public int getSize(){
        return size;
    }

    //返回链表是否为空
    public boolean isEmpty(){
        return size == 0;
    }

    //在索引为index处添加元素,练习用
    public void add(int index, E e){
        if(index < 0 || index > size)
            throw new IllegalArgumentException("index is illegal");

            Node prev = dummyHead;
            for(int i = 0; i < index; i++){
                prev = prev.next;
            }
//            Node node = new Node(e);
//            node.next = prev.next;
//            prev.next = node;
            prev.next = new Node(e,prev.next);
            size ++;

    }

    //在链表头添加元素e
    public void addFirst(E e){
        add(0, e);
    }

    //在链表尾部添加元素
    public void addLast(E e){
        add(size, e);
    }

    //获得链表的第index位置处的元素，练习用
    public E get(int index){
        //索引从0开始，如果size=10，index在[0,9]是合法的
        if(index < 0 || index >= size)
            throw new IllegalArgumentException("get failed, index is illegal");
        Node cur = dummyHead.next;
        for(int i = 0; i < index; i++){
            cur = cur.next;
        }
        return cur.e;
    }

    //获得链表的第一个元素
    public E getFirst(){
        return get(0);
    }

    //获得链表最后一个元素
    public E getLast(){
        return get(size - 1);
    }

    //修改链表中的第index个位置的元素
    public void set(int index, E e){

        if(index < 0 || index >= size)
            throw new IllegalArgumentException("set failed, index is illegal");

        Node cur = dummyHead.next;
        for(int i = 0; i < index; i++){
            cur = cur.next;
        }
        cur.e = e;
    }

    //查找链表中是否有元素e
    public boolean contains(E e){

        Node cur = dummyHead.next;
        while(cur != null){
            if(cur.e.equals(e))
                return true;
            cur = cur.next;
        }
        return false;
    }

    //在链表中删除index位置的元素，返回删除的元素,练习用
    public E remove(int index){

        if(index < 0 || index >= size)
            throw new IllegalArgumentException("remove failed, index is illegal");

        Node prev = dummyHead;
        for(int i = 0; i < index; i++){
            prev = prev.next;
        }

        Node retNode = prev.next;
        prev.next = retNode.next;
        retNode.next = null;
        size--;

        return retNode.e;
    }

    //删除链表第一个元素
    public E removeFirst(){
        return remove(0);
    }

    //删除链表最后一个元素
    public E removeLast(){
        return remove(size - 1);
    }

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();

//        Node cur = dummyHead.next;
//        while(cur != null){
//            res.append(cur + "->");
//            cur = cur.next;
//        }
        for(Node cur = dummyHead.next; cur != null; cur = cur.next)
            res.append(cur.e +"->");
        res.append("NULL");
        return res.toString();
    }


}
