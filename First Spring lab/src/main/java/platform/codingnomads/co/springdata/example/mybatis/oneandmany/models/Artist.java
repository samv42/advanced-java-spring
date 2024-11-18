package platform.codingnomads.co.springdata.example.mybatis.oneandmany.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;

@Data
@NoArgsConstructor
@ToString(exclude = "albums")
public class Artist {

    private Long id;

    private String name;

    private String bio;

    private ArrayList<Album> albums;
}
