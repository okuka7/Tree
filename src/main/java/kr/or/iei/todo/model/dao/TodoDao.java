package kr.or.iei.todo.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.or.iei.todo.model.dto.TodoDTO;
import kr.or.iei.user.model.dto.UserDto;

@Mapper
public interface TodoDao {

	List selectAllParentTodo(UserDto loginUser);

	List selectAllChildTodo(UserDto loginUser);

	int insertParent(TodoDTO todo);

	int insertChild(TodoDTO todo);

	int deleteTodo(int todoNo);

	List selectUndoneTodo(UserDto loginUser);

	List<TodoDTO> selectAllUndoneTodo();

}
