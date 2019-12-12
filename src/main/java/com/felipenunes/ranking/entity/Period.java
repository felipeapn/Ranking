package com.felipenunes.ranking.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="period")
public class Period {
	
	@Id
	@Column(name="period")
	private String periodId;
	
	@Column(name="status")
	private String status;

	public String getPeriod() {
		return periodId;
	}

	public void setPeriod(String period) {
		this.periodId = period;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Period [periodId=" + periodId + ", status=" + status + "]";
	}

}
