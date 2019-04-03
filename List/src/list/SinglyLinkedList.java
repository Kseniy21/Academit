package list;

import java.util.Objects;

public class SinglyLinkedList<T> {
    private ListItem<T> head;
    private int count;

    public SinglyLinkedList() {
    }

    public int getCount() {
        return count;
    }

    public T getFirstElement() {
        if (head == null) {
            throw new NullPointerException("Лист пустой");
        }
        return head.getData();
    }

    private ListItem<T> getListItem(int index) {
        ListItem<T> p = head;
        for (int i = 1; i <= index; i++) {
            p = p.getNext();
        }
        return p;
    }

    public T getElementByIndex(int index) {
        if (index < 0 || count <= index) {
            throw new IndexOutOfBoundsException("Элемента с таким индексом нет в списке");
        }

        return getListItem(index).getData();
    }

    public T changeElementByIndex(int index, T data) {
        if (index < 0 || count <= index) {
            throw new IndexOutOfBoundsException("Элемента с таким индексом нет в списке");
        }

        ListItem<T> element = getListItem(index);
        T temp = element.getData();
        element.setData(data);
        return temp;
    }

    public T deleteElementByIndex(int index) {
        if (index < 0 || count <= index) {
            throw new IndexOutOfBoundsException("Элемента с таким индексом нет в списке");
        }

        T temp;
        if (index == 0) {
            return deleteFirstElement();
        } else {
            ListItem<T> tempListItem = getListItem(index - 1);
            temp = tempListItem.getNext().getData();
            tempListItem.setNext(tempListItem.getNext().getNext());
            count--;
        }
        return temp;
    }

    public void insertFirstElement(T data) {
        head = new ListItem<T>(data, head);
        count++;
    }

    public void insertElementByIndex(T data, int index) {
        if (index < 0 || count < index) {
            throw new IndexOutOfBoundsException("Элемента с таким индексом нет в списке");
        }

        if (index == 0) {
            insertFirstElement(data);
            return;
        } else {
            ListItem<T> element = getListItem(index - 1);
            ListItem<T> temp = new ListItem<>(data, element.getNext());
            element.setNext(temp);
        }
        count++;
    }

    public boolean deleteByData(T data) {
        if (head == null) {
            return false;
        }

        if (Objects.equals(head.getData(), data)) {
            deleteFirstElement();
            return true;
        }

        for (ListItem<T> element = head, prev = null; element != null; prev = element, element = element.getNext()) {
            if (Objects.equals(element.getData(), data)) {
                if (prev == null) {
                    head = head.getNext();
                } else {
                    prev.setNext(element.getNext());
                }
                count--;
                return true;
            }
        }
        return false;
    }

    public T deleteFirstElement() {
        if (head == null) {
            throw new NullPointerException("Лист пустой");
        }

        T element = head.getData();
        head = head.getNext();
        count--;
        return element;
    }

    public void reverseList() {
        if (head == null) {
            return;
        }

        ListItem<T> prev = null;
        ListItem<T> next;
        for (ListItem<T> element = head; element != null; element = next) {
            next = element.getNext();

            element.setNext(prev);
            prev = element;
        }
        head = prev;
    }

    public SinglyLinkedList<T> copy() {
        SinglyLinkedList<T> copyList = new SinglyLinkedList<>();
        ListItem<T> copyNode = null;
        copyList.count = count;
        for (ListItem<T> link = head; link != null; link = link.getNext()) {
            if (copyNode == null) {
                copyList.head = new ListItem<>(link.getData());
                copyNode = copyList.head;
            } else {
                ListItem<T> node = new ListItem<>(link.getData());
                copyNode.setNext(node);
                copyNode = copyNode.getNext();
            }
        }
        return copyList;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (ListItem<T> element = head; element != null; element = element.getNext()) {
            sb.append(element.getData());
            if (element.getNext() != null) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
