package com.packages.spring.Model;

import java.text.ParseException;
import java.util.Locale;

import org.springframework.format.Formatter;

public class CreditCardFormatter  implements  Formatter<CreditCard>{

	@Override
	public String print(CreditCard object, Locale locale) {
		// TODO Auto-generated method stub
		return "sample "+object.getFirstFour()+"-"+object.getSecondFour();
	}

	@Override
	public CreditCard parse(String text, Locale locale) throws ParseException {
		// TODO Auto-generated method stub
		String []creditCardNumber=text.split("-");
		CreditCard cardObj=new CreditCard();
		cardObj.setFirstFour(creditCardNumber[0]);
		cardObj.setSecondFour(creditCardNumber[1]);
		cardObj.setThirdFour(creditCardNumber[2]);
		return cardObj;
	}

}
