package com.packages.spring.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

@Controller
@SessionAttributes({"modelObject1"})
public class FirstController {

	 @RequestMapping("/sessionattribute")
	   public String sessionExample(Model modelobject,SessionStatus status) {
		   modelobject.addAttribute("modelObject1", "ModelObject1");
		   modelobject.addAttribute("next","/second");
		   
		   
		   //if you want to end the session scope
		   //other request can't access the session scope model object
		  // status.setComplete();
		  return "sessionAttribute"; 
	   }
	   @RequestMapping("/sessionattribute/check")
	   public String sessionExample2(Model model1) {
		  String firstName=(String)model1.getAttribute("modelObject1");
		  System.out.println(firstName);
		  model1.addAttribute("next","/third");
		  model1.addAttribute("newNext","handlingMethod");
		  return "sessionAttribute"; 
	   }
}
