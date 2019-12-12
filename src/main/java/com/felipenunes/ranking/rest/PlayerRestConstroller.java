package com.felipenunes.ranking.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.felipenunes.ranking.entity.Player;
import com.felipenunes.ranking.service.PlayerService;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class PlayerRestConstroller {
	
	@Autowired
	private PlayerService playerService;
	
	@GetMapping("/players")
	public List<Player> getPlayers() {
		return playerService.getPlayers();		
	}
	
	@GetMapping("/players/{playerId}")
	public Player getPlayer(@PathVariable int playerId) {
		
		Player player = playerService.getPlayer(playerId);
		
		if (player == null) {
			throw new PlayerNotFoundException("Player ID not found - " + playerId);
		}
		
		return player;

	}

	@PostMapping("/players")
	public Player createPlayer(@RequestBody Player player) {
		
		player.setId(0);
		
		playerService.savePlayer(player);
		
		return player;

	}
	
	@PutMapping("/players")
	public Player updatePlayer(@RequestBody Player player) {
		
		playerService.savePlayer(player);
		
		return player;

	}
	
	@DeleteMapping("/players/{playerId}")
	public String deletePlayer(@PathVariable int playerId) {
		
		Player player = playerService.getPlayer(playerId);
		
		if (player == null) {
			throw new PlayerNotFoundException("Player ID not found - " + playerId);
		}
		
		playerService.deletePlayer(playerId);
				
		return "Delete Player ID - " + playerId;

	}
}
