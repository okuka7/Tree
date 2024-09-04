package kr.or.iei.user.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.or.iei.user.model.dao.UserDao;
import kr.or.iei.user.model.dto.UserDto;

@Service
public class UserService {
	@Autowired
	private UserDao userDao;
	@Autowired
	private BCryptPasswordEncoder encoder;

	@Transactional
	public int insertUser(UserDto u) {
		// 평문 패스워드 암호화로..!
		String encPw = encoder.encode(u.getUserPw());
		u.setUserPw(encPw);// 암호화된 패스워드로 넣기

		int result = userDao.insertMember(u);
		return result;
	}

	public UserDto selectOneUser(UserDto u) {
		// 아이디로 user 정보 먼저 조회
		UserDto user = userDao.selectOneUser(u.getUserId());
		System.out.println(user);

		// 조회한 정보가 null값이 아니고, 평문 비밀번호와 암호화된 비밀번호가 일치하면 아래 코드 실행
		if (user != null && encoder.matches(u.getUserPw(), user.getUserPw())) {
			System.out.println("확인");
			return user;
		} else {
			return null;
		}
	}

	public UserDto selectCheckId(String userId) {
		UserDto user = userDao.selectOneUser(userId);
		return user;
	}
}
