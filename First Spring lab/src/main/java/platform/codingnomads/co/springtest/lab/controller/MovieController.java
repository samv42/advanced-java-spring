package platform.codingnomads.co.springtest.lab.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import platform.codingnomads.co.springtest.lab.entity.Movie;
import platform.codingnomads.co.springtest.lab.service.MovieService;

import java.util.List;

@RestController
@RequestMapping("/")
@AllArgsConstructor
public class MovieController {

    private MovieService movieService;

    @GetMapping("/all")
    public List<Movie> getAllMovies() {
        return movieService.getAllMovies();
    }

    @GetMapping("/min/{rating}")
    public ResponseEntity<?> getMoviesByMinRating(@PathVariable("rating") Double rating) {
        List <Movie> movies = movieService.getMoviesMinRating(rating);
        if(movies == null || movies.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(movies);
    }
}
