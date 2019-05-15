package com.jorzolek.model;

public class Book {
    private String title;
    private String author;
    private int pages;
    private int year;
    private int month;

    public Book(String title, String author, int pages, int year, int month) {
        this.title = title;
        this.author = author;
        this.pages = pages;
        this.year = year;
        this.month = month;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    @Override
    public String toString() {
        return "Book{" +
               "title='" + title + '\'' +
               ", author='" + author + '\'' +
               ", pages=" + pages +
               ", year=" + year +
               ", month=" + month +
               '}';
    }
}
