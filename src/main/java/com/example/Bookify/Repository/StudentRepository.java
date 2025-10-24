package com.example.Bookify.Repository;

import com.example.Bookify.Entity.Student;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student  ,  String> {

    Student getStudentByLibCard(String libCard);
//    Student deleteStudentByLibCard(String libCard);

}
