package com.felipenunes.ranking.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Embeddable
public class ChallengeId implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@ManyToOne
    @JoinColumn(name = "period")
	private Period period;
	
	@ManyToOne
    @JoinColumn(name = "challenger")
	private Player challenger;
	
	@ManyToOne
    @JoinColumn(name = "challenged")
	private Player challenged;

	public Period getPeriod() {
		return period;
	}

	public void setPeriod(Period period) {
		this.period = period;
	}

	public Player getChallenger() {
		return challenger;
	}

	public void setChallenger(Player challenger) {
		this.challenger = challenger;
	}

	public Player getChallenged() {
		return challenged;
	}

	public void setChallenged(Player challenged) {
		this.challenged = challenged;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((challenged == null) ? 0 : challenged.hashCode());
		result = prime * result + ((challenger == null) ? 0 : challenger.hashCode());
		result = prime * result + ((period == null) ? 0 : period.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ChallengeId other = (ChallengeId) obj;
		if (challenged == null) {
			if (other.challenged != null)
				return false;
		} else if (!challenged.equals(other.challenged))
			return false;
		if (challenger == null) {
			if (other.challenger != null)
				return false;
		} else if (!challenger.equals(other.challenger))
			return false;
		if (period == null) {
			if (other.period != null)
				return false;
		} else if (!period.equals(other.period))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ChallengeId [period=" + period + ", challenger=" + challenger + ", challenged=" + challenged + "]";
	}
		
}
