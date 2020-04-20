package my.minibank.dao;

import java.util.List;

import my.minibank.model.NasabahModel;

public interface NasabahDao {
	
	public List<NasabahModel> getNasabah();

	public void saveNasabah(NasabahModel theNasabah);

	public NasabahModel getNasabah(int theId);

	public void deleteNasabah(int theId);
	
	public NasabahModel getNasabahByUsername(String username);
	
	public void updatePassword(int theId, String newPassword);

}
