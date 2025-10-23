package com.example.Bookify.Entity;
import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "students")
public class Student {

    @Column(nullable = false)
    private String name;

    @Id
    @Column(name = "lib_card", nullable = false, unique = true)
    private String libCard;

    @Column(name = "email_id", nullable = false, unique = true)
    private String emailId;

    @Column(nullable = false)
    private String branch;

    public String getRollNo() {
        return rollNo;
    }

    public void setRollNo(String rollNo) {
        this.rollNo = rollNo;
    }

    @Column(name = "roll_no",  nullable = false, unique = true )
    private  String rollNo;

    @PrePersist
    public void generateLibCard() {
        if (this.libCard == null) {
            this.libCard = "LIB" + UUID.randomUUID().toString().substring(0, 6).toUpperCase();

        }
    }
    public Student() {
    }


    public Student(String name, String libCard, String emailId, String branch, String rollNo) {
        this.name = name;
        this.libCard = libCard;
        this.emailId = emailId;
        this.branch = branch;
        this.rollNo = rollNo;
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
