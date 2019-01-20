package com.springboot.service;

import com.springboot.dao.StudentRepository;
import com.springboot.model.Students;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;

@Service
public class StudentServices {

    @Autowired
    private StudentRepository studentRepository;

  /* private List<Student> listStd = new ArrayList<>(Arrays.asList(new Student(11,"Menaka",32,"menaa@gmail.com"),
                                          new Student(12,"Meenu",30,"Meenu@gmail.com"),
                                          new Student(13,"Deepak",7,"deepu@gmail.com"),
                                          new Student(14,"Hetvika",4,"hetvika@gmail.com")));
*/
    public List<Students> getStudents(){
        List<Students> listStudents = new ArrayList<>();
        studentRepository.findAll().forEach(listStudents::add);
         return listStudents;
    }

    public Students getStudent(int id){

     //   return listStd.stream().filter(s->s.getStudentId()==id).findFirst().get();
        return studentRepository.findById(id).get();

    }

    public void saveStudent(Students student){

       // listStd.add(student);
        studentRepository.save(student);
    }
    public void updateStudent(int id,Students student){
       /* for(int i=0;i<listStd.size();i++){
            Student std = listStd.get(i);
            if(std.getStudentId()==id){
                listStd.set(i,student);
                return;
            }
        }*/
       studentRepository.save(student);
    }

    public void deleteStudent(int id){
      //  listStd.removeIf(s->s.getStudentId()==id);

        studentRepository.deleteById(id);
    }


}
