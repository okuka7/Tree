package kr.or.iei.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.servlet.http.HttpSession;
import kr.or.iei.user.model.dto.UserDto;
import kr.or.iei.user.model.service.UserService;

@Controller
@RequestMapping(value="/user")
public class UserController {
	@Autowired
	private UserService userService;
	
	// 페이지 이동
	@GetMapping(value = "/joinFrm")
	public String joinFrm() {
		return "user/joinFrm";
	}
	
	// 회원가입
	@PostMapping(value="/join")
	public String join(UserDto u, Model model) {
		int result = userService.insertUser(u);
		return "redirect:/";
	}
	
	// 아이디 체크
	@ResponseBody
	@PostMapping(value="/checkId")
	public int checkId(String userId) {
		UserDto user = userService.selectCheckId(userId);
		if(user == null) {
			return 1;
		}else {
			return 0;
		}
	}
	
	
	// 로그인
	@PostMapping(value = "/login")
	public String login(UserDto u, HttpSession session) {
	    UserDto user = userService.selectOneUser(u);
	    if (user != null) { // 로그인 성공
	        session.setAttribute("user", user); // 세션에 유저 정보 저장
	    }else {
	    	// 유저 조회가 안되면 "정보를 조회할 수 없습니다" 띄우기
	    }
	    return "redirect:/"; // 홈으로 리다이렉트
	}
	
	// 로그아웃
	@GetMapping(value="/logout")
	public String logout(HttpSession session, Model model) {
		session.invalidate();
		return "redirect:/";
	}
}
