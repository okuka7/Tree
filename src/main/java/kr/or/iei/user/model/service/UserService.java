package kr.or.iei.user.model.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


import kr.or.iei.user.model.dao.UserDao;
import kr.or.iei.user.model.dto.UserDto;

@Service
public class UserService {
	@Autowired
	private UserDao userDao;
	@Autowired
	private BCryptPasswordEncoder encoder;

	public UserDto selectOneUser(UserDto u) {
		UserDto user = userDao.selectOneUser(u);
		if(user != null) {
			if(encoder.matches(u.getUserId(), user.getUserId())) {
				user.setUserId(null);
				return user;
			}else {
				return null;
			}
		}
		return null;
	}
}
