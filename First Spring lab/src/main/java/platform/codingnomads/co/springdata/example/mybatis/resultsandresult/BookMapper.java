package platform.codingnomads.co.springdata.example.mybatis.resultsandresult;

import org.apache.ibatis.annotations.*;

import java.util.ArrayList;

@Mapper
public interface BookMapper {
    @Insert("INSERT INTO mybatis.books " +
            "(name, author, total_pages, publish_date) " +
            "VALUES (#{name}, #{author}, #{totalPages}, #{publishDate});")
    @Options(useGeneratedKeys = true, keyColumn = "id", keyProperty = "id")
    void insertNewBook(Book book);

    @Select("SELECT * " +
            "FROM mybatis.books " +
            "WHERE id = #{param1};")
    @Results(
            id = "bookResultMap",
            value = {
                    @Result(property = "totalPages", column = "total_pages"),
                    @Result(property = "publishDate", column = "publish_date")
            }
    )
    Book getBookById(Long id);

    @Select("SELECT * " +
            "FROM mybatis.books " +
            "WHERE publish_date = #{param1};")
    @ResultMap("bookResultMap")
    ArrayList<Book> getBookByPublishDate(int publishDate);

    @Delete("DELETE FROM mybatis.books WHERE id = #{param1};")
    void deleteBookById(Long bookId);
}
