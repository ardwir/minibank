package my.minibank.dao;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import my.minibank.model.Tagihan;
import my.minibank.model.Transaksi;

@Repository
public class TagihanDaoImpl implements TagihanDao {
	
	private SessionFactory sessionFactory;
	
	@Autowired
	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	@Override
	public void updateTagihan(Tagihan t) {
		Session session= this.sessionFactory.getCurrentSession();
		session.update(t);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Transaksi> listTransaksi(int id_nasabah) {
		Session session= this.sessionFactory.getCurrentSession();
		LocalDate today = LocalDate.now();
		int month = today.getMonthValue()-1;
		int year = today.getYear();
		List<Transaksi> transaksiList = session.createQuery(
				"SELECT * FROM tagihan WHERE EXTRACT(MONTH FROM jatuh_tempo_tagihan)=" + month
				+ " AND EXTRACT(YEAR FROM jatuh_tempo_tagihan)=" + year 
				+ " AND id_nasabah=" + id_nasabah).list();
		return transaksiList;
	}
	
	@Override
	public Tagihan getTagihan(int id_nasabah) {
		Session session= this.sessionFactory.getCurrentSession();
		return (Tagihan)session.get(Tagihan.class, id_nasabah);
	}

}
