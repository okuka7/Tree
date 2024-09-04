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

    private int calendarNo;
    private int userNo;
    private String startDay;
    private String endDay;
    private String calendarContent;
    private int important;

}
