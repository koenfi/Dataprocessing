package Domain;

import java.util.ArrayList;

public class Product {
	private int productNummer;
	private String productNaam;
	private String beschrijving;
	private double prijs;
	private ArrayList<OVchipkaart> ovChipkaarten;
	
	public Product() {
		
	}
	
	public Product (int productNummer, String productNaam, String beschrijving, double prijs) {
		this.productNummer = productNummer;
		this.productNaam = productNaam;
		this.beschrijving = beschrijving;
		this.prijs = prijs;
	}
	public void addOvChipkaarten(OVchipkaart o) {
		ovChipkaarten.add(o);
	}
	public OVchipkaart getOvChipkaart(int kaartnummer) {
		for (OVchipkaart o : ovChipkaarten) {
			if (o.getKaartNummer() == kaartnummer) {
				return o;
			}
		}
		return null;
	}
	public ArrayList<OVchipkaart> getOvChipkaarten() {
		return ovChipkaarten;
	}
	public void setOvChipkaarten(ArrayList<OVchipkaart> ovChipkaarten) {
		this.ovChipkaarten = ovChipkaarten;
	}
	public int getProductNummer() {
		return productNummer;
	}
	public void setProductNummer(int productNummer) {
		this.productNummer = productNummer;
	}
	public String getProductNaam() {
		return productNaam;
	}
	public void setProductNaam(String productNaam) {
		this.productNaam = productNaam;
	}
	public String getBeschrijving() {
		return beschrijving;
	}
	public void setBeschrijving(String beschrijving) {
		this.beschrijving = beschrijving;
	}
	public double getPrijs() {
		return prijs;
	}
	public void setPrijs(double prijs) {
		this.prijs = prijs;
	}
}
