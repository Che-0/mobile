import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Tarea1  extends JFrame implements ActionListener {
    JButton btnsaludar;
    JTextField texto;
    public Tarea1(){
        texto = new JTextField();
        setSize(400,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        btnsaludar = new JButton("Saludar");
        setTitle("Programa_1");
        btnsaludar.addActionListener(this);
        add(btnsaludar, BorderLayout.SOUTH);
        add(texto);
    }

    public static void main(String[] args) {
        Tarea1 p  = new Tarea1();
        p.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JOptionPane.showMessageDialog(null,"Hola --->" + texto.getText());

    }
}
