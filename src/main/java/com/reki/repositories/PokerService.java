package com.reki.repositories;

import org.springframework.stereotype.Service;

import com.reki.Hand;

@Service
public class PokerService {
	HandRepository handRepository;
	PlayerRepository playerRepository;
	
	public PokerService(HandRepository handRepository, PlayerRepository playerRepository) {
		super();
		this.handRepository = handRepository;
		this.playerRepository = playerRepository;
		
	}
	
	public void saveHand(Hand hand){
		handRepository.save(hand);
	}
	

}
