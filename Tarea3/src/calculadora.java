import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.script.*;

public class calculadora {
    private JPanel panel1;
    private JButton botonResta;
    private JButton botonDivision;
    private JButton botonMultiplica;
    private JButton UWUButton;
    private JButton boton5;
    private JButton boton2;
    private JButton botonBorrar;
    private JButton boton6;
    private JButton boton3;
    private JButton botonSuma;
    private JButton boton4;
    private JButton boton1;
    private JButton boton7;
    private JButton boton8;
    private JButton boton9;
    private JButton boton0;
    private JButton igualA;
    private JButton botonDecimal;
    private JLabel entradaDatos;



    public calculadora() {


        boton0.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                entradaDatos.setText(entradaDatos.getText()+"0");
            }

        });

        boton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                entradaDatos.setText(entradaDatos.getText()+"1");
            }
        });
        boton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                entradaDatos.setText(entradaDatos.getText()+"2");
            }
        });
        boton3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                entradaDatos.setText(entradaDatos.getText()+"3");
            }
        });

        boton4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                entradaDatos.setText(entradaDatos.getText()+"4");
            }
        });

        boton5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                entradaDatos.setText(entradaDatos.getText()+"5");
            }
        });
        boton6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                entradaDatos.setText(entradaDatos.getText()+"6");
            }
        });
        boton7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                entradaDatos.setText(entradaDatos.getText()+"7");
            }
        });

        boton8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                entradaDatos.setText(entradaDatos.getText()+"8");
            }
        });

        boton9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                entradaDatos.setText(entradaDatos.getText()+"9");
            }
        });
        botonBorrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String datos = entradaDatos.getText();
                entradaDatos.setText(  datos.substring(0, datos.length() - 1));
            }
        });
        botonMultiplica.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                entradaDatos.setText(entradaDatos.getText()+"*");
            }
        });

        botonDivision.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                entradaDatos.setText(entradaDatos.getText()+"/");
            }
        });

        botonResta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                entradaDatos.setText(entradaDatos.getText()+"-");
            }
        });
        botonSuma.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                entradaDatos.setText(entradaDatos.getText()+"+");
            }
        });
        botonDecimal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                entradaDatos.setText(entradaDatos.getText()+".");
            }
        });

        igualA.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String data = entradaDatos.getText();
                for (int i = 0; i < data.length(); i++) {
                    char caracter = data.charAt(i);
                    System.out.println(caracter);
                }

            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("calculadora");
        frame.setContentPane(new calculadora().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        frame.pack();

        frame.setSize(500,400);
        frame.setVisible(true);


    }
}
