package com.example.RestTemplete.BO;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class BitRate {
	@Id
	private String code;
	private String name;
	private int rate;
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getRate() {
		return rate;
	}
	public void setRate(int rate) {
		this.rate = rate;
	}
	public BitRate(String code, String name, int rate) {
		super();
		this.code = code;
		this.name = name;
		this.rate = rate;
	}
	public BitRate() {
		super();
	}

	
}
