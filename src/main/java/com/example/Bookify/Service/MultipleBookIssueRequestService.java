package com.example.Bookify.Service;

import com.example.Bookify.Entity.BookIssue;
import com.example.Bookify.Entity.Student;
import org.apache.catalina.LifecycleState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MultipleBookIssueRequestService {
    @Autowired
    private  StudentService studentService;

    @Autowired
    private  BookIssueService bookIssueService;


    public List<String> multipleBookIssueRequest() {
        List<Student> studentList = studentService.getAllStudent();

        List<String> results = studentList.parallelStream()
                .map(student -> {
                    BookIssue issue = bookIssueService.getBookIssueRequest(student.getLibCard(), "B001");
                    return issue != null ? "Issued to: " + student.getLibCard() : "Failed: " + student.getLibCard();
                })
                .toList();

        return results;
    }

}
