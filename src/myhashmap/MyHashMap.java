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
public class MyHashMap<K,V> {
    // Початкова ємність мапи
    private final int DEFAULT_INITIAL_CAPACITY = 16;
    // коефіцієнт завантаження
    private final float DEFAULT_LOAD_FACTOR = 0.75f;
    // створення бакетів - 16 штук
    Node[] table = new Node[DEFAULT_INITIAL_CAPACITY];
    // к-сть елементів в мапі
    private  int size = 0;

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public Object put(Object key, Object value) {
        // Розрахунок хеш значення ключа
        int hashValue = hash(key);
        // Розрахунок місця збереження
        int i = indexFor(hashValue,table.length);
        // якщо на позиції i є дані і ключ такий же, перезаписуємо дані
        for(Node node = table[i];node != null; node = node.next){
            Object k;
            if(node.hash == hashValue && ((k = node.key)==key||key.equals(k))){
                Object oldValue = node.value;
                node.value = value;
                return  oldValue;
            }
        }
        // якщо на позиції i дані відсутні або дані є але ключ не збігається добавляємо нову ноду
        addNode(key,value,hashValue,i);
        return null;
    }


    public Object get(Object key) {
        // Розрахунок хеш значення ключа
        int hashValue = hash(key);
        // По значенню хеша і довжині table отримуємо індекс для вставки даних
        int i = indexFor(hashValue,table.length);
        for(Node node = table[i];node != null;node = node.next){
            if(node.key.equals(key) && hashValue == node.hash){
                return node.value;
            }
        }
        return null;
    }

    // Запис даних в мапу
    // hashvalue - хеш-значення ключа
    // і - позиція вставки даних
    public void addNode(Object key, Object value, int hashValue, int i){
        // перевірка чи довжина масиву table не перевищує ємність мапи
        if(++size >= table.length * DEFAULT_LOAD_FACTOR){
            Node[] newTable = new Node[table.length << 1];
            transfer(table,newTable);
            table = newTable;
        }
        // отримуємо дані в i
        Node eNode = table[i];
        // додаємо нову ноду, вказуємо її зв'язок з попередньою
        table[i] = new Node(hashValue,key,value,eNode);
    }

    public void transfer (Node [] src, Node [] newTable) {
        int newCapacity = newTable.length;
        for (int j = 0; j <src.length; j ++) {
            Node e = src [j];                               // отримуємо кожен елемент
            if (e != null) {
                src [j] = null;
                do {
                    Node next = e.next;
                    int i = indexFor (e.hash, newCapacity);
                    e.next = newTable [i];
                    newTable [i] = e;
                    e = next;
                } while (e != null);
            }
        }
    }


    // розрахунок позиції вставки
    public int indexFor(int hashValue,int length){
        return hashValue % length;
    }

    public int hash(Object key){
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }

    static class Node<K,V>  {
        int hash;
        K key;
        V value;
        Node next;
        Node(int hash,K key,V value,Node next){
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }
    }



    public void clear(){
        for (int i = 0; i < table.length-1; i++) {
            for(Node node = table[i];node != null; node = node.next){
                Object k;
                if(node.value != null ){
                    node.value = null;
                }
            }
        }
        size = 0;
    }

    public void remove(Object key){
        int hashValue = hash(key);
        int i = indexFor(hashValue,table.length);
        for(Node node = table[i];node != null; node = node.next){
            Object k;
            if(node.hash == hashValue && ((k = node.key)==key||key.equals(k))){
                node.value = null;
                size--;
            }
        }

    }
}

