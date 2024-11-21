package platform.codingnomads.co.corespring.examples.application_context.customeventlistener;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class SecondListener implements ApplicationListener<UserRegistrationCompletedEvent> {
    @Override
    public void onApplicationEvent(UserRegistrationCompletedEvent event) {
        System.out.println("Second Listener received message.");
    }
}
