package labs.javaeelabs.seventhTask;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import labs.javaeelabs.Main;

import java.io.IOException;

public class seventhTaskController {
    @FXML
    Button backButton;

    @FXML
    private void onBackButtonClick() throws IOException {
        Scene mainScene = new Scene(new FXMLLoader(Main.class.getResource("main-view.fxml")).load());
        ((Stage) backButton.getScene().getWindow()).setScene(mainScene);
    }
}
