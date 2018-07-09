package com.lunatech.airportsandrunways;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name="airports")
public class Airport {	
	
	public String getName() {
		return name;
	}
	
	public int getId() {
		return id;
	}

	@Id
	private int id;
	private String ident;//
	private String type;		
	private String name;	
	@Column(name="latitude_deg")
	private float latitude;
	@Column(name="longitude_deg")
	private float longitude;
	@Column(name="elevation_ft")
	private int elevation;
	private String continent;
	@ManyToOne
	@JoinColumn(name="iso_country", referencedColumnName = "code", nullable=false, updatable=false)
	private Country country;
	//private String isoCountry;
	private String isoRegion;
	private String municipality;//
	private boolean scheduledService;
	private String gpsCode;//
	private String iataCode;
	private String localCode;//
	private String homeLink;//link
	@Column(name="wikipedia_link")
	private String wiki;//link
	private String keywords;
}
