
import java.applet.Applet;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.FontMetrics;

public class BouncingTextApplet extends Applet implements Runnable {
    
    private Thread animationThread;
    private int xPosition = 50;      // Current x-coordinate of text
    private int yPosition = 50;      // Current y-coordinate of text
    private int xVelocity = 3;       // Speed in x direction
    private int yVelocity = 2;       // Speed in y direction
    private String displayText = "Bouncing Text!";
    private int appletWidth;
    private int appletHeight;
    private boolean running = false;
    private int textWidth = 0;
    private int textHeight = 0;
    
    @Override
    public void init() {
        this.setSize(600, 400); // Increased size for better bouncing
        this.setBackground(Color.BLACK);
        
        appletWidth = this.getWidth();
        appletHeight = this.getHeight();
        
        // Calculate text dimensions
        Font font = new Font("Arial", Font.BOLD, 24);
        FontMetrics metrics = getFontMetrics(font);
        textWidth = metrics.stringWidth(displayText);
        textHeight = metrics.getHeight();
        
        System.out.println("Applet initialized! Size: " + appletWidth + "x" + appletHeight);
    }
    
    @Override
    public void start() {
        if (animationThread == null) {
            animationThread = new Thread(this);
            animationThread.start();
            running = true;
            System.out.println("Animation thread started!");
        }
    }
    
    @Override
    public void stop() {
        if (animationThread != null) {
            running = false;
            animationThread = null;
            System.out.println("Animation thread stopped!");
        }
    }
    
    @Override
    public void run() {
        Thread currentThread = Thread.currentThread();
        
        while (running && animationThread == currentThread) {
            try {
                // Update position
                xPosition += xVelocity;
                yPosition += yVelocity;
                
                // Check for collisions with left/right boundaries
                if (xPosition <= 0) {
                    xPosition = 0;
                    xVelocity = -xVelocity; // Bounce right
                } else if (xPosition + textWidth >= appletWidth) {
                    xPosition = appletWidth - textWidth;
                    xVelocity = -xVelocity; // Bounce left
                }
                
                // Check for collisions with top/bottom boundaries
                if (yPosition <= textHeight) {
                    yPosition = textHeight;
                    yVelocity = -yVelocity; // Bounce down
                } else if (yPosition >= appletHeight) {
                    yPosition = appletHeight - 5;
                    yVelocity = -yVelocity; // Bounce up
                }
                
                // Repaint the screen
                repaint();
                
                // Control animation speed
                Thread.sleep(30);
                
            } catch (InterruptedException e) {
                System.out.println("Animation thread interrupted: " + e.getMessage());
                break;
            }
        }
    }
    
    @Override
    public void paint(Graphics g) {
        // Set text color and font
        g.setColor(Color.GREEN);
        g.setFont(new Font("Arial", Font.BOLD, 24));
        
        // Draw the bouncing text
        g.drawString(displayText, xPosition, yPosition);
        
        // Draw info text
        g.setColor(Color.YELLOW);
        g.setFont(new Font("Arial", Font.PLAIN, 12));
        g.drawString("Position: (" + xPosition + ", " + yPosition + ")", 10, appletHeight - 40);
        g.drawString("Velocity: (" + xVelocity + ", " + yVelocity + ")", 10, appletHeight - 25);
        g.drawString("Use: appletviewer BouncingTextApplet.html", 10, appletHeight - 10);
        
        // Draw border
        g.setColor(Color.RED);
        g.drawRect(0, 0, getWidth()-1, getHeight()-1);
        
        // Draw center cross for reference
        g.setColor(Color.GRAY);
        g.drawLine(appletWidth/2, 0, appletWidth/2, appletHeight);
        g.drawLine(0, appletHeight/2, appletWidth, appletHeight/2);
    }
    
    @Override
    public void destroy() {
        System.out.println("Applet destroyed - cleaning up resources");
    }
}
