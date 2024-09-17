package labs.javaeelabs.seventhTask;

import javafx.animation.AnimationTimer;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.Duration;
import labs.javaeelabs.Main;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class seventhTaskController implements Initializable {
    @FXML
    Button backButton;
    @FXML
    MediaView seventhTaskMediaView;
    @FXML
    Button playButton;
    @FXML
    Button pauseButton;
    @FXML
    Slider volumeSlider;
    @FXML
    Button fileButton;
    @FXML
    Label labelForVideoDuration;

    private FileChooser fileChooser;

    @FXML
    private void onBackButtonClick() throws IOException {
        Scene mainScene = new Scene(new FXMLLoader(Main.class.getResource("main-view.fxml")).load());
        ((Stage) backButton.getScene().getWindow()).setScene(mainScene);
    }

    public void initialize(URL url, ResourceBundle resourceBundle) {
        fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Video Files", "*.mp4"));
        String pathToDirectory = "C:\\Users\\79197\\Desktop\\учеба\\oopLabs\\javaeelabs\\src\\main\\resources\\Videos";
        fileChooser.setInitialDirectory(new File(pathToDirectory));
        volumeSlider.setValue(30);
        onVolumeSlider();
    }
    @FXML
    private void onFileButtonClick() throws IOException {
        File videoFile = fileChooser.showOpenDialog(seventhTaskMediaView.getScene().getWindow());
        if (videoFile != null) {
            Media media = new Media(videoFile.toURI().toString());
            MediaPlayer mediaPlayer = new MediaPlayer(media);
            mediaPlayer.setVolume(0.3);
            seventhTaskMediaView.setMediaPlayer(mediaPlayer);
            mediaPlayer.setOnReady(() ->
                    labelForVideoDuration.setText("--:-- / " + formatDuration(media.getDuration()))
            );
            setupTimer(media);
            Platform.runLater(() -> {
                fileButton.setText(videoFile.getName());
                volumeSlider.setValue(30);
            });

        }


    }

    @FXML
    private void onPlayButtonClick() throws IOException {
        seventhTaskMediaView.getMediaPlayer().play();
    }
    @FXML
    private void onPauseButtonClick() throws IOException {
        seventhTaskMediaView.getMediaPlayer().pause();
    }

    private void onVolumeSlider() {
        volumeSlider.valueProperty().addListener(
                (observable, oldValue, newValue) -> {
                    if (seventhTaskMediaView.getMediaPlayer() != null)
                        seventhTaskMediaView.getMediaPlayer().setVolume(newValue.doubleValue() / 100);
                }
        );

    }

    private String formatDuration(Duration duration) {
        long minutes = (long) duration.toMinutes();
        long seconds = (long) duration.toSeconds() % 60;

        return String.format("%02d:%02d", minutes, seconds);
    }

    private void setupTimer(Media media) {
        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                labelForVideoDuration.setText(
                        formatDuration(seventhTaskMediaView.getMediaPlayer().getCurrentTime()) +
                                " / " +
                                formatDuration(media.getDuration())
                );
            }
        };
        timer.start();
    }
}
