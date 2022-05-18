package platform.codingnomads.co.ioc.examples.constructorinjection;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Mouse {
    private String type;
    private String model;

    public Mouse(String type, String model){
        this.type = type;
        this.model = model;
    }
}
