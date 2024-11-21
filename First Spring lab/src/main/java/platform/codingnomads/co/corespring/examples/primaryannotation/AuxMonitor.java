package platform.codingnomads.co.corespring.examples.primaryannotation;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Primary
@Component
public class AuxMonitor implements LinkedDevice{
}
