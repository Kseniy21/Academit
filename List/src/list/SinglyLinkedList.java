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
        ListItem<T> tempListItem = getListItem(index - 1);
        if (index == 0) {
            temp = deleteFirstElement();
        } else {
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
        if (index < 0 || count <= index) {
            throw new IndexOutOfBoundsException("Элемента с таким индексом нет в списке");
        }

        if (index == 0) {
            insertFirstElement(data);
        } else {
            ListItem<T> element = getListItem(index - 1);
            ListItem<T> temp = new ListItem<>(data, element.getNext());
            element.setNext(temp);
            count++;
        }
    }

    public boolean deleteByData(T data) {
        ListItem<T> element = head;
        for (int i = 0; i < count; element = element.getNext(), i++) {
            if (Objects.equals(element.getData(), data)) {
                deleteElementByIndex(i);
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

        ListItem<T> oldFirst = head;
        head = head.getNext();
        return oldFirst.getData();

    }

    public void reverseList() {
        ListItem<T> element = head;
        ListItem<T> nextElement = head.getNext();
        element.setNext(null);

        for (int i = 0; i < count - 2; i++) {
            ListItem<T> temp = nextElement.getNext();
            nextElement.setNext(element);
            element = nextElement;
            nextElement = temp;
        }
        head = nextElement;
        head.setNext(element);
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
            sb.append(element.getData().toString()).append(", ");
        }
        sb.setLength(sb.length() - 2);
        sb.append("]");
        return sb.toString();
    }
}
