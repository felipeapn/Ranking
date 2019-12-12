package com.felipenunes.ranking.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity(name = "Challenge")
@Table(name = "challenge")
public class Challenge {
	
	@EmbeddedId
	private ChallengeId challengeId;
	
	@Column(name="challenge_date")
	private Date challengeDate;
	
	@Column(name="game_date")
	private Date gameDate;
	
	@Column(name="challenger_set")
	private Integer challengerSets;
	
	@Column(name="challenged_set")
	private Integer challengedSets;
	
	@Column(name="comments")
	private String comments;

	public ChallengeId getChallengeId() {
		return challengeId;
	}

	public void setChallengeId(ChallengeId challengeId) {
		this.challengeId = challengeId;
	}

	public Date getChallengeDate() {
		return challengeDate;
	}

	public void setChallengeDate(Date challengeDate) {
		this.challengeDate = challengeDate;
	}

	public Date getGameDate() {
		return gameDate;
	}

	public void setGameDate(Date gameDate) {
		this.gameDate = gameDate;
	}

	public int getChallengerSets() {
		return challengerSets;
	}

	public void setChallengerSets(int challengerSets) {
		this.challengerSets = challengerSets;
	}

	public int getChallengedSets() {
		return challengedSets;
	}

	public void setChallengedSets(int challengedSets) {
		this.challengedSets = challengedSets;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	@Override
	public String toString() {
		return "Challenge [challengeId=" + challengeId + ", challengeDate=" + challengeDate + ", gameDate=" + gameDate
				+ ", challengerSets=" + challengerSets + ", challengedSets=" + challengedSets + ", comments=" + comments
				+ "]";
	}
	
}
