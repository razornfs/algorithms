package com.jorzolek.map;

import com.jorzolek.stack.MyAbstractDynamicArray;

import java.util.*;

public class MyMap<K, V> extends MyAbstractDynamicArray<MyEntry<K, V>> {

    public MyMap() {
        super();
    }

    public void put(K key, V value) {
        MyEntry<K, V> myEntry = new MyEntry<>(key, value);
        add(myEntry);
    }

    public Set<MyEntry<K, V>> entrySet() {
        return new HashSet<>(Arrays.asList(dynamicArray).subList(0, index));
    }

    public Set<K> keySet() {
        Set<K> keySet = new HashSet<>();
        for (int i = 0; i < index; i++) {
            keySet.add(dynamicArray[i].getKey());
        }
        return keySet;
    }

    public Collection<V> values() {
        List<V> values = new ArrayList<>(index);
        for (int i = 0; i < index; i++) {
            values.add(dynamicArray[i].getValue());
        }
        return values;
    }
}
