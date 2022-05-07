package a3_array_linkedlist_stack.queue;

//不浪费那1个空间
public class LoopQueue2<E> implements Queue<E> {

    private int size;
    private int front;
    private int tail;
    private E[] data;

    public LoopQueue2(int capacity){
        data = (E[]) new Object[capacity];
        size = 0;
        front = 0;
        tail = 0;
    }

    public LoopQueue2(){
        this(10);
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int getSize() {
        return size;
    }

    public int getCapacity(){
        return data.length;
    }


    @Override
    public void enqueue(E e) {
        if(size == getCapacity())
            resize(2 * getCapacity());
        data[tail] = e;
        tail = (tail + 1) % data.length;
        size++;
    }

    private void resize(int newCapacity){
        E[] newData = (E[]) new Object[newCapacity];
        for(int i = 0; i < getSize(); i++){
            newData[i] = data[(i + front) % data.length];
        }
        front = 0;
        tail = size;
        data = newData;
    }

    @Override
    public E dequeue() {
       if(isEmpty())
           throw  new IllegalArgumentException("LoopQueue is empty");
       E ret = data[front];
       data[front] = null;
       front = (front + 1) % data.length;
       size--;
       if(size == getCapacity() / 4 && getCapacity() / 2 != 0 )
           resize(getCapacity() / 2);

       return ret;
    }

    @Override
    public E getFront() {
        if(isEmpty())
            throw  new IllegalArgumentException("LoopQueue is empty");
        return data[front];
    }


    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Queue: size = %d , capacity = %d\n", size, getCapacity()));
        sb.append("front [");
        for(int i = 0; i < size; i++ ){
            sb.append(data[(i + front) % data.length]);
            if((i + front + 1) %data.length != tail)
                sb.append(", ");
        }
        sb.append("] tail");
        return sb.toString();
    }
}
