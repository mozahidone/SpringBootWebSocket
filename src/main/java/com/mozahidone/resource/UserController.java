package com.mozahidone.resource;

import com.mozahidone.config.SchedulerConfig;
import com.mozahidone.model.User;
import com.mozahidone.model.UserResponse;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {


    @MessageMapping("/user")
    @SendTo("/topic/user")
    public UserResponse getUser(User user) {
        if(SchedulerConfig.launchScheduler.equals("STOP")) {
            SchedulerConfig.launchScheduler = "START";
            SchedulerConfig.counter = 0;
            SchedulerConfig.customerName = user.getName();
            return new UserResponse("Hi " + user.getName() + ", <BR>Welcome to our system!");
        } else {
            SchedulerConfig.launchScheduler = "STOP";
            SchedulerConfig.customerName = user.getName();
            return new UserResponse(user.getName() + "<BR>Bye! Have a nice day!");
        }
    }
}
