import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class fotos {
    private JPanel panelMain;
    private JPanel fotos;
    private JButton atras;
    private JButton adelante;
    private JLabel imagen;
    private JPanel botones;

    int contador = 0;
    public fotos() {

        // tamaño de las imagen 950 * 560
        //tenemos que considerar que el tamaño de la imagen se ajuste al tamaño del contenedor
        String[] imagenes = {"Tarea2/src/img_0.png", "Tarea2/src/img_3.png", "Tarea2/src/img_4.png"};


        //imagen.setIcon(new ImageIcon("src/img_0.png"));

        imagen.setIcon(new ImageIcon(imagenes[contador]));





        adelante.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                //incrementamos solo si no superamos la longiitud del array
                if (contador != imagenes.length - 1) {
                    contador++;
                }

                imagen.setIcon(new ImageIcon(imagenes[contador]));
                System.out.println(imagenes.length);

                //JOptionPane.showMessageDialog(null, "Hola");
            }
        });
        atras.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (contador != 0) {
                    contador--;
                }

                imagen.setIcon(new ImageIcon(imagenes[contador]));
                System.out.println(imagenes.length);
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("fotos");
        frame.setContentPane(new fotos().panelMain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //frame.setLocationRelativeTo(null);
        frame.setTitle("Fotos");
        frame.setSize(600, 600);
        //frame.setResizable(false);

        frame.pack();
        frame.setVisible(true);
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
