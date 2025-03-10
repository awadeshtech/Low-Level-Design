package com.lld.designproject.meeting_scheduler;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.TimeZone;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import org.apache.tomcat.util.threads.ScheduledThreadPoolExecutor;

public class CalendarApp {
    public static void main(String[] args) {
        Event event = new Event();
        event.setStartTime(Instant.now().toEpochMilli());
        Instant.now().plus(2, ChronoUnit.MINUTES);
        long delay = event.getStartTime() - System.currentTimeMillis();
        LocalDateTime dateTime = LocalDateTime.now();
        List<String> list = new ArrayList<>();

        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);
        ScheduleEvent scheduleEvent = new ScheduleEvent(event);

        scheduledExecutorService.schedule(scheduleEvent,delay, TimeUnit.MILLISECONDS);

//        BlockingQueue<Event> blockingQueue = new ArrayBlockingQueue<>();

        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
//       String line = bufferedReader.readLine();

        List<Event> events = new ArrayList<>();
        events.add(event);
        events.sort(Comparator.comparing(Event::getTitle).thenComparing(Event::getEndTime));


    }
}
