import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;
import java.util.List;

public class Segmento {
    Point inicio;
    Point fin;
    Color color;
    public Segmento(Point inicio, Point fin, Color color) {
        this.inicio = inicio;
        this.fin = fin;
        this.color = color;
    }
}
