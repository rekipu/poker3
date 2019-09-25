package com.reki;

import org.springframework.beans.factory.annotation.Autowired;

public class Hand {

	@Autowired
	Baraja baraja;
	Carta[] mano;

	public Hand(Baraja baraja) {
		mano = new Carta[] { baraja.getCarta(), baraja.getCarta(), baraja.getCarta(), baraja.getCarta(),
				baraja.getCarta() };
		System.out.println(mano[0] + " " + mano[1] + " " + mano[2] + " " + mano[3] + " " + mano[4] + " ");
		System.out.println(punto(mano));
	}

	public int punto(Carta[] mano) {
		return compruebaRepes(mano);

	}

	public int compruebaRepes(Carta[] mano) {
		int repes = 1;
		int num = 0;
		for (int i = 0; i < 5; i++) {
			for (int r = i + 1; r < 5; r++) {
				if (mano[i].numero == mano[r].numero&&mano[r].numero!=num) {
					repes++;
					num = mano[i].numero;

				}
			}
		}
		switch (repes) {
		case 1:
			System.out.println("tienes farolillo real");
			break;
		case 2:
			System.out.println("Tienes pareja de " + num);
			break;
		case 3:
			System.out.println("Tienes trio de " + num);
			break;
		case 4:
			System.out.println("Tienes poker de " + num);
			break;
		case 5:
			System.out.println("Tienes repoker de " + num);
			break;
		}

		return (repes) * num;
	}
	
	public void compara(Carta[] mano,Carta[] mano2) {
		if (punto(mano)>punto(mano2)) {
			System.out.println("guanya el jugador! FELICITATS!");
		}else {
			System.out.println("Te jodes, guanya la maquina!");
		}
	}
}
