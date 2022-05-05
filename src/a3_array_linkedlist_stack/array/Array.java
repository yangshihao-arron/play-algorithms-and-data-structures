package a3_array_linkedlist_stack.array;

public class Array<E> {

    private E[] data;
    private int size;  //数组中有多少个元素，并且size指向数组中下一个为空的元素位置

    //构造函数，传入数组的容量capacity构造Array
    public Array(int capacity){
        data = (E[])new Object[capacity];
        size = 0;
    }
    //无参数的构造函数，默认数组的容量capacity=10
    public Array(){
       this(10);
    }

    //获取数组中的元素个数
    public int getSize(){
        return size;
    }

    //获取数组的容量
    public int getCapacity(){
        return data.length;
    }

    //判断数组是否为空
    public boolean isEmpty(){
        return size == 0;
    }

    //在所有元素后添加一个元素
    public void addLast(E e){
       add(size, e);
    }

    public void addFirst(E e){
        add(0, e);
    }

    //在第index位置插入一个新元素e
    public void add(int index, E e){

        if(index < 0 || index > size)
            throw new IllegalArgumentException("add failed, index is illegal");

        if(size == data.length)
            resize(2 * data.length);

        for(int i = size - 1; i >= index; i--){
            data[i + 1] = data[i];
        }
        data[index] = e;
        size++;
    }

    //获取index索引位置的元素
    E get(int index){
        if(index < 0 || index >= size)
            throw new IllegalArgumentException("get failed, index is illegal");
        return data[index];
    }

    //修改index索引位置的元素为e
    void set(int index ,E e){
        if(index < 0 || index >= size)
            throw new IllegalArgumentException("get failed, index is illegal");
        data[index] = e;
    }

    //是否包含元素e
    public boolean contains(int e){
        for(int i = 0; i < size; i++){
            if(data[i].equals(e))
                return true;
        }
        return false;
    }

    //查找数组中元素e索引，如果不存在元素e,返回-1
    public int find(E e){
        for(int i = 0; i < size; i++){
            if(data[i].equals(e))
                return i;
        }
        return -1;
    }

    //删除index处的元素，返回删除的元素
    public E remove(int index){
        if(index < 0 || index >= size)
            throw new IllegalArgumentException("remove failed, index is illegal");

        E ret = data[index];
        for(int i = index + 1 ; i < size ; i++){
            data[i - 1] = data[i];
        }
        size--;
        data[size] = null;  //loitering objects != memory leak
        if(size == data.length / 4 && data.length / 2 != 0)
            resize(data.length / 2);
        return ret;
    }

    public E removeFirst(){
        return remove(0);
    }

    public E removeLast(){
        return remove(size - 1);
    }

    //从数组中删除元素e
    public void removeElement(E e){
        int index = find(e);
        if(index != -1)
            remove(index);
    }

    private void resize(int newCapacity){
        E[] newData = (E[])new Object[newCapacity];
        for(int i = 0; i < size; i++){
            newData[i] = data[i];
        }
        data = newData;
    }

    @Override
    public String toString(){

        StringBuilder res = new StringBuilder();
        res.append(String.format("Array: size = %d , capacity = %d\n", size, data.length));
        res.append('[');
        for(int i = 0; i < size; i++){
            res.append(data[i]);
            if(i != size - 1)
                res.append(", ");
        }
        res.append(']');
        return  res.toString();
    }

}
