package com.example.Bookify.Service;

import com.example.Bookify.Entity.Book;
import com.example.Bookify.Repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public Book saveBookDetails(Book book) {
        return bookRepository.save(book);
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Book updateBookById(int id, Book bookDetails)
    {

       Book existingBook = bookRepository.findById(id).orElse(null);

        if(existingBook!= null)
        {

            // Update fields
            existingBook.setTitle(bookDetails.getTitle());
            existingBook.setAuthor(bookDetails.getAuthor());
            existingBook.setCategory(bookDetails.getCategory());
            existingBook.setTotalQuantity(bookDetails.getTotalQuantity());
            existingBook.setAssignedQuantity(bookDetails.getAssignedQuantity());

            // Save the updated book
            return bookRepository.save(existingBook);
        }
        else {
            // Book not found case
         // throw new RuntimeException("Book not found with id: " + id);
            return   null;
        }
    }

    public String deleteById(int id) {
        bookRepository.deleteById(id);
        return "Delete Successfully";
    }


    public Book getBookById(int id) {

        return  bookRepository.findById(id).orElse(null);

    }

}
