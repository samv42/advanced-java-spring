package platform.codingnomads.co.springweb.springrestcontrollers.simpledemo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class Cat {
    String name;
    String breed;
    String color;
    String sex;
}
