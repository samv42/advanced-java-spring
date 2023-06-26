package platform.codingnomads.co.springdata.example.mybatis.resultsandresult;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Book {
    private long id;
    private String name;
    private String author;
    private int totalPages;
    private int publishDate;
}
