package com.lld.designproject.meeting_scheduler;


import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CalendarController {


    @GetMapping(value = "/v1/api/events")
    List<Event> getEvents() {
        return new ArrayList<>();

    }
}
