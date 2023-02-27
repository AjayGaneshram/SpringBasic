package com.packages.spring;

import java.text.ParseException;
import java.util.Locale;

import org.springframework.format.Formatter;

public class PhoneNumberFormatter implements Formatter<Phone>{

	@Override
	public String print(Phone object, Locale locale) {
		// TODO Auto-generated method stub
		return object.getCountryCode()+"-"+object.getUserNumber();
	}

	@Override
	public Phone parse(String completePhoneNumber, Locale locale) throws ParseException {
		// TODO Auto-generated method stub
		System.out.println("Hi ..formatter method");
		int index=completePhoneNumber.indexOf("-");
		Phone phone=new Phone();
		String [] phoneNumberArray=completePhoneNumber.split("-");
		
		if(index==-1) {
			phone.setCountryCode("91");
			phone.setUserNumber(phoneNumberArray[0]);
			
		}
		else {
		
		phone.setCountryCode(phoneNumberArray[0]);
		phone.setUserNumber(phoneNumberArray[1]);
		}
		return phone;
	}

}
