package labs.javaeelabs.secondTask;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
public class CircleShape extends AbstractShape {
    protected final Ellipse circle;
    private final Integer radius;

    public CircleShape(Ellipse circle, Integer radius) {
        this.circle = circle;
        this.radius = radius;
        setupShape();
        setupFrame();
    }

    public CircleShape(Ellipse circle) {
        this.circle = circle;
        radius = 0;
    }


    @Override
    protected void setupFrame() {
        Rectangle currentFrame = new Rectangle(
                circle.getCenterX() - circle.getRadiusX() - 2,
                circle.getCenterY() - circle.getRadiusY() - 2,
                2 * circle.getRadiusX() + 4,
                2 * circle.getRadiusY() + 4
        );
        currentFrame = setupRectangle(currentFrame);
        setFrame(currentFrame);
    }

    @Override
    protected  void setupShape() {
        circle.setCenterX(350);
        circle.setCenterY(200);
        circle.setRadiusX(70);
        circle.setRadiusY(radius);
        circle.setFill(Color.TRANSPARENT);
        circle.setStroke(Color.BLACK);
        circle.setStrokeWidth(3);
    }

    @Override
    public void move(Integer x, Integer y, Directions direction) {
        int dx = (direction == Directions.LEFT ? -x : (direction == Directions.RIGHT ? x : 0));
        int dy = (direction == Directions.UP ? -y : (direction == Directions.DOWN ? y : 0));

        circle.setCenterX(circle.getCenterX() + dx);
        circle.setCenterY(circle.getCenterY() + dy);

        getFrame().setX(getFrame().getX() + dx);
        getFrame().setY(getFrame().getY() + dy);
    }

    @Override
    public void changeSize(Directions direction) {
        int change = 0;
        switch (direction) {
            case UP, LEFT -> change = -1;
            case DOWN, RIGHT -> change = 1;
        }
        if (direction == Directions.UP || direction == Directions.DOWN) {
            circle.setRadiusY(circle.getRadiusY() + change);
            circle.setCenterY(circle.getCenterY() + change);
        } else {
            circle.setRadiusX(circle.getRadiusX() + change);
            circle.setCenterX(circle.getCenterX() + change);
        }
        getFrame().setX(circle.getCenterX() - circle.getRadiusX() - 2);
        getFrame().setY(circle.getCenterY() - circle.getRadiusY() - 2);
        getFrame().setWidth(2 * circle.getRadiusX() + 4);
        getFrame().setHeight(2 * circle.getRadiusY() + 4);
    }

    @Override
    public Shape getShape() {
        return circle;
    }
}
