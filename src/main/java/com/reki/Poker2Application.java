package com.reki;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Poker2Application {

	public static void main(String[] args) {
		SpringApplication.run(Poker2Application.class, args);
		
		Baraja baraja = new Baraja();
		for (int i=1;i<20; i++) {
		Hand playerHand = new Hand(baraja);
		Hand computerHand = new Hand(baraja);
		}
		//playerHand.compara(playerHand.mano, computerHand.mano);
		
		
	}

}
