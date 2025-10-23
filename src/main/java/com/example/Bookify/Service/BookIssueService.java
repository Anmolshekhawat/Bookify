package com.example.Bookify.Service;


import com.example.Bookify.Controller.BookController;
import com.example.Bookify.Entity.Book;
import com.example.Bookify.Entity.BookIssue;
import com.example.Bookify.Entity.Student;
import com.example.Bookify.Repository.BookIssueRepository;
import com.example.Bookify.Repository.BookRepository;
import com.example.Bookify.Repository.StudentRepository;
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

    public BookIssue getBookIssueDetails(String libCard, String bookId)
    {

          BookIssue bookIssue  =  new BookIssue();
          Student student =   studentRepository.getStudentByLibCard(libCard);
          if(student == null)
               return null;


       // Saving the BoolIssue entry into book_issue table
          Book exitingBook =   bookRepository.findByBookId(bookId);

               if(exitingBook == null) {
                      return null;
              }else
              {
                   int bookRemaining =  (exitingBook.getTotalQuantity() - exitingBook.getAssignedQuantity());
                                if(bookRemaining !=0){
//                              bookController.decreaseBookAssignedQuantity(bookId ,1);
                                    exitingBook.setAssignedQuantity(exitingBook.getAssignedQuantity()+1);
                                    bookRepository.save(exitingBook);
                                            bookIssue.setBookId(bookId);
                                            bookIssue.setStudentId(libCard);
                                            bookIssue.setIssueDate(LocalDate.now());
                                            bookIssue.setDueDate(LocalDate.now().plusDays(30));
                                            bookIssue.setStatus("Issued");
                                            return   bookIssueRepository.save(bookIssue);

                                }else{
                                     return null;
                                }

             }
    }
}
