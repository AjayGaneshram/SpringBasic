package com.packages.spring.Validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class AgeValidator implements ConstraintValidator<Age, Integer> {

	private int lower;
	private int upper;
	
	@Override
	public void initialize(Age age) {
		// TODO Auto-generated method stub
	 this.lower=age.lower();
	 this.upper=age.upper();
	}
	
	@Override
	public boolean isValid(Integer age, ConstraintValidatorContext context) {
		// TODO Auto-generated method stub
	if(age==null) {
		return false;
	}
	if (age<lower || age>upper){
		return false;
	}
	return true;
	}

}
