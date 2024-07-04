package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import model.User;

public class UserDao {

	SessionFactory sf = null;

	public UserDao() {

		sf = new Configuration().configure("hibernat.cfg.xml").addAnnotatedClass(User.class).buildSessionFactory();

	}

	public int addorupdateuser(User u) {

		int i = 0;
		Transaction tx = null;
		try {
			Session s = sf.openSession();
			tx = s.beginTransaction();
			i = 1;
			s.saveOrUpdate(u);
			tx.commit();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			i = 0;
			tx.rollback();
		}

		return i;
	}

	public List<User> viewalluser() {

		List<User> user = new ArrayList<User>();
		Transaction tx = null;

		Session s = sf.openSession();
		tx = s.beginTransaction();
		user = s.createQuery("from User").list();
		tx.commit();

		return user;
	}

	public int deleteuser(int id) {

		int i = 0;
		Transaction tx = null;
		try {

			Session s = sf.openSession();
			tx = s.beginTransaction();
			User u = s.load(User.class, id);
			s.delete(u);
			i = 1;
			tx.commit();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			i = 0;
			tx.rollback();
		}

		return i;
	}

	public User userbyid(int id) {
		
		User user = null;
		Transaction tx = null;
		
		Session s = sf.openSession();
		tx=s.beginTransaction();
		user=s.load(User.class, id);
		tx.commit();
		
		return user;
	}

}
