package labs.javaeelabs.thirdTask;


import javafx.embed.swing.SwingFXUtils;
import javafx.geometry.Rectangle2D;
import javafx.scene.SnapshotParameters;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;


import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class FileSaver {
    private final static FileChooser fileChooser = new FileChooser();

    public static void saveFile(WritableImage image, String extension, Integer width, Integer height, Stage stage) {
        setupFileChooser(extension);
        File file = fileChooser.showSaveDialog(stage);
        if (file != null) {
            try {
                ImageIO.write(
                        SwingFXUtils.fromFXImage(resizeImage(image, width, height), null),
                        "png",
                        file
                );
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private static void setupFileChooser(String extension) {
        ExtensionFilter extFilter = new ExtensionFilter(
                String.format("%s files (*.%s)", extension.toUpperCase(), extension),
                String.format("*.%s", extension)
        );
        fileChooser.getExtensionFilters().clear();
        fileChooser.getExtensionFilters().add(extFilter);
    }

    private static WritableImage resizeImage(WritableImage fullSizeImage, int width, int height) {
        Image image = SwingFXUtils.toFXImage(SwingFXUtils.fromFXImage(fullSizeImage, null), null);
        ImageView imageView = new ImageView(image);

        imageView.setFitWidth(width);
        imageView.setFitHeight(height);
        imageView.setPreserveRatio(true);

        WritableImage resizedImage = new WritableImage(width, height);
        SnapshotParameters params = new SnapshotParameters();
        params.setFill(Color.TRANSPARENT);
        params.setViewport(new Rectangle2D(0, 0, width, height));
        imageView.snapshot(params, resizedImage);
        return resizedImage;
    }

}
