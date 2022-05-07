package a3_array_linkedlist_stack.queue;

public class Deque <E>{

    private E[] data;
    private int size;
    private int tail, front;

    public Deque(int capacity){
        data = (E[]) new Object[capacity];
        size = 0;
        front = 0;
        tail = 0;
    }

    public Deque(){
        this(10);
    }

    public int getSize(){
        return size;
    }

    public int getCapacity(){
        return data.length;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public void addFront(E e){
       if(size == data.length)
           resize(2 * data.length);
       front = front == 0 ? data.length - 1 : front - 1;
       data[front] = e;
       size++;
    }

    public void addLast(E e){
        if(size == data.length)
            resize(2 * data.length);
        data[tail] = e;
        tail = (tail + 1) % data.length;
        size++;
    }

    private void resize(int newCapacity){
        E[] newData = (E[]) new Object[newCapacity];
        for(int i = 0; i < size; i++){
            newData[i] = data[(i + front) % data.length];
        }
        data = newData;
        front = 0;
        tail = size;
    }

    public E getFront(){
        if(isEmpty())
            throw new IllegalArgumentException("Deque is empty");
        return data[front];
    }

    public E getLast(){
        if(isEmpty())
            throw new IllegalArgumentException("Deque is empty");
        int index = tail == 0 ? data.length - 1 : tail - 1;
        return data[index];
    }

    public E removeFront(){
        if(isEmpty())
            throw new IllegalArgumentException("Deque is empty");
        E ret = data[front];
        data[front] = null;
        size--;
        front = (front + 1) %data.length;
        if(getSize() == getCapacity() / 4 && getCapacity() / 2 != 0)
            resize(getCapacity() / 2);
        return ret;
    }

    public E removeLast(){
        if(isEmpty())
            throw new IllegalArgumentException("Deque is empty");
        tail = tail == 0 ? data.length - 1 : tail - 1;
        E ret = data[tail] = null;
        size--;
        if(size == getCapacity() / 4 && getCapacity() / 2 != 0)
            resize(getCapacity() / 2);
        return ret;
    }

    @Override
    public String toString(){

        StringBuilder res = new StringBuilder();
        res.append(String.format("Queue: size = %d , capacity = %d\n", getSize(), getCapacity()));
        res.append("front [");
        for(int i = 0 ; i < size ; i ++){
            res.append(data[(i + front) % data.length]);
            if(i != size - 1)
                res.append(", ");
        }
        res.append("] tail");
        return res.toString();
    }

    public static void main(String[] args){

        // 在下面的双端队列的测试中，偶数从队尾加入；奇数从队首加入
        Deque<Integer> dq = new Deque<>();
        for(int i = 0 ; i < 16 ; i ++){
            if(i % 2 == 0) dq.addLast(i);
            else dq.addFront(i);
            System.out.println(dq);
        }

        // 之后，我们依次从队首和队尾轮流删除元素
        System.out.println();
        for(int i = 0; !dq.isEmpty(); i ++){
            if(i % 2 == 0) dq.removeFront();
            else dq.removeLast();
            System.out.println(dq);
        }
    }

}
