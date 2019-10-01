package com.reki;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

@Entity
public class Baraja {
	@Id
	@GeneratedValue
	int barajaId;
	static ArrayList<Carta> baralla = new ArrayList<Carta>();
	String palo;

	public Baraja() {
		Map<Integer, String> palos = new TreeMap<Integer, String>();
		palos.put(1, "Diamantes");
		palos.put(2, "Picas");
		palos.put(3, "Corazones");
		palos.put(4, "Treboles");
				

		for (int i = 1; i < 5; i++) {
			palo = palos.get(i);
			for (int r = 1; r < 13; r++) {
				Carta carta = new Carta(r, palo);
				baralla.add(carta);
			}
		}
	}
	
	public Carta getCarta() {
		Random generator = new Random();
		int randomIndex = generator.nextInt(baralla.size());
		Carta placeholder = baralla.get(randomIndex);
		baralla.remove(randomIndex);
		return placeholder;
	}
}
