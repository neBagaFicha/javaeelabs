module labs.javaeelabs {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires javafx.swing;
    requires static lombok;


    opens labs.javaeelabs to javafx.fxml;
    exports labs.javaeelabs;

    opens labs.javaeelabs.firstTask to javafx.fxml;
    exports labs.javaeelabs.firstTask;

    opens labs.javaeelabs.secondTask to javafx.fxml;
    exports labs.javaeelabs.secondTask;

    opens labs.javaeelabs.thirdTask to javafx.fxml;
    exports labs.javaeelabs.thirdTask;

    opens labs.javaeelabs.fifthTask to javafx.fxml;
    exports labs.javaeelabs.fifthTask;
}