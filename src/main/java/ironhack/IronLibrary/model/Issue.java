package ironhack.IronLibrary.model;

import jakarta.persistence.*;

@Entity
public class Issue {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer issueId;
    private String issueDate;
    private String returnDate;
    //TODO: add studentId
    //@OneToOne
    //@JoinColumn(name = "studentId")
    //private Student issueStudent;
    @OneToOne
    @JoinColumn(name = "book_isbn")
    private Book issueBook;

    public Issue() {
    }

    //TODO add student
    public Issue(String issueDate, String returnDate, Book issueBook) {
        this.issueDate = issueDate;
        this.returnDate = returnDate;
        this.issueBook = issueBook;
    }

    public Integer getIssueId() {
        return issueId;
    }

    public void setIssueId(Integer issueId) {
        this.issueId = issueId;
    }

    public String getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(String issueDate) {
        this.issueDate = issueDate;
    }

    public String getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }

    public Book getIssueBook() {
        return issueBook;
    }

    public void setIssueBook(Book issueBook) {
        this.issueBook = issueBook;
    }

    @Override
    public String toString() {
        return "Issue{" +
                "issueId=" + issueId +
                ", issueDate='" + issueDate + '\'' +
                ", returnDate='" + returnDate + '\'' +
                ", issueBook=" + issueBook +
                '}';
    }
}
