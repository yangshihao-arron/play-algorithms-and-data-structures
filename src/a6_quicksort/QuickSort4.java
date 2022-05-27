package a6_quicksort;

import java.util.Arrays;
import java.util.Random;

//三路快速排序
public class QuickSort4 {
    private QuickSort4(){}
    public static  <E extends Comparable<E>> void sort(E[] arr){
        Random random = new Random();
        sort(arr, 0, arr.length - 1, random);
    }

    private static  <E extends Comparable<E>> void sort(E[] arr, int l, int r, Random random){

        if(l >= r) return;

        //生成[l, r]之间的随机索引
        int p = random.nextInt(r - l + 1) + l;
        swap(arr, l, p);

        // arr[l + 1, lt] < v, arr[lt + 1, i - 1 ] == v, arr[gt, r] > v
        int lt = l, i = l + 1, gt = r + 1;
        while(i < gt){

            if(arr[i].compareTo(arr[l]) < 0){
                lt ++;
                swap(arr, i ,lt);
                i++;
            }else if(arr[i].compareTo(arr[l]) > 0){
                gt --;
                swap(arr, i, gt);
            }else{ //arr[i] == arr[l]
                i++;
            }
        }

        swap(arr, l, lt);
        // arr[l, lt - 1] < v, arr[lt, gt - 1 ] == v, arr[gt, r] > v
        sort(arr, l, lt - 1, random);
        sort(arr, gt, r, random);
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
        SortingHelper.sortTest("QuickSort2", arr);
        SortingHelper.sortTest("QuickSort3", arr3);
        SortingHelper.sortTest("QuickSort4", arr2);

        Integer[] arr4 = ArrayGenerator.generateRandomArray(n, 1);
        SortingHelper.sortTest("QuickSort2", arr4);
        SortingHelper.sortTest("QuickSort3", arr4);
        SortingHelper.sortTest("QuickSort4", arr4);
    }

}
