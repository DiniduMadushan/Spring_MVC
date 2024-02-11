package spring.app.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import spring.app.dao.UserDAO;
import spring.app.entity.User;

@Service
@Transactional
public class UserServiceImplement implements UserService{
	@Autowired
	private UserDAO userdao;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	public boolean register(User user) {
		try {
			user.setPassword(passwordEncoder.encode(user.getPassword()));
			userdao.register(user);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	

}
