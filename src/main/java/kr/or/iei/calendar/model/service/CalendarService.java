package kr.or.iei.calendar.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.iei.calendar.model.dao.CalendarDao;
import kr.or.iei.calendar.model.dto.Calendar;

@Service
public class CalendarService {

    @Autowired
    private CalendarDao calendarDao;

    public Calendar getInfo() {
        Calendar calendar = calendarDao.getInfo();
    }
}
