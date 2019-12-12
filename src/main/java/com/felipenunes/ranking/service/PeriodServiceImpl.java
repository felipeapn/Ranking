package com.felipenunes.ranking.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.felipenunes.ranking.dao.PeriodDAO;
import com.felipenunes.ranking.entity.Period;

@Service
public class PeriodServiceImpl implements PeriodService {
	
	@Autowired
	private PeriodDAO periodDAO;

	@Override
	@Transactional
	public List<Period> getPeriod() {
		return periodDAO.getPeriod();
	}

	@Override
	@Transactional
	public void savePlayer(Period period) {
		periodDAO.savePeriod(period);
	}

	@Override
	@Transactional
	public Period getPeriod(String periodId) {
		return periodDAO.getPeriod(periodId);
	}

	@Override
	@Transactional
	public void deletePlayer(String periodId) {
		// TODO Auto-generated method stub

	}

}
