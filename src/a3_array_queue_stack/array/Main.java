package a3_array_queue_stack.array;

public class Main {
    public static void main(String[] args) {

        Array<Integer> arr = new Array();
        for(int i = 0; i < 10 ; i++){
            arr.addLast(i);
        }
        System.out.println(arr);

        arr.add(1, 100);
        System.out.println(arr);
        arr.addFirst(-1);
        System.out.println(arr);
        arr.addLast(1000);
        System.out.println(arr);
        arr.remove(2);
        arr.removeFirst();
        arr.removeLast();
        System.out.println(arr);
        arr.set(0 , 1);
        System.out.println(arr);
    }
}
