package platform.codingnomads.co.lab;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.lang.UsesSunHttpServer;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import platform.codingnomads.co.TestUtil;
import platform.codingnomads.co.springtest.lab.SpringTestLab;
import platform.codingnomads.co.springtest.lab.entity.Movie;
import platform.codingnomads.co.springtest.lab.repository.MovieRepository;
import platform.codingnomads.co.springtest.lab.service.MovieService;
import platform.codingnomads.co.springtest.mockingmethods.models.Recipe;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;

@SpringBootTest(classes = SpringTestLab.class)
@AutoConfigureMockMvc
@WithMockUser
public class MovieControllerTest {

    @Autowired
    private MockMvc mockMvc;

    //@MockBean
    //private MovieRepository movieRepo;

    //@MockBean
    //private MovieService movieService;

    @Test
    @Order(1)
    public void testGetAllMoviesSuccess() throws Exception{
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
    public void testGetAllMoviesFailure() throws Exception{
        //movieRepo.deleteAll();

        mockMvc.perform(get("/next"))
                .andDo(print())
                .andExpect(status().isNotFound());
    }

    @Test
    @Order(2)
    public void testGetAllMoviesSuccessTestUtil() throws Exception{
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
}
