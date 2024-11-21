package platform.codingnomads.co.springdata.example.mybatis.usingmappers.mappers;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import platform.codingnomads.co.springdata.example.mybatis.usingmappers.models.Artist;

import java.util.ArrayList;

@Mapper
public interface ArtistMapper {

    @Insert("INSERT INTO mybatis.artists (name, bio) VALUES (#{name}, #{bio});")
    @Options(useGeneratedKeys = true, keyColumn = "id", keyProperty = "id")
    void insertNewArtist(Artist artist);

    @Select("SELECT * FROM mybatis.artists WHERE id = #{param1};")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(
                    property = "songs",
                    column = "id",
                    javaType = ArrayList.class,
                    many = @Many(
                            select = "platform.codingnomads.co.springdata.example.mybatis.usingmappers.mappers.SongMapper.getSongsByArtistId",
                            fetchType = FetchType.LAZY
                    )
            )
    })
    Artist getArtistById(Long id);
}
