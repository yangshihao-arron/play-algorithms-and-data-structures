package a5_mergesort;

import a2_basic_sorting_algorithm.insert.ArrayGenerator;
import a2_basic_sorting_algorithm.insert.SortingHelper;

public class InsertionSort {

    private InsertionSort() {}

    //arr[0,i)已排序， arr[i, n) 未排序
    public static <E extends Comparable<E>> void sort(E[] arr){
        for(int i = 0; i < arr.length; i ++){
            E t = arr[i];
            int j;
            for(j = i; j > 0 && t.compareTo(arr[j - 1 ]) < 0; j--){
                arr[j] = arr[j-1];
            }
            arr[j] = t;
        }
    }

    public static <E extends Comparable<E>> void sort(E[] arr, int l, int r){
        for(int i = l; i <= r; i ++){
            E t = arr[i];
            int j;
            for(j = i; j - 1 >= l && t.compareTo(arr[j - 1 ]) < 0; j--){
                arr[j] = arr[j-1];
            }
            arr[j] = t;
        }
    }
    private static <E> void swap(E[] arr, int i, int j) {
        E temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] dataSize = {10000, 100000};
        for (int n : dataSize) {
            Integer[] arr = ArrayGenerator.generateRandomArray(n, n);
            SortingHelper.sortTest("InsertionSort", arr);
        }
    }
}
