package com.wyl.bean;

public class Address {
	public Address(String country,String city) {
		this.country = country;
		this.city = city;
	}

	public Address(){
		
	}
	
	public String country;
	
	public String city;

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	
	
}
