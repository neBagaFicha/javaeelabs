package labs.javaeelabs.secondTask;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public abstract class AbstractShape {
    private Rectangle frame;
    protected abstract void setupFrame();
    protected abstract void setupShape();
    public abstract void move(Integer x, Integer y, Directions direction);
    public abstract void changeSize(Directions direction);
    public abstract Shape getShape();
    public Rectangle setupRectangle(Rectangle rectangle) {
        rectangle.setFill(Color.TRANSPARENT);
        rectangle.setStroke(Color.BLACK);
        rectangle.setStrokeWidth(3.0f);
        rectangle.getStrokeDashArray().addAll(10.0, 20.0);
        rectangle.setOpacity(0.5);
        return rectangle;
    }
    public Rectangle getRectangle(){
        return new Rectangle();
    }

}
