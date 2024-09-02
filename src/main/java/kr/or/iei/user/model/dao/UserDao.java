package kr.or.iei.user.model.dao;

import org.apache.ibatis.annotations.Mapper;

import kr.or.iei.user.model.dto.UserDto;

@Mapper
public interface UserDao {

	UserDto selectOneUser(UserDto u);

}
