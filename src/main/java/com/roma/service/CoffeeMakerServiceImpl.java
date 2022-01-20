package com.roma.service;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.roma.entity.CoffeeMaker;
import com.roma.repository.CoffeeMakerRepository;

@Service
@Transactional
public class CoffeeMakerServiceImpl implements CoffeeMakerService {
	
	@Autowired
	private CoffeeMakerRepository coffeeMakerRepository;

	@Override
	public void create(CoffeeMaker coffeeMaker) {
		coffeeMakerRepository.save(coffeeMaker);
	}

	@Override
	public List<CoffeeMaker> getAll() {
		return coffeeMakerRepository.findAll();
	}

	@Override
	public CoffeeMaker getCoffeeMaker(int id) {
		return coffeeMakerRepository.findById(id).get();
	}

	@Override
	public boolean update(CoffeeMaker coffeeMaker, int id) {		
		if (coffeeMakerRepository.existsById(id)) {
			coffeeMaker.setId(id);
			if (coffeeMaker.getCoffeeMaker() == coffeeMakerRepository.getById(id).getCoffeeMaker() || coffeeMaker.getCoffeeMaker() == null) {
				coffeeMaker.setCoffeeMaker(coffeeMakerRepository.getById(id).getCoffeeMaker());
			} else {
				coffeeMaker.setCoffeeMaker(coffeeMaker.getCoffeeMaker());
			}
			if (coffeeMaker.getCoffeeBeverage() == coffeeMakerRepository.getById(id).getCoffeeBeverage() || coffeeMaker.getCoffeeBeverage() == null) {
				coffeeMaker.setCoffeeBeverage(coffeeMakerRepository.getById(id).getCoffeeBeverage());
			} else {
				coffeeMaker.setCoffeeBeverage(coffeeMaker.getCoffeeBeverage());
			}
			coffeeMaker.setBegWork(coffeeMakerRepository.getById(id).getBegWork());
			coffeeMaker.setEndWork(coffeeMakerRepository.getById(id).getEndWork());
			coffeeMakerRepository.save(coffeeMaker);
			return true;
		}
		return false;
	}

	@Override
	public boolean delete(int id) {
		if (coffeeMakerRepository.existsById(id)) {
			coffeeMakerRepository.deleteById(id);
			return true;
		}
		return false;
	}

	@Override
	public boolean start(Timestamp timestamp, int id) {
		CoffeeMaker coffeeMaker = new CoffeeMaker();
		if (coffeeMakerRepository.existsById(id)) {
			coffeeMaker.setId(id);
			coffeeMaker.setCoffeeMaker(coffeeMakerRepository.getById(id).getCoffeeMaker());
			coffeeMaker.setCoffeeBeverage(coffeeMakerRepository.getById(id).getCoffeeBeverage());
			coffeeMaker.setBegWork(timestamp);
			coffeeMaker.setEndWork(null);
			coffeeMakerRepository.save(coffeeMaker);
			return true;
		}
		return false;
	}
	
	@Override
	public boolean stop(Timestamp timestamp, int id) {
		CoffeeMaker coffeeMaker = new CoffeeMaker();
		if (coffeeMakerRepository.existsById(id)) {
			if (coffeeMakerRepository.getById(id).getBegWork() != null) {
				coffeeMaker.setId(id);
				coffeeMaker.setCoffeeMaker(coffeeMakerRepository.getById(id).getCoffeeMaker());
				coffeeMaker.setCoffeeBeverage(coffeeMakerRepository.getById(id).getCoffeeBeverage());
				coffeeMaker.setBegWork(coffeeMakerRepository.getById(id).getBegWork());
				coffeeMaker.setEndWork(timestamp);
				coffeeMakerRepository.save(coffeeMaker);
				return true;
			}			
		}
		return false;
	}

}
