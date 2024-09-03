package kr.or.iei.user.model.dao;

import org.apache.ibatis.annotations.Mapper;

import kr.or.iei.user.model.dto.UserDto;

@Mapper
public interface UserDao {

	int insertMember(UserDto u);

	UserDto selectOneUser(String userId);

}
