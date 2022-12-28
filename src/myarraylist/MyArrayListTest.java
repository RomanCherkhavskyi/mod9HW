package myarraylist;

public class MyArrayListTest {
    public static void main(String[] args) {
        //create MyArrayList
        MyArrayList<Object> array = new MyArrayList<>();
        //add element's in array
        array.add(23);
        array.add("asd");
        array.add('7');
        array.add(true);
        array.add(35);
        array.add("react");
        array.add(25d);
        array.add(1.75);
        //show all element's
        System.out.print("Element's of MyArrayList: ");
        array.show();      //виводить масив елементів MyArrayList
        //get some element by him index
        System.out.println("array.get(0) = " + array.get(0));
        System.out.println("array.get(3) = " + array.get(3));
        //show array size
        System.out.println("Array size = "+array.size());
        //remove element by him index
        array.remove(4);
        //show all element's
        System.out.print("Element's of MyArrayList: ");
        array.show();
        //clear array
        array.clear();
        //show all element's
        System.out.print("Element's of MyArrayList: ");
        array.show();



    }
}
