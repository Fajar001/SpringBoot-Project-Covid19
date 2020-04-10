package com.lawencon.app.Covid19.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lawencon.app.Covid19.dao.ListCovidDao;
import com.lawencon.app.Covid19.model.ListCovid;

@Service
@Transactional
public class ListCovidServiceImpl implements ListCovidService{
	
	@Autowired
	@Qualifier("list-covid_repo_hibernate")
	private ListCovidDao listCovidDao;

	@Override
	public List<ListCovid> findAll() throws Exception {
		return listCovidDao.findAll();
	}

	@Override
	public String insert() throws Exception {
		return listCovidDao.insert();
	}

	@Override
	public String update(int id, int totalCases, int totalDeaths, int totalRecovered) throws Exception {
		listCovidDao.update(id, totalCases, totalDeaths, totalRecovered);
		return "updated...";
	}

	@Override
	public String deleteById(int id) throws Exception {
		return listCovidDao.deleteById(id);
	}
}
