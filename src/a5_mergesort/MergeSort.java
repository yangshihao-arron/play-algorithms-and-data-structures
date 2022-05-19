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
        System.out.println("call ");
        sort(arr, l, mid);
        sort(arr, mid + 1, r);
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

        int n = 1000000;
        Integer[] arr = ArrayGenerator.generateRandomArray(n, n);
        MergeSort.sort(arr);
        SortingHelper.sortTest("MergeSort", arr);

    }

}
