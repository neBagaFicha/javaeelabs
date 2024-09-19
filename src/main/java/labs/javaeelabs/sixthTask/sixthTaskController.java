package labs.javaeelabs.sixthTask;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Point3D;

import javafx.scene.PerspectiveCamera;
import javafx.scene.Scene;
import javafx.scene.SceneAntialiasing;
import javafx.scene.SubScene;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.ScrollEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;

import javafx.scene.shape.Sphere;

import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import labs.javaeelabs.Main;
import labs.javaeelabs.thirdTask.FileSaver;


import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.stream.IntStream;

public class sixthTaskController {
    @FXML
    Button backButton;


    @FXML
    private void onBackButtonClick() throws IOException {
        Scene mainScene = new Scene(new FXMLLoader(Main.class.getResource("main-view.fxml")).load());
        ((Stage) backButton.getScene().getWindow()).setScene(mainScene);
    }

}

