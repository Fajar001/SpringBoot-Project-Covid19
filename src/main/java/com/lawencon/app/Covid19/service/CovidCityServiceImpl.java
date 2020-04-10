package com.lawencon.app.Covid19.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lawencon.app.Covid19.dao.CovidCityDao;
import com.lawencon.app.Covid19.model.CovidCity;

@Service
@Transactional
public class CovidCityServiceImpl implements CovidCityService{
	
	@Autowired
	@Qualifier("covid-city_repo_hibernate")
	private CovidCityDao covidCityDao;

	@Override
	public List<CovidCity> findAll() throws Exception {
		return covidCityDao.findAll();
	}

	@Override
	public String insertCity(CovidCity city) throws Exception {
		return covidCityDao.insertCity(city);
	}

	@Override
	public String updateCity(int id, String cityName, int caseByCity, int deathsByCity, int recovered) throws Exception {
		covidCityDao.updateCity(id, cityName, caseByCity, deathsByCity, recovered);
		return "updated...";
	}

	@Override
	public String deleteById(int id) throws Exception {
		return covidCityDao.deleteById(id);
	}
}
