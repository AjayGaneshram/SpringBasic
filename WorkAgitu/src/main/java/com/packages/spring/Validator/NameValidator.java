package com.packages.spring.Validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.packages.spring.UserData;

public class NameValidator  implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return UserData.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "name.empty","Name can't be empty");
	
	String name=((UserData)target).getName();
	if(!name.contains("_"))
	{
		errors.rejectValue("name", "name.invalid","name should contain _");
	}
	}

}
