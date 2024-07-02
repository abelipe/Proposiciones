package Programa;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.text.BadLocationException;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

public class Ventana extends JFrame{
    JPanel panel;
    JTextField textoProposicionP,textoProposicionQ,textoProposicionR,textoProposicionS,textoOperacion;
    JButton tablaVerdad,guardar1,guardar2,guardar3,guardar4,botonOperar,botonParentesisL,botonParentesisD,botonConjuncion,botonDisyuncion,botonNegacion,botonCondicional,botonBicondicional,botonNegado,botonAleatorio,botonLimpiar,botonEjecutar,botonLenguajeLogico;
    JTextArea areaTexto;
    JRadioButton radioBotonP,radioBotonQ,radioBotonR,radioBotonS;
    String p,q,r,s,texto;
    ArrayList<String> lista;
    
    public static String polinomio,tabla,tipo;
    int cont = 0;
    public Ventana() throws BadLocationException{
        this.setSize(800,680);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Proposiciones Logicas");
        setLocationRelativeTo(null);
        setMinimumSize(new Dimension(800,680));
        iniciarComponentes();
    }
    
    private void iniciarComponentes() throws BadLocationException{
        iniciarPanel();
        iniciarEtiquetas();
        iniciarCajasDeTexto();
        iniciarBotones();
        iniciarAreaDeTexto();
    }
    
    private void iniciarEtiquetas() throws BadLocationException{
        //etiqueta 1
        // Creamos un JTextPane
        JTextPane etiqueta1 = new JTextPane();
        // Obtenemos el StyledDocument del JTextPane
        StyledDocument doc = etiqueta1.getStyledDocument();
        // Creamos un objeto SimpleAttributeSet para el estilo del texto
        SimpleAttributeSet style = new SimpleAttributeSet();
        // Establecemos el color negro para el texto
        StyleConstants.setForeground(style, Color.black);
        // Establecemos la fuente Arial, negrita y tamaño 20 para el texto
        StyleConstants.setFontFamily(style, "Arial");
        StyleConstants.setBold(style, true);
        StyleConstants.setFontSize(style, 20);       

        //Etiqueta5
        
        JLabel etiqueta5 = new JLabel("estefano");
        etiqueta5.setText("Operacion:");
        etiqueta5.setForeground(Color.black);
        etiqueta5.setOpaque(true); // permiso para que se pueda pintar el fondo de la etiqueta
        etiqueta5.setBackground(Color.white); // color del fondo de la etiqueta
        etiqueta5.setBounds(25, 190, 150, 30);
        etiqueta5.setFont(new Font("arial", 3 , 20));
        panel.add(etiqueta5);
        
        //EtiquetaResultado
        
        JLabel etiquetaResultado = new JLabel();
        etiquetaResultado.setText("Resultado:");
        etiquetaResultado.setForeground(Color.black);
        etiquetaResultado.setOpaque(true); // permiso para que se pueda pintar el fondo de la etiqueta
        etiquetaResultado.setBackground(Color.white); // color del fondo de la etiqueta
        etiquetaResultado.setBounds(320, 190, 415, 30);
        etiquetaResultado.setFont(new Font("arial", 3 , 20));
        etiquetaResultado.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(etiquetaResultado);
        

    }
    
    private void iniciarPanel(){
        panel = new JPanel();
        panel.setBackground(Color.white);
        panel.setLayout(null);
        this.getContentPane().add(panel);
    }
    
    private void iniciarCajasDeTexto(){
        //textoOperacion
        textoOperacion = new JTextField();
        textoOperacion.setBounds(25, 230, 230, 30);
        textoOperacion.setFont(new Font("Arial Unicode MS", Font.PLAIN, 15));
        textoOperacion.setText("");
        panel.add(textoOperacion);
    }
    
    private void iniciarBotones(){
        
        //botonTabladeVerdad
        tablaVerdad = new JButton();
        tablaVerdad.setText("Tabla de Verdad");
        tablaVerdad.setBounds(25, 420, 230, 20);
        funcionTabladeVerdad();
        panel.add(tablaVerdad);

        //botonLimpiar
        botonLimpiar = new JButton();
        botonLimpiar.setBounds(145,360,110,20);
        botonLimpiar.setText("Limpiar");
        funcionBotonLimpiar();
        panel.add(botonLimpiar);
        
        //botonAleatorio
        botonAleatorio = new JButton();
        botonAleatorio.setBounds(25,360,115,20);
        botonAleatorio.setText("Aleatorio");
        funcionBotonAleatorio();
        panel.add(botonAleatorio);
        
        
        //botonBicondicional 
        botonBicondicional = new JButton();
        botonBicondicional.setBounds(145, 330, 110, 20);
        botonBicondicional.setFont(new Font("Arial Unicode MS", Font.PLAIN, 20));
        botonBicondicional.setText("⇔");
        funcionBotonBicondicional();
        panel.add(botonBicondicional);
        
        //botonCondicional
        botonCondicional = new JButton();
        botonCondicional.setBounds(25, 330, 115, 20);
        botonCondicional.setFont(new Font("Arial Unicode MS", Font.PLAIN, 20));
        botonCondicional.setText("⇒");
        funcionBotonCondicional();
        panel.add(botonCondicional);
        
        // botonNegado
        botonNegado = new JButton();
        botonNegado.setBounds(200, 270, 55, 20);
        botonNegado.setFont(new Font("Arial Unicode MS", Font.PLAIN, 20));
        botonNegado.setText("¬");
        funcionBotonNegado();
        panel.add(botonNegado);
        
        // botonDisyuncion
        botonDisyuncion = new JButton();
        botonDisyuncion.setBounds(145, 300, 110, 20);
        botonDisyuncion.setFont(new Font("Arial Unicode MS", Font.PLAIN, 20));
        botonDisyuncion.setText("∨");
        funcionBotonDisyuncion();
        panel.add(botonDisyuncion);
        
        // botonConjuncion
        botonConjuncion = new JButton();
        botonConjuncion.setBounds(25, 300, 115, 20);
        botonConjuncion.setFont(new Font("Arial Unicode MS", Font.PLAIN, 20));
        botonConjuncion.setText("∧");
        funcionBotonConjuncion();
        panel.add(botonConjuncion);
        
        // botonParentesisD
        botonParentesisD = new JButton();
        botonParentesisD.setBounds(155, 270, 40, 20);
        botonParentesisD.setText(")");
        funcionBotonParentesisR();
        panel.add(botonParentesisD);
        
        // botonParentesisL
        botonParentesisL = new JButton();
        botonParentesisL.setBounds(110, 270, 40, 20);
        botonParentesisL.setText("(");
        funcionBotonParentesisL();
        panel.add(botonParentesisL);

        
    }
    
    private void iniciarAreaDeTexto(){
        areaTexto = new JTextArea();
        ///areaTexto.setBounds(25, 200, 300, 200);
        areaTexto.setBackground(Color.WHITE);
        areaTexto.setLineWrap(true);
        areaTexto.setWrapStyleWord(true);
        areaTexto.setEditable(true);
        areaTexto.setFont(new Font("Arial Unicode MS", Font.PLAIN, 20));
        //panel.add(areaTexto);
        JScrollPane scroll = new JScrollPane(areaTexto,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scroll.setBounds(320, 230, 415, 290);
        panel.add(scroll);
        //areaTexto.setText("Estefano monti");
        //areaTexto.setText(areaTexto.getText() + "\npero es el mayor mariquito que jamas conoci y le sabe mucho pero a la vez no");
    }
    

    
    private void funcionBotonLimpiar(){
        ActionListener oyenDeAccion = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textoProposicionP.setEditable(true);
                textoProposicionP.setText("");
                textoProposicionQ.setEditable(true);
                textoProposicionQ.setText("");
                textoProposicionR.setEditable(true);
                textoProposicionR.setText("");
                textoProposicionS.setEditable(true);
                textoProposicionS.setText("");
                botonOperar.setEnabled(false);
                textoOperacion.setText("");
                guardar1.setEnabled(true);
                guardar2.setEnabled(true);
                guardar3.setEnabled(true);
                guardar4.setEnabled(true);
                botonEjecutar.setEnabled(false);
                areaTexto.setText("");
                cont = 0;
                
            }
        };
        botonLimpiar.addActionListener(oyenDeAccion);
    }
    
    
    private void funcionTabladeVerdad(){
        tablaVerdad.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                polinomio = textoOperacion.getText();
                if(Funciones.estaBienEscrito(polinomio)){
                    ArrayList<String> simples = new ArrayList<String>();
                    ArrayList<String> simplesNegadas = new ArrayList<String>();
                    ArrayList<String> compuestas = new ArrayList<String>();
                    ArrayList<String> compuestasNegadas = new ArrayList<String>();
                    ArrayList<String> nucleo = new ArrayList<String>();
                    Funciones.conseguirProposiciones(polinomio, simples, simplesNegadas, compuestas, compuestasNegadas,nucleo);
                    Set<Integer> conjunto = new HashSet<Integer>();
                    tabla = Funciones.imprimirTablaVerdad(polinomio, simples, simplesNegadas, compuestas, compuestasNegadas, nucleo, conjunto);
                    if(conjunto.size() == 1){
                        for(int valor: conjunto){
                            if(valor == 1){
                                
                                tipo = "Tautología";
                            }
                            else{
                                tipo = "Contradicción";
                            }
                        }
                    }
                    
                    else{
                        tipo = "Contingencia";
                    }
                    areaTexto.append("Polinomio \n\n" + Ventana.polinomio + "\n\n" +"Tabla de la verdad \n\n");
                    areaTexto.append(Ventana.tabla + "\n" + Ventana.tipo);
                    
                    
                }
                else{
                    areaTexto.setFont(new Font("Arial Unicode MS", Font.PLAIN, 20));
                    areaTexto.setForeground(Color.red);
                    areaTexto.setText("                      Error de sintaxis");
                }
            }
        });
    }
    
    
    
    
    private void funcionBotonParentesisL(){
        ActionListener oyenteDeAccion = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                int pos = textoOperacion.getCaretPosition();
                String text = textoOperacion.getText();
                String newText = text.substring(0, pos) + "(" + text.substring(pos);
                textoOperacion.setText(newText);
                textoOperacion.setCaretPosition(pos + 1);
            }
            
        };
        botonParentesisL.addActionListener(oyenteDeAccion);
    }
    
    private void funcionBotonParentesisR(){
        ActionListener oyenteDeAccion = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                int pos = textoOperacion.getCaretPosition();
                String text = textoOperacion.getText();
                String newText = text.substring(0, pos) + ")" + text.substring(pos);
                textoOperacion.setText(newText);
                textoOperacion.setCaretPosition(pos + 1);
            }
            
        };
        botonParentesisD.addActionListener(oyenteDeAccion);
    }
    
    private void funcionBotonNegado(){
        ActionListener oyenteDeAccion = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                int pos = textoOperacion.getCaretPosition();
                String text = textoOperacion.getText();
                String newText = text.substring(0, pos) + "¬" + text.substring(pos);
                textoOperacion.setText(newText);
                textoOperacion.setCaretPosition(pos + 1);
            }
            
        };
        botonNegado.addActionListener(oyenteDeAccion);
    }
    
    private void funcionBotonConjuncion(){
        ActionListener oyenteDeAccion = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                int pos = textoOperacion.getCaretPosition();
                String text = textoOperacion.getText();
                String newText = text.substring(0, pos) + "∧" + text.substring(pos);
                textoOperacion.setText(newText);
                textoOperacion.setCaretPosition(pos + 1);
            }
            
        };
        botonConjuncion.addActionListener(oyenteDeAccion);
    }
    
    private void funcionBotonDisyuncion(){
        ActionListener oyenteDeAccion = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                int pos = textoOperacion.getCaretPosition();
                String text = textoOperacion.getText();
                String newText = text.substring(0, pos) + "∨" + text.substring(pos);
                textoOperacion.setText(newText);
                textoOperacion.setCaretPosition(pos + 1);

            }
            
        };
        botonDisyuncion.addActionListener(oyenteDeAccion);
    }
    
    private void funcionBotonCondicional(){
        ActionListener oyenteDeAccion = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                int pos = textoOperacion.getCaretPosition();
                String text = textoOperacion.getText();
                String newText = text.substring(0, pos) + "⇒" + text.substring(pos);
                textoOperacion.setText(newText);
                textoOperacion.setCaretPosition(pos + 1);

            }
            
        };
        botonCondicional.addActionListener(oyenteDeAccion);
    }
    
    private void funcionBotonBicondicional(){
        ActionListener oyenteDeAccion = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                int pos = textoOperacion.getCaretPosition();
                String text = textoOperacion.getText();
                String newText = text.substring(0, pos) + "⇔" + text.substring(pos);
                textoOperacion.setText(newText);
                textoOperacion.setCaretPosition(pos + 1);
            }
            
        };
        botonBicondicional.addActionListener(oyenteDeAccion);
    }
    
    private void funcionBotonAleatorio(){
        ActionListener oyenteDeAccion = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                String aleatorio = Funciones.generarAleatorio();
                textoOperacion.setText(aleatorio);
            }
            
        };
        botonAleatorio.addActionListener(oyenteDeAccion);
    }
}
    