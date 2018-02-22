/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serpientesyescaleras.sistema;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author bruno
 */
public class Gestion{
    private Scanner scanner = new Scanner(System.in);    
    private String[][] tablero = new String[10][10];    
    
    public ArrayList<String> ingresarJugadores(){
        ArrayList<String> jugadores = new ArrayList<>();
        
        for(int contadorJugadores = 0;contadorJugadores<3;contadorJugadores++)
        {
            System.out.println("Ingrese el jugador "+(contadorJugadores+1));
            if(contadorJugadores==2){
                System.out.println("**Enter para jugar con dos jugadores");                 
                String ingreso = scanner.nextLine();
                if (ingreso.equals("")) {
                    return jugadores;
                }else{
                    jugadores.add(ingreso);  
                    break;
                }       
            }            
            jugadores.add(scanner.nextLine());   
        }   
                 
    return jugadores;
    }   

    public String[][] ingresarEscalerasYSerpientes() {
        ArrayList<String[]> escalerasYSerpientes = new ArrayList<>(); 
        inicializarMatriz();
            
        System.out.println("Ingrese las serpientes en el formato x1,y1;x2,y2;x3,y3");
        String[] serpientes = ((scanner.nextLine())).split(";");
        
        coordenadasEscalerasSerpientes(serpientes, "S");
        
        System.out.println("Ingrese las escaleres en el formato x1,y1;x2,y2;x3,y3");
        String[] escaleras = ((scanner.nextLine())).split(";");  
        
        coordenadasEscalerasSerpientes(escaleras, "E");      
        
        return tablero;
    }

    private void coordenadasEscalerasSerpientes(String[] parejaCoordenadas, String contenido) {
        
        for(int i = 0; i < parejaCoordenadas.length; i++) {
            String[] coordenadas = parejaCoordenadas[i].split(",");
            for (int j = 0; j < (coordenadas.length/2); j=j+2) {
                tablero[Integer.parseInt(coordenadas[j+1])-1][Integer.parseInt(coordenadas[j])-1] = contenido;
            }
        }
    }

    private void inicializarMatriz() {
        for(int i=0;i<10;i++){
            for(int j=0;j<10;j++){
                tablero[i][j]=" ";                
                tablero[i][j]=" ";
            }
        }
    }
    
    
}
