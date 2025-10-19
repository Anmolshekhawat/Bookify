package com.example.Bookify.Entity;



import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "issued_books")
public class IssuedBook {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "issue_id")
    private Integer issueId;

    @Column(name = "student_id", nullable = false)
    private String studentId;  // References students.lib_card

    @Column(name = "book_id", nullable = false)
    private String bookId;     // References books.book_id

    @Column(name = "issue_date", nullable = false)
    private LocalDate issueDate;

    @Column(name = "due_date", nullable = false)
    private LocalDate dueDate;

    @Column(name = "return_date")
    private LocalDate returnDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private Status status = Status.ISSUED;

    // Enum for status
    public enum Status {
        ISSUED,
        RETURNED,
        OVERDUE
    }

    // Constructors
    public IssuedBook() {}

    public IssuedBook(String studentId, String bookId, LocalDate issueDate, LocalDate dueDate,Status status) {
        this.studentId = studentId;
        this.bookId = bookId;
        this.issueDate = issueDate;
        this.dueDate = dueDate;
        this.status = status;
    }

    // Getters and Setters
    public Integer getIssueId() { return issueId; }


    public void setIssueId(Integer issueId) { this.issueId = issueId; }

    public String getStudentId() { return studentId; }
    public void setStudentId(String studentId) { this.studentId = studentId; }

    public String getBookId() { return bookId; }
    public void setBookId(String bookId) { this.bookId = bookId; }

    public LocalDate getIssueDate() { return issueDate; }
    public void setIssueDate(LocalDate issueDate) { this.issueDate = issueDate; }

    public LocalDate getDueDate() { return dueDate; }
    public void setDueDate(LocalDate dueDate) { this.dueDate = dueDate; }

    public LocalDate getReturnDate() { return returnDate; }
    public void setReturnDate(LocalDate returnDate) { this.returnDate = returnDate; }

    public Status getStatus() { return status; }
    public void setStatus(Status status) { this.status = status; }
}
