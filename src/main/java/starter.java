import db.HibernateUtil;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import scene.SceneManager;

public class starter extends Application {
    public static void main(String[] args) {
        launch();

    }

    @Override
    public void start(Stage stage) throws Exception {
        HibernateUtil.getSessionFactory();
        SceneManager.setStage(stage);
        SceneManager.switchPage("/view/Login_page.fxml");

    }

    @Override
    public void stop() throws Exception {
        HibernateUtil.shoutdown();
        super.stop();
    }
}
