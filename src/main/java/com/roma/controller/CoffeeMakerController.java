package com.roma.controller;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.roma.entity.CoffeeMaker;
import com.roma.service.CoffeeMakerService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "coffeemaker", description = "Работа кофеварки")
@RestController
@RequestMapping(value = "/coffeemaker")
public class CoffeeMakerController {
	
	private final CoffeeMakerService coffeeMakerService;
		
	@Autowired
	public CoffeeMakerController(CoffeeMakerService coffeeMakerService) {
		this.coffeeMakerService = coffeeMakerService;
	}	
	
	@Operation(summary = "Создание новой кофеварки", description = "Создание новой кофеварки")
	@PostMapping
	public ResponseEntity<?> create(@RequestBody CoffeeMaker coffeeMaker) {
		coffeeMakerService.create(coffeeMaker);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@Operation(summary = "Получение списка кофеварок", description = "Получение списка кофеварок")
	@GetMapping
	public ResponseEntity<List<CoffeeMaker>> getAll() {
		final List<CoffeeMaker> coffeeMakers = coffeeMakerService.getAll();		
		return coffeeMakers != null ? new ResponseEntity<>(coffeeMakers, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@Operation(summary = "Получение кофеварки (по id)", description = "Получение кофеварки (по id)")
	@GetMapping(value = "/{id}")
	public ResponseEntity<CoffeeMaker> getCoffeeMaker(@PathVariable(name = "id") int id) {
		final CoffeeMaker coffeeMaker = coffeeMakerService.getCoffeeMaker(id);
		return coffeeMaker != null ? new ResponseEntity<>(coffeeMaker, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);		
	}
	
	@Operation(summary = "Изменение кофеварки (по id)", description = "Изменение кофеварки (по id)")
	@PutMapping(value = "/{id}")
	public ResponseEntity<?> update(@RequestBody CoffeeMaker coffeeMaker, @PathVariable(name = "id") int id) {
		final boolean updated = coffeeMakerService.update(coffeeMaker, id);
		return updated ? new ResponseEntity<>(HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);		
	}
	
	@Operation(summary = "Удаление кофеварки (по id)", description = "Удаление кофеварки (по id)")
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> delete(@PathVariable(name = "id") int id) {
		final boolean deleted = coffeeMakerService.delete(id);
		return deleted ? new ResponseEntity<>(HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);		
	}
	
	@Operation(summary = "Старт работы кофеварки", description = "Старт работы кофеварки")
	@PostMapping(value = "/start/{id}")
	public ResponseEntity<?> start(@RequestBody Timestamp timestamp, @PathVariable(name = "id") int id) {
		final boolean updated = coffeeMakerService.start(timestamp, id);
		return updated ? new ResponseEntity<>(HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);		
	}
	
	@Operation(summary = "Завершение работы кофеварки", description = "Завершение работы кофеварки")
	@PostMapping(value = "/stop/{id}")
	public ResponseEntity<?> stop(@RequestBody Timestamp timestamp, @PathVariable(name = "id") int id) {
		final boolean updated = coffeeMakerService.stop(timestamp, id);
		return updated ? new ResponseEntity<>(HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);		
	}

}
