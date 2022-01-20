package com.roma.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.v3.oas.annotations.media.Schema;

@Entity
@Table(name = "coffee_maker")
public class CoffeeMaker {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	@Schema(accessMode = Schema.AccessMode.READ_ONLY)
	private Integer id;
	
	@Column(name = "coffee_maker")
	private String coffeeMaker;
	
	@Column(name = "coffee_beverage")
	private String coffeeBeverage;
	
	@Column(name = "beg_work")
	@Schema(accessMode = Schema.AccessMode.READ_ONLY)
	private Timestamp begWork;
	
	@Column(name = "end_work")
	@Schema(accessMode = Schema.AccessMode.READ_ONLY)
	private Timestamp endWork;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCoffeeMaker() {
		return coffeeMaker;
	}

	public void setCoffeeMaker(String coffeeMaker) {
		this.coffeeMaker = coffeeMaker;
	}

	public String getCoffeeBeverage() {
		return coffeeBeverage;
	}

	public void setCoffeeBeverage(String coffeeBeverage) {
		this.coffeeBeverage = coffeeBeverage;
	}

	public Timestamp getBegWork() {
		return begWork;
	}

	public void setBegWork(Timestamp begWork) {
		this.begWork = begWork;
	}

	public Timestamp getEndWork() {
		return endWork;
	}

	public void setEndWork(Timestamp endWork) {
		this.endWork = endWork;
	}

}
