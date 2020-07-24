package com.training.bean;

public class RegisterBean {
	private String firstName;
	private String lastName;
	private String Email;
	private String Telephone;
	private String Address1;
	private String Address2;
	private String City;
	private String postCode;
	private String Country;
	private String Region;
	private String password;
	private String passwordConfirm;

	public RegisterBean() {
	}

	public RegisterBean(String firstName, String lastName, String Email, String Telephone, String Address1, String Address2, String City, String postCode, String Country, String Region, String password, String passwordConfirm) {
		super();
		this.firstName = firstName;
		this.lastName= lastName;
		this.Email=Email;
		this.Telephone=Telephone;
		this.Address1=Address1;
		this.Address2=Address2;
		this.City=City;
		this.postCode=postCode;
		this.Country=Country;
		this.Region=Region;
		this.password = password;
		this.passwordConfirm=passwordConfirm;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		this.Email = email;
	}

	public String getTelephone() {
		return Telephone;
	}

	public void setTelephone(String telephone) {
		this.Telephone = telephone;
	}

	public String getAddress1() {
		return Address1;
	}

	public void setAddress1(String address1) {
		Address1 = address1;
	}

	public String getAddress2() {
		return Address2;
	}

	public void setAddress2(String address2) {
		Address2 = address2;
	}

	public String getCity() {
		return City;
	}

	public void setCity(String city) {
		City = city;
	}

	public String getPostCode() {
		return postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

	public String getCountry() {
		return Country;
	}

	public void setCountry(String country) {
		Country = country;
	}

	public String getRegion() {
		return Region;
	}

	public void setRegion(String region) {
		Region = region;
	}

	public String getPasswordConfirm() {
		return passwordConfirm;
	}

	public void setPasswordConfirm(String passwordConfirm) {
		this.passwordConfirm = passwordConfirm;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		//return "RegisterBean [userName=" + userName + ", password=" + password + "]";
		
		return "RegisterBean [firstName=" +firstName+ ",lastName=" + lastName +",Email=" +Email+ ",Telephone="+ Telephone+ ",Address1="+Address1+",Address2="+",City="+City+",postCode="+postCode+",Country="+Country+",Region="+Region+",password="+password+",passwordConfirm="+passwordConfirm+"]";
	}

}
