package a7_binary_search;

//修改循环不变量
public class BinarySearch3 {

    private BinarySearch3(){}

    public static <E extends Comparable<E>> int search(E[] data, E target){

        int l = 0, r = data.length;

        //在data[l, r)的范围中寻找target
        while(l < r){

            int mid = l + (r - l) / 2;

            if(data[mid].equals(target))
                return mid;
            else if(data[mid].compareTo(target) > 0)
                r = mid;  //继续在data[l, mid)范围里寻找
            else
                l = mid + 1;
        }
        return -1;
    }

}
