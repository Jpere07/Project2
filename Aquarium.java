import edu.cymbal.graphics.CanvasAPI;
import edu.cymbal.graphics.Graphics;
import edu.cymbal.graphics.PainterAPI;
import java.awt.Color;


public class Aquarium {
    public static void main(String[] args) {
        CanvasAPI canvas = Graphics.createCanvas(800, 600, "My First Drawing");

        PainterAPI painter = canvas.getPainter();
        painter.setSpeed(10); // Lower number means faster, zero means as fast as possible.
        
        painter.forward(100);
        painter.turnRight(90);
        painter.circle(40);

        //drawAquarium(painter);
    }

    /**
    * Draws two fish, two jellyfish, seaweed, and bubbles.
    * 
    * @param painter the painter used to draw the aquarium
     */
    public static void drawAquarium(PainterAPI painter) {
        // calls drawFish twice with different sizes and colors
        // calls drawJellyFish twice with different sizes and colors
        // calls drawDecoration for seaweed and bubbles
    }

    /**
    * Moves the painter without drawing a connecting line
    *
    * @param x the horizontal position. measured from the canvas center 
    * @param y the vertical position. measured from the canvas center
    * @param painter the painter used for movement
    */
    public static void setPosition(double x, double y, PainterAPI painter) {

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
    public static void drawFilledCircle(double radius, Color coloe, double x, double y, PainterAPI painter) {
        // calls setPosition
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
        // calls setPosition
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
       // calls drawFilledCircle for the body and eye
       // calls drawFilledTriangle for the tail
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
       // calls drawFilledCircle for the head
       // calls setPosition to place the tentacles
   }

   /**
    * Draws seaweed along the bottom and bubbles a;ong the sides
    * 
    * @param painter the painter used to draw the decorations
    */
   public static void drawDecoration(PainterAPI painter) {
       // uses a loop that calls setPosition to draw seaweed
       // uses another loop that calls drawFilledCircle for bubbles.
   }

}
