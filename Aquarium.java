import edu.cymbal.graphics.CanvasAPI;
import edu.cymbal.graphics.Graphics;
import edu.cymbal.graphics.PainterAPI;
import java.awt.Color;

public class Aquarium {
    public static void main(String[] args) {
        CanvasAPI canvas = Graphics.createCanvas(800, 600, "My First Drawing");

        PainterAPI painter = canvas.getPainter();
        painter.setSpeed(0); // Lower number means faster, zero means fast.

        drawAquarium(painter);
    }

    /**
    * Draws two fish, two jellyfish, seaweed, and bubbles.
    * 
    * @param painter the painter used to draw the aquarium
     */
    public static void drawAquarium(PainterAPI painter) {
        // calls drawFish twice with different sizes and colors
        drawFish(50, Color.PINK, -150, 50, painter);
        drawFish(75, Color.ORANGE, 150, -50, painter);
        // calls drawJellyFish twice with different sizes and colors
        drawJellyFish(35, new Color(128, 0, 128), -180, -120, painter);
        drawJellyFish(45, new Color(180, 80, 220), 150, 150, painter);
        // calls drawDecoration for seaweed and bubbles
        drawDecoration(painter);
    }

    /**
    * Moves the painter without drawing a connecting line
    *
    * @param x the horizontal position. measured from the canvas center 
    * @param y the vertical position. measured from the canvas center
    * @param painter the painter used for movement
    */
    public static void setPosition(double x, double y, PainterAPI painter) {
        // calls painter.penUp()
        painter.liftPen();
        // calls painter.moveTo(x, y)
        painter.moveTo(x, y);
        // calls painter.penDown()
        painter.lowerPen();
    }

    /**
    * draws a filled circle at the given position
    *
    * @param  radius the size of the circle 
    * @param color the circles color
    * @param x the horizontal position
    * @param y the vertical position
    * @param painter the painter used to draw 
    */
    public static void drawFilledCircle(double radius, Color color, double x, double y, PainterAPI painter) {

        setPosition(x, y - radius, painter); 
        painter.setPenColor(color);
        painter.startFill(color);
        painter.circle(radius);
        painter.finishFill();

    }

    /**
    * Draws a filled triangle pointing right for a fishs tail.
    *
    * @param size the height and width of the triangle 
    * @param color the triangles color 
    * @param x and horizontal position of its left edge 
    * @param y and vertical position of its bottom edge
    * @param painter the painter used to draw
    */
    public static void drawFilledTriangle(double size, Color color, double x, double y, PainterAPI painter) {
       
        setPosition(x, y, painter);
        painter.setPenColor(color);
        painter.startFill(color);

        painter.moveTo(x, y + size);
        painter.moveTo(x + size, y + size / 2);
        painter.moveTo(x, y);

        painter.finishFill();
    }

    /**
    * Draws fish tright with a round body and triangle tail.
    * 
    * @param size the radius of the fishs body
    * @param color the body and tail color
    * @param x and horizontal position of the body
    * @param y and vertical position of the body
    * @param painter the painter used to draw
    */
   public static void drawFish(double size, Color color, double x, double y, PainterAPI painter) {
       // Draws the tail
       drawFilledTriangle(size, color, x - 2 * size, y - size / 2, painter);
       
       // Draws the body
       drawFilledCircle(size, color, x, y, painter);

       // Draws the eye
       drawFilledCircle(size / 10, Color.BLACK, x + size / 3, y + size / 3, painter);
   }

   /**
    * Draws a jellyfish with a round head and straight tentacles.
    * 
    * @param size and head radius, also used to size the tentacles
    * @param x and horizontal position of the head
    * @param y and vertical position of the head
    * @param painter the painter used to draw
    */
   public static void drawJellyFish(double size, Color color, double x, double y, PainterAPI painter) {
        // Draw four straight tentacles
        painter.setPenColor(color);

        for (int i = 0; i < 4; i++) {
            double tentacleX = x - size * 0.6 + i * size * 0.4;

            setPosition(tentacleX, y - size, painter);
            painter.moveTo(tentacleX, y - size * 2);
        }

        // Draw the head
        drawFilledCircle(size, color, x, y, painter);

        // Draw the eyes
        drawFilledCircle(size / 8, Color.BLACK, x - size / 3, y - size / 4, painter);
        drawFilledCircle(size / 8, Color.BLACK, x + size / 3, y - size / 4, painter);
   }

   /**
    * Draws seaweed along the bottom and bubbles a;ong the sides
    * 
    * @param painter the painter used to draw the decorations
    */
   public static void drawDecoration(PainterAPI painter) {
       // Draws seaweed along the bottom
       for (int i = 0; i < 12; i++) {
           double x = -350 + i * 60;
           double height = 70 + (i % 3) * 15;
           Color green = new Color(70, 140, 40);

           setPosition(x - 8, -300, painter);
           painter.setPenColor(green);
           painter.startFill(green);

           // Go up one side to the tip
           painter.moveTo(x - 14, -300 + height * 0.25);
           painter.moveTo(x - 8, -300 + height * 0.5);
           painter.moveTo(x - 4, -300 + height * 0.75);
           painter.moveTo(x, -300 + height);

           // Come down the other side to the bottom
           painter.moveTo(x + 15, -300 + height * 0.75);
           painter.moveTo(x + 8, -300 + height * 0.5);
           painter.moveTo(x + 2, -300 + height * 0.25);
           painter.moveTo(x + 8, -300);
           painter.moveTo(x -8, -300);

           painter.finishFill();
       }

       // Draw small, staggered bubbles
       for (int i = 0; i < 6; i++) {
           double y = -190 + i * 80;
           double radius = 15 + (i % 3) * 2;
           double offset = (i % 3) * 25;

           painter.setPenColor( new Color(0, 170, 220));

           setPosition(-360 + offset, y - radius, painter);
           painter.circle(radius);

           setPosition(360 - offset, y + 25 - radius, painter);
           painter.circle(radius);
       }
   }

}
