package a5_mergesort;

public class SelectionSort {

    private SelectionSort(){}

    public static void sort(int[] arr){

        //arr[0...i)是有序的;arr[i...n)是无序的
        for(int i = 0; i < arr.length; i++){
            //选择arr[i...n)中最小值的索引
            int minIndex = i;
            for(int j = i; j < arr.length; j++){
                if(arr[j] < arr[minIndex])
                    minIndex = j;
            }
            swap(arr, i, minIndex);
        }
    }

    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {

        int[] arr= {1, 4, 2, 3, 6, 5};
        SelectionSort.sort(arr);
        for(int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
}
