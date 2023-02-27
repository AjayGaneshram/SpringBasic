package com.packages.spring.Controller;

import java.math.BigDecimal;
import java.sql.Date;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.beans.propertyeditors.CustomNumberEditor;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
//import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.packages.spring.CommunicationDTO;
import com.packages.spring.Phone;
import com.packages.spring.UserData;
import com.packages.spring.Model.CreditCard;
import com.packages.spring.Model.CreditCardEditor;
import com.packages.spring.Model.CreditCardFormatter;

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
			CreditCard cardObj=new CreditCard();
			cardObj.setFirstFour("678");
			cardObj.setSecondFour("8966");
			cardObj.setThirdFour("89788");
		   CommunicationDTO communicationDTO =new CommunicationDTO();
		   communicationDTO.setPhone(phone);
		   userData.setCommunicationDTO(communicationDTO);
		   userData.setCreditCard(cardObj);
		   System.out.println("Inside getHomepage");
		   return "HomePage";
	   }
	   @RequestMapping("/process-homepage")
	   //public String showResultPage(@RequestParam("your_name") String username, @RequestParam("your_partner") String crushName ,Model model) {
	   //public String showResultPage(UserData userData ,Model model) {
	   public String showResultPage(@Valid @ModelAttribute("userInfo") UserData userData, BindingResult result) {
		  
		  System.out.println("data binding value of email"+userData.getCommunicationDTO().getEmail()); 
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
	   
	   @InitBinder
	   public void initBinder(WebDataBinder binder) {
		   System.out.println("Inside the initbinder method");
		   
		   StringTrimmerEditor editor=new StringTrimmerEditor(true);
		   binder.registerCustomEditor(String.class, "communicationDTO.email",editor);
		   //if we add this, email will not bind with userData
		   //binder.setDisallowedFields("communicationDTO.email");
		   
		   //for handling the data format "6-09-6789"
		   SimpleDateFormat dataformat =new SimpleDateFormat("dd-MM-yyyy");
		   CustomDateEditor customDateEditor =new CustomDateEditor(dataformat,true);
		   binder.registerCustomEditor(Date.class, "date",customDateEditor);
		   
		   NumberFormat numberFormat =new DecimalFormat("##,####.00");
		   CustomNumberEditor DateEditor =new CustomNumberEditor(BigDecimal.class,numberFormat,true);
		   binder.registerCustomEditor(BigDecimal.class, "amount",DateEditor);
		   
		   //add custom formatter here also
		   //binder.addCustomFormatter(new CreditCardFormatter());
		   
		   CreditCardEditor cardEditor =new CreditCardEditor();
		   binder.registerCustomEditor(CreditCardEditor.class,"creditCard",cardEditor);
	   }
	   
	   
}
