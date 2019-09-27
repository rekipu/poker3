package com.reki;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Poker2Application {

	public static void main(String[] args) {
		SpringApplication.run(Poker2Application.class, args);

		Baraja baraja = new Baraja();

		Scanner lee = new Scanner(System.in);
		int select;
		int playerId = 0;
		String playerName;

		System.out.println("Welcome al poker'o'matic! aqui et podras enfrontar als millors jugadors de poker!");
		System.out.println("Please, entra el teu nom: ");
		playerName = lee.next();
		String resposta;
		Player player = new Player(playerName);
		System.out.println("Benvingut, " + player.getName() + " !");
		do {
			System.out.println("Procedim a repartir cartes...");

			Hand playerHand = new Hand(baraja);

			do {
				System.out.println(
						"En vols canviar alguna? Escriu numero de posicio de les que vulguis canviar: (p.ex. 134)");
				select = lee.nextInt();
				if (select != 0) {
					playerHand.canvi(select);
					playerHand.showCartas();
					playerHand.compruebaRepes();
				}
			} while (select != 0);

			Hand computerHand = new Hand(baraja);
			playerHand.showCartas();
			computerHand.showCartas();
			playerHand.compara(computerHand);
			System.out.println("Vols tornar a jugar? (s/n");
			resposta = lee.next();
		} while (resposta.equals("s"));

	}

}
