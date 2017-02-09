package com.jpinto.basedepizza.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@Entity
@Table(name = "por_pizza")
public class Pizza {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	private boolean isVegetarian;
	
	@NotNull
	@Size(max=50)
	private String name;
	
	@NotNull
	@Size(max=255)
	private String description;
	
	@NotNull
	private float priceInEuros;
	
	
	
}
