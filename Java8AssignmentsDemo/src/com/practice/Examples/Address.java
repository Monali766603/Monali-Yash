package com.practice.Examples;

public class Address {
	private String zipcode;

	public Address(String zipcode) {
		super();
		this.zipcode = zipcode;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return zipcode;
	}

}
