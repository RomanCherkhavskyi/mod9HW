package mystack;

public class MyStackTest {

    public static void main(String[] args) {
        MyStack<Object> stack = new MyStack<>();
        //add to stack
        stack.push(124);
        stack.push("qwe");
        stack.push(12l);
        stack.push(847);
        stack.push("asdQ");
        //show stack
        System.out.print("Stack element's: ");
        stack.show();
        //stack size
        System.out.println("stack.size() = " + stack.size());
        //show first stack element
        System.out.println("stack.peek() = " + stack.peek());
        //show first stack element and delete him
        System.out.println("stack.pop() = " + stack.pop());
        //stack size
        System.out.println("stack.size() = " + stack.size());
        //show stack
        System.out.print("Stack element's: ");
        stack.show();
        //remove element by index
        stack.remove(2);
        //stack size
        System.out.println("stack.size() = " + stack.size());
        //show stack
        System.out.print("Stack element's: ");
        stack.show();
        //clear stack
        stack.clear();
    }

}
