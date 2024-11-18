package platform.codingnomads.co.springsecurity.authorization.custompermissions.models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Book {
    String title;
    String author;
}
