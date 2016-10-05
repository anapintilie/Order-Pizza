package application;

import java.io.Serializable;

public abstract class Ingrediente implements Serializable{
	protected String [] den;

	public String[] getDen() {
		return den;
	}

	public void setDen(String[] den) {
		this.den = den;
	}

	public Ingrediente() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Ingrediente(String[] den) {
		super();
		this.den = den;
	}
	
	
}
