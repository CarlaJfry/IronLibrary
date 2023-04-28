package ironhack.IronLibrary.model;

import jakarta.persistence.*;

@Entity
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer authorId;
    private String name;
    private String email;
    @OneToOne
    @JoinColumn(name = "authorName")
    private Book publishedBook;

    public Author() {
    }

    public Author(String name, String email, Book publishedBook) {
        this.name = name;
        this.email = email;
        this.publishedBook = publishedBook;
    }

    public Author(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public Integer getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Integer authorId) {
        this.authorId = authorId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Book getPublishedBook() {
        return publishedBook;
    }

    public void setPublishedBook(Book publishedBook) {
        this.publishedBook = publishedBook;
    }
}
