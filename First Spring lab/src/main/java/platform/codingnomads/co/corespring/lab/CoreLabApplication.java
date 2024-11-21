package platform.codingnomads.co.corespring.lab;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class CoreLabApplication {
    public static void main(String[] args) {

        ApplicationContext ctx = new AnnotationConfigApplicationContext(LabConfig.class);
        Book book = ctx.getBean(Book.class);
        String[] movies = ctx.getBeanNamesForType(Movie.class);
        System.out.println("Book: " + book.getTitle() + " by " + book.getAuthor());
        for(String movie: movies) {
            System.out.println("Movie: " + ctx.getBean(movie, Movie.class) + " directed by: " + ctx.getBean(movie, Movie.class));
        }
    }
}
