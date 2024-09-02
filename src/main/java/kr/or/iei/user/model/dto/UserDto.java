package kr.or.iei.user.model.dto;

import org.apache.ibatis.type.Alias;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Alias(value="user")
public class UserDto {
	private int userNo;
	private String userId;
	private String userPw;
	private String userName;
	private String userEmail;
	private String enrollDate;
}
