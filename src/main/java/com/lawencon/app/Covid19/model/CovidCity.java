package com.lawencon.app.Covid19.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "covid_city")
public class CovidCity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idCovidCity;
	private String cityName;
	private int caseByCity, deathsByCity, recovered;
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public int getRecovered() {
		return recovered;
	}
	public void setRecovered(int recovered) {
		this.recovered = recovered;
	}
	public int getIdCovidCity() {
		return idCovidCity;
	}
	public void setIdCovidCity(int idCovidCity) {
		this.idCovidCity = idCovidCity;
	}
	public int getCaseByCity() {
		return caseByCity;
	}
	public void setCaseByCity(int caseByCity) {
		this.caseByCity = caseByCity;
	}
	public int getDeathsByCity() {
		return deathsByCity;
	}
	public void setDeathsByCity(int deathsByCity) {
		this.deathsByCity = deathsByCity;
	}
}
