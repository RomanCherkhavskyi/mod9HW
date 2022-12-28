package mylinkedlist;

/*
Завдання 2 - LinkedList
Напишіть свій клас MyLinkedList як аналог класу LinkedList.

Не можна використовувати масив. Кожний елемент повинен бути окремим об'єктом-посередником (Node - нода),
що зберігає посилання на попередній та наступний елемент колекції (двозв'язний список).

Методи

add(Object value) додає елемент в кінець
remove(int index) видаляє елемент із вказаним індексом
clear() очищає колекцію
size() повертає розмір колекції
get(int index) повертає елемент за індексом
 */


class Node<E> {
    public E value;
    public Node<E> next;
    public Node<E> prev;

    public Node(Node<E> prev, E value, Node<E> next) {
        this.value = value;
        this.next = next;
        this.prev = prev;
    }
}

public class MyLinkedList<E> {

    int listSize = 0;

    Node<E> first;

    Node<E> last;

    public void add(E value){
        final Node<E> l = last;
        final Node<E> newNode = new Node<>(l,   value,   null);
        last = newNode;
        if (l == null)
            first = newNode;
        else
            l.next = newNode;
        listSize++;
    }

    public int size(){
        return listSize;                                //повертає розмір листа
    }

    public void clear(){

        for (Node<E> clean = first; clean != null;){    //поки перший елемент листа не null
            Node<E> next = clean.next;                  //виконуватиметься очистка усіх полів Node
            clean.value = null;                         //першого елемента в листі
            clean.next = null;
            clean.prev = null;
            clean = next;                               //переміщення наступного лемента листа на місце першого
        }
        first=last=null;                                //коли всі елементи очищені - вказівники посилань очищаються
        listSize = 0;                                   //а розмір листа обнуляється

    }

    public Object get(int index){
        if (index >= listSize) return "Errore index";       //якщо індекс більше ніж к-сть елементів в листі - ерор
        if (index < (listSize >> 1)) {          //якщо індекс менше половини довжини листа
            Node<E> getNode = first;                  //здійснюємо лінійний пошук від початку листа
            for (int i = 0; i < index; i++)
                getNode = getNode.next;
            return getNode.value;
        } else {                                            //якщо індекс більше половини довжини листа
            Node<E> getNode = last;                               //здійснюємо лінійний пошук з кінця листа
            for (int i = listSize - 1; i > index; i--)
                getNode = getNode.prev;
            return getNode.value;
        }
    }

    public String remove(int index){
        if (index >= listSize) return "Errore index";       //якщо індекс більше ніж к-сть елементів в листі - ерор
        Node<E> removeNode = first;
        if (index == 0){                    //якщо індекспершого елемента

            first = first.next;             //на місце першого записується другий елемент
            listSize--;

            return "first removed";
        }

        if (index == listSize-1){           //якщо індекс останнього елемента

            last = last.prev;               //передостанній стає останнім
            listSize--;

            return "last removed";
        }

        for (int i = 0; i < index; i++)             //проходимо до елемента з вказаним індексом
            removeNode = removeNode.next;               //знаходимо елемент для видалення

        removeNode.value = null;                    //значення стає null
        removeNode.prev.next = removeNode.next;     //посилання next попереднього елемента перезаписується
        removeNode.next.prev = removeNode.prev;     //посилання prev наступного елемента перезаписується
        listSize--;

        return "Element " + index + " was removed";
    }
}



