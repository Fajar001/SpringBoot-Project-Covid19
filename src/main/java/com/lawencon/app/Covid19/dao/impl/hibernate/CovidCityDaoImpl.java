package com.lawencon.app.Covid19.dao.impl.hibernate;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.lawencon.app.Covid19.dao.CovidCityDao;
import com.lawencon.app.Covid19.model.CovidCity;

@Repository("covid-city_repo_hibernate")
public class CovidCityDaoImpl extends BaseHibernate implements CovidCityDao{

	@Override
	public String insertCity(CovidCity city) throws Exception {
		em.persist(city);
		return "Success Insert";
	}

	@Override
	public CovidCity updateCity(int id, String cityName, int caseByCity, int deathsByCity, int recovered) throws Exception {
		Query q = em.createQuery("from CovidCity where idCovidCity = :idParam");
		q.setParameter("idParam", id);
		CovidCity city = new CovidCity();
		city = (CovidCity) q.getSingleResult();
		city.setCityName(cityName);
		city.setCaseByCity(caseByCity);
		city.setDeathsByCity(deathsByCity);
		city.setRecovered(recovered);
		em.merge(city);
		return city;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<CovidCity> findAll() throws Exception {
		Query q = em.createQuery("from CovidCity");
		return q.getResultList();
	}

	@Override
	public String deleteById(int id) throws Exception {
		Query q = em.createQuery("from CovidCity where idCovidCity = :idParam");
		q.setParameter("idParam", id);
		CovidCity city = new CovidCity();
		city = (CovidCity) q.getSingleResult();
		city.setIdCovidCity(id);
		em.remove(city);
		return "Deleted...";
	}
	
}
