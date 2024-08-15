package org.example;

import java.util.Arrays;

public class ArrayOperations {
    private int[] array;
    private int size;

    public ArrayOperations(int capacity) {
        array = new int[capacity];
        size = 0;
    }

    public void insert(int element) {
        if (size == array.length) {
            array = Arrays.copyOf(array, size * 2);
        }
        array[size++] = element;
    }

    public void delete(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid index");
        }
        for (int i = index; i < size - 1; i++) {
            array[i] = array[i + 1];
        }
        size--;
    }

    public void traverse() {
        for (int i = 0; i < size; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ArrayOperations arrOps = new ArrayOperations(5);
        arrOps.insert(1);
        arrOps.insert(2);
        arrOps.insert(3);
        arrOps.traverse();

        arrOps.delete(1);
        arrOps.traverse();
    }
}
