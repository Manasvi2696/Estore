package com.estore.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

//@Entity
//@Table(name = "address")
@Embeddable
public class Address {
	//@Column(name = "street")
	private String Street;
	//@Column(name = "city")
	private String city;
	//@Column(name = "district")
	private String district;
	//@Column(name = "state")
	private String state;
	//@Column(name = "country")
	private String country;
	public Address() {
		
	}
	public Address(String street, String city, String district, String state, String country) {
		this.Street = street;
		this.city = city;
		this.district = district;
		this.state = state;
		this.country = country;
	}
	public String getStreet() {
		return Street;
	}
	public void setStreet(String street) {
		this.Street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	@Override
	public String toString() {
		return "Address [Street=" + Street + ", city=" + city + ", district=" + district + ", state=" + state
				+ ", country=" + country + "]";
	}
	
	
}
