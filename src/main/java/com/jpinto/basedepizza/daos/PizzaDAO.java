package com.jpinto.basedepizza.daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.jpinto.basedepizza.model.Pizza;

public interface PizzaDAO extends JpaRepository<Pizza,Long>{
	
	
	@Query("select p from Pizza p where p.name=:pizzaName")
	public List<Pizza> getPizzaByName( @Param("pizzaName") String name);
	
	@Query("select p from Pizza p")
	public List<Pizza> getAllPizzas();
	
}
