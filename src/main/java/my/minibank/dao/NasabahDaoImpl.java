package my.minibank.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import my.minibank.model.NasabahModel;

@Repository
@EnableTransactionManagement
@Transactional
public class NasabahDaoImpl implements NasabahDao{

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List < NasabahModel > getNasabah() {
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery < NasabahModel > cq = cb.createQuery(NasabahModel.class);
		Root < NasabahModel > root = cq.from(NasabahModel.class);
		cq.select(root);
		Query query = session.createQuery(cq);
		return query.getResultList();
	}

	@Override
	public void deleteNasabah(int id) {
		Session session = sessionFactory.getCurrentSession();
		NasabahModel book = session.byId(NasabahModel.class).load(id);
		session.delete(book);
	}

	@Override
	public void saveNasabah(NasabahModel theCustomer) {
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.saveOrUpdate(theCustomer);
	}

	@Override
	public NasabahModel getNasabah(int theId) {
		Session currentSession = sessionFactory.getCurrentSession();
		NasabahModel theCustomer = currentSession.get(NasabahModel.class, theId);
		return theCustomer;
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public NasabahModel getNasabahByUsername(String username) {
		List<NasabahModel> nasabah = new ArrayList<NasabahModel>();
		nasabah = sessionFactory.getCurrentSession().createQuery("FROM NasabahModel WHERE username=?1")
				.setParameter(1, username)
				.list();
		System.out.println("====================================================================");
		System.out.println(nasabah.toString()+"-----"+nasabah.get(0).getNama());
		System.out.println("====================================================================");
		if (nasabah.size() > 0) {
			return nasabah.get(0);
		} else {
			return null;
		}
	}

	@Override
	public void updatePassword(int theId, String newPassword) {
		Session session = sessionFactory.getCurrentSession();
		NasabahModel nasabah = session.byId(NasabahModel.class).load(theId);
		nasabah.setPassword(newPassword);
		session.saveOrUpdate("katasandi", nasabah);
	}


}
