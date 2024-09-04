package kr.or.iei.todo.model.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.iei.todo.model.dao.TodoDao;
import kr.or.iei.todo.model.dto.TodoDTO;
import kr.or.iei.user.model.dto.UserDto;

@Service
public class TodoService {
	@Autowired
	private TodoDao todoDao;

	public Map selectAllTodo(UserDto loginUser) {
		List parentList = todoDao.selectAllParentTodo(loginUser);
		List childList = todoDao.selectAllChildTodo(loginUser);
		Map<String, List> map = new HashMap<String, List>();
		map.put("parentList", parentList);
		map.put("childList", childList);
		return map;
	}

	public int insertTodo(TodoDTO todo) {
		int result = 0;
		if(todo.getTodoRefNo()==0) {
			result = todoDao.insertParent(todo);
		}else {
			result = todoDao.insertChild(todo);
		}
		return result;
	}
}
