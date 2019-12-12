package com.felipenunes.ranking.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.felipenunes.ranking.entity.Player;

@Repository
public class PlayerDAOImpl implements PlayerDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Player> getPlayers() {

		Session currentSession = sessionFactory.getCurrentSession();

		Query<Player> query = currentSession.createQuery("from Player order by lastName", Player.class);

		List<Player> players = query.getResultList();

		return players;
	}

	@Override
	public void savePlayer(Player player) {

		Session currentSession = sessionFactory.getCurrentSession();

		currentSession.saveOrUpdate(player);

	}

	@Override
	public Player getPlayer(int id) {

		Session currentSession = sessionFactory.getCurrentSession();

		Player player = currentSession.get(Player.class, id);

		return player;
	}

	@Override
	public void deletePlayer(int id) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query theQuery = currentSession.createQuery("delete from Player where id=:playerId");
		theQuery.setParameter("playerId", id);
		
		theQuery.executeUpdate();

	}

}
