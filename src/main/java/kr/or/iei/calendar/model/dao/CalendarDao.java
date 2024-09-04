package kr.or.iei.calendar.model.dao;

import org.apache.ibatis.annotations.Mapper;

import kr.or.iei.calendar.model.dto.Calendar;
import kr.or.iei.user.model.dto.UserDto;

@Mapper
public interface CalendarDao {
	int insertCalender(Calendar calendar);

    Calendar selectCalendar(UserDto user);
}
