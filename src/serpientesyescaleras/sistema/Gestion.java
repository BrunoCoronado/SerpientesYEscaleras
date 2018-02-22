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

    public void ingresarEscalerasYSerpientes() {
            
        System.out.println("Ingrese las serpientes en el formato x1,y1;x2,y2;x3,y3");
        String[] serpientes = ((scanner.nextLine())).split(";");        
        coordenadasEscalerasSerpientes(serpientes, "S");
        
        System.out.println("Ingrese las escaleres en el formato x1,y1;x2,y2;x3,y3");
        String[] escaleras = ((scanner.nextLine())).split(";");          
        coordenadasEscalerasSerpientes(escaleras, "E");              
    }

    private void coordenadasEscalerasSerpientes(String[] parejaCoordenadas, String contenido) {
        try {
            for(int posicionVector = 0; posicionVector < parejaCoordenadas.length; posicionVector++) {            
                String[] coordenadaIndividual = parejaCoordenadas[posicionVector].split(",");         
                for (int coordenada = 0; coordenada < (coordenadaIndividual.length/2); coordenada=coordenada+2) {
                    Juego.tablero[Integer.parseInt(coordenadaIndividual[coordenada+1])-1][Integer.parseInt(coordenadaIndividual[coordenada])-1].setContenido(contenido); 
                }
            }
        } catch (Exception e) {
            System.out.println("formato incorrecto, ingrese solo numeros");
            ingresarEscalerasYSerpientes();
        }
        
        
    }
}
