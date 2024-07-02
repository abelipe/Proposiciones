package Programa;

import java.awt.Container;
import java.awt.Font;
import javax.swing.*;

/**
 *
 * @author guille
 */
public class Ventana2 extends JFrame{
    public Ventana2(){
        super("Tabla de verdad");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(true);
        this.setSize(400,340);
        Container c = getContentPane();
        JTextArea texto = new JTextArea();
        texto.setEditable(false);
        texto.setBounds(20, 20, 390, 330);
        texto.setFont(new Font("Monospaced", Font.PLAIN, 20));
        texto.setText("Polinomio \n\n" + Ventana.polinomio + "\n\n" +"Tabla de la verdad \n\n");
        texto.setText(texto.getText() + Ventana.tabla + "\n" + Ventana.tipo);
        c.add(texto);
    }
}
