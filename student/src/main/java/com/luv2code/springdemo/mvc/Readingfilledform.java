package com.luv2code.springdemo.mvc;

import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
//import java.util.Scanner;


import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class Readingfilledform {

	//private static final String String = null;
	StudentDto studentDto= new StudentDto();
	StudentService service=new StudentService();

	@RequestMapping("/createsubmission")
	public String creatingstudent(HttpServletRequest request, Model model)
	{

		try {
			service.createconnection();
			/*  Scanner scanner= new Scanner(System.in);*/
			String name = request.getParameter("name");
			String phonenumber= request.getParameter("phonenumber");
			String gender= request.getParameter("gender");
			studentDto.setGender(gender);
			studentDto.setName(name);
			studentDto.setPhonenumber(phonenumber);
			String choice = request.getParameter("choice");
			AddressDto address=new AddressDto();
			if(choice.equalsIgnoreCase("yes"))
			{

				address.setHousenumber(request.getParameter("housenumber"));

				address.setStreet(request.getParameter("street"));

				address.setCity(request.getParameter("city"));

				address.setCountry(request.getParameter("country"));

				address.setPincode(Integer.parseInt(request.getParameter("pincode")));

			}
			studentDto.setAddress(address);
			service.createstudent(studentDto);
			String details =studentDto.toString();
			model.addAttribute("studentname",details);
			service.closeconnection();
			return "studentcreated";

		} catch (Exception e)
		{
			System.out.println("get " + e.getMessage());
		}
		service.closeconnection();
		return "studentcreated";

	}

	@RequestMapping("/readsubmission")
	public String readingstudent(HttpServletRequest request,Model model) {
		service.createconnection();

		ArrayList<String> str = new ArrayList<String>();
		ResultSet result = service.StudentDisplay();
		try {
			while(result.next()) {
				str.add(java.lang.String.format("|%03d |%-60s |%-60s |%-5s|%-50s|",result.getInt("ID"),
						result.getString("student_name"),
						result.getString("phone_number"),
						result.getString("gender"),
						result.getString("address")));

				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		model.addAttribute("student",str);

		return "displaystudent";
	}

	@RequestMapping("/updatesubmission")
	public String updatestudent(HttpServletRequest request,Model model) {

		service.createconnection();

		int rollNumber =Integer.parseInt(request.getParameter("ID"));
		ResultSet result = service.Studentdelete(rollNumber);
		String s="null ";
		try {
			while (result.next()) {
				s = java.lang.String.format("|%03d |%-30s |%-20s |%-5s|%-50s|%n ", result.getInt("ID"),
						result.getString("student_name"),
						result.getString("phone_number"),
						result.getString("gender"),
						result.getString("address"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		model.addAttribute("ID", rollNumber);
		model.addAttribute("updatestudent",s);
		service.closeconnection();

		return "updatedetail";
	}

	@RequestMapping("/updatechoicesubmission")
	public String updatefinal(HttpServletRequest request,Model model) {
		service.createconnection();
		String choice = request.getParameter("choice") ;
		String name=request.getParameter("name");
		String phonenumber = request.getParameter("phonenumber");
		String gender=request.getParameter("gender");
		int id=Integer.parseInt(request.getParameter("ID"));
		String addresschoice=request.getParameter("addresschoice");
		if(choice.equalsIgnoreCase("yes")) {
			AddressDto address = new AddressDto();
			if(addresschoice.equalsIgnoreCase("yes"))
			{

				address.setHousenumber(request.getParameter("housenumber"));

				address.setStreet(request.getParameter("street"));

				address.setCity(request.getParameter("city"));

				address.setCountry(request.getParameter("country"));

				address.setPincode(Integer.parseInt(request.getParameter("pincode")));

			}
			studentDto.setName(name);
			studentDto.setPhonenumber(phonenumber);
			studentDto.setGender(gender);
			studentDto.setId(id);
			studentDto.setAddress(address);
			service.Studentupdate(studentDto);
			service.closeconnection();
			return"studentupdated";
		}
		service.closeconnection();
		return "main-menu";

	}
	@RequestMapping("/deleterequest")

	public String deleterequest(HttpServletRequest request, Model model)
	{
		service.createconnection();
		int rollNumber=Integer.parseInt(request.getParameter("rollnumber"));
		ResultSet result = service.Studentdelete(rollNumber);
		String Str="null";
		try {
			while (result.next()) {
				Str=java.lang.String.format("|%03d |%-30s |%-20s |%-5s|%-50s|%n ", result.getInt("ID"),
						result.getString("student_name"),
						result.getString("phone_number"),
						result.getString("gender"),
						result.getString("address"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		model.addAttribute("student",Str);
		model.addAttribute("ID",rollNumber);
		service.closeconnection();
		return "conformdeletion";
	}
	@RequestMapping("/deleteconformation")
	public String deleteconformation(HttpServletRequest request, Model model)
	{
		service.createconnection();
		int rollNumber=Integer.parseInt(request.getParameter("ID"));
		String choice=request.getParameter("choice");
		if (choice.equalsIgnoreCase("yes"))
			service.Studentconformdelete(rollNumber);
		service.closeconnection();
		return "studentdeleted";
	}


















}
