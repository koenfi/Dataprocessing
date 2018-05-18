package DAO;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Domain.Product;

public class ProductDaoImpl extends OracleBaseDao implements ProductDao{

	@Override
	public List<Product> findAll() {
		List<Product> producten = new ArrayList<Product>();
		String s = "select * from product";
		try {
			conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
			PreparedStatement stmt = conn.prepareStatement(s);
			Product p = new Product();
			try (ResultSet rs = stmt.executeQuery()) {
				while (rs.next()) {
					p.setProductNummer(rs.getInt("PRODUCTNUMMER"));
					p.setProductNaam(rs.getString("PRODUCTNAAM"));
					p.setBeschrijving(rs.getString("BESCHRIJVING"));
					p.setPrijs(rs.getDouble("PRIJS"));
					producten.add(p);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return producten;
	}
	
	@Override
	public ArrayList<Product> findProductByOvkaart(int ovkaart) {
		ArrayList<Product> producten = new ArrayList<Product>();
		String s = "SELECT * from ov_chipkaart_product WHERE kaartnummer= " + ovkaart+ "";
		try {
			conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
			PreparedStatement stmt = conn.prepareStatement(s);
			Product p = new Product();
			try (ResultSet rs = stmt.executeQuery()) {
				while (rs.next()) {
					p.setProductNummer(rs.getInt("PRODUCTNUMMER"));
					p.setProductNaam(rs.getString("PRODUCTNAAM"));
					p.setBeschrijving(rs.getString("BESCHRIJVING"));
					p.setPrijs(rs.getDouble("PRIJS"));
					producten.add(p);
				}
			} 
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
		return producten;
	
	}

	@Override
	public Product findByProductNummer(int productNummer) {
		List<Product> producten = new ArrayList<Product>();
		String s = "select * from product WHERE PRODUCTNUMMER = '" + productNummer + "'";
		Product p = new Product();
		try {
			conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
			PreparedStatement stmt = conn.prepareStatement(s);
			try (ResultSet rs = stmt.executeQuery()) {
				while (rs.next()) {
					p.setProductNummer(rs.getInt("PRODUCTNUMMER"));
					p.setProductNaam(rs.getString("PRODUCTNAAM"));
					p.setBeschrijving(rs.getString("BESCHRIJVING"));
					p.setPrijs(rs.getDouble("PRIJS"));
				}
			}
		} catch (SQLException e){
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return p;
	}

	@Override
	public Product save(Product product) {
		String s = "INSERT INTO product (productnummer, productnaam, beschrijving, prijs) VALUES(" + product.getProductNummer() + ", '" + product.getProductNaam()  + "', '" + product.getBeschrijving() + "', " + product.getPrijs() + ")";
		try {
			conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
			PreparedStatement stmt = conn.prepareStatement(s);
			stmt.executeQuery();			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return product;
	}

	@Override
	public Product update(Product product) {
		String s = "UPDATE product SET productnummer = "+ product.getProductNummer() +", productnaam = '" + product.getProductNaam() + "', beschrijving = '"+ product.getBeschrijving() +"', prijs = "+ product.getPrijs() +" WHERE productnummer = "+ product.getProductNummer() +  "";
		try {
			conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
			PreparedStatement stmt = conn.prepareStatement(s);
			stmt.executeQuery();			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return product;
	}

	@Override
	public boolean delete(Product product) {
		String s = "DELETE FROM product WHERE productnummer = " + product.getProductNummer() + "";
		try {
			conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
			PreparedStatement stmt = conn.prepareStatement(s);
			stmt.executeQuery();	
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return true;
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
