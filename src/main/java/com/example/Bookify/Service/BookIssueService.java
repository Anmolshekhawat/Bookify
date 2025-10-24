package com.example.Bookify.Service;


import com.example.Bookify.Controller.BookController;
import com.example.Bookify.Entity.Book;
import com.example.Bookify.Entity.BookIssue;
import com.example.Bookify.Entity.Student;
import com.example.Bookify.Repository.BookIssueRepository;
import com.example.Bookify.Repository.BookRepository;
import com.example.Bookify.Repository.StudentRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.beanvalidation.SpringValidatorAdapter;

import java.time.LocalDate;

@Service
public class BookIssueService {

    @Autowired
    private   BookController bookController;
    @Autowired
    private BookRepository bookRepository;

    @Autowired
     private BookIssueRepository bookIssueRepository;
    @Autowired
    private  StudentRepository studentRepository;


    @Transactional
    public BookIssue getBookIssueRequest(String libCard, String bookId)
    {

          BookIssue bookIssue  =  new BookIssue();

          // check student Availability or validness
          Student student =   studentRepository.getStudentByLibCard(libCard);
          if(student == null)    // throw new RuntimeException("Invalid student");
              return null;




//               // check the book availability
//               Book exitingBook =   bookRepository.findBookByIdForUpdate(bookId);
//               if(exitingBook == null)
//                   return null;
//
//               // check the book Quantity
//               int bookAvailable =  (exitingBook.getTotalQuantity() - exitingBook.getAssignedQuantity());
//               if(bookAvailable<=0) return  null;
//
//
//               // let's increase  the assigned Quantity and save back the book database
//               exitingBook.setAssignedQuantity(exitingBook.getAssignedQuantity()+1);
//                bookRepository.save(exitingBook);

         // let's  store the book-Issue  Details in Book_issue database


        int updated =  bookRepository.issueBookIfAvailable(bookId);
        if(updated ==1) {
            bookIssue.setBookId(bookId);
            bookIssue.setStudentId(libCard);
            bookIssue.setIssueDate(LocalDate.now());
            bookIssue.setDueDate(LocalDate.now().plusDays(30));
            bookIssue.setStatus("Issued");
            return bookIssueRepository.save(bookIssue);

        }
        else {
            return  null;
        }


    }
}
