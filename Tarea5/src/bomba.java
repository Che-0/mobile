import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class bomba {
    private JPanel mainventana;
    private JPanel contador;
    private JPanel botones;
    private JLabel seg1;
    private JLabel seg2;
    private JButton iniciar;
    private JButton reset;

    private Timer timer;
    private int horas = 0;
    private int minutos = 0;
    private int segundos = 0;
    private boolean corriendo = false;

    private void actualizarLabel() {
        seg1.setText(String.format("%02d:%02d:%02d", horas, minutos, segundos));
    }

    public bomba() {
        iniciar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                corriendo = true;
                if (timer != null && timer.isRunning()) {
                    timer.stop();
                }
                horas = 0;
                minutos = 0;
                segundos = 0;
                actualizarLabel();

                // Timer para actualizar el contador cada segundo (1000 ms)
                // si queremos aumentar el tiempo de actualización, cambiar el valor de 1000 a ps algo mas corto
                timer = new Timer(100, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (corriendo) {
                            segundos++;
                            if (segundos == 60) {
                                segundos = 0;
                                minutos++;
                                if (minutos == 60) {
                                    minutos = 0;
                                    horas++;
                                }
                            }
                            actualizarLabel();
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
                horas = 0;
                minutos = 0;
                segundos = 0;
                actualizarLabel();
                if (timer != null && timer.isRunning()) {
                    timer.stop();
                }
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