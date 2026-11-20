package Model.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "IssueBooks")
public class issuBookEntity {

    @Id
    private String issueID;
    private String borrowMember;
    private String borrowBook;
    private String issueDate;
    private String dueDate;

    public issuBookEntity(String issueID, String borrowMember, String borrowBook, String issueDate, String dueDate) {
        this.issueID = issueID;
        this.borrowMember = borrowMember;
        this.borrowBook = borrowBook;
        this.issueDate = issueDate;
        this.dueDate = dueDate;
    }

    public issuBookEntity() {
    }

    @Override
    public String toString() {
        return "issuBookEntity{" +
                "issueID='" + issueID + '\'' +
                ", borrowMember='" + borrowMember + '\'' +
                ", borrowBook='" + borrowBook + '\'' +
                ", issueDate='" + issueDate + '\'' +
                ", dueDate='" + dueDate + '\'' +
                '}';
    }

    public String getIssueID() {
        return issueID;
    }

    public void setIssueID(String issueID) {
        this.issueID = issueID;
    }

    public String getBorrowMember() {
        return borrowMember;
    }

    public void setBorrowMember(String borrowMember) {
        this.borrowMember = borrowMember;
    }

    public String getBorrowBook() {
        return borrowBook;
    }

    public void setBorrowBook(String borrowBook) {
        this.borrowBook = borrowBook;
    }

    public String getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(String issueDate) {
        this.issueDate = issueDate;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }
}
