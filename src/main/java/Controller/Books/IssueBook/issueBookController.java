package Controller.Books.IssueBook;

import Model.Entity.issuBookEntity;
import Model.issueBookDTO;
import db.DBConnection;
import db.HibernateUtil;
import scene.SceneManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class issueBookController {

//    Connection connection = DBConnection.getInstance().getConnection();

    public void databaseSaveIssueBookDetails (issueBookDTO issuebook){

        try {
            issuBookEntity issuBookEntity = new issuBookEntity();
            issuBookEntity.setIssueID(issuebook.getIssueID());
            issuBookEntity.setBorrowMember(issuebook.getBorrowMember());
            issuBookEntity.setBorrowBook(issuebook.getBorrowBook());
            issuBookEntity.setIssueDate(issuebook.getIssueDate());
            issuBookEntity.setDueDate(issuebook.getDueDate());

            HibernateUtil.executeInTransaction(session -> session.persist(issuBookEntity));
            SceneManager.switchPage("/view/successNotification/AddIssueBookSuccessfulNotification.fxml");
        } catch (Exception e) {
            SceneManager.switchPage("/view/FailedNotification/AddIssueBookFailedNotification.fxml");
            throw new RuntimeException(e);
        }


//        String addIssueBookSql = "INSERT INTO issueBook (issueID, borrowMember, borrowBook, issuedate, duedate) VALUES (?,?,?,?,?)";
//
//        try {
//            PreparedStatement preparedStatement = connection.prepareStatement(addIssueBookSql);
//            preparedStatement.setString(1,issuebook.getIssueID());
//            preparedStatement.setString(2,issuebook.getBorrowMember());
//            preparedStatement.setString(3,issuebook.getBorrowBook());
//            preparedStatement.setString(4,issuebook.getIssueDate());
//            preparedStatement.setString(5,issuebook.getDueDate());
//
//            int addIssueBookQuaryResult = preparedStatement.executeUpdate();
//
//            if (addIssueBookQuaryResult > 0){
//                SceneManager.switchPage("/view/successNotification/AddBookSuccessNotification.fxml");
//            }else {
//                SceneManager.switchPage("/view/FailedNotification/AddIssueBookFailedNotification.fxml");
//            }
//
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
    }
}
