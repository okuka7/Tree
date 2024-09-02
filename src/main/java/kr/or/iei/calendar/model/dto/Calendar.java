package kr.or.iei.calendar.model.dto;

import org.apache.ibatis.type.Alias;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Alias(value="calendar")
public class Calendar {

    private int calendar_no;
    private int user_no;
    private String start_day;
    private String end_day;
    private String caledarn_content;
    private int important;

}
