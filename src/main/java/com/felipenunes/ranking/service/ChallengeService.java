package com.felipenunes.ranking.service;

import java.util.List;

import com.felipenunes.ranking.entity.Challenge;
import com.felipenunes.ranking.entity.ChallengeId;

public interface ChallengeService {

	public List<Challenge> getChallenges();

	public void saveChallenge(Challenge challenge);

	public Challenge getChallenge(ChallengeId challengeId);

	public void deleteChallenge(ChallengeId challengeId);
}
