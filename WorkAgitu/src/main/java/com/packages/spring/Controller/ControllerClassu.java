package com.packages.spring.Controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
//import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.packages.spring.CommunicationDTO;
import com.packages.spring.Phone;
import com.packages.spring.UserData;

@Controller
public class ControllerClassu {

	   @RequestMapping("/welcome")
		/* @ResponseBody */
	  
	    // Method
	    public String helloGfg()
	    {
	        return "welcome";
	    }
	   
	   @RequestMapping("/")
	   //public String getHomePage(Model model) {
	   public String getHomePage(@ModelAttribute("userInfo")UserData userData) {
			/*
			 * UserData userdata=new UserData(); model.addAttribute("userInfo",userdata);
			 */
			/* 
			 * we can set the default value for userName while opening the page
			 * userData.setUserName("Ganesh");
			 * 
			 *  */
		   Phone phone=new Phone();
		   phone.setCountryCode("91");
		   phone.setUserNumber("977736726");
		   CommunicationDTO communicationDTO =new CommunicationDTO();
		   communicationDTO.setPhone(phone);
		   userData.setCommunicationDTO(communicationDTO);
		   System.out.println("Inside getHomepage");
		   return "HomePage";
	   }
	   @RequestMapping("/process-homepage")
	   //public String showResultPage(@RequestParam("your_name") String username, @RequestParam("your_partner") String crushName ,Model model) {
	   //public String showResultPage(UserData userData ,Model model) {
	   public String showResultPage(@Valid @ModelAttribute("userInfo") UserData userData, BindingResult result) {
		   System.out.println("Inside showResultPage");
			/* model.addAttribute("userData", userData); */
		  if(result.hasErrors())
		  {
			  System.out.println("My form has errors");
			  List<ObjectError>listofErrors =result.getAllErrors();
			  for(ObjectError temp:listofErrors) {
				  System.out.println(temp);
			  }
			  return "HomePage";
		  }
		   return "resultPage";
	   }
	   
}
