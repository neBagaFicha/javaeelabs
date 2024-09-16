package labs.javaeelabs.thirdTask;

import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import labs.javaeelabs.secondTask.LineShape;

public class ModifiedLineShape extends LineShape {
    private Rectangle rectangle;
    private final Color colorOfContour;
    private final Integer widthOfContour;
    private final String typeOfContour;

    public ModifiedLineShape(Line line, Color colorOfContour, Integer widthOfContour, String typeOfContour) {
        this.line = line;
        this.colorOfContour = colorOfContour;
        this.widthOfContour = widthOfContour;
        this.typeOfContour = typeOfContour;
        setupMFrame();
    }


    public void setupMRectangle() {
        rectangle.setFill(Color.TRANSPARENT);
        rectangle.setStroke(new Color(colorOfContour.getRed(), colorOfContour.getGreen(), colorOfContour.getBlue(), 0.3));
        rectangle.setStrokeWidth(widthOfContour);
        if (typeOfContour.equals("Dotted")) {
            rectangle.getStrokeDashArray().addAll(10.0, 10.0);
        }

    }


    public void setupMFrame() {
        rectangle = new Rectangle(
                line.getStartX() - 2,
                line.getStartY() - 2,
                Math.abs(line.getStartY() - line.getEndY() - 5),
                Math.abs(line.getStartX() - line.getEndX() - 5)
        );
        setupMRectangle();
        setFrame(rectangle);
    }

    @Override
    public Rectangle getRectangle() {
        return getFrame();
    }
}