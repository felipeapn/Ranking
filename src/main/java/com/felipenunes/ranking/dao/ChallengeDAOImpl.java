package com.felipenunes.ranking.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.felipenunes.ranking.entity.Challenge;
import com.felipenunes.ranking.entity.ChallengeId;
import com.felipenunes.ranking.entity.Period;

@Repository
public class ChallengeDAOImpl implements ChallengeDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Challenge> getChallenges() {
		
		Session currentSession = sessionFactory.getCurrentSession();

		Query<Challenge> query = currentSession.createQuery("from Challenge", Challenge.class);

		List<Challenge> challenge = query.getResultList();

		return challenge;
	}

	@Override
	public void saveChallenge(Challenge challenge) {
		
		Session currentSession = sessionFactory.getCurrentSession();

		currentSession.saveOrUpdate(challenge);

	}

	@Override
	public Challenge getChallenge(ChallengeId challengeId) {

		Session currentSession = sessionFactory.getCurrentSession();
		
		Challenge challenge = currentSession.get(Challenge.class, challengeId);
		
		return challenge;
	}

	@Override
	public void deleteChallenge(ChallengeId challengeId) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query query = currentSession.createQuery("delete from Challenge where challengeId=:challengeId");
		query.setParameter("challengeId", challengeId);
		
		query.executeUpdate();
	}

}
