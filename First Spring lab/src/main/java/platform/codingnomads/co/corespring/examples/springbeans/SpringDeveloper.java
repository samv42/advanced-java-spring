package platform.codingnomads.co.corespring.examples.springbeans;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
public class SpringDeveloper {

    private Address address;
    private Occupant occupant;

    public SpringDeveloper(Address address, Occupant occupant) {
        this.address = address;
        this.occupant = occupant;
    }
}
