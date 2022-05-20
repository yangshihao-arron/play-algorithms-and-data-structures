package a5_mergesort;

import java.util.Arrays;

//自底向上的归并排序
public class AnotherMergeSort {

    public static <E extends Comparable<E>> void sortBU(E[] arr){

        E[] temp = Arrays.copyOf(arr, arr.length);

        int n = arr.length;

        //遍历合并区间的长度
        for(int sz = 1; sz < n; sz += sz){
            //遍历合并的两个区间的起始位置 i
            //合并 [i, i + sz - 1] 和[ i + sz, Math.min(i + sz + sz - 1, n - 1)]
            for(int i = 0; i + sz < n ; i += sz + sz){
                if(arr[i + sz - 1].compareTo(arr[i + sz]) > 0)
                    //防止下标越界
                    merge(arr, i, i + sz - 1,Math.min(i + sz + sz - 1, n - 1), temp);
            }
        }
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

}
