package a2_basic_sorting_algorithm.select;


public class SelectionSort2 {
    private SelectionSort2(){}
    //泛型约束
    public static <E extends Comparable<E>> void sort(E[] arr){

        //arr[0...i)是有序的;arr[i...n)是无序的
        for(int i = 0; i < arr.length; i++){
            //选择arr[i...n)中最小值的索引
            int minIndex = i;
            for(int j = i; j < arr.length; j++){
                if(arr[j].compareTo(arr[minIndex]) < 0)
                    minIndex = j;
            }
            swap(arr, i, minIndex);
        }
    }

    public static <E> void swap(E[] arr, int i, int j){
        E temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {

        Integer[] arr= {1, 4, 2, 3, 6, 5};
        SelectionSort2.sort(arr);
        for(int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");
        System.out.println();

        Student[] students = {
                new Student("a", 98),
                new Student("b", 100),
                new Student("c", 66)
        };
        SelectionSort2.sort(students);
        for(Student student : students)
            System.out.print(student + " ");
        System.out.println();
    }
}
