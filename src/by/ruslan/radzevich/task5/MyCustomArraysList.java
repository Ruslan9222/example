package by.ruslan.radzevich.task5;


import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;

public class MyCustomArraysList<T> {
    private Object[] elements;
    private int size;

    public MyCustomArraysList() {
        elements = new Object[10];
        size = 0;
    }

    public void add(int index, T element) {
        if (index > size || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        ensureCapacity(size + 1);
        System.arraycopy(elements, index, elements, index + 1, size - index);
        elements[index] = element;
        size++;
    }

    public boolean addAll(Collection<? extends T> c) {
        Object[] a = c.toArray();
        int numNew = a.length;
        ensureCapacity(size + numNew);
        System.arraycopy(a, 0, elements, size, numNew);
        size += numNew;
        return numNew != 0;
    }

    public void clear() {
        Arrays.fill(elements, 0, size, null);
        size = 0;
    }

    public T get(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        return (T) elements[index];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public T remove(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        T oldValue = (T) elements[index];
        int numMoved = size - index - 1;
        if (numMoved > 0) {
            System.arraycopy(elements, index + 1, elements, index, numMoved);
        }
        elements[--size] = null; // clear to let GC do its work
        return oldValue;
    }

    public boolean remove(Object o) {
        if (o == null) {
            for (int index = 0; index < size; index++) {
                if (elements[index] == null) {
                    fastRemove(index);
                    return true;
                }
            }
        } else {
            for (int index = 0; index < size; index++) {
                if (o.equals(elements[index])) {
                    fastRemove(index);
                    return true;
                }
            }
        }
        return false;
    }

    private void fastRemove(int index) {
        int numMoved = size - index - 1;
        if (numMoved > 0) {
            System.arraycopy(elements, index + 1, elements, index, numMoved);
        }
        elements[--size] = null; // clear to let GC do its work
    }

    private void ensureCapacity(int minCapacity) {
        if (minCapacity > elements.length) {
            int newCapacity = elements.length * 2;
            if (newCapacity < minCapacity) {
                newCapacity = minCapacity;
            }
            elements = Arrays.copyOf(elements, newCapacity);
        }
    }

    public void sort(Comparator<? super T> comparator) {
        Object[] a = Arrays.copyOf(elements, size);
        mergeSort(a, 0, size - 1, comparator);
        System.arraycopy(a, 0, elements, 0, size);
    }

    private void mergeSort(Object[] a, int left, int right, Comparator<? super T> comparator) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(a, left, mid, comparator);
            mergeSort(a, mid + 1, right, comparator);
            merge(a, left, mid, right, comparator);
        }
    }

    private void merge(Object[] a, int left, int mid, int right, Comparator<? super T> comparator) {
        int n1 = mid - left + 1;
        int n2 = right - mid;
        Object[] L = new Object[n1];
        Object[] R = new Object[n2];
        for (int i = 0; i < n1; ++i) {
            L[i] = a[left + i];
        }
        for (int j = 0; j < n2; ++j) {
            R[j] = a[mid + 1 + j];
        }
        int i = 0, j = 0;
        int k = left;
        while (i < n1 && j < n2) {
            if (comparator.compare((T) L[i], (T) R[j]) <= 0) {
                a[k] = L[i];
                i++;
            } else {
                a[k] = R[j];
                j++;
            }
            k++;
        }
        while (i < n1) {
            a[k] = L[i];
            i++;
            k++;
        }
        while (j < n2) {
            a[k] = R[j];
            j++;
            k++;
        }
    }

    public static void main(String[] args) {
        MyCustomArraysList<Integer> list = new MyCustomArraysList<>();
        list.add(0, 5);
        list.add(1, 3);
        list.add(2, 8);
        list.add(1, 4);

        System.out.println("Before sorting:");
        for (int i = 0; i < list.size; i++) {
            System.out.print(list.get(i) + " ");
        }

        list.sort(Integer::compareTo);

        System.out.println("\nAfter sorting:");
        for (int i = 0; i < list.size; i++) {
            System.out.print(list.get(i) + " ");
        }
    }
}

