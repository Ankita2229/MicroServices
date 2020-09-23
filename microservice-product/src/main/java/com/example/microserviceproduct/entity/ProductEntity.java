package com.example.microserviceproduct.entity;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class ProductEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "id")
	private long id;
	
//	private Collection<Review> reviews = new ArrayList<>();
	private Collection<ProductEntity> recommendations = new ArrayList<>();
	
	public Collection<ProductEntity> getRecommendations() {
		return recommendations;
	}

	public void setRecommendations(Collection<ProductEntity> recommendations) {
		this.recommendations = recommendations;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public int getProduct_qty() {
		return product_qty;
	}

	public void setProduct_qty(int product_qty) {
		this.product_qty = product_qty;
	}

	@JsonProperty("name")
    private String product_name;
	
	@JsonProperty("quantity")
	private int product_qty;
}
