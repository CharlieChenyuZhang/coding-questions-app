package com.codingquestions.app.utils;

/**
 * OOD
 * 
 * It's likely that they ask you to implement a hashmap in the interview
 * 
 * get(K key) put(K key, V value) containsKey(K key)
 */

public class HashMap<K, V> {
    // NOTE: a good pracftise is if you can make it static, make it static
    public static class Node<K, V> {
        final private K key;
        private V value;
        private Node<K, V> next;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public V setValue(V value) {
            V originalvalue = value;
            this.value = value;
            return originalvalue;
        }
    }

    private int size = 0;
    private static int initialCapacity = 16;
    private int capacity;
    private static float initialLoadFactor = 0.75f;
    private float loadFactor = initialLoadFactor;

    private Node<K, V>[] buckets;

    public HashMap() {
        this(initialCapacity, initialLoadFactor); // cascading
    }

    @SuppressWarnings("unchecked")
    public HashMap(int capacity, float loadFactor) {
        buckets = (Node<K, V>[]) (new Node[capacity]);
        this.capacity = capacity;
        this.loadFactor = loadFactor;
    }

    public Node<K, V> get(K key) {
        int hashNum = getHashNum(key);
        int index = getIndex(hashNum);

        Node<K, V> head = buckets[index];
        while (head != null) {
            if (equalsKey(head.getKey(), key)) {
                return head;
            }
            head = head.next;
        }
        return null;
    }

    public Node<K, V> put(K key, V value) {
        // case 1, if we can find it, we update and return the old value
        // case 2, couldn't find, add to the head
        Node<K, V> node = get(key);
        Node<K, V> newNode = new Node<>(key, value);
        if (node != null) {
            node.setValue(value);
            return newNode;
        }

        // check if we have reached the loadFactor limit
        if ((float) size / capacity >= loadFactor) {
            resize();
        }

        int hashNum = getHashNum(key);
        int index = getIndex(hashNum);

        newNode.next = buckets[index];
        size++;
        return newNode;
    }

    private void resize() {
        capacity = 2 * capacity;
        Node<K, V>[] newBuckets = (Node<K, V>[]) (new Node[capacity]);

        for (Node<K, V> cur : buckets) {
            while (cur != null) {
                int hashNum = getHashNum(cur.getKey());
                int index = getIndex(hashNum); // new index

                Node<K, V> head = newBuckets[index];
                Node<K, V> newHead = new Node<>(cur.getKey(), cur.getValue());
                newHead.next = head;
                newBuckets[index] = newHead;

                cur = cur.next;
            }
        }

        buckets = newBuckets;
    }

    public Node<K, V> remove(K key) {
        int hashNum = getHashNum(key);
        int index = getIndex(hashNum);

        Node<K, V> head = buckets[index];
        Node<K, V> prev = null;

        while (head != null) {
            if (equalsKey(head.getKey(), key)) {
                if (prev == null) {
                    buckets[index] = head.next;
                } else {
                    prev.next = head.next;
                }
                return head;
            }

            prev = head;
            head = head.next;
        }

        return null;
    }

    private int getHashNum(K key) {
        if (key == null) {
            return 0;
        }

        return key.hashCode() & 0X7FFFFFFF;
    }

    private int getIndex(int hashNum) {
        return hashNum % capacity;
    }

    private boolean equalsKey(K key1, K key2) {
        return key1 == key2 || key1 != null && key1.equals(key2);
    }

}