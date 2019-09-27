package com.reki;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Player {
	private @Id @GeneratedValue Long id;
	private String name;
	private LocalDate regDate;

	Player(){}
	
	Player(String name){
		this.name = name;
		this.regDate = LocalDate.now();
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public LocalDate getRegDate() {
		return regDate;
	}
}
