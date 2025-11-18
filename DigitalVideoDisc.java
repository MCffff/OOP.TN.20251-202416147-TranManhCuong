package com.hust.kstn;

public class DigitalVideoDisc {
	private String title;
	private String category;
	private String director;
	private int length;
	private String id;
	private double price;
	public String getTitle() {
		return title;
	}
	public String getCategory() {
		return category;
	}
	public String getDirector() {
		return director;
	}
	public int getLength() {
		return length;
	}
	public String getId() {
		return id;
	}
	public double getPrice() {
		return price;
	}
	public DigitalVideoDisc(String title, String category, String director, String id, 
			int length, double price){
		this.title= title;
		this.category = category;
		this.director = director;
		this.id = id;
		this.length = length;
		this.price = price;
	}
}
