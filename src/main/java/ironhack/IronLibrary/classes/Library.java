package ironhack.IronLibrary.classes;

import ironhack.IronLibrary.model.Author;
import ironhack.IronLibrary.model.Book;
import ironhack.IronLibrary.model.Issue;
import ironhack.IronLibrary.model.Student;
import ironhack.IronLibrary.repository.AuthorRepository;
import ironhack.IronLibrary.repository.BookRepository;
import ironhack.IronLibrary.repository.IssueRepository;
import ironhack.IronLibrary.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Library {
    @Autowired
    AuthorRepository authorRepository;
    @Autowired
    BookRepository bookRepository;
    @Autowired
    StudentRepository studentRepository;
    @Autowired
    IssueRepository issueRepository;

    public void insertStudent(Student student){
        studentRepository.save(student);
    }
    public void insertBook(Book book){
        bookRepository.save(book);
    }
    public void insertAuthor(Author author){
        authorRepository.save(author);
    }
    public void insertIssue(Issue issue){
        issueRepository.save(issue);
    }
}
