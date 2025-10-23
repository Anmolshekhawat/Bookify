package com.example.Bookify.Controller;


import com.example.Bookify.Entity.Student;
import com.example.Bookify.Service.StudentService;
import org.hibernate.query.sql.internal.ParameterRecognizerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/student/")
public class StudentController {

    @Autowired
    private StudentService studentService;


    @PostMapping
    public Student addStudent( @RequestBody Student student)
    {
        return studentService.saveStudent(student);
    }


    @GetMapping("{libCard}")
    public ResponseEntity<Student> getStudentByLibCard(@PathVariable String libCard)
    {
         Student student =  studentService. getStudentByLibCard(libCard);
         if(student != null)
         {
             return  ResponseEntity.ok(student);
         }
         else{
             return ResponseEntity.notFound().build();
         }
    }


    @PutMapping("{libCard}")
    public  ResponseEntity<Student> updateStudentByLibCard(@PathVariable String  libCard ,@RequestBody Student student)
    {

        if(studentService.updateStudentByLibCard(libCard,student) != null)
        {
            return ResponseEntity.ok(studentService.updateStudentByLibCard(libCard,student));
        }else {
            return  ResponseEntity.notFound().build();
        }
    }









}
