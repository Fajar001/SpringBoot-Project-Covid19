package com.lawencon.app.Covid19.service;

import java.util.List;

import com.lawencon.app.Covid19.model.CovidCity;

public interface CovidCityService {
	abstract List<CovidCity> findAll() throws Exception;
	abstract String insertCity(CovidCity city) throws Exception;
	abstract String updateCity(int id, String cityName, int caseByCity, int deathsByCity, int recovered) throws Exception;
	abstract String deleteById(int id) throws Exception;
}
