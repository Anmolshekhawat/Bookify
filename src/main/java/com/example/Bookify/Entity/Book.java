package com.example.Bookify.Entity;
import jakarta.persistence.*;

// I am testing
@Entity
@Table(name = "books")
public class Book{

    @Id
    @Column(name = "book_id", nullable = false ,unique = true)
    private String bookId;

    @Column(name = "title" , nullable = false )
    private String title;

    private String author;

    private String category;

    private int totalQuantity;


    private int assignedQuantity = 0;

    public Book() {
    }

    public Book(String bookId, String title, String author, String category, int totalQuantity, int assignedQuantity) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.category = category;
        this.totalQuantity = totalQuantity;
        this.assignedQuantity = assignedQuantity;
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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getTotalQuantity() {
        return totalQuantity;
    }

    public void setTotalQuantity(int totalQuantity) {
        this.totalQuantity = totalQuantity;
    }

    public int getAssignedQuantity() {
        return assignedQuantity;
    }

    public void setAssignedQuantity(int assignedQuantity) {
        this.assignedQuantity = assignedQuantity;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }



}
