module labs.javaeelabs {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.swing;
    requires static lombok;
    requires javafx.media;
    requires com.fasterxml.jackson.databind;


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

    opens labs.javaeelabs.seventhTask to javafx.fxml;
    exports labs.javaeelabs.seventhTask;

    opens labs.javaeelabs.fourthTask to javafx.fxml;
    exports labs.javaeelabs.fourthTask;

    opens labs.javaeelabs.sixthTask to javafx.fxml;
    exports labs.javaeelabs.sixthTask;
}