package com.example.additionalEndpoint;

public class Adress {
	private String house;
	private String street;
	private String thana;
	private String district;
	public Adress(String house, String street, String thana, String district) {
		this.house = house;
		this.street = street;
		this.thana = thana;
		this.district = district;
	}
	public String getHouse() {
		return house;
	}
	public void setHouse(String house) {
		this.house = house;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getThana() {
		return thana;
	}
	public void setThana(String thana) {
		this.thana = thana;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	
	
	
	
}
