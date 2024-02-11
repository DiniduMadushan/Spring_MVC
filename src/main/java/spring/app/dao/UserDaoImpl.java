package spring.app.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import spring.app.entity.User;

@Repository
public class UserDaoImpl implements UserDAO {

	@Autowired
	private SessionFactory session_factory;
	
	@Override
	public void register(User user) {
	Session curreSession=session_factory.getCurrentSession();
	curreSession.save(user);
		
	}

}
