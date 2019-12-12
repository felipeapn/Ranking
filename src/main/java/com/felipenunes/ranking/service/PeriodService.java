package com.felipenunes.ranking.service;

import java.util.List;

import com.felipenunes.ranking.entity.Period;

public interface PeriodService {

	public List<Period> getPeriod();

	public void savePlayer(Period period);

	public Period getPeriod(String periodId);

	public void deletePlayer(String periodId);
}
