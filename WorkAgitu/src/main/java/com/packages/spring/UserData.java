package com.packages.spring;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class UserData {

	@NotBlank(message="user name should not be empty")
	@Size(min=3,max=15, message="your name should have at least 3 ")
	private String userName ;
	
	@NotBlank(message="crush name should be present")
	private String crushName ;
	
	@AssertTrue (message="need to select the agreement")
	private boolean agreement;
	
	public boolean isAgreement() {
		return agreement;
	}
	public void setAgreement(boolean agreement) {
		this.agreement = agreement;
	}
	public String []numbers;
	public CommunicationDTO communicationDTO;
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
