package platform.codingnomads.co.springweb.resttemplate.POST.models;

import lombok.Builder;
import lombok.Data;

@Data
public class User {
    UserData data;
    Error error;
    String status;

}
