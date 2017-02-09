package com.jpinto.basedepizza.restcontrollers;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jpinto.basedepizza.daos.PizzaDAO;
import com.jpinto.basedepizza.model.Pizza;

@RestController
@RequestMapping("/pizzas")
public class PizzaController {

	@Autowired
	private PizzaDAO pizzaDao;
	
	@RequestMapping(value="/all")
	public List<Pizza> getAll(HttpServletResponse response){
		
		return this.pizzaDao.getAllPizzas();
	}
	
	
	@RequestMapping(value="/create", method=RequestMethod.POST)
	public Pizza create(@RequestBody Pizza pizza, HttpServletResponse response){
		
		return this.pizzaDao.save(pizza);
	}
	
	
}
