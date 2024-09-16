package labs.javaeelabs;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class MainController {
    @FXML
    Button firstTaskButton;
    @FXML
    Button secondTaskButton;
    @FXML
    Button thirdTaskButton;
    @FXML
    Button fourthTaskButton;
    @FXML
    protected void onFirstTaskButtonClick() throws IOException {
        Scene firstTaskScene = new Scene(new FXMLLoader(Main.class.getResource("firstTask-view.fxml")).load());
        ((Stage) firstTaskButton.getScene().getWindow()).setScene(firstTaskScene);
    }

    @FXML
    protected void onSecondTaskButtonClick() throws IOException {
        Scene secondTaskScene = new Scene(new FXMLLoader(Main.class.getResource("secondTask-view.fxml")).load());
        ((Stage) secondTaskButton.getScene().getWindow()).setScene(secondTaskScene);
    }

    @FXML
    protected void onThirdTaskButtonClick() throws IOException {
        Scene thirdTaskScene = new Scene(new FXMLLoader(Main.class.getResource("thirdTask-view.fxml")).load());
        ((Stage) thirdTaskButton.getScene().getWindow()).setScene(thirdTaskScene);
    }


}