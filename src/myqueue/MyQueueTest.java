package myqueue;

public class MyQueueTest {
    public static void main(String[] args) {

        MyQueue<Object> queue = new MyQueue<>();
        //add element's
        queue.add("win");
        queue.add(123);
        queue.add(1d);
        queue.add(1002);
        //show queue
        System.out.print("MyQueue element's: ");
        queue.show();
        //queue size
        System.out.println("queue.size() = " + queue.size());
        //show first element
        System.out.println("queue.peek() = " + queue.peek());
        //show first element and delete him
        System.out.println("queue.poll() = " + queue.poll());
        System.out.println("queue.peek() = " + queue.peek());
        //show queue
        System.out.print("MyQueue element's: ");
        queue.show();
        System.out.println("queue.size() = " + queue.size());
        //clear queue
        queue.clear();
        System.out.println("queue.size() = " + queue.size());
    }

}
