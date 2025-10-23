package com.example.Bookify.Repository;

import com.example.Bookify.Entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository   extends JpaRepository<Book,Integer> {

     Book findByBookId(String bookId);

    void deleteByBookId(String bookId);

}
