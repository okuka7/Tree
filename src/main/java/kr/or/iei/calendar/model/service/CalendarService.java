package kr.or.iei.calendar.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.iei.calendar.model.dao.CalendarDao;

@Service
public class CalendarService {

    @Autowired
    private CalendarDao calendarDao;
}
