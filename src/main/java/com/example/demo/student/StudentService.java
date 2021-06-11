package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public List<Student> users(){
        return List.of(new Student(1L,"Karan","karanpreet2494@gmail.com", LocalDate.of(2000, Month.FEBRUARY,24),LocalDate.now().getYear() - LocalDate.of(1992,2,24).getYear()));
    }

    public List<Student> users2(){
        return studentRepository.findAll();
    }

    public void addNewStudent(Student student) {
      Optional<Student> studentOptional = studentRepository.findStudentByEmail(student.getEmail());
       if(studentOptional.isPresent())
           throw new IllegalStateException("email is already taken");
       studentRepository.save(student);
    }

    public void deleteUser(Long id) {
        studentRepository.deleteById(id);
    }

    @Transactional
    public void updateUser(Long id, String name, String email) {
        Student student = studentRepository.findById(id).orElseThrow(() ->new IllegalStateException(
                "student with id " + id + " does not exists"));

        if (name != null && name.length() > 0 && !Objects.equals(student.getName(),name))
            student.setName(name);


    }



}
