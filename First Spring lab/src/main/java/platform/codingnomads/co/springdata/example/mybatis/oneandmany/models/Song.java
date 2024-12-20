package platform.codingnomads.co.springdata.example.mybatis.oneandmany.models;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Song {

    private Long id;

    private String name;

    private Album album;

    private Artist artist;

    //song length in seconds
    private int songLength;

    public Song(String name, Album album, Artist artist, int songLength) {
        this.name = name;
        this.album = album;
        this.artist = artist;
        this.songLength = songLength;
    }
}
