package com.lawencon.app.Covid19.dao;

import java.util.List;

import com.lawencon.app.Covid19.model.CovidCity;

public interface CovidCityDao {
	abstract String insertCity(CovidCity city) throws Exception;
	abstract CovidCity updateCity(int id, String cityName, int caseByCity, int deathsByCity, int recovered) throws Exception;
	abstract List<?> findAllTotal() throws Exception;
	abstract List<CovidCity> findAll() throws Exception;
	abstract List<CovidCity> findByid(int id) throws Exception;
	abstract String deleteById(int id) throws Exception;
}
