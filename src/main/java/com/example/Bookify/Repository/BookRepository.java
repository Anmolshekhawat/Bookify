package com.example.Bookify.Repository;

import com.example.Bookify.Entity.Book;
import jakarta.persistence.LockModeType;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository   extends JpaRepository<Book,Integer> {



     Book findByBookId(String bookId);
    void deleteByBookId(String bookId);


//    @Lock(LockModeType.PESSIMISTIC_WRITE)
//    @Query("SELECT b FROM Book b WHERE b.bookId = :bookId")
//    Book findBookByIdForUpdate(@Param("bookId") String bookId);


    @Modifying
    @Transactional
    @Query("UPDATE Book b SET b.assignedQuantity = b.assignedQuantity + 1 " +
            "WHERE b.bookId = :bookId AND b.assignedQuantity < b.totalQuantity")
    int issueBookIfAvailable(@Param("bookId") String bookId);



}
