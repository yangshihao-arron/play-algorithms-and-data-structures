package a2_basic_sorting_algorithm.select;

public class SelectionSort3 {
    private SelectionSort3(){}

    //arr[i,n)已排序， arr[0, i)未排序
    public static <E extends Comparable<E>> void sort(E[] arr){
        System.out.println("select3");
        for(int i = arr.length - 1; i > 0; i--){
            int maxIndex = i;
            for(int j = i; j >= 0 ; j--){
                if(arr[j].compareTo(arr[maxIndex]) > 0)
                    maxIndex = j;
            }
            swap(arr, i, maxIndex);
        }
    }


    public static <E> void swap(E[] arr, int i, int j){
        E temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {

        Integer[] arr = ArrayGenerator.generateRandomArray(10000,10000);
        SortingHelper.sortTest("SelectionSort3",arr);
    }

}
