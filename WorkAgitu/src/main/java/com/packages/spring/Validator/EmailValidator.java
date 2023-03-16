package com.packages.spring.Validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.packages.spring.UserData;

@Component
public class EmailValidator  implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return UserData.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "communicationDTO.email", "email.empty");
		String email=((UserData)target).getCommunicationDTO().getEmail();
		
		if(!email.endsWith("@wipro.com"))
		{
			errors.rejectValue("communicationDTO.email", "email.invalid");
		}
		
		
	}

}
