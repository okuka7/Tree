package kr.or.iei.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
	
	// 로그인
	@PostMapping(value = "/login")
	public String login(UserDto u, HttpSession session) {
	    UserDto user = userService.selectOneUser(u);
	    System.out.println(user);

	    if (user != null) { // 로그인 성공
	        session.setAttribute("user", user); // 세션에 유저 정보 저장
	        return "redirect:/"; // 홈으로 리다이렉트
	    } else { // 로그인 실패
	        return "redirect:/"; // 로그인 폼으로 리다이렉트
	    }
	}
}
