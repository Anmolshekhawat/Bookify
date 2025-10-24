package com.example.Bookify.Controller;


import com.example.Bookify.Service.MultipleBookIssueRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/multiple-book-request/")
public class MultipleBookIssueRequestHandler {

    @Autowired
    private MultipleBookIssueRequestService multipleBookIssueRequestService;

    @GetMapping
    public List<String>  multipleBookIssueRequest()
    {
        return  multipleBookIssueRequestService.multipleBookIssueRequest();
    }
}
