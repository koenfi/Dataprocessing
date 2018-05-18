package Domain;



import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import DAO.ReizigerDao;
import DAO.ReizigerDaoImpl;

public class Main {

	public static void main(String[] args) throws ParseException { 
		List <Reiziger> reizigers = new ArrayList<Reiziger>();
		ReizigerDao rd  = new ReizigerDaoImpl();
		//SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd-MM-yy");
		
		//reizigers  = rd.findAll();

		//Get reiziger met geboortedatum
		SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd-MM-yy");
		//Date date =  DATE_FORMAT.parse("01-07-94");
        //java.sql.Date sqlDate = new java.sql.Date(date.getTime());
        //System.out.println(DATE_FORMAT.format(sqlDate));
/*		reizigers = rd.findByGBdatum(sqlDate);
		for (Reiziger r : reizigers) {
			System.out.println(r.getNaam());
		}*/
		
		//nieuwe reiziger toevoegen
/*        Reiziger r = new Reiziger();
		r.setId(6);
		r.setVoorletters("K");
		r.setTussenvoegsel("");
		r.setNaam("Fischer");
		
		//System.out.println(date);
		//java.sql.Date sqlDate = new java.sql.Date(date.getTime());
		//System.out.println(sqlDate);
		r.setGbDatum(sqlDate);
		rd.save(r);
		System.out.println("gesaved!");*/
		
		//update reiziger
/*		Reiziger r = new Reiziger();
		r.setId(6);
		r.setVoorletters("K");
		r.setTussenvoegsel("");
		r.setNaam("Fischer");
		Date date =  DATE_FORMAT.parse("01-08-94");
		java.sql.Date sqlDate = new java.sql.Date(date.getTime());
		r.setGbDatum(sqlDate);
		rd.update(r);
		System.out.println("updated!!");*/
		
		//delete reiziger
		Reiziger r = new Reiziger();
		r.setId(6);
		r.setVoorletters("K");
		r.setTussenvoegsel(null);
		r.setNaam("Fischer");
		Date date =  DATE_FORMAT.parse("01-08-94");
		java.sql.Date sqlDate = new java.sql.Date(date.getTime());
		r.setGbDatum(sqlDate);
		System.out.println(rd.delete(r));
	}

}
