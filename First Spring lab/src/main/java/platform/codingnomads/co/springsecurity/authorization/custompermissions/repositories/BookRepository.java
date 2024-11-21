package platform.codingnomads.co.springsecurity.authorization.custompermissions.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import platform.codingnomads.co.springsecurity.authorization.custompermissions.models.Book;

public interface BookRepository extends JpaRepository<Book, Long> {
    Book getByTitle(String title);
}
