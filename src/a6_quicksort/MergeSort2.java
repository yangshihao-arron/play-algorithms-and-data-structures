package a6_quicksort;

import a5_mergesort.ArrayGenerator;
import a5_mergesort.SortingHelper;

import java.util.Arrays;

public class MergeSort2 {

    private MergeSort2(){}

    public static <E extends Comparable<E>> void sort(E[] arr){

        E[] temp = Arrays.copyOf(arr, arr.length);
        sort(arr, 0, arr.length - 1, temp);
    }

    private static <E extends Comparable<E>> void sort(E[] arr, int l ,int r, E[] temp){

        if(l >= r) return;

        int mid = (r - l) / 2 + l;
        sort(arr, l, mid,temp);
        sort(arr, mid + 1, r, temp);
        if(arr[mid].compareTo(arr[mid + 1]) > 0)
            merge(arr, l, mid, r, temp);
    }



    //合并两个有序的区间arr[l,mind] 和arr[mid + 1, r]
    private static <E extends Comparable<E>> void merge(E[] arr, int l, int mid, int r, E[] temp){

        //使用公共内存空间，避免了一直开空间
        System.arraycopy(arr, l, temp, l, r - l + 1);

        int i = l, j = mid + 1;

        //每轮循环为arr[k]赋值
        for(int k = l ; k <= r; k++){
            //是否越界
            if(i > mid){
                arr[k] = temp[j];
                j++;
            }else if(j > r){
                arr[k] = temp[i];
                i++;
            }else if(temp[i].compareTo(temp[j]) <= 0){
                arr[k] = temp[i];
                i++;
            }else{
                arr[k] = temp[j];
                j++;
            }
        }
    }

    public static void main(String[] args) {

        int n = 100000;
        Integer[] arr = ArrayGenerator.generateRandomArray(n, n);
        Integer[] arr2 = Arrays.copyOf(arr, arr.length);

        a5_mergesort.SortingHelper.sortTest("MergeSort2",arr);
        SortingHelper.sortTest("MergeSort20",arr2);


    }

}
