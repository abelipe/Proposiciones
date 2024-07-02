package Programa;

import java.util.ArrayList;
import javax.swing.text.BadLocationException;

public class Principal {
    public static void main(String[] args) throws BadLocationException {
        Ventana v1 = new Ventana();
        v1.setVisible(true);
        String p = "voy al cine";
        String q = "voy al parque";
        String r = "voy a la playa";
        String s = "Hoy esta soleado";
        String polinomio = "¬S⇔S";
        ArrayList<String> simples = new ArrayList<String>();
        ArrayList<String> simplesNegadas = new ArrayList<String>();
        ArrayList<String> compuestas = new ArrayList<String>();
        ArrayList<String> compuestasNegadas = new ArrayList<String>();
        ArrayList<String> nucleo = new ArrayList<String>();
        Funciones.conseguirProposiciones(polinomio, simples, simplesNegadas, compuestas, compuestasNegadas,nucleo);
                //System.out.println(Funciones.generarTexto(polinomio,p,q,r,s));
        
        
    }
    
}
