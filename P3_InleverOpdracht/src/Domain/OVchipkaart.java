package Domain;

import java.sql.Date;
import java.util.ArrayList;

public class OVchipkaart {
	private int kaartNummer;
	private Date geldigTot;
	private int klasse;
	private double saldo;
	private Reiziger reiziger;
	private ArrayList<Product> producten;
	
	public OVchipkaart() {
		
	}
	
	public OVchipkaart(int kaartNummer, Date geldigTot, int klasse, double saldo, Reiziger reiziger) {
		this.kaartNummer = kaartNummer;
		this.geldigTot = geldigTot;
		this.klasse = klasse; 
		this.saldo = saldo;
		this.reiziger = reiziger;
	}
	public void addProduct(Product p) {
		producten.add(p);
	}
	public Product getProduct(int productNummer) {
		for (Product p : producten) {
			if (p.getProductNummer() == productNummer) {
				return p;
			}
		}
		return null;
	}
	
	public ArrayList<Product> getProducten() {
		return producten;
	}

	public void setProducten(ArrayList<Product> producten) {
		this.producten = producten;
	}

	public int getKaartNummer() {
		return kaartNummer;
	}

	public void setKaartNummer(int kaartNummer) {
		this.kaartNummer = kaartNummer;
	}

	public Date getGeldigTot() {
		return geldigTot;
	}

	public void setGeldigTot(Date geldigTot) {
		this.geldigTot = geldigTot;
	}

	public int getKlasse() {
		return klasse;
	}

	public void setKlasse(int klasse) {
		this.klasse = klasse;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public Reiziger getReiziger() {
		return reiziger;
	}

	public void setReiziger(Reiziger reiziger) {
		this.reiziger = reiziger;
	}
}
