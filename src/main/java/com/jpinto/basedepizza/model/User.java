package com.jpinto.basedepizza.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.validator.constraints.NotEmpty;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Setter
@Getter
@ToString
@Entity
@Table(name = "users")
public class User implements Serializable {
	private static final long serialVersionUID = 270990445985081124L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotEmpty
	@Size(max = 255)
	private String email;
	
	@NotEmpty
	@Size(max = 255)
	private String password;

	@NotEmpty
	@Size(max = 255)
	private String phone;
	
	@Size(max = 255)
	private String secondPhone;

	@CreationTimestamp
	private Date created;
	
	@UpdateTimestamp
	private Date updated;
	

	public User(String email, String password, String phone) {
		super();
		this.password = password;
		this.phone = phone;
		this.email = email;
	}

}
