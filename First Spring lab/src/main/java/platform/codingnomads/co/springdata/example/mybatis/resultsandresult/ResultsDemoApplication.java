package platform.codingnomads.co.springdata.example.mybatis.resultsandresult;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;

@SpringBootApplication
public class ResultsDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(ResultsDemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner loadInitialData(SongMapper songMapper, BookMapper bookMapper) {
        return (args) -> {
            //notice the setter names have changed to match Java naming conventions
            Song song1 = new Song();
            song1.setName("Minnesota, WI");
            song1.setAlbumName("Bon Iver");
            song1.setArtistName("Bon Iver");
            song1.setSongLength(232);

            Song song2 = new Song();
            song2.setName("Post Humorous");
            song2.setAlbumName("Orca");
            song2.setArtistName("Gus Dapperton");
            song2.setSongLength(279);

            songMapper.insertNewSong(song1);
            songMapper.insertNewSong(song2);

            Song song3 = songMapper.getSongById(1L);
//            System.out.println(song3.toString());

            Book book1 = new Book();
            book1.setName("Cats and Cradle");
            book1.setAuthor("Afred Silverspoon");
            book1.setTotalPages(230);
            book1.setPublishDate(2000);

            Book book2 = new Book();
            book2.setName("War and Peace");
            book2.setAuthor("John Smith");
            book2.setTotalPages(180);
            book2.setPublishDate(2000);

            bookMapper.insertNewBook(book1);
            bookMapper.insertNewBook(book2);

            Book book3 = bookMapper.getBookById(1L);
            System.out.println(book3.toString());

            ArrayList<Book> bookList = bookMapper.getBookByPublishDate(2000);
            for(Book book : bookList){
                System.out.println(book.toString());
            }

            bookMapper.deleteBookById(1L);
        };
    }
}
