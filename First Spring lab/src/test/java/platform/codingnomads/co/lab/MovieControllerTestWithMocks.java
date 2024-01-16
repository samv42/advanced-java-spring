package platform.codingnomads.co.lab;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import platform.codingnomads.co.TestUtil;
import platform.codingnomads.co.springtest.lab.SpringTestLab;
import platform.codingnomads.co.springtest.lab.controller.MovieController;
import platform.codingnomads.co.springtest.lab.entity.Movie;
import platform.codingnomads.co.springtest.lab.repository.MovieRepository;
import platform.codingnomads.co.springtest.lab.service.MovieService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest(classes = SpringTestLab.class)
@AutoConfigureMockMvc
@WithMockUser
public class MovieControllerTestWithMocks {

    @Autowired
    private MockMvc mockMvc;

    //@MockBean
    //private MovieRepository movieRepo;

    @MockBean
    private MovieService movieService;

    @Test
    @Order(1)
    public void testGetAllMoviesSuccessMockJsonPath() throws Exception {
        when(movieService.getAllMovies()).thenReturn(Arrays.asList(Movie.builder()
                        .id(1l)
                        .name("The Shawshank Redemption")
                        .rating(9.3)
                        .build(),
                Movie.builder()
                        .id(2l)
                        .name("The Pursuit of Happyness")
                        .rating(8.0)
                        .build()
        ));
        mockMvc.perform(get("/all"))
                .andDo(print())
                .andExpect((status().isOk()))
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].id").value(1))
                .andExpect(jsonPath("$[0].name").value("The Shawshank Redemption"))
                .andExpect(jsonPath("$[0].rating").value(9.3))
                .andExpect(jsonPath("$[1].id").value(2))
                .andExpect(jsonPath("$[1].name").value("The Pursuit of Happyness"))
                .andExpect(jsonPath("$[1].rating").value(8.0));
    }

    @Test
    @Order(10)
    public void testGetAllMoviesFailure() throws Exception {
        //movieRepo.deleteAll();

        mockMvc.perform(get("/next"))
                .andDo(print())
                .andExpect(status().isNotFound());
    }

    @Test
    @Order(2)
    public void testGetAllMoviesSuccessMockService() throws Exception {
        Movie movie = new Movie().builder()
                .id(1l)
                .name("The Dark Knight")
                .rating(7.2).build();
        when(
                movieService.getAllMovies()
        ).thenReturn(Arrays.asList(movie));
        mockMvc.perform(get("/all"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(content().string(TestUtil.convertObjectToJsonString(movie)));
    }

    @Test
    @Order(3)
    public void testGetAllMoviesSuccessTestUtilMockService() throws Exception {
        byte[] responseContent = mockMvc.perform(get("/all"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
                .andReturn().getResponse().getContentAsByteArray();

        Movie[] movies = TestUtil.convertJsonBytesToObject(responseContent, Movie[].class);
        assertThat(movies).hasSize(2);
        assertThat(movies[0].getId()).isEqualTo(1);
        assertThat(movies[0].getName()).isEqualTo("The Shawshank Redemption");
        assertThat(movies[1].getId()).isEqualTo(2);
        assertThat(movies[1].getName()).isEqualTo("The Pursuit of Happyness");
    }

    @Test
    @Order(5)
    public void testGetMoviesByMinRatingSuccess() throws Exception {
        Movie movie = new Movie().builder()
                .id(1l)
                .name("The Dark Knight")
                .rating(7.2).build();
        when(
                movieService.getMoviesMinRating(8d)
        ).thenReturn(Arrays.asList(movie));
        mockMvc.perform(get("/min/8"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(content().string(TestUtil.convertObjectToJsonString(Arrays.asList(movie))));
    }
    @Test
    @Order(4)
    public void testGetMoviesByMinRatingFailure() throws Exception {
        when(
                movieService.getMoviesMinRating(8d)
        ).thenReturn(null).thenReturn(new ArrayList<>());
        mockMvc.perform(get("/min/8"))
                .andDo(print())
                .andExpect(status().isNotFound());
//        mockMvc.perform(get("/min/8"))
//                .andDo(print())
//                .andExpect(status().isNotFound());
    }
}
