package myqueue;

/*
Завдання 3 - Queue
Написати свій клас MyQueue як аналог класу Queue, який буде працювати за принципом FIFO (first-in-first-out).

Можна робити за допомогою Node або використати масив.

Методи

add(Object value) додає елемент в кінець
clear() очищає колекцію
size() повертає розмір колекції
peek() повертає перший елемент з черги
poll() повертає перший елемент з черги і видаляє його з колекції
 */


public class MyQueue<E> {

    private final int initSize = 1; //const size for init array
    private Object[] queueArray = new Object[initSize]; //create inner array
    private int counter = 0;    //count how many elements we have in array

    public void add(E value){
        if (counter == queueArray.length-1){
            resize(queueArray.length+1);
//            System.out.println("Array resized, new max size = "+ queueArray.length+1);
        }
        queueArray[counter++] = value;
    }

    private void resize(int newInitSize) {
        Object[] tempArray = new Object[newInitSize];
        System.arraycopy(queueArray,0,tempArray,0,counter);
        queueArray = tempArray;
    }

    public int size(){
        int size = 0;
        for (Object elem : queueArray) {
            if (elem != null){
                size++;
            }
        }
        return size;
    }


    public void clear(){
        for (int i = 0; i < queueArray.length-1; i++) {
            queueArray[i] = null;
        }
    }

    public E peek(){
        return (E) queueArray[0];
    }

    public E poll(){
        E firstElem = (E) queueArray[0];

        for (int i = 0; i < queueArray.length-1; i++) {
            queueArray[i] = queueArray[i+1];
        }
        return firstElem;
    }

    public void show(){
        for (Object item : queueArray) {
            if (item != null){
                System.out.print(item + " ");
            }
        }
        System.out.println();
    }

}


