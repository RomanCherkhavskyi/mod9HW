package myarraylist;

/*
Завдання 1 - ArrayList
Напишіть свій клас MyArrayList як аналог класу ArrayList.

Можна використовувати 1 масив для зберігання даних.

Методи

add(Object value) додає елемент в кінець
remove(int index) видаляє елемент із вказаним індексом
clear() очищає колекцію
size() повертає розмір колекції
get(int index) повертає елемент за індексом

 */

public class MyArrayList<E> {


    private final int initSize = 5; //const size for init array
    private Object[] innerArray = new Object[initSize]; //create inner array
    private int counter = 0;    //count how many elements we have in array


    public void add(E value){
        if (counter == innerArray.length-1){
            resize(innerArray.length*2);
            System.out.println("Array resized, new max size = "+ innerArray.length*2);
        }
        innerArray[counter++] = value;
    }

    private void resize(int newInitSize) {
        Object[] tempArray = new Object[newInitSize];
        System.arraycopy(innerArray,0,tempArray,0,counter);
        innerArray = tempArray;
    }

    public E get(int index){
        return (E) innerArray[index];
    }

    public int size(){
        int size = 0;
        for (Object elem : innerArray) {
            if (elem != null){
                size++;
            }
        }
        return size;
    }

    public void clear(){
        for (int i = 0; i < innerArray.length-1; i++) {
            innerArray[i] = null;
        }
    }

    public void remove(int index){
        for (int i = index; i < counter; i++){
            innerArray[i] = innerArray[i+1];
        }
        innerArray[counter] = null;


    }

    public void show(){
     for (Object item : innerArray) {
         if (item != null){
             System.out.print(item + " ");
         }
     }
     System.out.println();
     }
}



