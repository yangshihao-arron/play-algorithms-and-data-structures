package a3_array_queue_stack.queue;

public class TestLoopQueue3 {
    public static void main(String[] args) {
        LoopQueue3<Integer> queue = new LoopQueue3<>();
        for(int i = 0 ; i < 10 ; i ++){
            queue.enqueue(i);
            System.out.println(queue);

            if(i % 3 == 2){
                queue.dequeue();
                System.out.println(queue);
            }
        }
        System.out.println(queue.getSize());
    }
}
