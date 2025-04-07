import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;
import java.util.List;


class Lienzo extends JPanel {
    private Color colorDibujo = Color.BLACK;
    private List<Segmento> segmentos = new ArrayList<>();
    private Point puntoAnterior;

    public Lienzo() {
        setBackground(Color.WHITE); // Color de fondo del lienzo

        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                puntoAnterior = e.getPoint();
            }
        });

        addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                Point puntoActual = e.getPoint();
                if (puntoAnterior != null) {
                    segmentos.add(new Segmento(puntoAnterior, puntoActual, colorDibujo));
                    repaint(); // Redibuja el lienzo
                }
                puntoAnterior = puntoActual;
            }
        });
    }

    public void setColorDibujo(Color color) {
        this.colorDibujo = color;
    }

    public void limpiar() {
        segmentos.clear();
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setStroke(new BasicStroke(5)); // Grosor de la línea

        for (Segmento segmento : segmentos) {
            g2d.setColor(segmento.color);
            g2d.drawLine(segmento.inicio.x, segmento.inicio.y, segmento.fin.x, segmento.fin.y);
        }
    }
}
