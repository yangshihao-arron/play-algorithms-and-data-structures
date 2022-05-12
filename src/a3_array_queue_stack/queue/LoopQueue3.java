package a3_array_queue_stack.queue;

//不使用size，只使用front和tail来完成LoopQueue3的所有逻辑
public class LoopQueue3<E> implements Queue<E> {

    private E[] data;
    private int front, tail;

    public LoopQueue3(int capacity){

        data = (E[]) new Object[capacity + 1];
        front = 0;
        tail = 0;
    }

    public LoopQueue3(){
        this(10);
    }

    private int getCapacity(){
        return data.length - 1;
    }

    @Override
    public int getSize() {
        return (tail + data.length - front) % data.length;
    }

    @Override
    public boolean isEmpty() {
        return tail == front;
    }

    @Override
    public void enqueue(E e) {
        if((tail + 1) % data.length == front)
            resize(getCapacity() * 2 + 1);
        data[tail] = e;
        tail = (tail + 1) % data.length;

    }

    private void resize(int newCapacity){
        E[] newData = (E[]) new Object[newCapacity];
        int sz = getSize();
        for(int i = 0; i < getSize(); i++){
            newData[i] = data[(i + front) % data.length];
        }
        data = newData;
        front = 0;
        tail = sz;
    }

    @Override
    public E dequeue() {
        if(isEmpty())
            throw new IllegalArgumentException("LoopQueue is empty");
        E ret = data[front];
        data[front] = null;
        front = (front + 1) % data.length;
        if(getSize() == getCapacity() / 4 && getCapacity() / 2 != 0)
            resize(getCapacity() / 2);
        return ret;
    }

    @Override
    public E getFront() {
        if(isEmpty())
            throw new IllegalArgumentException("LoopQueue is empty");
        return data[front];
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Queue: size = %d , capacity = %d\n", getSize(), getCapacity()));
        sb.append("front [");
        for(int i = 0; i < getSize(); i++){
            sb.append(data[(i + front) % data.length]);
            if((i + front +  1) % data.length != tail){
                sb.append(", ");
            }
        }
        sb.append("] tail");
        return sb.toString();
    }
}
