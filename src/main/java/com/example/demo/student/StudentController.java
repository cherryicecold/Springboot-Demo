package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("v1/user")
    public List<Student> user(){
        return studentService.users();
    }
    /*public List<Student> users(){
        return List.of(new Student(1L,"Karan","karanpreet2494@gmail.com", LocalDate.of(2000, Month.FEBRUARY,24),LocalDate.now().getYear() - LocalDate.of(1992,2,24).getYear()));
    }*/
    @PostMapping("v1/user")
    public void registerStudent(@RequestBody Student student){
        studentService.addNewStudent(student);
    }

    @DeleteMapping("v1/user/{studentId}")
    public void deleteUser(@PathVariable("studentId") Long studentId){
        studentService.deleteUser(studentId);

    }

    @PutMapping("v1/user/{Id}")
    public void updateUser(@PathVariable("Id") Long Id,
                           @RequestParam(required = false) String name,
                           @RequestParam(required = false) String email){

        studentService.updateUser(Id,name,email);

    }
}
