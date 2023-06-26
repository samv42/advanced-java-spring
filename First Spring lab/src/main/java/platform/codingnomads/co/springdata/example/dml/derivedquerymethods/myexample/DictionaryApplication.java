package platform.codingnomads.co.springdata.example.dml.derivedquerymethods.myexample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import platform.codingnomads.co.springdata.example.dml.derivedquerymethods.plantexample.Plant;
import platform.codingnomads.co.springdata.example.dml.derivedquerymethods.plantexample.PlantApplication;
import platform.codingnomads.co.springdata.example.dml.derivedquerymethods.plantexample.PlantRepo;

import java.util.List;

@SpringBootApplication
public class DictionaryApplication implements CommandLineRunner {
        @Autowired
        WordRepo wordRepo;

        public static void main(String[] args) {
            SpringApplication.run(platform.codingnomads.co.springdata.example.dml.derivedquerymethods.myexample.DictionaryApplication.class);
        }

    @Override
    public void run(String... args) throws Exception {
                Word agility = Word.builder()
                        .name("agility")
                        .definition("The quality of being agile; the power of " +
                                "moving the limbs quickly and easily; quickness of motion ")
                        .length(7)
                        .type("noun")
                        .origin("French")
                        .build();
                wordRepo.save(agility);

                Word adieu = Word.builder()
                        .name("adieu")
                        .definition("farewell")
                        .length(5)
                        .type("interjection")
                        .origin("French")
                        .build();
                wordRepo.save(adieu);

                Word lager = Word.builder()
                        .name("lager")
                        .definition("type of beer")
                        .length(5)
                        .type("noun")
                        .origin("German")
                        .build();
                wordRepo.save(lager);

                Word prattle = Word.builder()
                        .name("prattle")
                        .definition("meaningless chatter")
                        .length(7)
                        .type("verb")
                        .origin("German")
                        .build();
                wordRepo.save(prattle);

                Word comprehend = Word.builder()
                        .name("comprehend")
                        .definition("to understand")
                        .length(9)
                        .type("verb")
                        .origin("French")
                        .build();
                wordRepo.save(comprehend);
        System.out.println("\n********* findByNameContaining(a) *********");
        List<Word> words1 = wordRepo.findByNameContaining("a");
        words1.forEach(System.out::println);

        System.out.println("\n********* findByLengthLessThanEqual(5) *********");
        List<Word> words2 = wordRepo.findByLengthLessThanEqual(5);
        words2.forEach(System.out::println);

        System.out.println("\n********* findByLengthGreaterthan(6) *********");
        List<Word> words3 = wordRepo.findByLengthGreaterThan(6);
        words3.forEach(System.out::println);

        System.out.println("\n********* findByLengthGreaterthanEqual(5) *********");
        List<Word> words4 = wordRepo.findByLengthGreaterThanEqual(5);
        words4.forEach(System.out::println);

        System.out.println("\n********* findByType(noun) *********");
        List<Word> words5 = wordRepo.findByType("noun");
        words5.forEach(System.out::println);

        System.out.println("\n********* findByOrigin(German) *********");
        List<Word> words6 = wordRepo.findByOrigin("German");
        words6.forEach(System.out::println);

        System.out.println("\n********* findByNameStartingWith(a) *********");
        List<Word> words7 = wordRepo.findByNameStartingWith("a");
        words7.forEach(System.out::println);

        System.out.println("\n********* findByNameEndingWith( *********");
        List<Word> words8 = wordRepo.findByNameEndingWith("r");
        words8.forEach(System.out::println);

        System.out.println("\n********* findByNameContainingAndType(a,noun) *********");
        List<Word> words9 = wordRepo.findByNameContainingAndType("a", "noun");
        words9.forEach(System.out::println);

        System.out.println("\n********* findByName *********");
        List<Word> words10 = wordRepo.findByName("prattle");
        words10.forEach(System.out::println);

        wordRepo.deleteAll();
    }
}
