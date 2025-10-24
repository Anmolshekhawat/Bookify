package com.example.Bookify.Service;


import com.example.Bookify.Entity.Student;
import com.example.Bookify.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;
    public Student saveStudent(Student student) {

        return  studentRepository.save(student);
    }

    public Student getStudentByLibCard(String libCard) {
         return studentRepository.getStudentByLibCard(libCard);
    }

    public Student updateStudentByLibCard(String libCard, Student student) {

        Student newStudent =  studentRepository.getStudentByLibCard(libCard);
        if(newStudent != null)
        {
            newStudent.setName(student.getName());
            newStudent.setRollNo(student.getRollNo());
            newStudent.setEmailId(student.getEmailId());
            newStudent.setBranch(student.getLibCard());
            newStudent.setBranch(student.getBranch());

          return    studentRepository.save(newStudent);
        }
        else {
            return null;
        }



    }


    public void addNStudents(int n) {

         List<Student> list = new ArrayList<>();

        for(int i = 1; i<=n; i++)
        {
            Student student  = new Student();
            student.setName(" Ravi "+ i);
            student.setBranch("cse ");
            student.setEmailId("Ravi" + i +" @gmail.com");
            student.setRollNo("22ESGCS" + i);
           list.add(student);
        }
        studentRepository.saveAll(list);
    }

    public List<Student> getAllStudent() {
       return   studentRepository.findAll();
    }
}
