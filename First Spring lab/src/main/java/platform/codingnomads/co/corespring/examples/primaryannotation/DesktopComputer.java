package platform.codingnomads.co.corespring.examples.primaryannotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DesktopComputer {
    @Autowired
    private VideoCard videoCard;
    @Autowired
    private LinkedDevice linkedDevice;
}
