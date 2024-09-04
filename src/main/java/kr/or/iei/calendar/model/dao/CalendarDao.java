package kr.or.iei.calendar.model.dao;

import org.apache.ibatis.annotations.Mapper;

import kr.or.iei.calendar.model.dto.Calendar;

@Mapper
public interface CalendarDao {
	int insertCalender(Calendar calendar);
}
