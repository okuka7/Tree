package kr.or.iei.todo.model.dto;

import org.apache.ibatis.type.Alias;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Alias(value="todo")
@Schema(description = "할일 객체")
public class TodoDTO {
	@Schema(description = "할 일 번호", type="int")
	private int todoNo;
	@Schema(description = "할 일 내용", type="String")
	private String todoContent;
	@Schema(description = "할 일 체크여부", type="boolean")
	private boolean todoDone;
	@Schema(description = "할 일 작성자 번호", type="int")
	private int userNo;
	@Schema(description = "할 일 작성자 아이디", type="String")
	private String userId;
	@Schema(description = "할 일 작성 날짜", type="String")
	private String todoDate; //만약에 계산이 들어가면 Date로 바꿀것
	@Schema(description = "상위 할일 번호", type="int")
	private int todoRefNo;
}
