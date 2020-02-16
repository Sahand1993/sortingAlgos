package com.sortingalgos;


public class QuickSorter<T extends Comparable<T>> {
    private Class<T> type; // TODO: This seems to do no checking, i.e. having java.lang.String in Beans.xml does not cause a crash when giving the method Integers.

    public QuickSorter(Class<T> type) {
        System.out.println(type);
        this.type = type;
    }

    public T[] sort(T[] array, int pivot) {
        if (array.length < 2) {
            return array;
        }

        int newPivot = partition(array, pivot);
        T[] leftSide = sort(sliceOfArray(array, 0, newPivot), newPivot - 1);
        T[] rightSide = sort(sliceOfArray(array, newPivot + 1, array.length), array.length - newPivot - 2);

        // Create the sorted array
        System.arraycopy(leftSide, 0, array, 0, leftSide.length);
        array[newPivot] = array[newPivot];
        System.arraycopy(rightSide, 0, array, newPivot + 1, rightSide.length);

        return array;
    }

    private int partition(T[] array, int pivot) {
        for (int i = pivot + 1; i < array.length; i++) {
            int diff = array[pivot].compareTo(array[i]);
            if (diff > 0) {
                T current = array[pivot];
                T next = array[pivot + 1];
                T atI = array[i];
                array[pivot] = current;
                array[pivot + 1] = next;
                array[i] = atI;
                pivot++;
            }
        }

        for (int i = pivot - 1; i >= 0; i--) {
            int diff = array[pivot].compareTo(array[i]);
            if (diff < 0) {
                T atI = array[i];
                T prev = array[pivot - 1];
                T current = array[pivot];
                array[pivot] = atI;
                array[i] = prev;
                array[pivot - 1] = current;
                pivot--;
            }
        }
        return pivot;
    }

    private T[] sliceOfArray(T[] array, int start, int end) {
        Comparable[] slice = new Comparable[end - start];

        if (end - start >= 0) System.arraycopy(array, start, slice, 0, end - start);

        // TODO: Can't get away from hack below, see what happens when having method return Comparable[] instead.
        return (T[]) slice;
    }
}
