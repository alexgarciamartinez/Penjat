/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package penjat;

import java.util.Scanner;

/**
 *
 * @author alexg
 */
public class Penjat {
    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //char letra = sc.nextLine().charAt(0);
        final char[][] estatPenjatInicial =
        {
          {' ',' ',' ',' ','_','_','_','_',' ',' ',' ',' '},                                      
          {' ',' ',' ','|',' ',' ',' ',' ',' ',' ',' ',' '},
          {' ',' ',' ','|',' ',' ',' ',' ',' ',' ',' ',' '},
          {' ',' ',' ','|',' ',' ',' ',' ',' ',' ',' ',' '},
          {' ',' ',' ','|',' ',' ',' ',' ',' ',' ',' ',' '},
          {' ',' ',' ','|',' ',' ',' ',' ',' ',' ',' ',' '},
          {' ','_','_','|','_',' ',' ',' ',' ',' ',' ',' '},                                      
          {'|',' ',' ',' ',' ','|','_','_','_','_','_',' '},
          {'|',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','|'},
          {'|','_','_','_','_','_','_','_','_','_','_','|'}
         };
        
         final String[] paraules = {"patata","armari","bicicleta",
                            "advocat","ascensor","astronauta","autopista",
                            "avinguda","bigoti","carretera","castanya",
                            "cervell","civada","cultura","dentista","esquena",
                            "estrella","formatge","gendre","genoll",
                            "infermera","internet","maduixa","malaltia",
                            "maluc","mandarina","maquinista","motocicleta",
                            "nebot","pastanaga","patinet","perruqueria",
                            "pissarra","professor","quadrat","taronja",
                            "tramvia","trapezi","tricicle","violeta"};
        final int MAXINTENTS = 7;
        
        // Estat gràfic del joc durant la partida
        char[][] estatPenjat = 
        new char[estatPenjatInicial.length][estatPenjatInicial[0].length];
            
            
        // Inicialitzar el dibuix del penjat
        inicialitzarEstatPenjat(estatPenjatInicial,estatPenjat);
            
            
        mostrarEstatPenjat(estatPenjat);
            
        // Seleccionar la paraula aleatòriament
        int index = (int)(Math.random()*paraules.length);
        String paraula = paraules[index];
        // Eliminar aquesta línia quan el joc estigui completat
        paraula = "patata";
             
        int totalEncerts = 0;
        int totalErrors = 0;
            
        // Estructra de dades (array) per saber quines lletres portem 
        //encertades            
        boolean[] lletresEncertades = new boolean[paraula.length()];
            
        // Llistat de lletres que hem introduït
        String lletres = "";
        do {
            System.out.print("Paraula: ");
            mostrarParaula(paraula,lletresEncertades);
            
            System.out.print("Lletres: ");
            mostrarLletresIntroduides(lletres);
            
            char lletra = ' ';
            boolean existeix = false;
            while (!existeix){
                System.out.print("Introdueix lletra:");
                lletra = demanarLletra(lletres).charAt(0);
                if (existeixLletra(lletres, lletra)){
                    existeix = false;
                }
                else {
                    lletres += lletra;
                    existeix = true;
                } 
            }
            
            boolean esEncert = false;
            for (int i = 0; i < paraula.length(); i++) {
                if (lletra == paraula.charAt(i)) {
                    lletresEncertades[i] = true;
                    esEncert = true;
                    totalEncerts++;
                }
            }
            if (!esEncert){
                totalErrors++;
            }
            System.out.println("");
        } while(totalEncerts < paraula.length() && totalErrors < MAXINTENTS);
    }
    
    static void mostrarEstatPenjat(char[][] estat) {
        for (char[] fila : estat) {
            for (char valor : fila) {
                System.out.print(valor);
            }
            System.out.println("");
        }
    }
    static void inicialitzarEstatPenjat(char[][] estatPenjatIni, char[][] estat) {
        for (int i = 0; i < estatPenjatIni.length; ++i) {
            for (int j = 0; j < estatPenjatIni[0].length; ++j) {
                estat[i][j] = estatPenjatIni[i][j];
            }
        }
    }
    static void mostrarParaula(String paraula, boolean[] encertades) {
        for (int i = 0; i < paraula.length(); i++){
            if (encertades[i] == true){
                System.out.print(paraula.charAt(i));
            }
            else{
                System.out.print("*");
            }
        }
        System.out.println("");
    }   
    static void mostrarLletresIntroduides(String lletres) {
        for (int i = 0; i < lletres.length(); i++){
            System.out.print(lletres.charAt(i));
        }
        System.out.println("");
    }   
    static String demanarLletra(String lletres) {
        String lletraDemanada = sc.nextLine();
        return lletraDemanada;   
    } 
    static boolean existeixLletra(String lletres, char lletra) {
        boolean existeix = false;
        for (int i = 0; i < lletres.length(); i++){
            if (lletres.charAt(i) == lletra){
                existeix = true;
            }
        }
        return existeix;
    }
    /*static void actualitzarEstatPenjat(char[][] penjat,int errors) {
        
    }
    static void netejaPantalla() {
    
    }*/
}
