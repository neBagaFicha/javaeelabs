package labs.javaeelabs.thirdTask;

import javafx.scene.shape.Ellipse;
import labs.javaeelabs.secondTask.CircleShape;

public class ModifiedCircleShape extends CircleShape {

    public ModifiedCircleShape(Ellipse circle) {
        super(circle);
        setupFrame();
    }
}
