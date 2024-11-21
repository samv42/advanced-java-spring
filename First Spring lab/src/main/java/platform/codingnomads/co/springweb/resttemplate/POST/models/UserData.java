package platform.codingnomads.co.springweb.resttemplate.POST.models;

import lombok.Builder;

@lombok.Data
@Builder
public class UserData {
    int id;
    String email;
    String first_name;
    String last_name;
    String created_at;
    String updated_at;
}
