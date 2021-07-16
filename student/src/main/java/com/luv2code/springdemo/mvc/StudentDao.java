package com.luv2code.springdemo.mvc;

import java.sql.*;
import java.sql.DriverManager;

public class StudentDao {
    private Connection conn ;
    private Statement statement;
    private ResultSet result;
    private String url="jdbc:mysql://localhost:3306/?user=root";
    private String username="root";
    private String password="1995";
    public StudentDto createstudentdao(StudentDto studentDto)
    {
        try {
            statement.execute("INSERT INTO studentwebapp (student_name,phone_number,gender,address)" +
                    " values ('" + studentDto.getName() + "','" + studentDto.getPhonenumber() + "','" +
                    studentDto.getGender() +"','"+studentDto.getAddress()+"');");
        }catch(SQLException e){
            System.out.println("error in creating new student"+e);
        }
        return studentDto;
    }

    public ResultSet displaydao() {
        try {

            result = statement.executeQuery("SELECT * FROM studentwebapp;");
            return result;

        } catch (SQLException e) {
            System.out.println("display error" + e.getMessage());
        }
        return null;
    }
    public ResultSet deletedao(int rollNumber) {
        try {

            statement.execute("select * from studentwebapp where ID=" + rollNumber + ";");
            result = statement.getResultSet();
            return result;
        } catch (SQLException e) {
            System.out.println("delete error" + e.getMessage());
        }
        return null;
    }
    public void conformeddeletedao(int rollNumber) {
        try {

            statement.execute("DELETE FROM studentwebapp Where ID=" + rollNumber + ";");

        } catch (SQLException e) {
            System.out.println("delete error" + e.getMessage());
        }
    }
    public StudentDto updatedao(StudentDto student){
        try{

            statement.execute("UPDATE studentwebapp SET student_name= '" + student.getName() + "'," +
                    "phone_number='" + student.getPhonenumber() +
                    "', gender='" + student.getGender() +"',address='"+student.getAddress()+
                    "' WHERE ID=" + student.getId() + ";");

        }catch(SQLException e){
            System.out.println("update error"+e.getMessage());
        }
        return student;
    }

    public void connectionclose(){
        try{
            conn.close();
        }catch(SQLException e){
            System.out.println("connection closing error"+e);
        }
    }
    public void createconnection()
    {
        try{
        	 try
             {
                 
                 Class.forName("com.mysql.cj.jdbc.Driver");
                

             }
             catch(ClassNotFoundException error)
             {
                 System.out.println("Error:" + error.getMessage()); 
             }
        	
        	
            conn= DriverManager.getConnection(url, username,password);
            statement = conn.createStatement();
            statement.execute("USE student;");
            statement.execute("CREATE TABLE  IF NOT EXISTS studentwebapp (ID INT PRIMARY KEY AUTO_INCREMENT," +
                    "student_name TEXT,phone_number TEXT,gender TEXT,address TEXT default null);");
            
        } catch(SQLException e){
            System.out.println("connection error in student DAO " + e.getMessage());
        }
    }
}
