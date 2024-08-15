package org.example;

import java.util.LinkedList;

class HashTable {
    private final int SIZE = 10;
    private LinkedList<KeyValue>[] table;

    public HashTable() {
        table = new LinkedList[SIZE];
        for (int i = 0; i < SIZE; i++) {
            table[i] = new LinkedList<>();
        }
    }

    private int hash(int key) {
        return key % SIZE;
    }

    public void put(int key, int value) {
        int index = hash(key);
        for (KeyValue kv : table[index]) {
            if (kv.key == key) {
                kv.value = value;
                return;
            }
        }
        table[index].add(new KeyValue(key, value));
    }

    public Integer get(int key) {
        int index = hash(key);
        for (KeyValue kv : table[index]) {
            if (kv.key == key) {
                return kv.value;
            }
        }
        return null;
    }

    public void remove(int key) {
        int index = hash(key);
        table[index].removeIf(kv -> kv.key == key);
    }

    static class KeyValue {
        int key, value;

        KeyValue(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    public static void main(String[] args) {
        HashTable hashTable = new HashTable();
        hashTable.put(1, 10);
        hashTable.put(2, 20);
        hashTable.put(12, 120);

        System.out.println("Get key 2: " + hashTable.get(2));
        hashTable.remove(2);
        System.out.println("Get key 2 after removal: " + hashTable.get(2));
    }
}
