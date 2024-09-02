package kr.or.iei.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.or.iei.user.model.service.UserService;
@RequestMapping(value="/user")
public class UserController {
	@Autowired
	private UserService userService;
	
	@GetMapping(value = "/joinFrm")
	public String joinFrm() {
		return "user/joinFrm";
	}
}
