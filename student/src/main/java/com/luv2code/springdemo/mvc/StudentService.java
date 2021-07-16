package com.luv2code.springdemo.mvc;


import java.sql.ResultSet;



public class StudentService {
    StudentDao studentDao=new StudentDao();
    public StudentDto createstudent(StudentDto student){
        return studentDao.createstudentdao(student);
    }
    public ResultSet StudentDisplay(){
        return studentDao.displaydao();
    }
    public ResultSet Studentdelete(int rollnumber){
        return studentDao.deletedao(rollnumber);
    }
    public void Studentconformdelete(int rollnumber){
        studentDao.conformeddeletedao(rollnumber);
    }
    public StudentDto Studentupdate(StudentDto student)
    {
     return studentDao.updatedao(student);
    }
    public void closeconnection(){
        studentDao.connectionclose();

    }
    public void createconnection(){
        studentDao.createconnection();
    }
}
