package com.jorzolek.streams;

import com.jorzolek.model.Book;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class BookMain {
    private static List<Book> books = new ArrayList<>();

    static {
        books.add(new Book("Ogniem i mieczem", "Henryk Sienkiewicz", 800, 1884, 3));
        books.add(new Book("Potop", "Henryk Sienkiewicz", 650, 1870, 8));
        books.add(new Book("Pan Wołodyjowski", "Henryk Sienkiewicz", 500, 1876, 4));
        books.add(new Book("Pan Tadeusz", "Adam Mickiewicz", 300, 1744, 8));
        books.add(new Book("Nad Niemnem", "Eliza Orzeszkowa", 1200, 1914, 9));
    }

    public static void viewBooksPublishedBefore1900() {
        books.stream()
             .filter(e -> e.getYear() < 1900)
             .forEach(System.out::println);
    }

    public static void viewBooksSortedByTitle() {
        books.stream()
             .sorted(Comparator.comparing(Book::getTitle))
             .forEach(System.out::println);
    }

    public static void viewBooksGroupedByMonth() {
        System.out.println(books.stream()
                                .collect(Collectors.groupingBy(Book::getMonth, Collectors.summingInt(Book::getPages))));
    }

    public static void viewAmountOfBooksWithMoreThan1000Pages() {
        System.out.println(books.stream()
                                .filter(e -> e.getPages() > 1000)
                                .count());
    }

    public static List<Book> findAllBooksByAuthor(String author) {
        return books.stream()
                    .filter(e -> e.getAuthor().equals(author))
                    .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        findAllBooksByAuthor("Henryk Sienkiewicz").forEach(System.out::println);
    }
}
