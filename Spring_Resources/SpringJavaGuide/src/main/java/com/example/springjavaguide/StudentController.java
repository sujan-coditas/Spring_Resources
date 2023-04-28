package com.example.springjavaguide;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {
    @GetMapping("/student")
    public Student getStudent() {

        return new Student("Sujan", "Nanded");
    }

@GetMapping("/studentList")
    public List<Student> getStudentList() {

        List<Student> students= new ArrayList<>();
        students.add(new Student("arya","indore"));
        students.add(new Student("tanmay","pune"));
        students.add(new Student("yash","agra"));
        students.add(new Student("mrunmai","pune"));

        return students;

    }



    @GetMapping("{name}/{address}")
    public Student studentPathVariable(@PathVariable("name") String name,@PathVariable("address") String address){
        return new Student(name,address);
    }
@GetMapping("/studentQuery")
    public Student studentQueryParameter(@RequestParam(name="name") String name){
        return new Student(name);
    }


}
