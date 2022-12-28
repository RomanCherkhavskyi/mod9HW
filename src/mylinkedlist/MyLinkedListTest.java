package mylinkedlist;

public class MyLinkedListTest {

    public static void main(String[] args) {
        MyLinkedList<String> list = new MyLinkedList<>();
        //add element's
        list.add("1");
        list.add("2");
        list.add("R");
        list.add("A");
        list.add("M");
        list.add("T");
        //list size
        System.out.println("List size is "+list.size());
        //get element by index
        System.out.println(list.get(0));
        System.out.println(list.get(1));
        System.out.println(list.get(2));
        System.out.println(list.get(3));
        System.out.println(list.get(4));
        System.out.println(list.get(5));
        System.out.println(list.get(6));
        //remove element by index
        System.out.println(list.remove(2));
        //get element by index
        System.out.println(list.get(0));
        System.out.println(list.get(1));
        System.out.println(list.get(2));
        System.out.println(list.get(3));
        System.out.println(list.get(4));
        System.out.println(list.get(5));
        System.out.println(list.get(6));
        //list size
        System.out.println("List size is "+list.size());

        //list clear
        list.clear();
        //list size
        System.out.println("List size is "+list.size());

    }

}
