package com.eval.coronakit.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CoronaKit {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="delivery_address")
	private String deliveryAddress;
	
	@Column(name="order_date")
	private String orderDate;
	
	@Column(name="total_amount")
	private double totalAmount;
	
	
	public CoronaKit() {
		// TODO Auto-generated constructor stub
	}

	public CoronaKit(int id, String deliveryAddress, String orderDate, int totalAmount) {
		super();
		this.id = id;
		this.deliveryAddress = deliveryAddress;
		this.orderDate = orderDate;
		this.totalAmount = totalAmount;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDeliveryAddress() {
		return deliveryAddress;
	}
	public void setDeliveryAddress(String deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}
	public String getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}
	public double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(double totalamount2) {
		this.totalAmount = totalamount2;
	}

}
