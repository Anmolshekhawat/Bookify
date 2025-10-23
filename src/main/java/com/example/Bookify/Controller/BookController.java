package com.example.Bookify.Controller;

import com.example.Bookify.Entity.Book;
import com.example.Bookify.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;
import java.util.List;

@RestController
@RequestMapping("/api/books/")
public class BookController {

    @Autowired
    private BookService bookService;


    @PostMapping
    public Book addBook(@RequestBody Book book) {
        return bookService.saveBookDetails(book);
    }


    @GetMapping
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }


    // Get book by ID
    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable int id) {
        Book book =   bookService.getBookById(id);
         if(book !=  null)
         {
             return ResponseEntity.ok(book);
         }
         else
         {
             return  ResponseEntity.notFound().build();
         }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable int id, @RequestBody Book bookDetails) {
        Book book =   bookService.updateBookById(id,bookDetails);
        if(book !=  null)
        {
            return ResponseEntity.ok(book);
        }
        else
        {
            return  ResponseEntity.notFound().build();
        }
    }

    // Delete a book by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBook(@PathVariable int id) {
       return ResponseEntity.ok(bookService.deleteById(id));
    }
}
