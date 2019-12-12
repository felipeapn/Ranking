package com.felipenunes.ranking.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.felipenunes.ranking.entity.Period;
import com.felipenunes.ranking.entity.Player;
import com.felipenunes.ranking.service.PeriodService;

@RestController
@RequestMapping("/api")
public class PeriodRestController {
	
	@Autowired
	private PeriodService periodService;
	
	
	@GetMapping("/periods")
	public List<Period> getPeriod() {
		return periodService.getPeriod();
	}
	@GetMapping("/periods/{periodId}")
	public Period getPeriod(@PathVariable String periodId) {
		
		Period period = periodService.getPeriod(periodId);
		
		if (period == null) {
			throw new PlayerNotFoundException("Period ID not found - " + periodId);
		}
		
		return period;

	}

	@PostMapping("/periods")
	public Period createPeriod(@RequestBody Period period) {
				
		periodService.savePlayer(period);
		
		return period;

	}
	
	@PutMapping("/periods")
	public Period updatePeriod(@RequestBody Period period) {
		
		periodService.savePlayer(period);
		
		return period;

	}
}
