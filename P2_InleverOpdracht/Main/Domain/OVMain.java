package Domain;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import DAO.OVchipkaartDao;
import DAO.OVchipkaartDaoImpl;
import DAO.ReizigerDao;
import DAO.ReizigerDaoImpl;

public class OVMain {

	public static void main(String[] args) throws ParseException {
		OVchipkaartDao ocd = new OVchipkaartDaoImpl();
		ReizigerDao rd = new ReizigerDaoImpl();
		List<OVchipkaart> ovKaarten = new ArrayList<OVchipkaart>();
		SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd-MM-yy");
		
		List<Reiziger> r = new ArrayList<Reiziger>();
		
		
		//haal alle ovkaarten op
		//ovKaarten = ocd.findAll();
		
		//heel een ovkaart op met kaartnummer
		/*OVchipkaart o = new OVchipkaart();
		o = ocd.findByKaartnummer(35283);
		System.out.println(o.getSaldo());*/
		
		//ovkaart inserten in database
		/*OVchipkaart o = new OVchipkaart();
		o.setKaartNummer(12346);
		Date date =  DATE_FORMAT.parse("01-08-19");
		Date gbdate =  DATE_FORMAT.parse("17-09-02");
		java.sql.Date sqlDate = new java.sql.Date(date.getTime());
		java.sql.Date sql2Date = new java.sql.Date(gbdate.getTime());
		r = rd.findByGBdatum(sql2Date);
		o.setGeldigTot(sqlDate);
		o.setSaldo(20.0);
		o.setKlasse(2);
		for (Reiziger s : r) {
			o.setReiziger(s);
		}
		ocd.save(o);*/
		
		//ovkaart update
/*		OVchipkaart o = new OVchipkaart();
		o.setKaartNummer(12346);
		Date date =  DATE_FORMAT.parse("01-08-21");
		Date gbdate =  DATE_FORMAT.parse("17-09-02");
		java.sql.Date sqlDate = new java.sql.Date(date.getTime());
		java.sql.Date sql2Date = new java.sql.Date(gbdate.getTime());
		r = rd.findByGBdatum(sql2Date);
		o.setGeldigTot(sqlDate);
		o.setSaldo(20.0);
		o.setKlasse(2);
		for (Reiziger s : r) {
			o.setReiziger(s);
		}
		ocd.update(o);*/
		
		// delete ovkaart
		/* ovKaarten = ocd.findAll();
		for (OVchipkaart o : ovKaarten) {
			if (o.getKaartNummer() == 12346) {
				System.out.println(ocd.delete(o));
			}
		}*/
		
	}

}
