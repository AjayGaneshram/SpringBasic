package com.packages.spring.Model;

import org.springframework.core.convert.converter.Converter;

public class CreditCardConverter implements Converter<String, CreditCard>{

	@Override
	public CreditCard convert(String source) {
		// TODO Auto-generated method stub
		String []creditCardNumber=source.split("-");
		CreditCard cardObj=new CreditCard();
		cardObj.setFirstFour(creditCardNumber[0]);
		cardObj.setSecondFour(creditCardNumber[1]);
		cardObj.setThirdFour(creditCardNumber[2]);
		return cardObj;
	}

}
