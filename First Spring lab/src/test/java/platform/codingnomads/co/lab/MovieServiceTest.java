package platform.codingnomads.co.lab;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import platform.codingnomads.co.springtest.lab.SpringTestLab;
import platform.codingnomads.co.springtest.lab.entity.Movie;
import platform.codingnomads.co.springtest.lab.repository.MovieRepository;
import platform.codingnomads.co.springtest.lab.service.MovieService;
import platform.codingnomads.co.springtest.lab.service.MovieServiceImpl;

import java.util.ArrayList;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

@SpringBootTest(classes = MovieService.class)
@WithMockUser
public class MovieServiceTest {
    @Mock
    private MovieRepository movieRepository;

    @InjectMocks
    private MovieServiceImpl movieService;

//    @Autowired
//    Movie movie = new Movie().builder()
//            .id(1l)
//            .name("The Dark Knight")
//            .rating(7.2).build();

    @Test
    void testGetAllMoviesSuccess() {
        Movie movie = new Movie().builder()
            .id(1l)
            .name("The Dark Knight")
            .rating(7.2).build();
        when(movieRepository.findAll()).thenReturn(Arrays.asList(movie));
        assertThat(movieService.getAllMovies()).isEqualTo(Arrays.asList(movie));
    }

    @Test
    void testGetAllMoviesFailure() {
        when(movieRepository.findAll()).thenReturn(new ArrayList<>());
        assertThat(movieService.getAllMovies()).isEqualTo(new ArrayList<>());
    }

    @Test
    void testGetMoviesMinRatingSuccess() {
        Movie movie = new Movie().builder()
                .id(1l)
                .name("The Dark Knight")
                .rating(7.2).build();
        when(movieRepository.getByRating(anyDouble())).thenReturn(Arrays.asList(movie));
        assertThat(movieService.getMoviesMinRating(8d)).isEqualTo(Arrays.asList(movie));
    }
    @Test
    void testGetMoviesMinRatingFailure() {
        when(movieRepository.getByRating(anyDouble())).thenReturn(new ArrayList<>());
        assertThat(movieService.getMoviesMinRating(8d)).isEqualTo(new ArrayList<>());
    }
}
