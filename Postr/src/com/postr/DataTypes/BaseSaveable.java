package com.postr.DataTypes;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Index;

@Entity
public class BaseSaveable {
	@Id Long id;
	public Long getId() {
		return id;
	}

	public void setPersona(String persona) {
		this.persona = persona;
	}

	
	@Index
	String persona;
	
	protected BaseSaveable(){}

	public BaseSaveable(BaseSaveable existingData) {
		this.id = existingData.id;
	}
}
