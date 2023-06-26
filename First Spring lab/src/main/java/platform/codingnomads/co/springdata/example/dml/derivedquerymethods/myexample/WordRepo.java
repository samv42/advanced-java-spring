package platform.codingnomads.co.springdata.example.dml.derivedquerymethods.myexample;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import platform.codingnomads.co.springdata.example.dml.derivedquerymethods.plantexample.Plant;

import java.util.List;


@Repository
public interface WordRepo extends JpaRepository<Word, Long> {
    List<Word> findByNameContaining(String name);
    List<Word> findByLengthLessThanEqual(int length);
    List<Word> findByLengthGreaterThan(int length);
    List<Word> findByLengthGreaterThanEqual(int length);
    List<Word> findByType(String type);
    List<Word> findByOrigin(String origin);
    List<Word> findByNameStartingWith(String name);
    List<Word> findByNameEndingWith(String name);
    List<Word> findByNameContainingAndType(String name, String type);
    List<Word> findByName(String name);

}
