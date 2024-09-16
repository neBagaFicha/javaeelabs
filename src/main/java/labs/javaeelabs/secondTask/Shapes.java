package labs.javaeelabs.secondTask;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Shapes {
    LINE(new LineShape(new Line())),
    CIRCLE(new CircleShape(new Ellipse(), 70)),
    Ellipse(new CircleShape(new Ellipse(), 100));
    private final AbstractShape shape;
}
