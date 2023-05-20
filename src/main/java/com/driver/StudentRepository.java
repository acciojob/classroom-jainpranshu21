package com.driver;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class StudentRepository {

    Map<String,Student> studentDb=new HashMap<>();
    Map<String,Teacher> teacherDb=new HashMap<>();
    Map<String, List<String>> teacherStudentDb=new HashMap<>();

    public String addStudent(Student student){
      String name=student.getName();
      studentDb.put(name,student);
      return "New student added successfully";
    }

    public String addTeacher(Teacher teacher){
        String name=teacher.getName();
        teacherDb.put(name,teacher);
        return "New teacher added successfully";
    }

    public String addStudentTeacherPair(String student,String teacher){
       if(!teacherStudentDb.containsKey(teacher))
           teacherStudentDb.put(teacher,new ArrayList<>());
       List<String>name=new ArrayList<>();
       for(String name1:teacherStudentDb.keySet()){
           if(name1.equals(teacher)){
               name=teacherStudentDb.get(name1);
               name.add(student);
           }
       }
       teacherStudentDb.put(teacher,name);
       return "New student-teacher pair added successfully";
    }

    public List<Student> getAllStudentsByObj(){
        List<Student>students=new ArrayList<>();
        for(Student student:studentDb.values())
            students.add(student);
        return students;
    }

    public List<Teacher> getAllTeachersByObj(){
        List<Teacher>teachers=new ArrayList<>();
        for(Teacher teacher:teacherDb.values()){
            teachers.add(teacher);
        }
        return teachers;
    }

    public List<String> getStudentsByTeacherName(String name){
        List<String>students=new ArrayList<>();
        if(teacherStudentDb.containsKey(name))
        students=teacherStudentDb.get(name);
        return students;
    }

    public String deleteTeacherByName(String teacher){
        teacherDb.remove(teacher);
        if(teacherStudentDb.containsKey(teacher))
            teacherStudentDb.remove(teacher);
        return "SUCCESS";
    }

    public String deleteAllTeachers(){
      teacherDb.clear();
      teacherStudentDb.clear();
      return "SUCCESS";
    }
}
