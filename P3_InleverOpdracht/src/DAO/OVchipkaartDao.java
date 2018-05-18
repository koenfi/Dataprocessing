package DAO;

import java.util.List;

import Domain.OVchipkaart;

public interface OVchipkaartDao {
	
	public List<OVchipkaart> findAll();
	public OVchipkaart findByKaartnummer(int kaartnummer);
	public OVchipkaart save(OVchipkaart ovKaart);
	public OVchipkaart update(OVchipkaart ovKaart);
	public boolean delete(OVchipkaart ovKaart);
	public void closeConnection();
}
