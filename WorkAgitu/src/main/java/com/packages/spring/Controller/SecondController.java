package com.packages.spring.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.support.SessionStatus;

@Controller
public class SecondController {

	@RequestMapping("/handlingMethod")
	public String handlingMethod(@SessionAttribute("modelObject1") String objectName ,Model model,SessionStatus status ) {
		//String firstName=(String)model.getAttribute("modelObject1");
		String name="New :---) "+objectName;
		model.addAttribute("next",name);
		status.setComplete();
		return "sessionAttribute";
	}
}
