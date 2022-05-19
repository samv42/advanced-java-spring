package platform.codingnomads.co.corespring.examples.application_context.frameworkevents;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

@Component
public class ApplicationReadyEvent implements ApplicationListener<ContextRefreshedEvent> {
    @Override
    public void onApplicationEvent(@NonNull ContextRefreshedEvent contextRefreshedEvent) {
        System.out.println("Application is ready!!");
    }
}
