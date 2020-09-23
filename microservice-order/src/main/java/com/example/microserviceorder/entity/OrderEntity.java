package com.example.microserviceorder.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class OrderEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "id")
	private long id;
	
	
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getOrder_status() {
		return order_status;
	}

	public void setOrder_status(String order_status) {
		this.order_status = order_status;
	}

	@JsonProperty("status")
    private String order_status;

//	public static enum Status {
//
//		/**
//		 * Placed, but not payed yet. Still changeable.
//		 */
//		PAYMENT_EXPECTED,
//
//		/**
//		 * {@link Order} was payed. No changes allowed to it anymore.
//		 */
//		PAID,
//
//		/**
//		 * The {@link Order} is currently processed.
//		 */
//		PREPARING,
//
//		/**
//		 * The {@link Order} is ready to be picked up by the customer.
//		 */
//		READY,
//
//		/**
//		 * The {@link Order} was completed.
//		 */
//		TAKEN;
//	}

}
