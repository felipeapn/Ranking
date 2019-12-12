package com.felipenunes.ranking.dao;

import java.util.List;

import com.felipenunes.ranking.entity.Challenge;
import com.felipenunes.ranking.entity.ChallengeId;

public interface ChallengeDAO {

	public List<Challenge> getChallenges();

	public void saveChallenge(Challenge challenge);

	public Challenge getChallenge(ChallengeId challengeId);

	public void deleteChallenge(ChallengeId challengeId);
	
}

