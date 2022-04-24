package a1_linear_search;

import java.util.Objects;

public class LinearSearch1 {

    private LinearSearch1() {}

    public static <E> int search(E[] data, E target) {

        //类使用equals比较内容相等，一般情况下需要重写equals
        //8中基本类型的包装类和String不需要重写
        for (int i = 0; i < data.length; i++) {
            if (data[i].equals(target)) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Student[] students = {
                new Student("aa"),
                new Student("bb"),
                new Student("cc")
        };
        Student student = new Student("aa");
        int res = LinearSearch1.search(students, student);
        System.out.println(res);
        System.out.println(Objects.equals(students[0], student));

      /*  int[] dataSize = {1000000, 10000000};
        for(int n: dataSize) {
            Integer[] data = ArrayGenerator.generateOrderedArray(n);
            long startTime = System.nanoTime(); //以纳秒为时间戳
            //多次测量，可以排除额外因素
            for (int k = 0; k < 100; k++)
                LinearSearch1.search(data, n);
            long endTime = System.nanoTime();

            double time = (endTime - startTime) / 1000000000.0;
            System.out.println("n = " + n + ", 100 runs : " + time + "s");
        }*/
    }
}
