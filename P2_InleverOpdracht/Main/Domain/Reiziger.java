package Domain;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class Reiziger {
	private int id;
	private String voorletters;
	private String tussenvoegsel;
	private String naam;
	private Date gbDatum;
	private List<OVchipkaart> ovKaarten;
	
	public Reiziger() {
		ovKaarten = new ArrayList<OVchipkaart>();
	}
	
	public List<OVchipkaart> getOvKaarten() {
		return ovKaarten;
	}
	
	public void addOvKaart(OVchipkaart ovkaart) {
		ovKaarten.add(ovkaart);
	}

	public void setOvKaarten(List<OVchipkaart> ovKaarten) {
		this.ovKaarten = ovKaarten;
	}

	public Reiziger(int id, String voorletters, String naam, Date gbDatum) {
		this.id = id;
		this.voorletters = voorletters;
		this.naam = naam;
		this.gbDatum = gbDatum;
		ovKaarten = new ArrayList<OVchipkaart>();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getVoorletters() {
		return voorletters;
	}

	public void setVoorletters(String voorletters) {
		this.voorletters = voorletters;
	}

	public String getTussenvoegsel() {
		return tussenvoegsel;
	}

	public void setTussenvoegsel(String tussenvoegsel) {
		this.tussenvoegsel = tussenvoegsel;
	}

	public String getNaam() {
		return naam;
	}

	public void setNaam(String naam) {
		this.naam = naam;
	}

	public Date getGbDatum() {
		return gbDatum;
	}

	public void setGbDatum(Date gbDatum) {
		this.gbDatum = gbDatum;
	}
	
}
