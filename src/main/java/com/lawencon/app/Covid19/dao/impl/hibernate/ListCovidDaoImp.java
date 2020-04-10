package com.lawencon.app.Covid19.dao.impl.hibernate;

import java.util.List;
import java.util.Map;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.lawencon.app.Covid19.dao.ListCovidDao;
import com.lawencon.app.Covid19.model.ListCovid;

@Repository("list-covid_repo_hibernate")
public class ListCovidDaoImp extends BaseHibernate implements ListCovidDao{

	@SuppressWarnings("unchecked")
	@Override
	public List<ListCovid> findAll() throws Exception {
		Query q = em.createQuery("from ListCovid");
		return q.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public String insert() throws Exception {
		Query q = em.createNativeQuery("select sum(case_by_city) as sum1, sum(deaths_by_city) as sum2, sum(recovered) from covid_city");
		List<Map<String, Object>> listResult = bMapperHibernate(q.getResultList(), "Total_cases", "Total_deaths", "Total_Recovered");
		if(!listResult.isEmpty()) {
			ListCovid listCovid = new ListCovid();
			listCovid.setTotalCasesInfection(Integer.valueOf(listResult.get(0).get("Total_cases").toString()));
			listCovid.setTotalDeaths(Integer.valueOf(listResult.get(0).get("Total_deaths").toString()));
			listCovid.setTotalRecovered(Integer.valueOf(listResult.get(0).get("Total_Recovered").toString()));
			em.persist(listCovid);
		}
		else {
			return"Failed Insert! cause zero list";
		}
		
		return "Success Input";
	}

	@Override
	public ListCovid update(int id, int totalCases, int totalDeaths, int totalRecovered) throws Exception {
		Query q = em.createQuery("from ListCovid where idListCovid = :idParam");
		q.setParameter("idParam", id);
		ListCovid covid = new ListCovid();
		covid = (ListCovid) q.getSingleResult();
		covid.setTotalCasesInfection(totalCases);
		covid.setTotalDeaths(totalDeaths);
		covid.setTotalRecovered(totalRecovered);
		em.merge(covid);
		return covid;
	}

	@Override
	public String deleteById(int id) throws Exception {
		Query q = em.createQuery("from ListCovid where idListCovid = :idParam");
		q.setParameter("idParam", id);
		ListCovid covid = new ListCovid();
		covid = (ListCovid) q.getSingleResult();
		covid.setIdListCovid(id);
		em.remove(covid);
		return "Deleted...";
	}
	
}
