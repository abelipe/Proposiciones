package Programa;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class Funciones {
    public static boolean estaBienEscrito(String cadena){
        cadena = cadena.replace(" ", "").replace("p", "P").replace("q", "Q").replace("r", "R").replace("s", "S");
        String anterior = "",siguiente = "";
        if(cadena.equals("")){
            return false;
        }
        if (cadena.equals("(")){
            return false;
        }
        for (int i = 0; i < cadena.length(); i++) {
            String caracter = String.valueOf(cadena.charAt(i));
            if(caracter.equals("(") || caracter.equals(")")|| caracter.equals("P") || caracter.equals("Q") || caracter.equals("R") || caracter.equals("S") || caracter.equals("⇒") || caracter.equals("⇔") || caracter.equals("¬") || caracter.equals("∨") || caracter.equals("∧") ){
            }
            else{
                return false;
            }
        }
        
        for (int i = 0; i < cadena.length(); i++) {
            if (i == 0){
                anterior = String.valueOf(cadena.charAt(i));
                if(anterior.equals(")") || anterior.equals("⇔") || anterior.equals("⇒") || anterior.equals("∨") || anterior.equals("∧")){
                    return false;
                }
            }
            else{
                siguiente = String.valueOf(cadena.charAt(i));
                if(anterior.equals("¬")){
                    if(siguiente.equals("¬")){
                        return false;
                    }
                }
                if (anterior.equals("P") || anterior.equals("Q") || anterior.equals("S") || anterior.equals("R")){
                    if (siguiente.equals("P") || siguiente.equals("Q") || siguiente.equals("R") || siguiente.equals("S") || siguiente.equals("(") || siguiente.equals("¬")){
                        return false;
                    }
                }
                if (anterior.equals("⇔") || anterior.equals("⇒") || anterior.equals("∨") || anterior.equals("∧") || anterior.equals("¬")){
                    if (siguiente.equals("⇔") || siguiente.equals("⇒") || siguiente.equals("∨") || siguiente.equals("∧") || siguiente.equals(")")){
                        return false;
                    }
                }
                if(anterior.equals("(")){
                    if (siguiente.equals("⇔") || siguiente.equals("⇒") || siguiente.equals("∨") || siguiente.equals("∧") || siguiente.equals(")")){
                        return false;
                    }
                    
                }
                if (anterior.equals(")")){
                    if(siguiente.equals("(") || siguiente.equals("P") || siguiente.equals("Q") || siguiente.equals("R") || siguiente.equals("S") || siguiente.equals("¬")){
                        return false;
                    }
                }
                if(i == cadena.length() -1 && (siguiente.equals("(") || siguiente.equals("⇔") || siguiente.equals("⇒") || siguiente.equals("∨") || siguiente.equals("∧") || siguiente.equals("¬"))){
                    return false;
                }
                anterior = new String(siguiente);
            }
            
        }
        return true;
    }
    
    public static String generarAleatorio(){
        String vector[] = {"P","Q","R","S","⇒","⇔","∨","∧","¬"};
        int numero[] = {3,4,5,6,7};
        Random random = new Random();
        Random aleatorio = new Random(System.currentTimeMillis());
        int tamaño = numero[random.nextInt(numero.length)];
        String cadena = "";
        do{
            cadena = "";
            for (int i = 0; i < tamaño; i++) {
                int cosa =aleatorio.nextInt(vector.length);
                cadena += vector[cosa]; 
            }
        } while(!Funciones.estaBienEscrito(cadena));
        
        return cadena;
    }
    
    public static String generarTexto(String cadena , String p, String q , String r, String s){
        cadena = cadena = cadena.replace(" ", "").replace("p", "P").replace("q", "Q").replace("r", "R").replace("s", "S");
        String conjuncion[] = {"y","y además", "y tambien" , "pero tambien" , "y tambien sucede que"};
        String disyuncion[] = {"o","o bien"};
        String condicional[] = {" entonces",", eso implica que",", en consecuancia",", en consecuancia a lo anterior",", entonces sucede que", " eso conlleva que"};
        String bicondicional[] = {", eso ocurrira unicamente si",", eso ocurrira si y solo si"};
        String negado[] = {"es falso que","no es cierto que","no es verdad que"};
        Random random = new Random();
        String polinomio = "";
        String caracter;
        for (int i = 0; i < cadena.length(); i++) {
            caracter = String.valueOf(cadena.charAt(i));
            if(caracter.equals("(")){
                polinomio += ";";
            }
            else if(caracter.equals(")")){
                polinomio += ";";
            }
            else if(caracter.equals("P")){
                polinomio += " "+p;
            }
            else if(caracter.equals("Q")){
                polinomio += " "+q;
            }
            else if(caracter.equals("R")){
                polinomio += " "+r;
            }
            else if(caracter.equals("S")){
                polinomio += " "+s;
            }
            else if(caracter.equals("∧")){
                polinomio += " " +conjuncion[random.nextInt(conjuncion.length)];
            }
            else if(caracter.equals("∨")){
                polinomio += " " + disyuncion[random.nextInt(disyuncion.length)];
            }
            else if(caracter.equals("⇒")){
                polinomio += condicional[random.nextInt(condicional.length)];
            }
            else if(caracter.equals("⇔")){
                polinomio += bicondicional[random.nextInt(bicondicional.length)];
            }
            else if(caracter.equals("¬")){
                polinomio += " " + negado[random.nextInt(negado.length)];
            }
        }
        String copia;
        do{
            copia = new String(polinomio);
            polinomio = polinomio.trim();
            String caracterI = String.valueOf(polinomio.charAt(0));
            //System.out.println(caracterI);
            String caracterF = String.valueOf(polinomio.charAt(polinomio.length()-1));
            //System.out.println(caracterF);
            if(caracterI.equals(";")){
                polinomio = polinomio.substring(1);
            }
            if(caracterF.equals(";")){
                polinomio = polinomio.substring(0, polinomio.length() -1);
            }
            polinomio = polinomio.replace(";,", ";").replace(",;", ";").replace(";;", ";");
            
        } while(!copia.equals(polinomio));
        return polinomio;
    }
    
    
    public static void conseguirProposiciones(String polinomio , ArrayList<String> simples , ArrayList<String> simplesNegadas , ArrayList<String> compuestas , ArrayList<String> compuestasNegadas ,ArrayList<String> nucleo){
        simples.clear();
        simplesNegadas.clear();        
        compuestas.clear(); 
        compuestasNegadas.clear(); 
        polinomio = polinomio.replace(" ", "").replace("p", "P").replace("q", "Q").replace("r", "R").replace("s", "S");
        String copiaPolinomio = new String(polinomio);
        String copiaPolinomio1 = new String(polinomio);
        if(polinomio.contains("P")){simples.add("P");}
        if(polinomio.contains("Q")){simples.add("Q");}
        if(polinomio.contains("R")){simples.add("R");}
        if(polinomio.contains("S")){simples.add("S");}
        
        if(polinomio.contains("(")){
            char caracterInicio = '(';
            char caracterFin = ')';
            int indiceInicio = polinomio.indexOf(caracterInicio);
            int indiceFin = polinomio.indexOf(caracterFin);
            if (indiceInicio != -1 && indiceFin != -1) {
                String subcadena1 = polinomio.substring(indiceInicio, indiceFin + 1);
                compuestas.add(subcadena1);
            }
            polinomio = polinomio.substring(indiceFin+1);
            indiceInicio = polinomio.indexOf(caracterInicio);
            indiceFin = polinomio.indexOf(caracterFin);
            if (indiceInicio != -1 && indiceFin != -1) {
                String subcadena2 = polinomio.substring(indiceInicio, indiceFin + 1);
                compuestas.add(subcadena2);
            }
        }
        
        while(copiaPolinomio.contains("¬")) {
            int indiceInicio = copiaPolinomio.indexOf('¬');
            int indiceDespues = indiceInicio + 1;
            String despues = copiaPolinomio.substring(indiceDespues, indiceDespues+1);
            copiaPolinomio = copiaPolinomio.substring(indiceInicio+1);
            if(!(despues.equals("("))){
                if(!simplesNegadas.contains("¬" + despues)){
                    simplesNegadas.add("¬" + despues);
                }
            }
            else{
                char caracterInicio = '(';
                char caracterFin = ')';
                int inicio = copiaPolinomio.indexOf(caracterInicio);
                int fin = copiaPolinomio.indexOf(caracterFin);
                String subcadena1 = copiaPolinomio.substring(inicio, fin + 1);
                if(!compuestasNegadas.contains("¬" + subcadena1)){
                    compuestasNegadas.add("¬" + subcadena1);
                }
            }
        }
        
        String separador = "";
        String operando1 = "";
        String operando2 = "";
        
        if(!(copiaPolinomio1.contains("("))){
            if(copiaPolinomio1.contains("∧")){
                separador = "∧";
            }
            if(copiaPolinomio1.contains("∨")){
                separador = "∨";
            }
            if(copiaPolinomio1.contains("⇒")){
                separador = "⇒";
            }
            if(copiaPolinomio1.contains("⇔")){
                separador = "⇔";
            }
            operando1 = copiaPolinomio1.substring(0,copiaPolinomio1.indexOf(separador));
            operando2 = copiaPolinomio1.substring(copiaPolinomio1.indexOf(separador) + 1);
        }
        else{
            if(copiaPolinomio1.substring(0, 2).equals("¬(") || copiaPolinomio1.substring(0, 1).equals("(")){
                operando1 = copiaPolinomio1.substring(0, copiaPolinomio1.indexOf(")") +1);
                operando2 = copiaPolinomio1.substring(copiaPolinomio1.indexOf(")") +2);                
            }
            else{
                if(copiaPolinomio1.substring(0, 1).equals("¬")){
                    operando1 = copiaPolinomio1.substring(0, 2);
                    operando2 = copiaPolinomio1.substring(3);
                }
                else{
                    operando1 = copiaPolinomio1.substring(0, 1);
                    operando2 = copiaPolinomio1.substring(2);
                }
            }
        }
        nucleo.add(operando1);
        nucleo.add(operando2);
    }

    public static String imprimirTablaVerdad(String polinomio , ArrayList<String> simples , ArrayList<String> simplesNegadas , ArrayList<String> compuestas , ArrayList<String> compuestasNegadas, ArrayList<String> nucleo, Set<Integer> conjunto){
        String tabla = "";
        conjunto.clear();
        polinomio = polinomio.replace(" ", "").replace("p", "P").replace("q", "Q").replace("r", "R").replace("s", "S");
        Map<String, Integer> miDiccionario = new HashMap<>();
        int elPolinomio = polinomio.length();

        for (int i = 0; i < simples.size(); i++) {
            tabla = tabla + String.format("%-3s", simples.get(i));
        }
        for (int i = 0; i < simplesNegadas.size(); i++) {
            tabla = tabla + String.format("%-5s", simplesNegadas.get(i));
        }
        for (int i = 0; i < compuestas.size(); i++) {
            tabla = tabla + String.format("%-9s", compuestas.get(i));
        }
        for (int i = 0; i < compuestasNegadas.size(); i++) {
            tabla = tabla + String.format("%-9s", compuestasNegadas.get(i));
        }
        tabla = tabla + String.format("%-5s \n", polinomio);
        if (simples.size() == 1){
            for (int i = 0; i < 2; i++) {
                String p = simples.get(0);
                miDiccionario.put(simples.get(0), i);
                tabla += String.format("%-3d", i);
                
                if (simplesNegadas.size() > 0){
                    int matriz[] = new int[simplesNegadas.size()];
                    for (int j = 0; j < matriz.length; j++) {
                        miDiccionario.put(simplesNegadas.get(j),valorNegado(simplesNegadas.get(j), miDiccionario));
                        tabla += String.format("%-5d", valorNegado(simplesNegadas.get(j), miDiccionario));
                        
                    } 
                }
                if(compuestas.size()>0){
                    int matriz[] = new int[compuestas.size()];
                    for (int j = 0; j < matriz.length; j++) {
                        int laCompuesta = compuestas.get(j).length();
                        miDiccionario.put(compuestas.get(j),valor(compuestas.get(j), miDiccionario));
                        //tabla += String.format("%-9d", valor(compuestas.get(j), miDiccionario)); 
                        tabla += center(valor(compuestas.get(j), miDiccionario)+"", laCompuesta);
                        tabla += espaciosFaltantes(9-laCompuesta);
                        }
                }
                if(compuestasNegadas.size()>0){
                    for (int j = 0; j < compuestasNegadas.size(); j++) {
                        int laCompuestaNegada = compuestasNegadas.get(j).length();
                        miDiccionario.put(compuestasNegadas.get(j),valorCompuestasNegadas(compuestasNegadas.get(j), miDiccionario));
                        //tabla += String.format("%-9d", valorCompuestasNegadas(compuestasNegadas.get(j), miDiccionario));  
                        tabla += center(valorCompuestasNegadas(compuestasNegadas.get(j), miDiccionario)+"", laCompuestaNegada);
                        tabla += espaciosFaltantes(9-laCompuestaNegada);
                    }
                }
                
                
                String operando1 = nucleo.get(0);
                String operando2 = nucleo.get(1);
                System.out.println(operando2);
                String separador = polinomio.replace(operando1,"").replace(operando2,"").replace("¬", "");
                int valor1 = miDiccionario.get(operando1);
                int valor2 = miDiccionario.get(operando2);
                int valorFinal = 0;
                if(separador.equals("∧")){
                    if(valor1== 1 && valor2 == 1){valorFinal=1;}
                    if(valor1 == 1 && valor2 == 0){valorFinal = 0;}
                    if(valor1 == 0 && valor2 == 1){valorFinal = 0;}
                    if(valor1 == 0 && valor2 == 0){valorFinal = 0;}
                }
                if(separador.equals("∨")){
                    if(valor1== 1 && valor2 == 1){valorFinal = 1;}
                    if(valor1 == 1 && valor2 == 0){valorFinal = 1;}
                    if(valor1 == 0 && valor2 == 1){valorFinal = 1;}
                    if(valor1 == 0 && valor2 == 0){valorFinal = 0;}
                }
                if(separador.equals("⇒")){
                    if(valor1== 1 && valor2 == 1){valorFinal = 1;}
                    if(valor1 == 1 && valor2 == 0){valorFinal = 0;}
                    if(valor1 == 0 && valor2 == 1){valorFinal = 1;}
                    if(valor1 == 0 && valor2 == 0){valorFinal = 1;}
                }
                if(separador.equals("⇔")){
                    if(valor1== 1 && valor2 == 1){valorFinal = 1;}
                    if(valor1 == 1 && valor2 == 0){valorFinal = 0;}
                    if(valor1 == 0 && valor2 == 1){valorFinal =  0;}
                    if(valor1 == 0 && valor2 == 0){valorFinal =  1;}
                }
                System.out.println(valorFinal);
                tabla += center(valorFinal+"", elPolinomio);
                tabla += "\n";
                conjunto.add(valorFinal);
            }
        }
        else if(simples.size() == 2){
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 2; j++) {
                    miDiccionario.put(simples.get(0), i);
                    tabla += String.format("%-3d", i);
                    miDiccionario.put(simples.get(1), j);
                    tabla += String.format("%-3d", j);
                    if (simplesNegadas.size() > 0){
                        int matriz[] = new int[simplesNegadas.size()];
                        for (int k = 0; k < matriz.length; k++) {
                            miDiccionario.put(simplesNegadas.get(k),valorNegado(simplesNegadas.get(k), miDiccionario));
                            tabla += String.format("%-5d", valorNegado(simplesNegadas.get(k), miDiccionario));
                        }
                    }
                    if(compuestas.size()>0){
                        for (int k = 0; k < compuestas.size(); k++) {
                            int laCompuesta = compuestas.get(k).length();
                            miDiccionario.put(compuestas.get(k),valor(compuestas.get(k), miDiccionario));
                            //tabla += String.format("%-9d", valor(compuestas.get(j), miDiccionario)); 
                            tabla += center(valor(compuestas.get(k), miDiccionario)+"", laCompuesta);
                            tabla += espaciosFaltantes(9-laCompuesta);
                        }
                    }
                    if(compuestasNegadas.size()>0){
                        for (int k = 0; k < compuestasNegadas.size(); k++) {
                            int laCompuestaNegada = compuestasNegadas.get(k).length();
                            miDiccionario.put(compuestasNegadas.get(k),valorCompuestasNegadas(compuestasNegadas.get(k), miDiccionario));
                            //tabla += String.format("%-9d", valorCompuestasNegadas(compuestasNegadas.get(j), miDiccionario));  
                            tabla += center(valorCompuestasNegadas(compuestasNegadas.get(k), miDiccionario)+"", laCompuestaNegada);
                            tabla += espaciosFaltantes(9-laCompuestaNegada);
                        }
                    }
                    String operando1 = nucleo.get(0);
                    String operando2 = nucleo.get(1);
                    String separador = polinomio.replace(operando1,"").replace(operando2,"");
                    int valor1 = miDiccionario.get(operando1);
                    int valor2 = miDiccionario.get(operando2);
                    int valorFinal = 0;
                    if(separador.equals("∧")){
                        if(valor1== 1 && valor2 == 1){valorFinal=1;}
                        if(valor1 == 1 && valor2 == 0){valorFinal = 0;}
                        if(valor1 == 0 && valor2 == 1){valorFinal = 0;}
                        if(valor1 == 0 && valor2 == 0){valorFinal = 0;}
                    }
                    if(separador.equals("∨")){
                        if(valor1== 1 && valor2 == 1){valorFinal = 1;}
                        if(valor1 == 1 && valor2 == 0){valorFinal = 1;}
                        if(valor1 == 0 && valor2 == 1){valorFinal = 1;}
                        if(valor1 == 0 && valor2 == 0){valorFinal = 0;}
                    }
                    if(separador.equals("⇒")){
                        if(valor1== 1 && valor2 == 1){valorFinal = 1;}
                        if(valor1 == 1 && valor2 == 0){valorFinal = 0;}
                        if(valor1 == 0 && valor2 == 1){valorFinal = 1;}
                        if(valor1 == 0 && valor2 == 0){valorFinal = 1;}
                    }
                    if(separador.equals("⇔")){
                        if(valor1== 1 && valor2 == 1){valorFinal = 1;}
                        if(valor1 == 1 && valor2 == 0){valorFinal = 0;}
                        if(valor1 == 0 && valor2 == 1){valorFinal =  0;}
                        if(valor1 == 0 && valor2 == 0){valorFinal =  1;}
                    }
                    tabla += center(valorFinal+"", elPolinomio);
                    tabla += "\n";
                    conjunto.add(valorFinal);
                }
            }  
        }
        
        else if(simples.size() == 3){
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 2; j++) {
                    for (int x = 0; x < 2; x++) {
                        miDiccionario.put(simples.get(0), i);
                        tabla += String.format("%-3d", i);
                        miDiccionario.put(simples.get(1), j);
                        tabla += String.format("%-3d", j);
                        miDiccionario.put(simples.get(2), x);
                        tabla += String.format("%-3d", x);
                        if (simplesNegadas.size() > 0){
                            int matriz[] = new int[simplesNegadas.size()];
                            for (int k = 0; k < matriz.length; k++) {
                                miDiccionario.put(simplesNegadas.get(k),valorNegado(simplesNegadas.get(k), miDiccionario));
                                tabla += String.format("%-5d", valorNegado(simplesNegadas.get(k), miDiccionario));
                            }
                        }
                        if(compuestas.size()>0){
                            for (int k = 0; k < compuestas.size(); k++) {
                                int laCompuesta = compuestas.get(k).length();
                                miDiccionario.put(compuestas.get(k),valor(compuestas.get(k), miDiccionario));
                                //tabla += String.format("%-9d", valor(compuestas.get(j), miDiccionario)); 
                                tabla += center(valor(compuestas.get(k), miDiccionario)+"", laCompuesta);
                                tabla += espaciosFaltantes(9-laCompuesta);
                            }
                        }
                        if(compuestasNegadas.size()>0){
                            for (int k = 0; k < compuestasNegadas.size(); k++) {
                                int laCompuestaNegada = compuestasNegadas.get(k).length();
                                miDiccionario.put(compuestasNegadas.get(k),valorCompuestasNegadas(compuestasNegadas.get(k), miDiccionario));
                                //tabla += String.format("%-9d", valorCompuestasNegadas(compuestasNegadas.get(j), miDiccionario));  
                                tabla += center(valorCompuestasNegadas(compuestasNegadas.get(k), miDiccionario)+"", laCompuestaNegada);
                                tabla += espaciosFaltantes(9-laCompuestaNegada);
                            }
                        }
                        String operando1 = nucleo.get(0);
                        String operando2 = nucleo.get(1);
                        String separador = polinomio.replace(operando1,"").replace(operando2,"");
                        int valor1 = miDiccionario.get(operando1);
                        int valor2 = miDiccionario.get(operando2);
                        int valorFinal = 0;
                        if(separador.equals("∧")){
                            if(valor1== 1 && valor2 == 1){valorFinal=1;}
                            if(valor1 == 1 && valor2 == 0){valorFinal = 0;}
                            if(valor1 == 0 && valor2 == 1){valorFinal = 0;}
                            if(valor1 == 0 && valor2 == 0){valorFinal = 0;}
                        }
                        if(separador.equals("∨")){
                            if(valor1== 1 && valor2 == 1){valorFinal = 1;}
                            if(valor1 == 1 && valor2 == 0){valorFinal = 1;}
                            if(valor1 == 0 && valor2 == 1){valorFinal = 1;}
                            if(valor1 == 0 && valor2 == 0){valorFinal = 0;}
                        }
                        if(separador.equals("⇒")){
                            if(valor1== 1 && valor2 == 1){valorFinal = 1;}
                            if(valor1 == 1 && valor2 == 0){valorFinal = 0;}
                            if(valor1 == 0 && valor2 == 1){valorFinal = 1;}
                            if(valor1 == 0 && valor2 == 0){valorFinal = 1;}
                        }
                        if(separador.equals("⇔")){
                            if(valor1== 1 && valor2 == 1){valorFinal = 1;}
                            if(valor1 == 1 && valor2 == 0){valorFinal = 0;}
                            if(valor1 == 0 && valor2 == 1){valorFinal =  0;}
                            if(valor1 == 0 && valor2 == 0){valorFinal =  1;}
                        }
                        tabla += center(valorFinal+"", elPolinomio);
                        tabla += "\n";
                        conjunto.add(valorFinal);
                    }
                    
                }
            }
        }
        else{
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 2; j++) {
                    for (int x = 0; x < 2; x++) {
                        for (int y = 0; y < 2; y++) {
                            miDiccionario.put(simples.get(0), i);
                            tabla += String.format("%-3d", i);
                            miDiccionario.put(simples.get(1), j);
                            tabla += String.format("%-3d", j);
                            miDiccionario.put(simples.get(2), x);
                            tabla += String.format("%-3d", x);
                            miDiccionario.put(simples.get(3), y);
                            tabla += String.format("%-3d", y);
                            
                            if (simplesNegadas.size() > 0){
                                int matriz[] = new int[simplesNegadas.size()];
                                for (int k = 0; k < matriz.length; k++) {
                                    miDiccionario.put(simplesNegadas.get(k),valorNegado(simplesNegadas.get(k), miDiccionario));
                                    tabla += String.format("%-5d", valorNegado(simplesNegadas.get(k), miDiccionario));
                                }
                            }
                            if(compuestas.size()>0){
                                for (int k = 0; k < compuestas.size(); k++) {
                                    int laCompuesta = compuestas.get(k).length();
                                    miDiccionario.put(compuestas.get(k),valor(compuestas.get(k), miDiccionario));
                                    //tabla += String.format("%-9d", valor(compuestas.get(j), miDiccionario)); 
                                    tabla += center(valor(compuestas.get(k), miDiccionario)+"", laCompuesta);
                                    tabla += espaciosFaltantes(9-laCompuesta);
                                }
                            }
                            if(compuestasNegadas.size()>0){
                                for (int k = 0; k < compuestasNegadas.size(); k++) {
                                    int laCompuestaNegada = compuestasNegadas.get(k).length();
                                    miDiccionario.put(compuestasNegadas.get(k),valorCompuestasNegadas(compuestasNegadas.get(k), miDiccionario));
                                    //tabla += String.format("%-9d", valorCompuestasNegadas(compuestasNegadas.get(j), miDiccionario));  
                                    tabla += center(valorCompuestasNegadas(compuestasNegadas.get(k), miDiccionario)+"", laCompuestaNegada);
                                    tabla += espaciosFaltantes(9-laCompuestaNegada);
                                }
                            }
                            String operando1 = nucleo.get(0);
                            String operando2 = nucleo.get(1);
                            String separador = polinomio.replace(operando1,"").replace(operando2,"");
                            int valor1 = miDiccionario.get(operando1);
                            int valor2 = miDiccionario.get(operando2);
                            int valorFinal = 0;
                            if(separador.equals("∧")){
                                if(valor1== 1 && valor2 == 1){valorFinal=1;}
                                if(valor1 == 1 && valor2 == 0){valorFinal = 0;}
                                if(valor1 == 0 && valor2 == 1){valorFinal = 0;}
                                if(valor1 == 0 && valor2 == 0){valorFinal = 0;}
                            }
                            if(separador.equals("∨")){
                                if(valor1== 1 && valor2 == 1){valorFinal = 1;}
                                if(valor1 == 1 && valor2 == 0){valorFinal = 1;}
                                if(valor1 == 0 && valor2 == 1){valorFinal = 1;}
                                if(valor1 == 0 && valor2 == 0){valorFinal = 0;}
                            }
                            if(separador.equals("⇒")){
                                if(valor1== 1 && valor2 == 1){valorFinal = 1;}
                                if(valor1 == 1 && valor2 == 0){valorFinal = 0;}
                                if(valor1 == 0 && valor2 == 1){valorFinal = 1;}
                                if(valor1 == 0 && valor2 == 0){valorFinal = 1;}
                            }
                            if(separador.equals("⇔")){
                                if(valor1== 1 && valor2 == 1){valorFinal = 1;}
                                if(valor1 == 1 && valor2 == 0){valorFinal = 0;}
                                if(valor1 == 0 && valor2 == 1){valorFinal =  0;}
                                if(valor1 == 0 && valor2 == 0){valorFinal =  1;}
                            }
                            tabla += center(valorFinal+"", elPolinomio);
                            tabla += "\n";
                            conjunto.add(valorFinal);
                        }
                    }
                }
            }
        
        }
        return tabla;
    }
    
    public static int valorNegado(String proposicion ,Map<String, Integer> dictionary){
        proposicion = proposicion.substring(1);
        int cosa = dictionary.get(proposicion);
        if(cosa == 0){
            return 1;
        }
        else {
            return 0;
        }
    }
    
    public static int valor(String proposicion ,Map<String, Integer> dictionary){
        proposicion = proposicion.substring(1,proposicion.length()-1);
        String separador = "";
        int valor1;
        int valor2;
        if(proposicion.contains("∧")){
           separador = "∧";
        }
        if(proposicion.contains("∨")){
           separador = "∨";
        }
        if(proposicion.contains("⇒")){
           separador = "⇒";
        }
        if(proposicion.contains("⇔")){
           separador = "⇔";
        }
        
        String operador1 = proposicion.substring(0, proposicion.indexOf(separador));
        String operador2 = proposicion.substring(proposicion.indexOf(separador)+1);
        valor1 = dictionary.get(operador1);
        valor2 = dictionary.get(operador2);
        if(separador.equals("∧")){
            if(valor1== 1 && valor2 == 1){return 1;}
            if(valor1 == 1 && valor2 == 0){return 0;}
            if(valor1 == 0 && valor2 == 1){return 0;}
            if(valor1 == 0 && valor2 == 0){return 0;}
        }
        if(separador.equals("∨")){
            if(valor1== 1 && valor2 == 1){return 1;}
            if(valor1 == 1 && valor2 == 0){return 1;}
            if(valor1 == 0 && valor2 == 1){return 1;}
            if(valor1 == 0 && valor2 == 0){return 0;}
        }
        if(separador.equals("⇒")){
            if(valor1== 1 && valor2 == 1){return 1;}
            if(valor1 == 1 && valor2 == 0){return 0;}
            if(valor1 == 0 && valor2 == 1){return 1;}
            if(valor1 == 0 && valor2 == 0){return 1;}
        }
        if(separador.equals("⇔")){
            if(valor1== 1 && valor2 == 1){return 1;}
            if(valor1 == 1 && valor2 == 0){return 0;}
            if(valor1 == 0 && valor2 == 1){return 0;}
            if(valor1 == 0 && valor2 == 0){return 1;}
        }
        return 1;
    }
    
    public static int valorCompuestasNegadas(String proposicion ,Map<String, Integer> dictionary){
        proposicion = proposicion.substring(1);
        int valor = valor(proposicion, dictionary);
        if(valor == 0){
            return 1;
        }
        else {
            return 0;
        }
    }
    
    public static String center(String s, int size) {
        return center(s, size, ' ');
}

    public static String center(String s, int size, char pad) {
        if (s == null || size <= s.length()) return s;

        StringBuilder sb = new StringBuilder(size);
        for (int i = 0; i < (size - s.length()) / 2; i++) {
          sb.append(pad);
        }
        sb.append(s);
        while (sb.length() < size) {
          sb.append(pad);
        }
        return sb.toString();
      }
    
    public static String espaciosFaltantes(int numero){
        String espacios = "";
        if(numero == 0){
            return espacios;
        }
        else{
            for (int i = 0; i < numero; i++) {
                espacios+= " ";
            }
        }
        return espacios;
    }
}



