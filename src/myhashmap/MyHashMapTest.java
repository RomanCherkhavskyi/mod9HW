package myhashmap;

/*

Завдання 5 - HashMap
Написати свій клас MyHashMap як аналог класу HashMap.

Потрібно робити за допомогою однозв'язної Node.

Не може зберігати дві ноди з однаковими ключами.

Методи

put(Object key, Object value) додає пару ключ + значення
remove(Object key) видаляє пару за ключем
clear() очищає колекцію
size() повертає розмір колекції
get(Object key) повертає значення (Object value) за ключем
* */

public class MyHashMapTest<K,V> {

    public static void main(String[] args) {
        MyHashMap myHashMap = new MyHashMap();
        for (int i = 0; i < 20; i++) {
            myHashMap.put(i,"value: " + i);
        }
        for (int i = 0; i < 20; i++) {
            System.out.println(myHashMap.get(i));
        }
        System.out.println("myHashMap.size() = " + myHashMap.size());

    }
}
