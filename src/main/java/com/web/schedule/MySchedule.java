package com.web.schedule;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

import com.web.repo.ScheduleTimingsRepo;

import lombok.Getter;
import lombok.Setter;


@Component
public class MySchedule {

	@Getter
	@Setter
    private ScheduleTimingsRepo scheduleTimingsRepo;

   

   // @Scheduled(cron="#{ @scheduleTimingsRepo.findCronExpressionById(${cron.expression.id1}) }")
    public void task1() {
        LocalDateTime dt = LocalDateTime.now();
        System.out.println("Cron Expression 1: " + dt);
    }

  
    
   

	
	
}
