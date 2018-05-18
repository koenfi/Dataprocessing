package DAO;

import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import Domain.Reiziger;


public class ReizigerDaoImpl extends OracleBaseDao implements ReizigerDao  {
	
	public List<Reiziger> findAll() {
		List<Reiziger> reizigers = new ArrayList<Reiziger>();
		String s = "select * from reiziger";
		try {
			conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
			PreparedStatement stmt = conn.prepareStatement(s);
			try (ResultSet rs = stmt.executeQuery()) {
				while (rs.next()) {
					Reiziger r = new Reiziger();
					r.setId(rs.getInt("REIZIGERID"));
					r.setVoorletters(rs.getString("VOORLETTERS"));
					if (rs.getString("TUSSENVOEGSEL") != null) {
						r.setTussenvoegsel(rs.getString("TUSSENVOEGSEL"));
					}
					r.setNaam(rs.getString("ACHTERNAAM"));
					r.setGbDatum(rs.getDate("GEBORTEDATUM"));
					reizigers.add(r);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return reizigers;
	}
	
	public List<Reiziger> findByGBdatum(Date GBdatum) {
		List<Reiziger> reizigers = new ArrayList<Reiziger>();
		SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd-MM-yy");
        
        java.sql.Date sqlDate = new java.sql.Date(GBdatum.getTime());
		
		String s = "SELECT * FROM reiziger WHERE GEBORTEDATUM = '" + DATE_FORMAT.format(sqlDate) + "'";
		
		try {
			conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
			PreparedStatement stmt = conn.prepareStatement(s);
			Reiziger r = new Reiziger();
			try (ResultSet rs = stmt.executeQuery()) {
				System.out.println("rs is gevuld");
				while (rs.next()) {
					r.setId(rs.getInt("REIZIGERID"));
					r.setVoorletters(rs.getString("VOORLETTERS"));
					if (rs.getString("TUSSENVOEGSEL") != null) {
						r.setTussenvoegsel(rs.getString("TUSSENVOEGSEL"));
					}
					r.setNaam(rs.getString("ACHTERNAAM"));
					r.setGbDatum(rs.getDate("GEBORTEDATUM"));
					reizigers.add(r);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return reizigers;
	}
	
	public Reiziger save(Reiziger reiziger) {
		Reiziger r = reiziger;
		SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd-MM-yy");
        java.sql.Date sqlDate = new java.sql.Date(r.getGbDatum().getTime());
		System.out.println(sqlDate);
		int id = r.getId();
		String voorletter = r.getVoorletters();
		String tussenvoegsel = r.getTussenvoegsel();
		String achternaam = r.getNaam();
		//Date GBdatum = r.getGbDatum();
		String s = "INSERT INTO reiziger (REIZIGERID, VOORLETTERS, TUSSENVOEGSEL, ACHTERNAAM, GEBORTEDATUM) VALUES(" + id + ", '" + voorletter  + "', '" + tussenvoegsel + "', '" + achternaam + "', '" + DATE_FORMAT.format(sqlDate) + "')";
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
		
		return r;
	}
	
	public Reiziger update(Reiziger reiziger) {
		Reiziger r = reiziger;
		SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd-MM-yy");
        java.sql.Date sqlDate = new java.sql.Date(r.getGbDatum().getTime());
        
        int id = r.getId();
		String voorletter = r.getVoorletters();
		String tussenvoegsel = r.getTussenvoegsel();
		String achternaam = r.getNaam();
        
		String s = "UPDATE reiziger SET VOORLETTERS = '"+ voorletter +"', TUSSENVOEGSEL = '" + tussenvoegsel + "', ACHTERNAAM = '"+ achternaam +"', GEBORTEDATUM = '"+ DATE_FORMAT.format(sqlDate) +"' WHERE REIZIGERID = "+ id +  "";
		System.out.println(s);
		try {
			System.out.println("in try");
			conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
			System.out.println("connection made..");
			PreparedStatement stmt = conn.prepareStatement(s);
			System.out.println("stmt made..");
			stmt.executeQuery();			
			System.out.println("query uitgevoerd");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return r;
	}
	
	public boolean delete(Reiziger reiziger) {
		
		String s = "DELETE FROM reiziger WHERE reizigerid = " + reiziger.getId() + "";
		
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
