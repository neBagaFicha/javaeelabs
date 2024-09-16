package labs.javaeelabs.firstTask;
import javafx.embed.swing.SwingFXUtils;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import labs.javaeelabs.Main;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class FirstTaskController {

    @FXML
    Button backButton;
    @FXML
    AnchorPane firstTaskPane;
    @FXML
    ToggleGroup firstTaskToggleButtonGroup;
    @FXML
    Button saveButton;
    @FXML
    private void onBackButtonClick() throws IOException {
        Scene mainScene = new Scene(new FXMLLoader(Main.class.getResource("main-view.fxml")).load());
        ((Stage) backButton.getScene().getWindow()).setScene(mainScene);
    }
    @FXML
    private void firstTaskPaneClick(MouseEvent event) {
        if (firstTaskToggleButtonGroup.getSelectedToggle() != null) {
            ImageView copiedImageView = (ImageView) ((ToggleButton) firstTaskToggleButtonGroup.getSelectedToggle()).getGraphic();
            ImageView newImageView = new ImageView(copiedImageView.getImage());
            newImageView.setFitHeight(90);
            newImageView.setFitWidth(90);
            newImageView.setX(event.getX() - 45);
            newImageView.setY(event.getY() - 45);
            firstTaskPane.getChildren().add(newImageView);
        }
    }

    @FXML
    private void onSaveButtonClick() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Сохранить изображение");

        FileChooser.ExtensionFilter pngFilter = new FileChooser.ExtensionFilter("PNG files (*.png)", "*.png");
        FileChooser.ExtensionFilter jpgFilter = new FileChooser.ExtensionFilter("JPEG files (*.jpg, *.jpeg)", "*.jpg", "*.jpeg");
        FileChooser.ExtensionFilter bmpFilter = new FileChooser.ExtensionFilter("BMP files (*.bmp)", "*.bmp");

        fileChooser.getExtensionFilters().addAll(pngFilter, jpgFilter, bmpFilter);

        File outputFile = fileChooser.showSaveDialog(backButton.getScene().getWindow());

        if (outputFile != null) {
            WritableImage image = firstTaskPane.snapshot(null, null);

            try {
                BufferedImage bufferedImage = SwingFXUtils.fromFXImage(image, null);
                BufferedImage croppedImage = bufferedImage.getSubimage(50,50, (int)firstTaskPane.getWidth() - 250, (int)firstTaskPane.getHeight() - 50);
                ImageIO.write(croppedImage, getFileExtension(outputFile), outputFile);
                System.out.println("Изображение сохранено в файл: " + outputFile.getAbsolutePath());
            } catch (IOException e) {
                System.err.println("Ошибка при сохранении изображения: " + e.getMessage());
            }
        }
    }

    private String getFileExtension(File file) {
        String fileName = file.getName();
        int extensionIndex = fileName.lastIndexOf('.');
        if (extensionIndex > 0) {
            return fileName.substring(extensionIndex + 1).toLowerCase();
        }
        return "";
    }
}
