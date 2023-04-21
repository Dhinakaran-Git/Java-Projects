package com.bassure.security.client.event;

import com.bassure.security.client.entity.UserDemo;
import lombok.Getter;
import lombok.Setter;
import org.springframework.context.ApplicationEvent;

@Getter
@Setter
public class RegisterCompleteEvent extends ApplicationEvent {

    private UserDemo userDemo;
    private String applicationUrl;
    public RegisterCompleteEvent(UserDemo user, String applicationUrl) {
        super(user);
        this.userDemo = user;
        this.applicationUrl = applicationUrl;
    }
}
