package com.felipenunes.ranking.dao;

import java.util.List;

import com.felipenunes.ranking.entity.Period;

public interface PeriodDAO {

	public List<Period> getPeriod();

	public void savePeriod(Period period);

	public Period getPeriod(String periodId);

	public void deletePeriod(String periodId);	
	
}
