package labs.javaeelabs.secondTask;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import lombok.AllArgsConstructor;
import lombok.Getter;
public class RectangleShape extends AbstractShape{
    public Rectangle shape;

    public RectangleShape(Rectangle copiedShape) {
        super();
    }

    @Override
    protected void setupFrame() {
    }

    @Override
    protected void setupShape() {
    }

    @Override
    public void move(Integer x, Integer y, Directions direction) {
        int dx = (direction == Directions.LEFT ? -x : (direction == Directions.RIGHT ? x : 0));
        int dy = (direction == Directions.UP ? -y : (direction == Directions.DOWN ? y : 0));

        shape.setX(shape.getX() + dx);
        shape.setY(shape.getY() + dy);

    }

    @Override
    public void changeSize(Directions direction) {
        int change = 0;
        switch (direction) {
            case UP, LEFT -> change = -1;
            case DOWN, RIGHT -> change = 1;
        }
        if (direction == Directions.UP || direction == Directions.DOWN) {
            shape.setHeight(shape.getHeight() + change);
        } else {
            shape.setWidth(shape.getWidth() + change);
        }

    }

    @Override
    public Shape getShape() {
        return shape;
    }
}
