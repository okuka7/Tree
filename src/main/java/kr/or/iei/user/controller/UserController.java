package kr.or.iei.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;
import kr.or.iei.user.model.dto.UserDto;
import kr.or.iei.user.model.service.UserService;
@RequestMapping(value="/user")
public class UserController {
	@Autowired
	private UserService userService;
	
	@GetMapping(value = "/joinFrm")
	public String joinFrm() {
		return "user/joinFrm";
	}
	@PostMapping(value = "/login")
	public String login(UserDto u, HttpSession session) {
		System.out.println(u);
//		UserDto user = userService.selectOneUser(u);	
//		if(user != null) {
//			session.setAttribute("user", user);
//		}
		return "redirect:/";
	}
}
