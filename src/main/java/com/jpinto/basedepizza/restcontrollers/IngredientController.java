package com.jpinto.basedepizza.restcontrollers;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jpinto.basedepizza.daos.IngredientDAO;
import com.jpinto.basedepizza.model.Ingredient;



@RestController
@RequestMapping("/ingredient")
public class IngredientController {
	
	private Logger logger = LoggerFactory.getLogger(IngredientController.class);

	@Autowired
	private IngredientDAO ingredientDao;
	
	@RequestMapping(value="/all", method=RequestMethod.GET)
	public List<Ingredient> getAll(HttpServletResponse response){
		
		return this.ingredientDao.getAllIngredients();
	}
	
	
	@RequestMapping(value="/create", method=RequestMethod.POST)
	public Ingredient create(@RequestBody Ingredient ingredient, HttpServletResponse response){
		
		logger.error("Creating ingredient. Dao class: "+this.ingredientDao.getClass().toString());
		
		return this.ingredientDao.save(ingredient);
	}
	
	
}