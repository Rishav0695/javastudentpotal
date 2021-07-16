package com.luv2code.springdemo.mvc;



import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/")
public class formgeneration {

	// need a controller method to show the initial HTML form
	
	@RequestMapping("/create")
	public String create() {
		return "creationform";
	}
	
	@RequestMapping("/read")
	public String read() {
		return "readallstudents";
	}
	@RequestMapping("/update")
	public String update() {
		return "updateform";
	}
	@RequestMapping("/delete")
	public String delete() {
		return "deleteform";
	}
	// new a controller method to read form data and
	// add data to the model
/*
	@RequestMapping("/processFormVersionTwo")	
	public String letsShoutDude(HttpServletRequest request, Model model) {
		
		// read the request parameter from the HTML form
		String theName = request.getParameter("studentName");
		
		// convert the data to all caps
		theName = theName.toUpperCase();
		
		// create the message
		String result = "Yo! " + theName;
		
		// add message to the model
		model.addAttribute("message", result);
				
		return "helloworld";
	}
	
	@RequestMapping("/processFormVersionThree")	
	public String processFormVersionThree(
			@RequestParam("studentName") String theName, Model model) 
	{
				
		// convert the data to all caps
		theName = theName.toUpperCase();
		
		// create the message
		String result = "Hey My Friend from v3! " + theName;
		
		// add message to the model
		model.addAttribute("message", result);
				
		return "helloworld";
	}	
	*/
	
	
}






