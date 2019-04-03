package main;

import list.SinglyLinkedList;

public class Main {
    public static void main(String[] args) {
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
        list.insertFirstElement(6);
        list.insertFirstElement(4);
        list.insertFirstElement(3);
        list.insertFirstElement(2);
        list.insertFirstElement(1);
        list.insertFirstElement(0);
        System.out.println(list);
        list.insertElementByIndex(5, 5);
        System.out.println(list);

        System.out.println("Размер списка = " + list.getCount());
        System.out.println("Значение первого элемента = " + list.getFirstElement());

        System.out.println("Получение значения по индексу 3: " + list.getElementByIndex(3));
        System.out.println("Старое значение по индексу 3: " + list.changeElementByIndex(3, 30));
        System.out.println(list);
        System.out.println("Получение измененного значения по индексу 3: " + list.getElementByIndex(3));

        System.out.println("Удаленное значение по индексу 3: " + list.deleteElementByIndex(3));
        System.out.println("Лист после удаления элемента: " + list);

        list.insertFirstElement(10);
        System.out.println("Лист после вставки элемента в начало списка: " + list);

        list.insertElementByIndex(100, 2);
        System.out.println("Лист после вставки элемента по индексу 2: " + list);

        list.deleteByData(0);
        System.out.println("Лист после удаления узла со значением 0: " + list);

        list.deleteFirstElement();
        System.out.println("Лист после удаления первого узла: " + list);

        list.deleteElementByIndex(2);
        System.out.println("Лист после удаления элемента по индексу 2: " + list);

        list.reverseList();
        System.out.println("Лист после разворота: " + list);

        list.copy();
        System.out.println("Копия списка: " + list);
    }
}
