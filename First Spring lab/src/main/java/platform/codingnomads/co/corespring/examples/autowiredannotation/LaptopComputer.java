package platform.codingnomads.co.corespring.examples.autowiredannotation;

import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@ToString
public class LaptopComputer {
    @Autowired
    private VideoCard videoCard;

    @Autowired
    @Qualifier("volusion")
    private VideoCard videoCard2;

    @Autowired
    @Qualifier("exceptian")
    private VideoCard videoCard3;
}
