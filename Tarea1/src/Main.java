import java.awt. *;
import java.util.jar.JarOutputStream;
import javax.swing.JOptionPane;


public class Main {
    public static void main(String[] args) {

        JOptionPane.showMessageDialog(null,"Dame tu nombre: ");
        String nombre = JOptionPane.showInputDialog("tu nombre");
        JOptionPane.showMessageDialog(null,"Tu nombre es --> " + nombre);
        System.out.println(nombre);


        System.out.println("Hello world!");
    }
}