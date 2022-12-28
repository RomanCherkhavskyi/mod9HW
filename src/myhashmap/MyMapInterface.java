package myhashmap;

public interface MyMapInterface {

    // размер
    int size();
    // пусто
    boolean isEmpty();
    // Получить элементы на основе ключа
    Object get(Object key);
    // Добавить элементы
    Object put(Object key,Object value);

    // Внутренний интерфейс
    interface Node<k,v>{
        k getKey();
        v getValue();
    }

}
