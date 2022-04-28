package a2_basic_sorting_algorithm.select;

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
        long endTime = System.nanoTime();
        if(!SortingHelper.isSorted(arr))
            throw new RuntimeException(sortname + " failed");
        double time = (endTime - startTime) / 1000000000.0;
        System.out.println(String.format("%s, n = %d : %f s",sortname, arr.length, time));
    }
}
