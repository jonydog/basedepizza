package com.jpinto.basedepizza.business.interfaces;

import org.springframework.validation.Errors;

import com.jpinto.basedepizza.model.Pizza;

public interface PizzaService {

	public void createNewPizza(Pizza pizza, Errors errors);
}
