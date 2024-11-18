package platform.codingnomads.co.springsecurity.authorization.custompermissions.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import platform.codingnomads.co.springsecurity.authorization.custompermissions.models.Book;
import platform.codingnomads.co.springsecurity.authorization.custompermissions.models.User;
import platform.codingnomads.co.springsecurity.authorization.custompermissions.repositories.BookRepository;
import platform.codingnomads.co.springsecurity.authorization.custompermissions.repositories.UserRepository;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    BookRepository bookRepository;

    public User getUser(String email) {
        return userRepository.findByEmail(email);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    public void saveBook(Book book) {bookRepository.save(book);}

    public void getBookByTitle(String title) {bookRepository.getByTitle(title);}
}
