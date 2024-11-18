package platform.codingnomads.co.springdata.example.mybatis.mapperslesson;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;

@SpringBootApplication
public class MyBatisDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyBatisDemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner loadInitialData(SongMapper songMapper) {
        return (args) -> {
            //initial data
            /*Song song1 = new Song();
            song1.setName("Minnesota, WI");
            song1.setAlbum_name("Bon Iver");
            song1.setArtist_name("Bon Iver");
            song1.setSong_length(232);

            Song song2 = new Song();
            song2.setName("Post Humorous");
            song2.setAlbum_name("Orca");
            song2.setArtist_name("Gus Dapperton");
            song2.setSong_length(279);

            songMapper.insertNewSong(song1);
            songMapper.insertNewSong(song2);

            Song song3 = songMapper.getSongById(1L);
            System.out.println(song3.toString());*/
            Song song3 = new Song();
            song3.setName("Heart cooks brain");
            song3.setAlbum_name("Lonesome Crowded West");
            song3.setArtist_name("Modest Mouse");
            song3.setSong_length(242);

            Song song4 = new Song();
            song4.setName("Lounge");
            song4.setAlbum_name("Lonesome Crowded West");
            song4.setArtist_name("Modest Mouse");
            song4.setSong_length(260);

            Song song5 = new Song();
            song5.setName("A different city");
            song5.setAlbum_name("Moon and Antarctica");
            song5.setArtist_name("Modest Mouse");
            song5.setSong_length(300);

            songMapper.insertNewSong(song3);
            songMapper.insertNewSong(song4);
            songMapper.insertNewSong(song5);

            ArrayList<Song> album = songMapper.getSongsByAlbum("Lonesome Crowded West");
            for(Song song : album){
                System.out.println(song.getName());
            }
            ArrayList<Song> songName = songMapper.getSongsByName("Lounge");
            Song Lounge = songName.get(0);
            System.out.println(Lounge.toString());

            ArrayList<Song> antarctica = songMapper.getSongsByAlbumAndArtist("Modest Mouse",
                    "Moon and Antarctica");
            for(Song song : antarctica){
                System.out.println(song.getName());
            }

            Song song6 = new Song();
            song6.setId(4L);
            song6.setName("Lounge (Closing Time)");
            song6.setAlbum_name("Lonesome Crowded West");
            song6.setArtist_name("Modest Mouse");
            song6.setSong_length(260);
            songMapper.updateSong(song6);

            Song song7 = songMapper.getSongById(4L);
            System.out.println(song7.toString());

            songMapper.deleteSongById(1L);
            songMapper.deleteSongsByAlbum("Lonesome Crowded West");
            songMapper.deleteSongsByAlbumAndArtist("Modest Mouse", "Moon and Antarctica");
        };
    }
}
