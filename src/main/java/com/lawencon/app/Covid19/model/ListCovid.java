package com.lawencon.app.Covid19.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "list_covid")
public class ListCovid {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idListCovid;
	private int totalCasesInfection, totalDeaths, totalRecovered;
	
	public int getTotalRecovered() {
		return totalRecovered;
	}

	public void setTotalRecovered(int totalRecovered) {
		this.totalRecovered = totalRecovered;
	}

	public int getIdListCovid() {
		return idListCovid;
	}

	public void setIdListCovid(int idListCovid) {
		this.idListCovid = idListCovid;
	}

	public int getTotalCasesInfection() {
		return totalCasesInfection;
	}

	public void setTotalCasesInfection(int totalCasesInfection) {
		this.totalCasesInfection = totalCasesInfection;
	}

	public int getTotalDeaths() {
		return totalDeaths;
	}

	public void setTotalDeaths(int totalDeaths) {
		this.totalDeaths = totalDeaths;
	}
}
