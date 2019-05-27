import java.util.*;

public class MyArrayList<T> implements List<T> {
    private T[] items;
    private int size;
    private int modCount;

    public MyArrayList() {
        items = (T[]) new Object[20];
    }

    public MyArrayList(int capacity) {
        items = (T[]) new Object[capacity];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object o) {
        for (int i = 0; i < size; i++) {
            if (Objects.equals(items[i], o)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return new MyIterator();
    }

    private class MyIterator implements Iterator<T> {
        private int currentIndex = -1;
        private int modification = modCount;

        @Override
        public boolean hasNext() {
            return currentIndex + 1 < size;
        }

        @Override
        public T next() {
            if (modification != modCount) {
                throw new ConcurrentModificationException("В коллекции произошли изменения!");
            }
            if (currentIndex == size) {
                throw new NoSuchElementException("Конец коллекции.");
            }
            currentIndex++;
            return items[currentIndex];
        }
    }

    @Override
    public Object[] toArray() {
        return Arrays.copyOf(items, size);
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        System.arraycopy(items, 0, a, 0, size);
        if (a.length > size) {
            a[size] = null;
        }
        return a;
    }

    @Override
    public boolean add(T element) {
        if (items.length <= size) {
            increaseCapacity();
        }
        items[size] = element;
        size++;
        modCount++;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        for (int i = 0; i < size; i++) {
            if (Objects.equals(items[i], o)) {
                remove(i);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        for (Object element : c) {
            if (!contains(element)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        return addAll(size, c);
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Некорректный индекс!");
        }
        if (c.size() == 0) {
            return false;
        }

        ensureCapacity(c.size() + size);
        System.arraycopy(items, index, items, index + c.size(), size - index);
        int i = index;
        for (T element : c) {
            items[i] = element;
            i++;
        }
        modCount++;
        size = size + c.size();
        return true;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        if (c.size() == 0) {
            return false;
        }
        boolean removed = false;
        for (int i = 0; i < size; i++) {
            if (c.contains(items[i])) {
                remove(i);
                i--;
                removed = true;
            }
        }
        return removed;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        if (c.size() == 0) {
            return false;
        }
        boolean removed = false;
        for (int i = 0; i < size; i++) {
            if (!c.contains(items[i])) {
                remove(i);
                i--;
                removed = true;
            }
        }
        return removed;
    }

    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            items[i] = null;
        }
        size = 0;
        modCount++;
    }

    @Override
    public T get(int index) {
        if (index >= size() || index < 0) {
            throw new IndexOutOfBoundsException("Некорректный индекс!");
        }

        return items[index];
    }

    @Override
    public T set(int index, T element) {
        if (index >= size() || index < 0) {
            throw new IndexOutOfBoundsException("Некорректный индекс!");
        }

        T item = items[index];
        items[index] = element;
        return item;
    }

    @Override
    public void add(int index, T element) {
        if (index >= size() || index < 0) {
            throw new IndexOutOfBoundsException("Некорректный индекс!");
        }

        if (items.length <= size) {
            increaseCapacity();
        }
        if (index < size) {
            System.arraycopy(items, index, items, index + 1, size - index);
        }
        items[index] = element;
        size++;
        modCount++;

    }

    @Override
    public T remove(int index) {
        if (index >= size() || index < 0) {
            throw new IndexOutOfBoundsException("Некорректный индекс!");
        }

        T item = items[index];
        if (index < size - 1) {
            System.arraycopy(items, index + 1, items, index, size - index - 1);
        }
        size--;
        modCount++;
        return item;
    }

    @Override
    public int indexOf(Object o) {
        for (int i = 0; i < size; i++) {
            if (Objects.equals(items[i], o)) {
                return i;
            }
        }

        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        for (int i = size - 1; i >= 0; i--) {
            if (Objects.equals(items[i], o)) {
                return i;
            }
        }
        return -1;
    }

    private void increaseCapacity() {
        items = Arrays.copyOf(items, items.length * 2);
    }

    public void ensureCapacity(int capacity) {
        if (capacity > items.length) {
            items = Arrays.copyOf(items, capacity);
        }
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        sb.append("[");
        for (int i = 0; i < size; ++i) {
            sb.append(items[i]).append(", ");
        }
        sb.deleteCharAt(sb.length() - 2);
        sb.append("]");
        return sb.toString();
    }

    @Override
    public ListIterator<T> listIterator() {
        return null;
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        return null;
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        return null;
    }
}
