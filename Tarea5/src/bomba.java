import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class bomba {
    private JPanel mainventana;
    private JPanel contador;
    private JPanel botones;
    private JLabel seg1;
    private JLabel seg2;
    private JButton iniciar;
    private JButton reset;

    private Timer timer;
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
    private boolean corriendo = false;

    public bomba() {
        iniciar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                corriendo = true;
                if (timer != null && timer.isRunning()) {
                    timer.stop();
                }

                timer = new Timer(1000, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (corriendo) {
                            LocalTime ahora = LocalTime.now();
                            seg1.setText(ahora.format(formatter));
                        }
                    }
                });
                timer.start();
            }
        });

        reset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                corriendo = false;
                seg1.setText("00:00:00");
                if (timer != null && timer.isRunning()) {
                    timer.stop();
                }
            }
        });
        reset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                corriendo = false;
                seg1.setText("00:00:00");
                if (timer != null && timer.isRunning()) {
                    timer.stop();}
            }
        });
    }

    public void dimencion() {
        mainventana.setPreferredSize(new Dimension(950, 560));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("bomba");
            frame.setContentPane(new bomba().mainventana);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(300, 300);
            frame.pack();
            frame.setVisible(true);
        });
    }
}