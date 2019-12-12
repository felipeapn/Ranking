package com.felipenunes.ranking.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.felipenunes.ranking.dao.ChallengeDAO;
import com.felipenunes.ranking.entity.Challenge;
import com.felipenunes.ranking.entity.ChallengeId;

@Service
public class ChallengeServiceImpl implements ChallengeService {
	
	@Autowired
	private ChallengeDAO challengeDAO;
	
	@Override
	@Transactional
	public List<Challenge> getChallenges() {
		return challengeDAO.getChallenges();
	}

	@Override
	@Transactional
	public void saveChallenge(Challenge challenge) {
		challengeDAO.saveChallenge(challenge);

	}

	@Override
	@Transactional
	public Challenge getChallenge(ChallengeId challengeId) {
		return challengeDAO.getChallenge(challengeId);
	}

	@Override
	@Transactional
	public void deleteChallenge(ChallengeId challengeId) {
		challengeDAO.deleteChallenge(challengeId);
	}

}
