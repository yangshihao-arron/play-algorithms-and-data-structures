package a7_binary_search;

//非递归写法
public class BinarySearch2 {

    private BinarySearch2(){}

    public static <E extends Comparable<E>> int search(E[] data, E target){

        int l = 0, r = data.length - 1;

        //在data[l, r]的范围中寻找target
        while(l <= r){
            int mid = l + (r - l) / 2;
            if(data[mid].equals(target))
                return mid;
            else if(data[mid].compareTo(target) > 0)
                r = mid - 1;
            else
                l = mid + 1;
        }
        return -1;
    }


}
