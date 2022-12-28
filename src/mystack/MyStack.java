package mystack;

/*
* Завдання 4 - Stack
Написати свій клас MyStack як аналог класу Stack, який працює за принципом LIFO (last-in-first-out).

Можна робити за допомогою Node або використати масив.

Методи

push(Object value) додає елемент в кінець
remove(int index) видаляє елемент за індексом
clear() очищає колекцію
size() повертає розмір колекції
peek() повертає перший елемент стеку
pop() повертає перший елемент стеку та видаляє його з колекції
* */
class MyStack<E>{

    int length = 8;
    Object[] stackArray = new Object[length];

    int elemCount = 0;

    Object lastPushed = null;

    int lastIndex = -1;        //бо ерший індекс в масиві це 0

    public void push(Object value){
        if (elemCount == length){
            resizeStack(length*2);
        }

        for (int i = 0; i < stackArray.length-1; i++) {
            if (stackArray[i]==null){
                stackArray[elemCount]=value;
                lastPushed = value;
            }
        }
        lastIndex++;
        elemCount++;
    }

    public void resizeStack(int value){
        Object[] tempArray = new Object[value];
        System.arraycopy(stackArray,0,tempArray,0,stackArray.length);
        stackArray = tempArray;
    }

    public int size(){
        return elemCount;
    }

    public void clear(){
        for (int i = 0; i < stackArray.length-1; i++) {
            stackArray[i]=null;
        }
    }

    public E peek(){
        return (E)lastPushed;
    }

    public E pop(){
        Object result = stackArray[lastIndex];
        stackArray[lastIndex] = null;
        elemCount--;
        return (E)result;
    }

    public void   remove(int index){
        for (int i = index; i < stackArray.length-1; i++) {
            stackArray[i]=stackArray[i+1];
        }
        elemCount--;
    }
    public void show(){
        for (Object item : stackArray) {
            if (item != null){
                System.out.print(item + " ");
            }
        }
        System.out.println();
    }
}



