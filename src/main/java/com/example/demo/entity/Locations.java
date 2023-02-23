package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Locations {
	@Id
	private Integer id;
	private String locationName;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getLocationName() {
		return locationName;
	}
	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}
	@Override
	public String toString() {
		return "Locations [id=" + id + ", locationName=" + locationName + "]";
	}
}
