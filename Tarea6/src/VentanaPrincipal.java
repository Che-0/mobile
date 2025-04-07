import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class VentanaPrincipal extends JFrame {
    private Lienzo lienzo;
    private Color colorSeleccionado = Color.BLACK;
    private JButton botonColorRojo;
    private JButton botonColorAzul;
    private JButton botonColorVerde;
    private JButton botonGoma;
    private JButton botonLimpiar;

    public VentanaPrincipal() {
        setTitle("Mi Pequeño Paint");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null); // Centrar la ventana

        // Inicializar el lienzo
        lienzo = new Lienzo();
        add(lienzo, BorderLayout.CENTER);

        // Crear panel para los controles
        JPanel panelControles = new JPanel();
        panelControles.setLayout(new FlowLayout(FlowLayout.LEFT));

        // Crear botones de color
        botonColorRojo = crearBotonColor(Color.RED, "Rojo");
        botonColorAzul = crearBotonColor(Color.BLUE, "Azul");
        botonColorVerde = crearBotonColor(Color.GREEN, "Verde");

        // Crear botón de goma
        botonGoma = new JButton("Goma");
        botonGoma.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                colorSeleccionado = lienzo.getBackground(); // Establecer el color de fondo como color de "dibujo"
                lienzo.setColorDibujo(colorSeleccionado);
            }
        });

        // Crear botón para limpiar el lienzo
        botonLimpiar = new JButton("Limpiar");
        botonLimpiar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lienzo.limpiar();
            }
        });

        // Añadir botones al panel
        panelControles.add(botonColorRojo);
        panelControles.add(botonColorAzul);
        panelControles.add(botonColorVerde);
        panelControles.add(botonGoma);
        panelControles.add(botonLimpiar);

        // Añadir panel de controles al norte de la ventana
        add(panelControles, BorderLayout.NORTH);

        setVisible(true);
    }

    private JButton crearBotonColor(Color color, String texto) {
        JButton boton = new JButton(texto);
        boton.setBackground(color);
        boton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                colorSeleccionado = color;
                lienzo.setColorDibujo(colorSeleccionado);
            }
        });
        return boton;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(VentanaPrincipal::new);
    }
}