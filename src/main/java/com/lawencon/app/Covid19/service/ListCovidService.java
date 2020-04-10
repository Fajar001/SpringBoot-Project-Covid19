package com.lawencon.app.Covid19.service;

import java.util.List;

import com.lawencon.app.Covid19.model.ListCovid;

public interface ListCovidService {
	abstract List<ListCovid> findAll() throws Exception;
	abstract String insert() throws Exception;
	abstract String update(int id, int totalCases, int totalDeaths, int totalRecovered) throws Exception;
	abstract String deleteById(int id)throws Exception;
}
