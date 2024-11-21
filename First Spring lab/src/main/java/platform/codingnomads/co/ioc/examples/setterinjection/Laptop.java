package platform.codingnomads.co.ioc.examples.setterinjection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Laptop {
    private Processor processor;
    private OS os;
    private Keyboard keyboard;

    @Autowired
    public void setProcessor(Processor processor) {
        this.processor = processor;
    }

    @Autowired
    public void setOs(OS os) {
        this.os = os;
    }

    @Autowired
    public void setKeyboard(Keyboard keyboard) {this.keyboard = keyboard; }

    public String printLaptopConfiguration() {
        return "processor: " + processor.getCore() + " core " + processor.getName() +
                "\nOS: " + os.getName() + "\nkeyboard: " + keyboard.getModel();
    }
}
