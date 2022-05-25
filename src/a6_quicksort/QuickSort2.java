package a6_quicksort;

import java.util.Arrays;
import java.util.Random;

//为快速排序添加随机化
public class QuickSort2 {
    private QuickSort2(){}

    public static  <E extends Comparable<E>> void sort(E[] arr){
        Random random = new Random();
        sort(arr, 0, arr.length - 1);
    }

    public static  <E extends Comparable<E>> void sort(E[] arr, int l, int r){
        if(l >= r) return;
        int p = partition(arr, l, r);
        sort(arr, l, p - 1);
        sort(arr, p + 1, r);
    }

    public static  <E extends Comparable<E>> int partition(E[] arr, int l, int r){

        //生成[l, r]之间的随机索引
        int p = new Random().nextInt(r - l + 1) + l;
        swap(arr, l, p);
        //arr[l+1, j]中的元素 < arr[l]
        //arr[j + 1, i - 1]中的元素 >= arr[l]
        int j = l;
        for(int i = l + 1; i <= r; i++){
            if(arr[l].compareTo(arr[i]) >= 0){
                j++;
               swap(arr, i, j);
            }
        }
        swap(arr, l, j);
        return j;
    }

    private static <E> void swap(E[] arr, int i, int j){
        E t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public static void main(String[] args) {
        int n = 50000;
        Integer[] arr = ArrayGenerator.generateRandomArray(n, n);
        Integer[] arr2 = Arrays.copyOf(arr, arr.length);
        Integer[] arr3 = ArrayGenerator.generateOrderedArray(n);
        SortingHelper.sortTest("QuickSort1", arr);
        SortingHelper.sortTest("MergeSort20", arr2);
        SortingHelper.sortTest("QuickSort2", arr3);
    }

}
