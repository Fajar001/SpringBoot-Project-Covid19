package com.lawencon.app.Covid19.dao;

import java.util.List;

import com.lawencon.app.Covid19.model.ListCovid;

public interface ListCovidDao {
	abstract List<ListCovid> findAll() throws Exception;
	abstract String insert() throws Exception;
	abstract ListCovid update(int id, int totalCases, int totalDeaths, int totalRecovered) throws Exception;
	abstract String deleteById(int id)throws Exception;
}
