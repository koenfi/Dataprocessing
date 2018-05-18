package DAO;

import java.sql.Date;
import java.util.List;
import Domain.Reiziger;

public interface ReizigerDao {
	
	public List<Reiziger> findAll();
	public List<Reiziger> findByGBdatum(Date gBdatum);
	public Reiziger save(Reiziger reiziger);
	public Reiziger update(Reiziger reiziger);
	public boolean delete(Reiziger reiziger);
	public void closeConnection();
}
