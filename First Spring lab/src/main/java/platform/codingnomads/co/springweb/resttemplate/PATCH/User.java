package platform.codingnomads.co.springweb.resttemplate.PATCH;

import lombok.*;

@Data
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {
    int id;
    String email;
    String first_name;
    String last_name;
    String created_at;
    String updated_at;

}
