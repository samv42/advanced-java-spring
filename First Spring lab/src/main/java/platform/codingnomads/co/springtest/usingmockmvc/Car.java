package platform.codingnomads.co.springtest.usingmockmvc;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@Builder
public class Car {
    String model;
    String color;
    String brand;
}
