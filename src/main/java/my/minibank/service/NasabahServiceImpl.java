package my.minibank.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import my.minibank.dao.NasabahDao;
import my.minibank.model.NasabahModel;

@Service
public class NasabahServiceImpl implements NasabahService{

	@Autowired
	private NasabahDao nasabahDao;
	
	@Override
	@Transactional
	public List<NasabahModel> getNasabah() {
		return nasabahDao.getNasabah();
	}

	@Override
	@Transactional
	public void saveNasabah(NasabahModel theNasabah) {
		nasabahDao.saveNasabah(theNasabah);
	}

	@Override
	@Transactional
	public NasabahModel getNasabah(int theId) {
		return nasabahDao.getNasabah(theId);
	}

	@Override
	@Transactional
	public void deleteNasabah(int theId) {
		nasabahDao.deleteNasabah(theId);
	}

	@Override
	@Transactional
	public NasabahModel getNasabah(String username) {
		return nasabahDao.getNasabahByUsername(username);
	}

	@Override
	@Transactional
	public void changePassword(int theId, String newPassword) {
		nasabahDao.updatePassword(theId, newPassword);
	}

}
