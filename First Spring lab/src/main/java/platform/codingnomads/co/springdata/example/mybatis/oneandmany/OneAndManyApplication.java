package platform.codingnomads.co.springdata.example.mybatis.oneandmany;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import platform.codingnomads.co.springdata.example.mybatis.oneandmany.mappers.AlbumMapper;
import platform.codingnomads.co.springdata.example.mybatis.oneandmany.mappers.ArtistMapper;
import platform.codingnomads.co.springdata.example.mybatis.oneandmany.mappers.SongMapper;
import platform.codingnomads.co.springdata.example.mybatis.oneandmany.models.Album;
import platform.codingnomads.co.springdata.example.mybatis.oneandmany.models.Artist;
import platform.codingnomads.co.springdata.example.mybatis.oneandmany.models.Song;

import java.util.ArrayList;
import java.util.Collections;

@SpringBootApplication
public class OneAndManyApplication {

    public static void main(String[] args) {
        SpringApplication.run(OneAndManyApplication.class, args);
    }

    @Bean
    public CommandLineRunner loadInitialData(SongMapper songMapper, ArtistMapper artistMapper, AlbumMapper albumMapper) {
        return (args) -> {

            Artist artist1 = new Artist();
            artist1.setName("Bon Iver");
            artist1.setBio("Bon Iver is an American indie folk band founded " +
                    "in 2006 by singer-songwriter Justin Vernon.");
            artistMapper.insertNewArtist(artist1);
            Song song1 = new Song();
            song1.setName("Minnesota, WI");
            song1.setArtist(artist1);
            song1.setSongLength(232);

            Album album1 = new Album();
            album1.setName("Bon Iver");
            album1.setArtist(artist1);
            album1.setSongs(new ArrayList<>(Collections.singletonList(song1)));
            artist1.setAlbums(new ArrayList<>(Collections.singletonList(album1)));
            song1.setAlbum(album1);

            Artist artist2 = new Artist();
            artist2.setName("Gus Dapperton");
            artist2.setBio("Brendan Patrick Rice, better known by his stage name Gus Dapperton, " +
                    "is an American singer and songwriter from Warwick, New York.");
            artistMapper.insertNewArtist(artist2);

            Song song2 = new Song();
            song2.setName("Post Humorous");

            Album album2 = new Album();
            album2.setName("Orca");
            album2.setArtist(artist2);
            album2.setSongs(new ArrayList<>(Collections.singletonList(song2)));
            song2.setAlbum(album2);
            song2.setArtist(artist2);
            song2.setSongLength(279);
            artist2.setAlbums(new ArrayList<>(Collections.singletonList(album2)));

            songMapper.insertNewSong(song1);
            songMapper.insertNewSong(song2);

            albumMapper.insertNewAlbum(album1);
            albumMapper.insertNewAlbum(album2);

            Song song3 = songMapper.getSongById(1L);
            System.out.println(song3.toString());

            /*Artist artist3 = artistMapper.getArtistById(1L);
            System.out.println(artist3.toString());
            System.out.println(artist3.getSongs());*/
        };
    }
}
