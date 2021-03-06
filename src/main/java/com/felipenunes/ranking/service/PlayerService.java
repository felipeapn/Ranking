package com.felipenunes.ranking.service;

import java.util.List;

import com.felipenunes.ranking.entity.Player;

public interface PlayerService {

	public List<Player> getPlayers();

	public void savePlayer(Player player);

	public Player getPlayer(int id);

	public void deletePlayer(int id);
	
}
