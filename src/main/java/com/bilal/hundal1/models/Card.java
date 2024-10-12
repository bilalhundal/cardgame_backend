package com.bilal.hundal1.models;

import lombok.Getter;
import lombok.Setter;

/**
 * This is POJO model class
 */
@Getter
@Setter
public class Card {
	private String id;
	private String name;
	private int number;
	public Card() {
		
	}
	public Card(String name, int number,String id) {
		super();
		this.name = name;
		this.number = number;
		this.id=id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	

}
