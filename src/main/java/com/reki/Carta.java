package com.reki;

public class Carta {
	int numero;
	String palo;
	
	public int getNumero() {
		return numero;
	}

	public String getPalo() {
		return palo;
	}

	public Carta(int numero, String palo) {

		this.numero=numero;
		this.palo = palo;
	}

	@Override
	public String toString() {
		return "Carta [numero=" + numero + ", palo=" + palo + "]";
	}
	
	
}
