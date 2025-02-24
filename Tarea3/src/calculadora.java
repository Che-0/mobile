import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.script.*;



// lo que sea sera , lo que sera deberia ser

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


    //flags para saber si una operacion espera a ser resuelta
    boolean esperaSuma = false;
    boolean esperaResta = false;
    boolean esperaMultiplicacion = false;
    boolean esperaDivision = false;

    boolean seutilizoPunto = false;

    boolean esperaDecimal = false;

    boolean utilizarFlotantes = false;

    // valorF es la variable que guardara el valor de las operaciones que se realicen
    int valorF=0;

    float valorFF=0.f;

    //datoMemoria es la variable que guardara los datos que se ingresen en la calculadora
    String datoMemoria ="0";

    // primeraOperacion es un flag que se activa cuando se realiza la primera operacion y si saber si ya habia un valorF
    boolean primeraOperacion = true;


    /////// Comprobacion de resolucion de operaciones    ///////

    public void estadodeResolucion (String datoenlaMemoria){
        if (esperaMultiplicacion){

            if (utilizarFlotantes){
                valorFF = valorFF * parseofloat(datoenlaMemoria);
                System.out.println("El valor despues de multiplicar es "+valorFF);
                esperaMultiplicacion = false;
            }else{
                valorF = valorF * parseo(datoenlaMemoria);
                System.out.println("El valor despues de multiplicar es "+valorF);
                esperaMultiplicacion = false;
            }
        }

        if(esperaSuma){
            if (utilizarFlotantes){
                System.out.println("Suma pewro con flotantes");
                System.out.println("El valor de la memoria es "+datoenlaMemoria);
                System.out.println("El valor ff es "+valorFF);
                valorFF = valorFF + parseofloat(datoenlaMemoria);
                System.out.println("El valor despues de sumar es "+valorFF);
                esperaSuma = false;
            }else{

                valorF = valorF + parseo(datoenlaMemoria);
                System.out.println("El valor despues de sumar es "+valorF);
                esperaSuma = false;
            }
        }
        if(esperaResta){
            if (utilizarFlotantes){
                valorFF = valorFF - parseofloat(datoenlaMemoria);
                System.out.println("El valor despues de restar es "+valorFF);
                esperaResta = false;
            }else {
                valorF = valorF - parseo(datoenlaMemoria);
                System.out.println("El valor despues de restar es " + valorF);
                esperaResta = false;
            }
        }
        if(esperaDivision){

            if (parseo(datoenlaMemoria) == 0){
                JOptionPane.showMessageDialog(null,"No se puede dividir entre 0");
                esperaDivision = false;
                // TODO: reiniciar la calculadora
            }
            valorF = valorF / parseo(datoenlaMemoria);
            System.out.println("El valor despues de dividir es "+valorF);
            esperaDivision = false;
        }
        if(seutilizoPunto){
            valorFF = valorFF + parseofloat(datoenlaMemoria);
            System.out.println("El valor despues de sumar es "+valorFF);
            datoMemoria = "0";
            esperaDecimal = false;
        }

    }



    //////// FUNCIONES DE OPERACIONES ////////// activan las flags de espera de operacion

    public float parseofloat(String x){
        float valorFlotante = Float.parseFloat(x);
        return valorFlotante;
    }
    public int parseo(String x){
        int valorEntero = Integer.parseInt(x);
        return valorEntero;
    }
    public void divide(){
        esperaDivision = true;
    }
    public void multiplica(){
        esperaMultiplicacion = true;
    }

    public void suma(){
        esperaSuma = true;
    }
    public void resta(){
        esperaResta = true;
    }
    public void decimal(){
        esperaDecimal = true;
    }

    public calculadora() {

        boton0.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                datoMemoria = datoMemoria + "0";
                entradaDatos.setText(entradaDatos.getText()+"0");
            }

        });

        boton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                datoMemoria = datoMemoria + "1";
                entradaDatos.setText(entradaDatos.getText()+"1");
            }
        });
        boton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                datoMemoria = datoMemoria + "2";
                entradaDatos.setText(entradaDatos.getText()+"2");
            }
        });
        boton3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                datoMemoria = datoMemoria + "3";
                entradaDatos.setText(entradaDatos.getText()+"3");
            }
        });

        boton4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                datoMemoria = datoMemoria + "4";
                entradaDatos.setText(entradaDatos.getText()+"4");
            }
        });

        boton5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                datoMemoria = datoMemoria + "5";
                entradaDatos.setText(entradaDatos.getText()+"5");
            }
        });
        boton6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                datoMemoria = datoMemoria + "6";
                entradaDatos.setText(entradaDatos.getText()+"6");
            }
        });
        boton7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                datoMemoria = datoMemoria + "7";
                entradaDatos.setText(entradaDatos.getText()+"7");
            }
        });

        boton8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                datoMemoria = datoMemoria + "8";
                entradaDatos.setText(entradaDatos.getText()+"8");
            }
        });

        boton9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                datoMemoria = datoMemoria + "9";
                entradaDatos.setText(entradaDatos.getText()+"9");
            }
        });
        botonBorrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!datoMemoria.isEmpty()){
                    datoMemoria =datoMemoria.substring(0, datoMemoria.length() - 1);
                }

                String datos = entradaDatos.getText();
                if (!datos.isEmpty()){
                    entradaDatos.setText(  datos.substring(0, datos.length() - 1));
                }
            }
        });


        /// ************ OPERACIONES ************
        botonMultiplica.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                //si es la primera operacion se guarda el valor de la memoria en valorF
                if(primeraOperacion){
                    valorF = parseo(datoMemoria);
                    primeraOperacion = false;
                }

                //tomamos los datos en la memoria y lo pasamos como argumento a la funcion
                estadodeResolucion(datoMemoria);

                if(!utilizarFlotantes){
                    //parseo convierte el string a un entero
                    multiplica();
                    System.out.println("El valor de la memoria es "+datoMemoria);
                }

                //parseo convierte el string a un entero
                multiplica();
                System.out.println("El valor de la memoria es "+datoMemoria);

                //despues de hacer la operacion se limpia la memoria
                datoMemoria = "0";

                //se agrega el simbolo de multiplicacion al label
                entradaDatos.setText(entradaDatos.getText()+"*");
            }
        });

        botonDivision.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(primeraOperacion){
                    if (datoMemoria.isEmpty()){
                        datoMemoria = "0";
                    }
                    valorF = Integer.parseInt(datoMemoria);
                    primeraOperacion = false;
                }
                estadodeResolucion(datoMemoria);
                divide();
                System.out.println("El valor de la memoria es "+datoMemoria);
                datoMemoria = "0";
                entradaDatos.setText(entradaDatos.getText()+"/");
            }
        });

        botonResta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(primeraOperacion){
                    //Es para cuado se inicia con un numero negativo
                    if (datoMemoria.isEmpty()){
                        datoMemoria = "0";
                    }
                    valorF = Integer.parseInt(datoMemoria);
                    primeraOperacion = false;
                }
                estadodeResolucion(datoMemoria);
                resta();
                System.out.println("El valor de la memoria es "+datoMemoria);
                datoMemoria = "0";
                entradaDatos.setText(entradaDatos.getText()+"-");
            }
        });
        botonSuma.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(primeraOperacion){
                    valorF = Integer.parseInt(datoMemoria);
                    primeraOperacion = false;
                }
                estadodeResolucion(datoMemoria);
                suma();
                System.out.println("El valor de la memoria es "+datoMemoria);
                datoMemoria = "0";
                entradaDatos.setText(entradaDatos.getText()+"+");

            }
        });
        botonDecimal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(primeraOperacion){
                    //Es para cuado se inicia con un numero negativo
                    if (datoMemoria.isEmpty()){
                        datoMemoria = "0";
                    }
                    primeraOperacion = false;
                }
                utilizarFlotantes = true;
                // se necesita arreglar para que solo lo haga una vez
                //valorFF = parseofloat(datoMemoria);
                estadodeResolucion(datoMemoria);
                decimal();
                System.out.println("se uso punto memo"+datoMemoria);
                System.out.println("El valor ff "+valorFF);
                //datoMemoria = "0";
                entradaDatos.setText(entradaDatos.getText()+".");
            }
        });

        igualA.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                estadodeResolucion(datoMemoria);
                entradaDatos.setText(entradaDatos.getText()+"="+valorF);
                System.out.println("El valor final es "+valorFF);
            }
        });
        UWUButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,"UWU");
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




