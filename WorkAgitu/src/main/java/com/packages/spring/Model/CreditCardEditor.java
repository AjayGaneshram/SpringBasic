package com.packages.spring.Model;

import java.beans.PropertyEditorSupport;

public class CreditCardEditor  extends PropertyEditorSupport{

	@Override
	public String getAsText() {
		// TODO Auto-generated method stub
		CreditCard card=(CreditCard) getValue();
		return "sample "+card.firstFour +"-"+card.secondFour;
	}
	
	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		String []creditCardNumber=text.split("-");
		CreditCard cardObj=new CreditCard();
		cardObj.setFirstFour(creditCardNumber[0]);
		cardObj.setSecondFour(creditCardNumber[1]);
		cardObj.setThirdFour(creditCardNumber[2]);
		setValue(cardObj); 
	}
}
