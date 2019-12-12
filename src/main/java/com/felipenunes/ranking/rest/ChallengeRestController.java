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

import com.felipenunes.ranking.entity.Challenge;
import com.felipenunes.ranking.entity.ChallengeId;
import com.felipenunes.ranking.entity.Period;
import com.felipenunes.ranking.entity.Player;
import com.felipenunes.ranking.service.ChallengeService;
import com.felipenunes.ranking.service.PeriodService;
import com.felipenunes.ranking.service.PlayerService;

@RestController
@RequestMapping("/api")
public class ChallengeRestController {

	@Autowired
	private ChallengeService challengeService;

	@Autowired
	private PeriodService periodService;

	@Autowired
	private PlayerService playerService;

	@GetMapping("/challenges")
	public List<Challenge> getChallenge() {

		return challengeService.getChallenges();

	}

	@GetMapping("/challenges/{periodId}/{challengerId}/{challengedId}")
	public Challenge getChallenge(@PathVariable String periodId, @PathVariable int challengerId,
			@PathVariable int challengedId) {

		Period period = periodService.getPeriod(periodId);
		Player challenger = playerService.getPlayer(challengerId);
		Player challenged = playerService.getPlayer(challengedId);

		ChallengeId challengeId = new ChallengeId();
		challengeId.setPeriod(period);
		challengeId.setChallenger(challenger);
		challengeId.setChallenged(challenged);

		Challenge challenge = challengeService.getChallenge(challengeId);

		if (challenge == null) {
			throw new PlayerNotFoundException("Challenge ID not found - " + challenge);
		}

		return challenge;

	}

	@PostMapping("/challenges")
	public Challenge createChallenge(@RequestBody Challenge challenge) {

		if (challenge.getChallengeId().getChallenger() == challenge.getChallengeId().getChallenged()) {
			throw new PlayerNotFoundException(
					"Challenger equals challenged not allowed - " + challenge.getChallengeId());
		}

		challengeService.saveChallenge(challenge);

		return challenge;

	}

	@PutMapping("/challenges")
	public Challenge updateChallenge(@RequestBody Challenge challenge) {

		if (challenge.getChallengeId().getChallenger() == challenge.getChallengeId().getChallenged()) {
			throw new PlayerNotFoundException(
					"Challenger equals challenged not allowed - " + challenge.getChallengeId());
		}

		challengeService.saveChallenge(challenge);

		return challenge;

	}

	@DeleteMapping("/challenges/{periodId}/{challengerId}/{challengedId}")
	public String deleteChallenge(@PathVariable String periodId, @PathVariable int challengerId,
							@PathVariable int challengedId) {

		Period period = periodService.getPeriod(periodId);
		Player challenger = playerService.getPlayer(challengerId);
		Player challenged = playerService.getPlayer(challengedId);

		ChallengeId challengeId = new ChallengeId();
		challengeId.setPeriod(period);
		challengeId.setChallenger(challenger);
		challengeId.setChallenged(challenged);

		Challenge challenge = challengeService.getChallenge(challengeId);

		if (challenge == null) {
			throw new PlayerNotFoundException("Challenge ID not found - " + challengedId);
		}
		
		challengeService.deleteChallenge(challengeId);
		
		System.out.println(challengedId);

		return "Delete Player ID - " + challengeId;
	}	

}
