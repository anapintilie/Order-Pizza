package application;

public class Utilizator {
	private String nume;
	private int nr_telefon;
	private String sector;
	private String adresa;
	public String getNume() {
		return nume;
	}
	public void setNume(String nume) {
		this.nume = nume;
	}
	public int getNr_telefon() {
		return nr_telefon;
	}
	public void setNr_telefon(int nr_telefon) {
		this.nr_telefon = nr_telefon;
	}
	public String getSector() {
		return sector;
	}
	public void setSector(String sector) {
		this.sector = sector;
	}
	public String getAdresa() {
		return adresa;
	}
	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}
	public Utilizator(String nume, int nr_telefon, String sector, String adresa) {
		super();
		this.nume = nume;
		this.nr_telefon = nr_telefon;
		this.sector = sector;
		this.adresa = adresa;
	}
	public Utilizator() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
