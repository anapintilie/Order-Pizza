package application;

import java.io.Serializable;

public class Pizza extends Ingrediente implements IAfisare,Serializable{
	private String nume;
	private double pret;
	private String diametru;
	
	public String getNume() {
		return nume;
	}
	public void setNume(String nume) {
		this.nume = nume;
	}
	public double getPret() {
		return pret;
	}
	public void setPret(double pret) {
		this.pret = pret;
	}
	public String getDiametru() {
		return diametru;
	}
	public void setDiametru(String diametru) {
		this.diametru = diametru;
	}
	public Pizza() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Pizza(String[] den) {
		super(den);
		// TODO Auto-generated constructor stub
	}
	public Pizza(String[] den,String nume, double pret, String diametru) {
		super(den);
		this.nume = nume;
		this.pret = pret;
		this.diametru = diametru;
	}
	@Override
	public String afiseaza() {
		
		return den[0]+", "+den[1]+", "+den[2]+", "+den[3]+", "+den[4]+", "+den[5];
		}
	
	
	
}
