package com.roma.service;

import java.sql.Timestamp;
import java.util.List;

import com.roma.entity.CoffeeMaker;

public interface CoffeeMakerService {
	
	void create(CoffeeMaker coffeeMaker);
	
	List<CoffeeMaker> getAll();
	
	CoffeeMaker getCoffeeMaker(int id);
		
	boolean update(CoffeeMaker coffeeMaker, int id);
	
	boolean delete(int id);
	
	boolean start(Timestamp timestamp, int id);
	
	boolean stop(Timestamp timestamp, int id);
	
}
