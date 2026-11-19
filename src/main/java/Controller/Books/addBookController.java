package Controller.Books;

import Model.BookDTO;
import Model.Entity.BookEntity;
import db.DBConnection;
import db.HibernateUtil;
import org.hibernate.Session;
import scene.SceneManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class addBookController {

//    Connection connection = DBConnection.getInstance().getConnection();

    public void databaseSaveBookDetails(BookDTO book) {

        try {
            BookEntity bookEntity = new BookEntity();

            bookEntity.setBook_id(book.getBook_id());
            bookEntity.setTitle(book.getTitle());
            bookEntity.setAuthor(book.getAuthor());
            bookEntity.setCategory(book.getCategory());
            bookEntity.setPublished_year(book.getPublished_year());
            bookEntity.setQuantity(book.getQuantity());

            HibernateUtil.executeInTransaction(session -> session.persist(bookEntity));

            SceneManager.switchPage("/view/successNotification/AddBookSuccessNotification.fxml");
        } catch (Exception e) {
            SceneManager.switchPage("/view/FailedNotification/AddBookFaildNotification.fxml");
            throw new RuntimeException(e);
        }

//        String AddBookSql = "INSERT INTO books (book_id, title, author, category, published_year, quantity) VALUES (?,?,?,?,?,?)";
//
//        try {
//            PreparedStatement preparedStatement = connection.prepareStatement(AddBookSql);
//            preparedStatement.setString(1,book.getBook_id());
//            preparedStatement.setString(2,book.getTitle());
//            preparedStatement.setString(3,book.getAuthor());
//            preparedStatement.setString(4, book.getCategory());
//            preparedStatement.setInt(5,book.getPublished_year());
//            preparedStatement.setInt(6,book.getQuantity());
//
//            int addBookQuaryResult = preparedStatement.executeUpdate();
//            if (addBookQuaryResult > 0){
//                SceneManager.switchPage("/view/successNotification/AddBookSuccessNotification.fxml");
//            }else {
//                SceneManager.switchPage("/view/FailedNotification/AddBookFaildNotification.fxml");
//            }
//
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }


    }
}
