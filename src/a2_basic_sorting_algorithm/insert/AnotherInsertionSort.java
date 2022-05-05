package a2_basic_sorting_algorithm.insert;

public class AnotherInsertionSort {

    private AnotherInsertionSort() {
    }

    public static <E extends Comparable<E>> void sort(E[] arr) {
        //arr[0,i)未排序， arr[i, n)已排序
        for (int i = arr.length - 1; i >= 0; i--) {
            E t = arr[i];
            int j;
            for (j = i; j < arr.length - 1 && t.compareTo(arr[j + 1]) > 0; j++)
                arr[j] = arr[j + 1];
            arr[j] = t;
        }

    }

    public static void main(String[] args) {

        int[] dataSize = {10000, 100000};
        for (int n : dataSize) {
            Integer[] arr = ArrayGenerator.generateRandomArray(n, n);
            SortingHelper.sortTest("AnotherInsertionSort", arr);
        }
    }
}
