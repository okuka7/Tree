package kr.or.iei.calendar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.or.iei.calendar.model.dto.Calendar;
import kr.or.iei.calendar.model.service.CalendarService;

@Controller
@RequestMapping(value = "/calendar")
public class CalendarController {

    @Autowired
    private CalendarService calendarService;

    @GetMapping(value="/list")
    public String list(){
        return "calendar/calendar";
    }
    
    @GetMapping(value = "/insert")
    public String insertCalender(Calendar calendar) {
    	int result = calendarService.insertCalender(calendar);
    	return "calender/writeFrm";
    }

}
