package kr.or.iei.calendar.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.iei.calendar.model.dao.CalendarDao;
import kr.or.iei.calendar.model.dto.Calendar;
import kr.or.iei.user.model.dto.UserDto;

@Service
public class CalendarService {

    @Autowired
    private CalendarDao calendarDao;

	public int insertCalender(Calendar calendar) {
		int result = calendarDao.insertCalender(calendar);
		return result;
	}
    public Calendar getInfo(UserDto user) {
        Calendar calendar = calendarDao.selectCalendar(user);
        System.out.println(calendar);
        return calendar;
    }
}
