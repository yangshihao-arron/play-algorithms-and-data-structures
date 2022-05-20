package a5_mergesort;

import java.util.Arrays;

public class MergeSort {

    private MergeSort(){}

    public static <E extends Comparable<E>> void sort(E[] arr){
        sort(arr, 0, arr.length - 1);
    }

    private static <E extends Comparable<E>> void sort(E[] arr, int l ,int r){

        if(l >= r) return;

        int mid = (r - l) / 2 + l;
        sort(arr, l, mid);
        sort(arr, mid + 1, r);
        merge(arr, l, mid, r);
    }

    private static <E extends Comparable<E>> void sort2(E[] arr, int l ,int r){

        if(l >= r) return;

        int mid = (r - l) / 2 + l;
        sort2(arr, l, mid);
        sort2(arr, mid + 1, r);
        if(arr[mid].compareTo(arr[mid + 1]) > 0)//第一个优化
            merge(arr, l, mid, r);
    }

    public static <E extends Comparable<E>> void sort2(E[] arr){
        sort2(arr, 0, arr.length - 1);
    }

    public static <E extends Comparable<E>> void sort3(E[] arr){
        sort3(arr, 0, arr.length - 1);
    }

    private static <E extends Comparable<E>> void sort3(E[] arr, int l ,int r){

       // if(l >= r) return;
        if(r - l <= 15){ //了解即可
            InsertionSort.sort(arr, l, r); //小规模，插入排序比较好
            return;
        }

        int mid = (r - l) / 2 + l;
        sort3(arr, l, mid);
        sort3(arr, mid + 1, r);
        if(arr[mid].compareTo(arr[mid + 1]) > 0)
            merge(arr, l, mid, r);
    }


    //合并两个有序的区间arr[l,mind] 和arr[mid + 1, r]
    private static <E extends Comparable<E>> void merge(E[] arr, int l, int mid, int r){
        //注意变量的偏移
        E[] temp = Arrays.copyOfRange(arr, l, r + 1);

        int i = l, j = mid + 1;

        //每轮循环为arr[k]赋值
        for(int k = l ; k <= r; k++){
            //是否越界
            if(i > mid){
                arr[k] = temp[j - l];
                j++;
            }else if(j > r){
                arr[k] = temp[i - l];
                i++;
            }else if(temp[i -l].compareTo(temp[j-l]) <= 0){
                arr[k] = temp[i - l];
                i++;
            }else{
                arr[k] = temp[j - l];
                j++;
            }
        }
    }

    public static void main(String[] args) {

        int n = 100000;
        Integer[] arr = ArrayGenerator.generateRandomArray(n, n);
        Integer[] arr2 = Arrays.copyOf(arr,arr.length);
        Integer[] arr3 = Arrays.copyOf(arr,arr.length);
        SortingHelper.sortTest("MergeSort",arr);
        SortingHelper.sortTest("MergeSort2",arr2);
        SortingHelper.sortTest("MergeSort3",arr3);

    }

}
