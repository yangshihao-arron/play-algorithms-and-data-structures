package a6_quicksort;

import java.util.Arrays;
import java.util.Random;

//双路快速排序
public class QuickSort3 {
    private QuickSort3(){}

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
        //arr[l+1, i - 1] <= v
        //arr[j + 1, r]  >= v
        int i = l + 1, j = r;
        while(true){
            while(i <= j && arr[i].compareTo(arr[l]) < 0){
                i++;
            }
            while(j >= i && arr[j].compareTo(arr[l]) > 0)
                j--;

            if(i >= j)  //i == j ,指向等于标定点的元素
                break;

            swap(arr, i, j);
            i++;
            j--;
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

        Integer[] arr4 = ArrayGenerator.generateRandomArray(n, 1);
        Integer[] arr5 = Arrays.copyOf(arr4, arr4.length);
        SortingHelper.sortTest("QuickSort2", arr4);
        SortingHelper.sortTest("QuickSort3", arr5);
    }

}
