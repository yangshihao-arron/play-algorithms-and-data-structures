package a2_basic_sorting_algorithm.select;

public class TestPerformance {

    public static void main(String[] args) {
        int[] dataSize = {10000, 100000};
        for(int n : dataSize){
            Integer[] arr= ArrayGenerator.generateRandomArray(n,n);
            SortingHelper.sortTest("SelectionSort2",arr);
        }
    }
}
