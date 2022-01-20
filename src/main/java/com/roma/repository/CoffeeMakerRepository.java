package com.roma.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.roma.entity.CoffeeMaker;

@Repository
public interface CoffeeMakerRepository extends JpaRepository<CoffeeMaker, Integer> {

}
