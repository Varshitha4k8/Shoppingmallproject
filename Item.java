package com.example.demo.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Item")

public class Item {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(name="itemname")
	private String itemname;
	@Column(name="price")
	private double price;
	@Column(name="manufacturingDate")
	private LocalDate manufacturingDate;
	@Column(name="expiry")
	private LocalDate expiry;
	public Item() {
		super();
	}
	public Item(long id, String itemname, double price, LocalDate manufacturingDate, LocalDate expiry) {
		super();
		this.id = id;
		this.itemname = itemname;
		this.price = price;
		this.manufacturingDate = manufacturingDate;
		this.expiry = expiry;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getItemname() {
		return itemname;
	}
	public  void setItemname(String itemname) {
		this.itemname = itemname;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public LocalDate getManufacturingDate() {
		return manufacturingDate;
	}
	public void setManufacturingDate(LocalDate manufacturingDate) {
		this.manufacturingDate = manufacturingDate;
	}
	public LocalDate getExpiry() {
		return expiry;
	}
	public void setExpiry(LocalDate expiry) {
		this.expiry = expiry;
	}
	@Override
	public String toString() {
		return "Item [id=" + id + ", itemname=" + itemname + ", price=" + price + ", manufacturingDate="
				+ manufacturingDate + ", expiry=" + expiry + "]";
	}
	

}


