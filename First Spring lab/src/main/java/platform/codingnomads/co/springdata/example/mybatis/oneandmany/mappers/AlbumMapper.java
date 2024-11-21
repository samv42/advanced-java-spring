package platform.codingnomads.co.springdata.example.mybatis.oneandmany.mappers;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import platform.codingnomads.co.springdata.example.mybatis.oneandmany.models.Album;
import platform.codingnomads.co.springdata.example.mybatis.oneandmany.models.Artist;
import platform.codingnomads.co.springdata.example.mybatis.oneandmany.models.Song;

import java.util.ArrayList;

@Mapper
public interface AlbumMapper {
    @Insert("INSERT INTO mybatis.albums " +
            "(name, artist_id) " +
            "VALUES (#{name}, #{artist.id});")
    @Options(useGeneratedKeys = true, keyColumn = "id", keyProperty = "id")
    void insertNewAlbum(Album album);

    @Select("SELECT * " +
            "FROM mybatis.albums " +
            "WHERE id = #{param1};")
    @Results(
            id = "albumResultMap",
            value = {
                    @Result(
                            property = "artist",
                            column = "artist_id",
                            javaType = Artist.class,
                            one = @One(
                                    select = "platform.codingnomads.co.springdata.example.mybatis.oneandmany.mappers.ArtistMapper.getArtistById",
                                    fetchType = FetchType.LAZY
                            )
                    ),
                    @Result(
                            property = "songs",
                            column = "id",
                            javaType = ArrayList.class,
                            many = @Many(
                                    select = "platform.codingnomads.co.springdata.example.mybatis.oneandmany.mappers.SongMapper.getSongsByAlbumId",
                                    fetchType = FetchType.LAZY
                            )
                    )
            }
    )
    Album getAlbumById(long id);

    @Select("SELECT * " +
            "FROM mybatis.albums " +
            "WHERE artist_id = #{param1};")
    @ResultMap("albumResultMap")
    ArrayList<Album> getAlbumsByArtistId(Long id);
}
