package a2_basic_sorting_algorithm.insert;

import java.util.Arrays;

//小优化
public class InsertionSort3 {

    private InsertionSort3(){}

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

    public static void main(String[] args) {
        int[] dataSize = {10000, 100000};
        for(int n : dataSize){
            Integer[] arr= ArrayGenerator.generateRandomArray(n,n);
            Integer[] arr2= Arrays.copyOf(arr, arr.length);
            SortingHelper.sortTest("InsertionSort", arr);
            SortingHelper.sortTest("InsertionSort3", arr2);
        }
    }
}
