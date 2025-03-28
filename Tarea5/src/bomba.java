import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class bomba {
    private JPanel mainventana;
    private JPanel contador;
    private JPanel botones;
    private JLabel seg1;
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
                // 10 en putiza
                // 100 mas o menos
                timer = new Timer(10, new ActionListener() {
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
        //mainventana.setPreferredSize(new Dimension(3000, 300));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("bomba");
            frame.setContentPane(new bomba().mainventana);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            frame.pack();
            frame.setSize(600, 120);
            frame.setVisible(true);
        });
    }
}

/*

                ..
                ..           ..--::..
                ..         .-:.     .::
                ..         -.         ::                        .---=:
                ..        .:           -.                    .:-.     :.
                ..        -.           :-                  ..-.       .+.
                          -:           .=.                .--         .=.
                          ..           .=:               .--          :+.
                          -:            -:               -=           :=
                          .:            =-              .-.           ::
                           :            --             .=:            -.
                           :.           .:             ::            --.
                           .:           :-            .-.           .+.
                           .-.          --            -:            =.        ..
                            ..         .+:           .=.          .*:         ..
                             -:         .:.....  ....:-:         .+.          ..
                              .. .:                           .==-            ..
                              :=-.                              .==
                           :+:                                     --
                          :+          ...                           .+:
                         .+.          :*-                :=-.        -=.
                        .=:          .*%%%=.          :++#=           -.
                        .-           :*#%#=.          -#%#*.          :=
                        .:                             .:.            :+.
                        .:                                            -:
                        .:                    :###*.                  =.
                        .::                .:   .-.  .:             .=-
                         .=-               .::.:-::::-.             =+.
                           :+.                .                     =.
                             .+=..                               .==
                                .==..                        .:==
                                .=:::-=:.               .:===--
                                .=..-:...-===++=+=++--:...   :-
                                .=:::-:::.:                  --
                                :=.:.                        --
                                --..                  .--=+*=*:
                                  .-==++**+****+*++=-:...
 */