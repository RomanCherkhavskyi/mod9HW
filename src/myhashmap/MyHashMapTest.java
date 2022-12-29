package myhashmap;



public class MyHashMapTest {

    public static void main(String[] args) {
        MyHashMap<Integer,Integer> myHashMap = new MyHashMap<>();
        for (int i = 0; i < 20; i++) {
            myHashMap.put(i,"value: " + i);
        }
        for (int i = 0; i < 20; i++) {
            System.out.println(myHashMap.get(i));
        }
        System.out.println("myHashMap.size() = " + myHashMap.size());

//        myHashMap.clear();
        myHashMap.remove(4);
        myHashMap.remove(5);
        myHashMap.remove(3);
        myHashMap.remove(12);
        for (int i = 0; i < 20; i++) {
            System.out.println(myHashMap.get(i));
        }
        System.out.println("myHashMap.size() після remove() = " + myHashMap.size());

        myHashMap.clear();
        for (int i = 0; i < 20; i++) {
            System.out.println(myHashMap.get(i));
        }
        System.out.println("myHashMap.size() після clear() = " + myHashMap.size());


    }
}
