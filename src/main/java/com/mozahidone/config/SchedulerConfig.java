package com.mozahidone.config;

import com.mozahidone.model.UserResponse;
import com.mozahidone.template.MessageTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@EnableScheduling
@Configuration
public class SchedulerConfig {

    @Autowired
    SimpMessagingTemplate template;

    public static Integer counter = 0;

    public static String launchScheduler = "STOP";
    public static String customerName = "";

    @Scheduled(fixedDelay = 6000)
    public void sendAdhocMessages() {
        if(launchScheduler.equals("START")) {
            counter++;
            if(counter <= 4) {
                String message = MessageTemplate.getMessage(customerName, counter);
                System.out.println("Counter" + counter + ", Message:" + message);
                template.convertAndSend("/topic/user", new UserResponse(message));
            }
        }
    }
}
