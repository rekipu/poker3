package com.reki;

public class Ordenador {

	private Hand mano;
	
	
	//per fer, tota la IA...detectar dins el array multi quins espais falten per demanar canviar les cartes...
	Ordenador(Hand mano){
		this.mano=mano;
		
		int contador=0;
		for (int i=1; i<3;i++) {
			for (int r=0; r<3;r++) {
				if(mano.compruebaRepes()[i][r] != 0) {
					contador++;
				}
			}
		}
		if (contador<7){
		}
	}
}
