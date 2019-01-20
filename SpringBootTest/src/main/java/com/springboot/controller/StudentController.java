package com.springboot.controller;

import com.springboot.model.Students;
import com.springboot.service.StudentServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    public StudentServices studentServices;

    @RequestMapping(value = "/students",method = RequestMethod.GET )
    public List<Students> getAllStudents(){
        return studentServices.getStudents();
    }

    @RequestMapping(value="/students/{id}",method = RequestMethod.GET)
    public Students getStudent(@PathVariable("id") int studentId){
        return studentServices.getStudent(studentId);
    }

    @RequestMapping(value="/students",method = RequestMethod.POST)
    public void saveStudent(@RequestBody Students student){
        studentServices.saveStudent(student);
    }

    @RequestMapping(value="/students/{studentId}",method = RequestMethod.PUT)
    public void updateStudent(@PathVariable int studentId,@RequestBody Students student){
        studentServices.updateStudent(studentId,student);
    }

    @RequestMapping(value="/students/{id}",method = RequestMethod.DELETE)
    public void deleteStudent(@PathVariable("id") int studentId){
        studentServices.deleteStudent(studentId);
    }

}
