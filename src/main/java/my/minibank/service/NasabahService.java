package my.minibank.service;

import java.util.List;

import my.minibank.model.NasabahModel;

public interface NasabahService {
	
	public List<NasabahModel> getNasabah();
	
	public void saveNasabah(NasabahModel theNasabah);

	public NasabahModel getNasabah(int theId);

	public void deleteNasabah(int theId);
	
	public NasabahModel getNasabah(String username);
	
	public void changePassword(int theId, String newPassword);

	//i dont know wht is this
//	UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;
 
}
