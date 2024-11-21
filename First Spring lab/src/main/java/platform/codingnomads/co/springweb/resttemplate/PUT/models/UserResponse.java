package platform.codingnomads.co.springweb.resttemplate.PUT.models;

import lombok.Data;

@Data
public class UserResponse {
    User data;
    Error error;
    String status;
}
