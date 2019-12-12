package com.felipenunes.ranking.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.felipenunes.ranking.dao.PlayerDAO;
import com.felipenunes.ranking.entity.Player;

@Service
public class PlayerServiceImpl implements PlayerService {

	@Autowired
	private PlayerDAO playerDAO;

	@Override
	@Transactional
	public List<Player> getPlayers() {
		return playerDAO.getPlayers();
	}

	@Override
	@Transactional
	public void savePlayer(Player player) {
		playerDAO.savePlayer(player);	
	}

	@Override
	@Transactional
	public Player getPlayer(int id) {
		return playerDAO.getPlayer(id);
	}

	@Override
	@Transactional
	public void deletePlayer(int id) {
		playerDAO.deletePlayer(id);
	}
	

}





