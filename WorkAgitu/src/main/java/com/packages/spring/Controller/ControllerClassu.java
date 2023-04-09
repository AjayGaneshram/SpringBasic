package com.packages.spring.Controller;

import java.math.BigDecimal;
import java.sql.Date;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.beans.propertyeditors.CustomNumberEditor;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.InitBinder;
//import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.packages.spring.CommunicationDTO;
import com.packages.spring.Phone;
import com.packages.spring.UserData;
import com.packages.spring.Model.CreditCard;
import com.packages.spring.Model.CreditCardEditor;
import com.packages.spring.Model.CreditCardFormatter;
import com.packages.spring.Validator.EmailValidator;
import com.packages.spring.Validator.NameValidator;

@Controller
@SessionAttributes("userInfo")
public class ControllerClassu {

	@Autowired
	private EmailValidator emailValidator;
	
	@ModelAttribute("userInfo")
	public UserData userDataObject() {
		return new UserData();
	}
	
	
	   @RequestMapping("/welcome")
		/* @ResponseBody */
	  
	    // Method
	    public String helloGfg()
	    {
	        return "welcome";
	    }
	   
	   @RequestMapping("/email/{userName}")
	   public String emailMethod(@PathVariable("userName")String userNameDetail,Model model) {
		model.addAttribute("userName1",userNameDetail.toUpperCase());
		   return "email";
	   } 
	   
	   @RequestMapping("/session")
	   public String sessionChecker() {
		   
		   return "session";
	   }
	   @RequestMapping("/")
	   //public String getHomePage(Model model) {
	   //@cookieValue annotation is  used to get the value from cookies (Spring annotation)
	   //HttpservletResponse and HttpservletRequest is used to get and set the values in cookies.
	   public String getHomePage(@CookieValue("UserName_details")String cookieValue,@ModelAttribute("userInfo")UserData userData,HttpServletRequest request) {
			/*
			 * UserData userdata=new UserData(); model.addAttribute("userInfo",userdata);
			 */
			/* 
			 * we can set the default value for userName while opening the page
			 * userData.setUserName("Ganesh");
			 * 
			 *  */
		   System.out.println("----------------");
		   System.out.println(cookieValue);
		   System.out.println("-----------------");
		   
		   // way to get the value with the help of HttpservletResponse and HttpServletRequest
			/*
			 * Cookie[]cookieName=request.getCookies();
			 * 
			 * for(Cookie temp:cookieName) { if("UserName_details".equals(temp.getName())) {
			 * String myUserName=temp.getValue(); userData.setUserName(myUserName); } }
			 */
		   userData.setCrushName(cookieValue);
		   
		   //session
		   
		   
		   
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
	   //requestParam is used to get the value from query parameter 
	   //path variable is used to get the value from url.
	   //public String showResultPage(@RequestParam("your_name") String username, @RequestParam("your_partner") String crushName ,Model model) {
	   //public String showResultPage(UserData userData ,Model model) {
	   public String showResultPage(@Valid @ModelAttribute("userInfo") UserData userData, BindingResult result,HttpServletResponse response,HttpServletRequest request) {
		  
		  System.out.println("data binding value of email"+userData.getCommunicationDTO().getEmail()); 
		   System.out.println("Inside showResultPage");
            //Adding validator for email verification 
		   emailValidator.validate(userData, result);
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
		  
		  //create a cookie for the user name
		  Cookie cookies=new Cookie("UserName_details",userData.getUserName());
		  cookies.setMaxAge(60*60*24); 
		  response.addCookie(cookies);
		  
		  
		  //session
		  
		  HttpSession session=request.getSession();
		  session.setAttribute("crushName", userData.getCrushName());
		  return "resultPage";
	   }
	   
	   @InitBinder
	   public void initBinder(WebDataBinder binder ) {
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
		   
			/*
			 * CreditCardEditor cardEditor =new CreditCardEditor();
			 * binder.registerCustomEditor(CreditCardEditor.class,"creditCard",cardEditor);
			 */ 
		   
	      //NameValidator validator=new NameValidator();
		   //adding validator here with spring method
		   
	
		   
	      binder.addValidators(new NameValidator());
	      //adding emailvalidator with the help of autowired object
	     // binder.addValidators(new EmailValidator());	  
	    		   		  
	   }
	   
}
