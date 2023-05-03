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

import java.util.List;
import java.util.Optional;

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
    public Book getBookByTitle(String title) {
        Optional<Book> optionalBook = bookRepository.findBookByTitle(title);
        if(optionalBook.isPresent()) {
            return optionalBook.get();
        }
        return null;

    }
    public List<Book> getBookByCategory(String category) {
        List<Book> bookList = bookRepository.findBooksByCategory(category);
        if(bookList.size() > 0) {
            return bookList;
        }
        return null;
    }
    public Book getBookByAuthor(String authorName) {
        Optional<Author> optionalAuthor = authorRepository.findAuthorByName(authorName);
        if(optionalAuthor.isPresent()) {
            return optionalAuthor.get().getPublishedBook();
        }
        return null;
    }
    public List<Author> getAllAuthors(){
        List<Author> authorsList = authorRepository.findAll();
        if(authorsList.size() > 0) {
            return authorsList;
        }
        return null;
    }
    public Book getBookById(String isbn) {
        Optional<Book> optionalBook = bookRepository.findById(isbn);
        if (optionalBook.isPresent()) {
            return optionalBook.get();
        }
        return null;
    }
    public List<Issue>findIssueByStudentNumber(String studentUsn){
        Optional<Student> optionalStudent = studentRepository.findById(studentUsn);
        if(optionalStudent.isPresent()){
            List<Issue> issueList = issueRepository.findAllByStudentUsn(studentUsn);
            if(issueList.size() > 0) {
                return issueList;
            }
            return null;
        }
        return null;
    }
    //TODO: 7 - List books by usn
}
