package com.lunatech.airportsandrunways;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="countries")
public class Country implements Serializable{	
	private static final long serialVersionUID = 7767951182825632602L;
	public String getName() {
		return name;
	}
	
	public String getCode() {
		return code;
	}

	@Id
	private int id;
	
	private String code;
	@Column(name="wikipedia_link")
	private String wiki;//
	private String continent;
	private String name;
	private String keywords;
}