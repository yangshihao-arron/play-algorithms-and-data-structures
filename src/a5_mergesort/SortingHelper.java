package a5_mergesort;

import a2_basic_sorting_algorithm.insert.AnotherInsertionSort;
import a2_basic_sorting_algorithm.insert.InsertionSort;
import a2_basic_sorting_algorithm.insert.InsertionSort3;
import a2_basic_sorting_algorithm.select.SelectionSort2;
import a2_basic_sorting_algorithm.select.SelectionSort3;

import java.lang.reflect.Method;

public class SortingHelper {

    private SortingHelper(){}

    public static <E extends Comparable<E>> boolean isSorted(E[] arr){
        for(int i = 1; i < arr.length; i++){
            if(arr[i-1].compareTo(arr[i]) > 0)
                return false;
        }
        return true;
    }
    //通过反射其实写起来更优雅
    public static <E extends Comparable<E>> void sortTest(String sortname, E[] arr){
        Long startTime = System.nanoTime();

        if("SelectionSort2".equals(sortname))
            SelectionSort2.sort(arr);
        else if("SelectionSort3".equals(sortname))
            SelectionSort3.sort(arr);
        else if("InsertionSort".equals(sortname))
            InsertionSort.sort(arr);
        else if("InsertionSort3".equals(sortname))
            InsertionSort3.sort(arr);
        else if("AnotherInsertionSort".equals(sortname))
            AnotherInsertionSort.sort(arr);
        else if("MergeSort".equals(sortname))
            MergeSort.sort(arr);

        long endTime = System.nanoTime();
        if(!isSorted(arr))
            throw new RuntimeException(sortname + " failed");
        double time = (endTime - startTime) / 1000000000.0;
        System.out.println(String.format("%s, n = %d : %f s",sortname, arr.length, time));
    }
}
