package DAO;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import Domain.OVchipkaart;
import Domain.Product;
import Domain.Reiziger;

public class OVchipkaartDaoImpl extends OracleBaseDao implements OVchipkaartDao{
	ReizigerDao rd = new ReizigerDaoImpl();
	ProductDao pd = new ProductDaoImpl();
	List<Reiziger> reizigers = new ArrayList<Reiziger>(); 
	
	
	@Override
	public List<OVchipkaart> findAll() {
		List<OVchipkaart> ovKaarten = new ArrayList<OVchipkaart>();
		reizigers = rd.findAll();
		for (Reiziger r : reizigers) {
			System.out.println(r.getNaam());
		}
		String s = "select * from ov_chipkaart";
		try {
			conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
			PreparedStatement stmt = conn.prepareStatement(s);
			try (ResultSet rs = stmt.executeQuery()) {
				while (rs.next()) {
					OVchipkaart o = new OVchipkaart();
					o.setKaartNummer(rs.getInt("KAARTNUMMER"));
					o.setGeldigTot(rs.getDate("GELDIGTOT"));
					o.setKlasse(rs.getInt("KLASSE"));
					o.setSaldo(rs.getDouble("SALDO"));
					for (Reiziger r : reizigers) {
						System.out.println(r.getNaam());
						if (rs.getInt("reizigerid") == r.getId()) {
							o.setReiziger(r);
							r.addOvKaart(o);
						}
					}
					o.setProducten(pd.findProductByOvkaart(o.getKaartNummer()));
					ovKaarten.add(o);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ovKaarten;
	}

	@Override
	public OVchipkaart findByKaartnummer(int kaartnummer) {
		reizigers = rd.findAll();
		OVchipkaart o = new OVchipkaart();;
		String s = "select * from ov_chipkaart WHERE kaartnummer =" + kaartnummer + "";
		try {
			conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
			PreparedStatement stmt = conn.prepareStatement(s);
			try (ResultSet rs = stmt.executeQuery()) {
				while (rs.next()) {
					o.setKaartNummer(rs.getInt("KAARTNUMMER"));
					o.setGeldigTot(rs.getDate("GELDIGTOT"));
					o.setKlasse(rs.getInt("KLASSE"));
					o.setSaldo(rs.getDouble("SALDO"));
					for (Reiziger r : reizigers) {
						System.out.println(r.getNaam());
						if (rs.getInt("reizigerid") == r.getId()) {
							o.setReiziger(r);
						}
					}
				}
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return o;
	}

	@Override
	public OVchipkaart save(OVchipkaart ovKaart) {
		SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd-MM-yy");
        java.sql.Date sqlDate = new java.sql.Date(ovKaart.getGeldigTot().getTime());
		System.out.println(sqlDate);
		int kaartnummer = ovKaart.getKaartNummer();
		int klasse = ovKaart.getKlasse();
		double saldo = ovKaart.getSaldo();
		int reizigerid = ovKaart.getReiziger().getId();
		
		String s = "INSERT INTO ov_chipkaart (kaartnummer, geldigtot, klasse, saldo, reizigerid) VALUES(" + kaartnummer + ", '" + DATE_FORMAT.format(sqlDate)  + "', " + klasse + ", " + saldo + ", " + reizigerid + ")";
		System.out.println(s);
		try {
			conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
			PreparedStatement stmt = conn.prepareStatement(s);
			System.out.println("before execute..");
			stmt.executeQuery();			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ovKaart;
	}

	@Override
	public OVchipkaart update(OVchipkaart ovKaart) {
		SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd-MM-yy");
        java.sql.Date sqlDate = new java.sql.Date(ovKaart.getGeldigTot().getTime());
		System.out.println(sqlDate);
		int kaartnummer = ovKaart.getKaartNummer();
		int klasse = ovKaart.getKlasse();
		double saldo = ovKaart.getSaldo();
		int reizigerid = ovKaart.getReiziger().getId();
		
		String s = "UPDATE ov_chipkaart SET geldigtot = '" + DATE_FORMAT.format(sqlDate) +"', KLASSE = " + klasse  + ", SALDO = " + saldo + ", REIZIGERID = " + reizigerid + " WHERE KAARTNUMMER = "+ kaartnummer +"";
		System.out.println(s);
		try {
			conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
			PreparedStatement stmt = conn.prepareStatement(s);
			System.out.println("before execute..");
			stmt.executeQuery();			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ovKaart;
	}

	@Override
	public boolean delete(OVchipkaart ovKaart) {
		String s = "DELETE FROM ov_chipkaart WHERE kaartnummer = " + ovKaart.getKaartNummer() + "";
		
		try {
			conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
			PreparedStatement stmt = conn.prepareStatement(s);
			stmt.executeQuery();	
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}
	
	public void closeConnection() {
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
