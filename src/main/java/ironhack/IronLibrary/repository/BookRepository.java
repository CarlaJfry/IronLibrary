package ironhack.IronLibrary.repository;

import ironhack.IronLibrary.model.Author;
import ironhack.IronLibrary.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book, String> {

    Optional<Book> findBookByTitle(String title);
    List<Book> findBookByCategory(String category);
}
