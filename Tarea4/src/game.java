import javax.swing.*;
import java.awt.event.*;
import java.util.concurrent.TimeUnit;

public class game {
    private JPanel main;
    private JLabel juan;
    private JLabel goku;


    public game() {
        main.setPreferredSize(new java.awt.Dimension(700, 580));
        main.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                super.mouseDragged(e);
                System.out.println("x: " + e.getX() + " y: " + e.getY());
            }
        });
        main.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                System.out.println("x: " + e.getX() + " y: " + e.getY());
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
        juan.preferredSize().setSize(10, 10);
        juan.addMouseListener(new MouseAdapter() {
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
                System.out.println("juan x: " + e.getX() + " y: " + e.getY());
                //int x = e.getX();
                //int y = e.getY();

                //juan.setLocation(x, y);
                try {
                    int x = e.getX();
                    int y = e.getY();
                    if (x ==573){
                        //VENTANA DE DIALAGO
                        JOptionPane.showMessageDialog(null, "Ganaste");
                    }
                    TimeUnit.MILLISECONDS.sleep(30);
                    juan.setLocation(x, y);
                } catch (InterruptedException ex) {
                    throw new RuntimeException(ex);
                }


                System.out.println("moviendo juan");
            }
        });

        goku.setIcon(new ImageIcon("src/gaku3.png"));
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("game");
        frame.setContentPane(new game().main);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);

        frame.pack();
        frame.setVisible(true);
    }
}
