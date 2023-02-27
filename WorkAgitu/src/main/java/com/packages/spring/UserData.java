package com.packages.spring;

import java.math.BigDecimal;
import java.util.Date;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.packages.spring.Model.CreditCard;
import com.packages.spring.Validator.Age;

public class UserData {

	@NotBlank(message="user name should not be empty")
	@Size(min=3,max=15, message="your name should have at least 3 ")
	private String userName ;
	
	@NotBlank(message="crush name should be present")
	private String crushName ;
	
	@AssertTrue (message="need to select the agreement")
	private boolean agreement;
	
	@Age(lower=30 ,upper=60)
	private Integer age;
	
	public String []numbers;
	public CommunicationDTO communicationDTO;
	public CreditCard creditCard;
	public Date date;
	
	public BigDecimal amount;
	
	
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public CreditCard getCreditCard() {
		return creditCard;
	}
	public void setCreditCard(CreditCard creditCard) {
		this.creditCard = creditCard;
	}

	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public boolean isAgreement() {
		return agreement;
	}
	public void setAgreement(boolean agreement) {
		this.agreement = agreement;
	}
	public UserData() {
	// TODO Auto-generated constructor stub
	}
	public CommunicationDTO getCommunicationDTO() {
		return communicationDTO;
	}
	public void setCommunicationDTO(CommunicationDTO communicationDTO) {
		this.communicationDTO = communicationDTO;
	}
	public String[] getNumbers() {
		return numbers;
	}
	public void setNumbers(String[] numbers) {
		this.numbers = numbers;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getCrushName() {
		return crushName;
	}
	public void setCrushName(String crushName) {
		this.crushName = crushName;
	}
	
	
}
