package com.qbryx.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "product_inventory")
public class InventoryProduct extends Product {
	
	private long id;
	private Product product;
	private int stock;

	public InventoryProduct(Product product) {
		super(product.getUpc(), product.getCategory(), product.getName(), product.getDescription(), product.getPrice());
		// TODO Auto-generated constructor stub
	}
	
	public InventoryProduct(Product product, int stock) {
		super(product.getUpc(), product.getCategory(), product.getName(), product.getDescription(), product.getPrice());
		this.stock = stock;
	}
	
	public InventoryProduct(String upc, int stock){
		setUpc(upc);
		this.stock = stock;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	@Id @GeneratedValue
	@Column(name = "id")
	public long getId() {
		return id;
	}

	@Column(name = "stock")
	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}
	
	@OneToOne
	@JoinColumn(name = "upc", insertable=false, updatable=false)
	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
}
