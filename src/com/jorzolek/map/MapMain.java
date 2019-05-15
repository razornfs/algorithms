package com.jorzolek.map;

public class MapMain {
    public static void main(String[] args) {
        MyMap<Integer, String> myMap = new MyMap<>();
        myMap.put(1, "Jan Kowalski");
        myMap.put(2, "Jan Nowak");
        myMap.put(3, "Marek Kowalski");
        myMap.put(4, "Adam Kowalski");
        myMap.put(5, "Jan Małysz");

        myMap.entrySet()
             .forEach(e -> System.out.println(e.getValue()));

        myMap.entrySet()
             .stream()
             .map(e -> e.getValue())
             .filter(e -> e.startsWith("Jan"))
             .forEach(System.out::println);
    }
}
