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
    Scanner scanner = new Scanner(System.in);
    
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

    public ArrayList<String> ingresarEscalerasYSerpientes() {
        ArrayList<String> escalerasYSerpientes = new ArrayList<>(); 
        
        System.out.println("Ingrese las serpientes en el formato x1,y1;x2,y2;x3,y3");
        escalerasYSerpientes.add(scanner.nextLine());
        System.out.println("Ingrese las escaleres en el formato x1,y1;x2,y2;x3,y3");
        escalerasYSerpientes.add(scanner.nextLine());        
        
        return escalerasYSerpientes;
    }
}
