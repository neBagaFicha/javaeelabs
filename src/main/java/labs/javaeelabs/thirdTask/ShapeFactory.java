package labs.javaeelabs.thirdTask;


import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import labs.javaeelabs.secondTask.AbstractShape;
import labs.javaeelabs.secondTask.RectangleShape;
import lombok.Setter;


@Setter
public class ShapeFactory {
    public static AbstractShape create(Shape shape, Color colorOfContour, Color colorOfFill,
                                       Integer widthOfContour, String typeOfContour, Double centerX, Double centerY) {

        return switch (shape.getClass().getSimpleName()) {
            case "Circle" -> {
                Ellipse copiedShape = new Ellipse();
                copiedShape.setRadiusX(50);
                copiedShape.setRadiusY(50);
                setupCircleAndEllipse(copiedShape, colorOfContour, colorOfFill, widthOfContour, centerX, centerY);
                if (typeOfContour.equals("Dotted")) {
                    copiedShape.getStrokeDashArray().addAll(10.0, 10.0);
                }
                yield new ModifiedCircleShape(copiedShape);
            }
            case "Rectangle" -> {
                Rectangle copiedShape = new Rectangle();
                copiedShape.setWidth(100);
                copiedShape.setHeight(50);
                copiedShape.setX(centerX - 50);
                copiedShape.setY(centerY - 25);
                copiedShape.setFill(colorOfFill);
                copiedShape.setStroke(new Color(colorOfContour.getRed(), colorOfContour.getGreen(), colorOfContour.getBlue(), 0.3));
                copiedShape.setStrokeWidth(widthOfContour);
                if (typeOfContour.equals("Dotted")) {
                    copiedShape.getStrokeDashArray().addAll(10.0, 10.0);
                }
                yield new RectangleShape(copiedShape);
            }
            case "Ellipse" -> {
                Ellipse copiedShape = new Ellipse();
                copiedShape.setRadiusX(50);
                copiedShape.setRadiusY(70);
                setupCircleAndEllipse(copiedShape, colorOfContour, colorOfFill, widthOfContour, centerX, centerY);
                if (typeOfContour.equals("Dotted")) {
                    copiedShape.getStrokeDashArray().addAll(10.0, 10.0);
                }
                yield new ModifiedCircleShape(copiedShape);
            }
            case "Line" ->{
                Line copiedShape = new Line();
                copiedShape.setStroke(colorOfFill);
                copiedShape.setStrokeWidth(3);
                copiedShape.setStartX(centerX - 50);
                copiedShape.setStartY(centerY - 50);
                copiedShape.setEndX(centerX + 50);
                copiedShape.setEndY(centerY + 50);
                yield new ModifiedLineShape(copiedShape, colorOfContour,widthOfContour, typeOfContour);
            }

            default -> throw new IllegalStateException("Unexpected value: " + shape.getClass().getSimpleName());
        };
    }

    private static void setupCircleAndEllipse(Ellipse copiedShape, Color colorOfContour, Color colorOfFill,
                                              Integer widthOfContour, Double centerX, Double centerY){
        copiedShape.setCenterX(centerX);
        copiedShape.setCenterY(centerY);
        copiedShape.setFill(colorOfFill);
        copiedShape.setStroke(new Color(colorOfContour.getRed(), colorOfContour.getGreen(), colorOfContour.getBlue(), 0.3));
        copiedShape.setStrokeWidth(widthOfContour);
    }
}
