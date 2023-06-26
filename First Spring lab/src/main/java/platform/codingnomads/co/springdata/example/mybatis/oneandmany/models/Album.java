package platform.codingnomads.co.springdata.example.mybatis.oneandmany.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;

@Data
@NoArgsConstructor
@ToString(exclude = "songs")
public class Album {
    private long id;
    private String name;
    private Artist artist;
    private ArrayList<Song> songs;

}
