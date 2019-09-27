package com.reki;

import org.springframework.beans.factory.annotation.Autowired;

public class Hand {

	@Autowired
	private Baraja baraja;
	Carta[] mano;

	public Hand(Baraja baraja) {
		this.baraja=baraja;
		this.mano = new Carta[] { baraja.getCarta(), baraja.getCarta(), baraja.getCarta(), baraja.getCarta(),
				baraja.getCarta() };
		showCartas();
		System.out.println(punto());
	}

	public int punto() {
		return compruebaRepes()[0][0];

	}
	public Carta getCarta() {
		return baraja.getCarta();
	}
	//aixo tornara a posicio [0][0] la puntuació, a 1,0 el numero de la primera parella o trio, a 1,0 el de la segona, 
	//a 1,1 en endavant els llocs k ocupa la primera parella o trio, i a 2,1 en endavant els de la segona
	public int[][] compruebaRepes() {
		int repes = 1;
		int dobleRepes = 1;
		int num = 0;
		int num2 = 0;
		int[][] results = {{0,0,0},{0,0,0}};
		for (int i = 0; i < 5; i++) {
			for (int r = i + 1; r < 5; r++) {
				if (this.mano[i].getNumero() == this.mano[r].getNumero()) {
					if (num == 0|| num==this.mano[i].getNumero()) {
						results[1][i+1]=i;
						repes++;
						num = this.mano[i].getNumero();
						results[1][0]= num;
						break;
					} else {
						results[2][i+1]=i;
						dobleRepes++;
						num2 = this.mano[i].getNumero();
						results[2][0]= num2;
					}

				}
			}
			
		}
		if (dobleRepes == 1) {
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
		} else {
			if (dobleRepes > repes) {
				System.out.println("Tens un full de " + num2 + " i " + num);
			} else {
				System.out.println("Tens una doble parella de " + num2 + " i " + num);
			}

		}
		results[0][0]= ((repes) * num)+ (dobleRepes * num2);
		
		return results;
	}

	public void compara(Hand mano) {
		if (this.punto() > mano.punto()) {
			System.out.println("guanya el jugador! FELICITATS!");
		} else if (this.punto()>mano.punto()) {
			System.out.println("Te jodes, guanya la maquina!");
		} else {
			System.out.println("INCREIBLEEEE! tenim un EMPAT!");
		}
	}

	public void canvi(int select) {
		int size= String.valueOf(select).length();
		switch (size) {
		case 0:
			break;
		case 1:
			this.mano[select-1]= baraja.getCarta();
			break;
		case 2:
			this.mano[(select % 10)-1]= baraja.getCarta();
			this.mano[(select / 10 % 10)-1]= baraja.getCarta();
			break;
		case 3:
			this.mano[(select % 10)-1]= baraja.getCarta();
			this.mano[(select / 10 % 10)-1]= baraja.getCarta();
			this.mano[(select / 100 % 10)-1]= baraja.getCarta();
			break;
		case 4:
			System.out.println(select % 10);
			this.mano[(select % 10)-1]= baraja.getCarta();
			this.mano[(select / 10 % 10)-1]= baraja.getCarta();
			this.mano[(select / 100 % 10)-1]= baraja.getCarta();
			this.mano[(select / 1000 % 10)-1]= baraja.getCarta();
			break;
		case 5:
			for(int i=0;i<5;i++) {
			this.mano[i]= baraja.getCarta();
			}
			break;
			
			
		}
		
	}

	public void showCartas() {
		System.out.println(this.mano[0] + " " + this.mano[1] + " " + this.mano[2] + " " + this.mano[3] + " " + this.mano[4] + " ");		
	}
}
