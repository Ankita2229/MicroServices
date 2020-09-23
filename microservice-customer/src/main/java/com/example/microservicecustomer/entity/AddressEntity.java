package com.example.microservicecustomer.entity;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class AddressEntity {
	
	@NotNull
    private Long registerId;

    @NotNull
    private String zipCode;

    @NotNull
    @Size(min = 10, max = 50)
    private String location;

    @NotNull
    @Size(min = 10, max = 20)
    private String receiverName;

	public Long getRegisterId() {
		return registerId;
	}

	public void setRegisterId(Long registerId) {
		this.registerId = registerId;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getReceiverName() {
		return receiverName;
	}

	public void setReceiverName(String receiverName) {
		this.receiverName = receiverName;
	}
    
}
