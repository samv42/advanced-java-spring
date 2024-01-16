package platform.codingnomads.co.springweb.resttemplate.PUT.models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class User {
    int id;
    String email;
    String first_name;
    String last_name;
    String created_at;
    String updated_at;
}
