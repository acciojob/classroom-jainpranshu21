package com.driver;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {

    StudentRepository studentRepository=new StudentRepository();

    public String addStudent(Student student){
      return studentRepository.addStudent(student);
    }

    public String addTeacher(Teacher teacher){
        return studentRepository.addTeacher(teacher);
    }

    public String addStudentTeacherPair(String student,String teacher){
        return studentRepository.addStudentTeacherPair(student,teacher);
    }

    public Student getStudentByName(String name){
        List<Student>students=studentRepository.getAllStudentsByObj();
        Student s=null;
        for(Student student:students){
            if(student.getName().equals(name))
                s=student;
        }
        return s;
    }

    public Teacher getTeacherByName(String name){
        List<Teacher>teachers=studentRepository.getAllTeachersByObj();
        Teacher t=null;
        for(Teacher teacher:teachers){
            if(teacher.getName().equals(name)){
                t=teacher;
            }
        }
        return t;
    }

    public List<String> getStudentsByTeacherName(String teacher){
        List<String>students=studentRepository.getStudentsByTeacherName(teacher);
        return students;
    }

    public List<String> getAllStudents(){
        List<Student>students=studentRepository.getAllStudentsByObj();
        List<String>ans=new ArrayList<>();
        for (Student student:students){
            ans.add(student.getName());
        }
        return ans;
    }

    public String deleteTeacherByName(String teacher){
        return studentRepository.deleteTeacherByName(teacher);
    }

    public String deleteAllTeachers(){
        return studentRepository.deleteAllTeachers();
    }
}
