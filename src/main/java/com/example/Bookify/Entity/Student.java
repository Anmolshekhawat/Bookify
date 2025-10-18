package com.example.Bookify.Entity;
import jakarta.persistence.*;

@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String name;

    @Column(name = "lib_card", nullable = false, unique = true)
    private String libCard;

    @Column(name = "email_id", nullable = false, unique = true)
    private String emailId;

    @Column(nullable = false)
    private String branch;


    public Student() {}

    public Student(String name, String libCard, String emailId, String branch) {
        this.name = name;
        this.libCard = libCard;
        this.emailId = emailId;
        this.branch = branch;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLibCard() {
        return libCard;
    }

    public void setLibCard(String libCard) {
        this.libCard = libCard;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }


}
