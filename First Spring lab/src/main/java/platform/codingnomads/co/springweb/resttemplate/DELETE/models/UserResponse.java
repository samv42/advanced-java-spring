package platform.codingnomads.co.springweb.resttemplate.DELETE.models;

import lombok.Data;

@Data
public class UserResponse {
    User data;
    Error error;
    String status;
}
