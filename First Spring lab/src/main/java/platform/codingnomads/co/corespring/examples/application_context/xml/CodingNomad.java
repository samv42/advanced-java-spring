package platform.codingnomads.co.corespring.examples.application_context.xml;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.MessageFormat;

@Component
@RequiredArgsConstructor
public class CodingNomad {
    private final JDK jdk;
    private final IDE ide;
    private final Framework framework;
    private final Monitor monitor;
    private final Keyboard keyboard;

    public String createAwesomeSoftware() {
        return MessageFormat
                .format("This coding nomad is creating awesome software using, " +
                                "IDE:({0}:{1}), JDK: ({2}:{3}), Framework:({4}:{5}), Monitor: ({6}:{7}), Keyboard: ({8})",
                        ide.getName(),
                        ide.getVersion(),
                        jdk.getName(),
                        jdk.getVersion(),
                        framework.getName(),
                        framework.getVersion(),
                        monitor.getBrand(),
                        monitor.getModel(),
                        keyboard.getType()
                );
    }
}
