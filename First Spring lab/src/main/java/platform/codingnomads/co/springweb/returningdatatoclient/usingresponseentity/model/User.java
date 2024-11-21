package platform.codingnomads.co.springweb.returningdatatoclient.usingresponseentity.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {

    private int id;

    private String name;

    private String email;
}
