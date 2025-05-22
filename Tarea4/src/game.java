import javax.swing.*;
import java.awt.event.*;
import java.util.concurrent.TimeUnit;
import java.awt.Point; // Import Point for easier coordinate manipulation

public class game {
    private JPanel main;
    private JLabel juan;
    private JLabel goku;

    // Store the initial mouse press location relative to the JLabel
    private Point initialClick;

    public game() {
        main.setPreferredSize(new java.awt.Dimension(700, 580));
        main.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                super.mouseDragged(e);
                // These coordinates are relative to the 'main' panel
                System.out.println("main x: " + e.getX() + " y: " + e.getY());
            }
        });
        main.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                // These coordinates are relative to the 'main' panel
                System.out.println("main x: " + e.getX() + " y: " + e.getY());
            }
        });
        main.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                super.focusGained(e);
                System.out.println("focus gained");
            }
        });

        juan.setIcon(new ImageIcon("src/cawa3.png"));
        // Setting preferredSize for JLabel with an image icon might not be effective for its actual size
        // The size will be determined by the image.
        // If you need to scale the image, you'll need to do it on the ImageIcon itself.
        // juan.preferredSize().setSize(10, 10); // This line is likely not doing what you expect

        juan.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) { // Use mousePressed to record initial click
                super.mousePressed(e);
                // Get the point where the mouse was pressed relative to the JLabel
                initialClick = e.getPoint();
                System.out.println("juan pressed at: " + initialClick.x + ", " + initialClick.y);
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                System.out.println("juan x: " + e.getX() + " y: " + e.getY());
                System.out.println("juan clicked");
            }
        });

        juan.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                super.mouseDragged(e);

                // Get the current mouse position relative to the 'main' panel
                // This is the key change: convert the event's source coordinates
                // (which are relative to 'juan') to coordinates relative to 'main'.
                // Or, even better, get the mouse position on the screen and subtract
                // the 'main' panel's screen location to get coordinates relative to 'main'.
                // However, a simpler approach for dragging is to calculate the new location
                // based on the initial click and the current mouse position relative to the parent.

                // Get the current mouse position relative to the 'main' panel
                // The 'e.getLocationOnScreen()' gives the mouse position on the entire screen.
                // 'juan.getParent().getLocationOnScreen()' gives the 'main' panel's position on the screen.
                // By subtracting these, we get the mouse position relative to the 'main' panel.
                int newX = e.getXOnScreen() - juan.getParent().getLocationOnScreen().x - initialClick.x;
                int newY = e.getYOnScreen() - juan.getParent().getLocationOnScreen().y - initialClick.y;


                // Set the new location of 'juan'
                juan.setLocation(newX, newY);

                // Check for win condition (adjust coordinates as needed for 'goku's position)
                // You'll need to define where 'goku' is and its bounds to make this accurate.
                // For example, if goku is at (573, Y) and has a certain width/height.
                // This is a rough example, you'll need to adjust 'goku's actual bounds.
                if (newX ==607 && newY == 285) { // Assuming 573-579 is the x-range for winning
                    JOptionPane.showMessageDialog(null, "Ganaste");
                }

                // The sleep can cause UI unresponsiveness. It's generally not recommended
                // in UI event dispatching threads. If you need a delay, consider a Swing Timer.
                // For a drag operation, it will make the dragging very choppy.
                // try {
                //     TimeUnit.MILLISECONDS.sleep(60);
                // } catch (InterruptedException ex) {
                //     Thread.currentThread().interrupt(); // Restore interrupt status
                //     throw new RuntimeException(ex);
                // }

                System.out.println("moviendo juan a: " + newX + ", " + newY);
            }
        });

        goku.setIcon(new ImageIcon("src/gaku3.png"));
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("game");
        frame.setContentPane(new game().main);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Set a reasonable initial size for the frame. pack() will adjust it based on preferred sizes.
        frame.setSize(700, 580); // Match preferred size of main panel for better initial display

        frame.pack();
        frame.setVisible(true);
    }
}