package com.example.Bookify.Controller;


import com.example.Bookify.Entity.BookIssue;
import com.example.Bookify.Service.BookIssueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping("api/book-issue/")
public class IssueBookController {

    @Autowired
    private BookIssueService bookIssueService;

    @PostMapping("/{libCard}/{bookId}")
    public ResponseEntity<?> getBookIssueRequest(@PathVariable String libCard, @PathVariable String bookId) {
        BookIssue bookIssue = bookIssueService.getBookIssueDetails(libCard, bookId);

        if (bookIssue != null) {
            HashMap<String, Object> response = new HashMap<>();
            response.put("message", "Book issue details fetched successfully!");
            response.put("data", bookIssue);

            return ResponseEntity.ok(response);
        } else {
            HashMap<String, String> response = new HashMap<>();
            response.put("message", "No record found for given LibCard and BookId");

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }





}
