package platform.codingnomads.co.ioc.examples.constructorinjection;

import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Laptop {

    private Processor processor;
    private OS os;
    private Mouse mouse;

    // these fields are being injected from the ApplicationContext
    // if a class contains only one constructor (as this one does), the use of @Autowired is optional
    // if a class contains two or more constructors, @Autowired is required for constructor injection to take place
    public Laptop(Processor processor, OS os, Mouse mouse) {
        this.processor = processor;
        this.os = os;
        this.mouse = mouse;
    }

    public String printLaptopConfiguration() {
        return "processor: " + processor.getCore() + " core " + processor.getName() +
                "\nOS: " + os.getName() + "\nMouse: " + " Type: " + mouse.getType() + " Model: " + mouse.getModel();
    }
}
