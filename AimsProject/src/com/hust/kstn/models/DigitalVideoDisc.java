package com.hust.kstn;

public class DigitalVideoDisc {
	private String title;
	private String category;
	private String director;
	private int length;
	private int id;
	private double price;
	private static int nbDigitalVideoDiscs = 0;
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
	public int getId() {
		return id;
	}
	public double getPrice() {
		return price;
	}
	public DigitalVideoDisc(String title, String category, String director, 
			int length, double price){
		nbDigitalVideoDiscs += 1;
		this.title= title;
		this.category = category;
		this.director = director;
		this.id = nbDigitalVideoDiscs;
		this.length = length;
		this.price = price;
	}
}
