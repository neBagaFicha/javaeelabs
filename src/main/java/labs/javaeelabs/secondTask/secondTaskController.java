package labs.javaeelabs.secondTask;



import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import labs.javaeelabs.Main;


import java.io.IOException;
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;

public class secondTaskController  implements Initializable {
    @FXML
    AnchorPane paneForShape;
    @FXML
    Button backButton;

    AbstractShape shape;

    @FXML
    private void onBackButtonClick() throws IOException {
        Scene mainScene = new Scene(new FXMLLoader(Main.class.getResource("main-view.fxml")).load());
        ((Stage) backButton.getScene().getWindow()).setScene(mainScene);
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        backButton.setFocusTraversable(false);
        paneForShape.setFocusTraversable(true);
        shape = Shapes.values()[new Random().nextInt(3)].getShape();
        paneForShape.getChildren().add(shape.getShape());
        paneForShape.getChildren().add(shape.getFrame());
    }

    @FXML
    protected void onKeyPressed(KeyEvent keyEvent) {
        switch (keyEvent.getCode()) {
            case UP,DOWN,LEFT,RIGHT -> onArrowsPressed(keyEvent);
            case EQUALS,MINUS ->  onPlusMinusPressed(keyEvent);
            case COMMA,PERIOD -> onLessGreaterPressed(keyEvent);
        }
    }

    private void onArrowsPressed(KeyEvent keyEvent) {
        switch (keyEvent.getCode()) {
            case UP -> shape.move(2,2, Directions.UP);
            case DOWN -> shape.move(2,2, Directions.DOWN);
            case LEFT -> shape.move(2,2, Directions.LEFT);
            case RIGHT -> shape.move(2,2, Directions.RIGHT);
        }
    }

    private void onPlusMinusPressed(KeyEvent keyEvent) {
        switch (keyEvent.getCode()) {
            case EQUALS -> shape.changeSize(Directions.UP);
            case MINUS -> shape.changeSize(Directions.DOWN);
        }
    }

    private void onLessGreaterPressed(KeyEvent keyEvent) {
        switch (keyEvent.getCode()) {
            case COMMA -> shape.changeSize(Directions.LEFT);
            case PERIOD -> shape.changeSize(Directions.RIGHT);
        }
    }


}
