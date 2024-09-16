package labs.javaeelabs.thirdTask;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.SnapshotParameters;
import javafx.scene.control.*;
import javafx.scene.image.WritableImage;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.Duration;
import labs.javaeelabs.Main;
import labs.javaeelabs.secondTask.AbstractShape;
import labs.javaeelabs.secondTask.Directions;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.Objects;
import java.util.ResourceBundle;

public class thirdTaskController implements Initializable {
    @FXML
    AnchorPane thirdTaskPane;
    @FXML
    Button backButton;
    @FXML
    ComboBox<String> comboBoxForTypeOfContour;
    @FXML
    ToggleGroup choosePrimitiveToggleButtonGroup;
    @FXML
    ColorPicker colorPickerForContour;
    @FXML
    ColorPicker colorPickerForFill;
    @FXML
    TextField textFieldForWidthOfContour;
    @FXML
    TextField widthForImageToSave;
    @FXML
    TextField heightForImageToSave;
    @FXML
    Button saveButton;
    @FXML
    Button helpButton;

    Tooltip tooltipForHelp = new Tooltip("""
            Это приложение выполняет функцию графического редактора,
             \
            настройте изображение \
            в правой панели и щелкните лкм по левой панели,
             после добавления на панель фигуры, вы можете изменять \
            ее размеры\s
            (клавиши "<" ">" "+" "-" и менять ее расположение на клавиши стрелок\s""");


    @FXML
    private void onBackButtonClick() throws IOException {
        Scene mainScene = new Scene(new FXMLLoader(Main.class.getResource("main-view.fxml")).load());
        ((Stage) backButton.getScene().getWindow()).setScene(mainScene);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        Arrays.asList("Dotted", "Solid").forEach(value -> comboBoxForTypeOfContour.getItems().add(value));

    }

    Painter painter = new Painter();

    @FXML
    private void onThirdTaskPaneClick(MouseEvent event)  {
        thirdTaskPane.requestFocus();
        if (!Objects.equals(textFieldForWidthOfContour.getText(), "") && !Objects.equals(comboBoxForTypeOfContour.getValue(), null)
                && choosePrimitiveToggleButtonGroup.getSelectedToggle() != null) {

            AbstractShape newShape = ShapeFactory.create((Shape) (((ToggleButton) choosePrimitiveToggleButtonGroup.getSelectedToggle()).getChildrenUnmodifiable().getFirst()),
                    colorPickerForContour.getValue(),
                    colorPickerForFill.getValue(),
                    Integer.parseInt(textFieldForWidthOfContour.getText()),
                    comboBoxForTypeOfContour.getValue(), event.getX(), event.getY());


            if (painter.getCurrentShape() != null) {
                if (painter.getCurrentShape().getRectangle().getStroke() != null) {
                    var previousRectangle = painter.getCurrentShape().getRectangle();
                    Color colorOfRectangle = (Color) previousRectangle.getStroke();
                    previousRectangle.setStroke(new Color(colorOfRectangle.getRed(), colorOfRectangle.getGreen(), colorOfRectangle.getBlue(), 1));
                } else {
                    var previousShape = painter.getCurrentShape().getShape();
                    Color colorOfBuffShape = (Color) previousShape.getStroke();
                    previousShape.setStroke(new Color(colorOfBuffShape.getRed(), colorOfBuffShape.getGreen(), colorOfBuffShape.getBlue(), 1));
                }
            }
            painter.setCurrentShape(newShape);
            thirdTaskPane.getChildren().add(newShape.getShape());
            thirdTaskPane.getChildren().add(newShape.getRectangle());
        }
    }

    @FXML
    protected void onKeyPressed(KeyEvent keyEvent) {
        if (painter.getCurrentShape() != null) {
            switch (keyEvent.getCode()) {
                case UP, DOWN, LEFT, RIGHT -> onArrowsPressed(keyEvent);
                case EQUALS, MINUS -> onPlusMinusPressed(keyEvent);
                case COMMA, PERIOD -> onLessGreaterPressed(keyEvent);
            }
        }
    }

    private void onArrowsPressed(KeyEvent keyEvent) {
        switch (keyEvent.getCode()) {
            case UP -> painter.getCurrentShape().move(2, 2, Directions.UP);
            case DOWN -> painter.getCurrentShape().move(2, 2, Directions.DOWN);
            case LEFT -> painter.getCurrentShape().move(2, 2, Directions.LEFT);
            case RIGHT -> painter.getCurrentShape().move(2, 2, Directions.RIGHT);
        }
    }

    private void onPlusMinusPressed(KeyEvent keyEvent) {
        switch (keyEvent.getCode()) {
            case EQUALS -> painter.getCurrentShape().changeSize(Directions.UP);
            case MINUS -> painter.getCurrentShape().changeSize(Directions.DOWN);
        }
    }

    private void onLessGreaterPressed(KeyEvent keyEvent) {
        switch (keyEvent.getCode()) {
            case COMMA -> painter.getCurrentShape().changeSize(Directions.LEFT);
            case PERIOD -> painter.getCurrentShape().changeSize(Directions.RIGHT);
        }
    }

    @FXML
    private void onHelpButtonPressed(MouseEvent event) {
        tooltipForHelp.show(helpButton, event.getScreenX(), event.getScreenY());
    }

    @FXML
    private void onHelpButtonReleased(){
        tooltipForHelp.hide();
    }

    @FXML
    private void onSaveButtonClick(){
        FileSaver.saveFile(thirdTaskPane.snapshot(null, null), "png", Integer.parseInt(widthForImageToSave.getText()), Integer.parseInt(heightForImageToSave.getText()), (Stage) backButton.getScene().getWindow());
    }

}
