package com.example.Bookify.Entity;


import jakarta.persistence.*;
import org.hibernate.query.sql.internal.ParameterRecognizerImpl;
import org.springframework.beans.factory.aot.AotServices;
import org.springframework.boot.autoconfigure.web.WebProperties;

import java.time.LocalDate;

//import java.time.LocalDate;

@Entity
@Table(name = "book_issue")
public class BookIssue {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int issueId;

    @Column(name = "book_id", nullable = false)
    private String bookId;

    @Column(name = "student_id", nullable = false)
    private String studentId;

    @Column(name = "issue_date", nullable = false)
    private LocalDate issueDate;

    @Column(name = "due_date", nullable = false)
    private LocalDate dueDate;

    @Column(name = "return_date")
    private LocalDate returnedDate;

    @Column(name = "status")
    private  String status;


    public BookIssue() {
    }

    public BookIssue(int id ,String bookId, String studentId, LocalDate issueDate, LocalDate dueDate, LocalDate returnedDate, String status) {
       this.issueId = id;
       this.bookId = bookId;
        this.studentId = studentId;
        this.issueDate = issueDate;
        this.dueDate = dueDate;
        this.returnedDate = returnedDate;
        this.status = status;
    }

    public int getId() {
        return issueId;
    }

    public void setId(int id) {
        this.issueId = id;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
      this.bookId = bookId;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public LocalDate getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(LocalDate issueDate) {
        this.issueDate = issueDate;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public LocalDate getReturnedDate() {
        return returnedDate;
    }

    public void setReturnedDate(LocalDate returnedDate) {
        this.returnedDate = returnedDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
