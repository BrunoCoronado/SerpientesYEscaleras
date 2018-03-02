/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serpientesyescaleras.sistema;

import bean.Casilla;
import java.util.Random;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import static serpientesyescaleras.sistema.Juego.tablero;

/**
 *
 * @author bruno
 */
public class Gestion{
    private Scanner scanner = new Scanner(System.in);   
    private boolean serpiente = true;
    
    public String[] ingresarJugadores(){
        String[] jugadores = null;
        System.out.println("jugar con: \n1) 2 Jugadores\n2) 3 Jugadores");
        try{
            switch(scanner.nextInt()){
                case 1:
                    jugadores = new String[2];
                    break;
                case 2:
                    jugadores = new String[3]; 
                    break;
                default:
                    ingresarJugadores();
            }
        }catch(Exception e){
            System.out.println("ingrese solo numeros.");
            ingresarJugadores();
        }
            
        
        for(int contadorJugadores = 0;contadorJugadores<jugadores.length;contadorJugadores++){
            System.out.println("Ingrese el jugador ");
//            String ingreso = scanner.nextLine();
            String jugador = scanner.nextLine();
            jugador = (jugador.equals(""))?scanner.nextLine():jugador;
            jugadores[contadorJugadores]=jugador;
            /*if(contadorJugadores==2){
                System.out.println("**Enter para jugar con dos jugadores");                 
                String ingreso = scanner.nextLine();
                if (ingreso.equals("")) {
                    return jugadores;
                }else{
                    jugadores.add(ingreso);  
                    break;
                }       
            } */           
            //jugadores[contadorJugadores] = scanner.nextLine();   
        }              
    return jugadores;
    }   

    public void ingresarEscalerasYSerpientes() {
        if(this.serpiente){
            System.out.println("Ingrese las serpientes en el formato x1,y1;x2,y2;x3,y3\n***(no validas en el borde inferior)");
            String[] serpientes = ((scanner.nextLine())).split(";");        
            coordenadasEscalerasSerpientes(serpientes, "S");
        }else{
            System.out.println("Ingrese las escaleras en el formato x1,y1;x2,y2;x3,y3\n***(no validas en el borde superior)");
            String[] escaleras = ((scanner.nextLine())).split(";");          
            coordenadasEscalerasSerpientes(escaleras, "E");              
        }
    }
    //deberia ir en juego
    private int coordenadasEscalerasSerpientes(String[] parejaCoordenadas, String contenido) {
        try {
            Pattern pattern;
            if(this.serpiente){
                    pattern = Pattern.compile("^[0-8]{1}[,]{1}[0-9]{1}");
                }else{
                    pattern = Pattern.compile("^[1-9]{1}[,]{1}[0-9]{1}");
            }
            end:
            for(int posicionVector = 0; posicionVector < parejaCoordenadas.length; posicionVector++) { 
                String coordenadaFilaColumna = parejaCoordenadas[posicionVector];
                Matcher matcher = pattern.matcher(coordenadaFilaColumna);
                if (matcher.matches()) {
                    String[] coordenadaIndividual = parejaCoordenadas[posicionVector].split(",");                             
                    agregarSerpientesYEscalerasAlTablero(coordenadaIndividual,contenido);
                    //parejaCoordenadas = null;
                } else {                    
                    System.out.println("formato incorrecto o posicion invalida");
                    limpiarEscalerasYSerpientes();
                    parejaCoordenadas = null;
                    ingresarEscalerasYSerpientes();
                    break end;
                }
            }
            //agregarSerpientesYEscalerasAlTablero(coordenadaIndividual,contenido);
            if(this.serpiente){
                this.serpiente=false;
                ingresarEscalerasYSerpientes();
            }            
        } catch (Exception e) {
            System.out.println("formato incorrecto");
            limpiarEscalerasYSerpientes();
            ingresarEscalerasYSerpientes();
        }
        return 0;
    }
    
    public void agregarSerpientesYEscalerasAlTablero(String[] serpientesYEscaleras, String contenido){
        for (int coordenada = 0; coordenada < (serpientesYEscaleras.length/2); coordenada=coordenada+2) {
                String cont = Juego.tablero[Integer.parseInt(serpientesYEscaleras[coordenada])][Integer.parseInt(serpientesYEscaleras[coordenada+1])].getContenido();
                if(cont.contains(" ")||cont.contains("S")||cont.contains("E")){
                    Juego.tablero[Integer.parseInt(serpientesYEscaleras[coordenada])][Integer.parseInt(serpientesYEscaleras[coordenada+1])].setContenido(contenido); 
                }
            }
    }
    
    public void ejemploTablero(){
        System.out.println("Ejemplo de las coordenadas en el tablero");
        System.out.println("-----------------------------------------------------------------------");
        for(int fila=0;fila<10;fila++){
            for(int columna=0;columna<10;columna++){
                    System.out.print("|  "+fila+","+columna+" ");
            }            
            System.out.print("|");
            System.out.print("\n-----------------------------------------------------------------------\n");
        } 
    }

    private void limpiarEscalerasYSerpientes() {
        for(int fila=0;fila<10;fila++){
            for(int columna=0;columna<10;columna++){
                if (fila==9 && columna==9) {
                    tablero[fila][columna]= new Casilla("*","1",",2",",3","123");
                }else if (fila==0 && columna==0) {
                    tablero[fila][columna]= new Casilla("$"," ","  ","  ","");
                }else{
                    if(this.serpiente){
                        tablero[fila][columna]= new Casilla(" "," ","  ","  ","");
                    }else{
                        if(tablero[fila][columna].getContenido().equals("E")){
                            tablero[fila][columna]= new Casilla(" "," ","  ","  ","");
                        }
                    }                    
                }
            }
        }
    }
}
