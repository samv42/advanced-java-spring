package platform.codingnomads.co.springweb.resttemplate.PATCH.models;

import lombok.Data;
import platform.codingnomads.co.springweb.resttemplate.PATCH.User;
import platform.codingnomads.co.springweb.resttemplate.PUT.models.Error;

@Data
public class UserResponse {
    User data;
    Error error;
    String status;
}
