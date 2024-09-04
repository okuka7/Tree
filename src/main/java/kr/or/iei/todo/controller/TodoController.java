package kr.or.iei.todo.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import kr.or.iei.todo.model.dto.TodoDTO;
import kr.or.iei.todo.model.service.TodoService;
import kr.or.iei.user.model.dto.UserDto;

@Controller
@RequestMapping(value="/todo")
@Tag(name="TODO", description = "TODO API")
public class TodoController {
	@Autowired
	private TodoService todoService;
	
	@Operation(summary = "할일 목록 조회", description = "당일 할일 목록 조회")
	@GetMapping(value="/todoList")
	public String selectAllTodo(@SessionAttribute UserDto loginUser, Model model) {
		Map todoList = todoService.selectAllTodo(loginUser);
		model.addAttribute("parentList",todoList.get("parentList"));
		model.addAttribute("childList", todoList.get("childList"));
		return "todo/todoList";
	}
	
	@Operation(summary="진행중인 할일 목록 조회", description="당일 할일 목록 중 체크가 되지 않은 목록 조회")
	@GetMapping(value="/unDoneTodoList")
	public String selectUndoneTodo(@SessionAttribute UserDto loginUser, Model model) {
		Map todoList = todoService.unDoneTodo(loginUser);
		model.addAttribute("parentList", todoList.get("parentList"));
		model.addAttribute("childList", todoList.get("childList"));
		return "todo/todoList";
	}
	
	@Operation(summary="할일 등록", description="당일 할일 목록 등록")
	@PostMapping
	public String insertTodo(TodoDTO todo, Model model) {
		int result = todoService.insertTodo(todo);
		model.addAttribute("result", result);
		return "todo/todoList";
	}

	@Operation(summary="할일 삭제", description="할일 번호를 받아서 완료 할일 삭제")
	@GetMapping(value="/deleteTodo")
	public String deleteTodo(int todoNo) {
		int result = todoService.deleteTodo(todoNo);
		return "todo/todoList";
	}
	

	
	
	
	
	
	
	
	
	
	
	
}
