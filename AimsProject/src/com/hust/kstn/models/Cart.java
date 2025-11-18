package com.hust.kstn;
import java.util.Arrays;
import java.util.Comparator;

public class Cart {
	private static final int MAX_NUMBER_ORDERED = 20;
	public static DigitalVideoDisc[] itemsInCart = new DigitalVideoDisc[MAX_NUMBER_ORDERED];
	
	// đếm cập nhật số lượng dvd
	public int qtyOrdered() {
		int i = 0;
		for (DigitalVideoDisc item : itemsInCart) {
			if (item != null) {
			i += 1;
			}
		}
		return i;
	} 
	
	// thêm dvd
	public void addDVD(DigitalVideoDisc disc) {
		if (qtyOrdered()==20) {
			System.out.println("The cart is almost full");
		}
		else if (qtyOrdered()<20) {
			itemsInCart[qtyOrdered()] = disc;
			System.out.println("The disc has been added sucessfully");
		}
	}

    public void addDVD(DigitalVideoDisc disc1, DigitalVideoDisc disc2) {
		if (qtyOrdered()==20) {
			System.out.println("The cart is almost full");
		}
		else if (qtyOrdered()<20) {
			itemsInCart[qtyOrdered()] = disc1;
			System.out.println("The disc1 has been added sucessfully");
		}
		if (qtyOrdered()==20) {
			System.out.println("The cart is almost full");
		}
		else if (qtyOrdered()<20) {
			itemsInCart[qtyOrdered()] = disc2;
			System.out.println("The disc2 has been added sucessfully");
		}
	}

    
	
	// xoá dvd
	public void removeDVD(DigitalVideoDisc disc) {
		int qtyOrdered = qtyOrdered();
		int index_remove = -1;
		if (qtyOrdered == 0) {
		System.out.println("The cart is empty");
		}
		else if (qtyOrdered > 0) {
			for (int j = 0; j<qtyOrdered; j++) {
				if (itemsInCart[j].equals(disc)) {
					index_remove = j;
					break;
				}
			}
			if (index_remove != -1) {
			for (int j = index_remove; j<qtyOrdered-1; j++) {
				itemsInCart[j] = itemsInCart[j+1];
				itemsInCart[qtyOrdered] = null;
				}
			}
			else {System.out.println("The disc does not exist");}
		}
	}
	
	// tính tổng phí mua dvd
	public double calculateTotalCost() {
		double totalCost = 0.0;
		for (DigitalVideoDisc item : itemsInCart) {
			totalCost += item.getPrice(); 
		}
		return totalCost;
	}
	
	// in ra thông tin tất cả các dvd trong giỏ
	public void print() {
		System.out.println("=== Total items in cart: "+ qtyOrdered() + "===");
		System.out.println("=== All items in cart ===");
		for (DigitalVideoDisc item : itemsInCart) {
			System.out.println("[Title]: " + item.getTitle() + "," + "[Price]:" + item.getPrice() + "," + 
		"[Category]: ");
		}
	}
	
	public void sortByTitle() {
		Arrays.sort(itemsInCart, Comparator.comparing(s->s.getTitle()));
	}
	public void sortByPrice() {
		Arrays.sort(itemsInCart, Comparator.comparingDouble(p -> p.getPrice()));
	}
	public void fOutById(String id) {
		for (DigitalVideoDisc item : itemsInCart) {
			if (item.equals(id)) {
				
			}
		}
	}
	public void placeOrder() {
		
	}
	public void randomDVD() {
		
	}
	public void playDemoDVD() {
		
	}
	// Phương thức khởi tạo
}
