package com.example.Bookify.Repository;

import com.example.Bookify.Entity.BookIssue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookIssueRepository extends JpaRepository<BookIssue , Integer> {

}
