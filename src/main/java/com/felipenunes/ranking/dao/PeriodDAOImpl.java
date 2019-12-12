package com.felipenunes.ranking.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.felipenunes.ranking.entity.Period;

@Repository
public class PeriodDAOImpl implements PeriodDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Period> getPeriod() {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query<Period> query = currentSession.createQuery("from Period order by periodId", Period.class);
		
		List<Period> periods = query.getResultList();
		
		return periods;
	}

	@Override
	public void savePeriod(Period period) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		currentSession.saveOrUpdate(period);

	}

	@Override
	public Period getPeriod(String periodId) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		Period period = currentSession.get(Period.class, periodId);
		
		return period;

	}

	@Override
	public void deletePeriod(String periodId) {
		// TODO Auto-generated method stub

	}

}
