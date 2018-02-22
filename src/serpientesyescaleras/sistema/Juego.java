/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serpientesyescaleras.sistema;

import bean.Casilla;
import java.util.ArrayList;
import java.util.Random;
/**
 *
 * @author bruno
 */
public class Juego {
    private Menu menu = new Menu();
    private Gestion gestion = new Gestion();
    private ArrayList<String> jugadores;
        
    public static Casilla[][] tablero = new Casilla[10][10]; 
    
    public void inicializar(){
        
        switch(menu.menuPrincipal())
        {
            case 1:
                jugadores = gestion.ingresarJugadores();
                //escalerasYSerpientes = gestion.ingresarEscalerasYSerpientes();
                gestion.ingresarEscalerasYSerpientes();
                iniciarJuego();
                break;
            case 2:
                
            case 3:
                System.exit(0);
            default:
                System.out.println("Seleccione alguna de las 3 opciones disponibles");
                inicializar();
        }
    }

    private void iniciarJuego() {        
        generarTablero();
        movimiento();
    }
    
    private void generarTablero(){
        System.out.println("\nTurno del jugador\tRonda:");
        System.out.println("-----------------------------------------------------------------------");
        for (int coordenadaX=9;coordenadaX>-1;coordenadaX--) {                        
            for (int coordenadaY=9;coordenadaY>-1;coordenadaY--) {
                /*if (coordenadaX==0 && coordenadaY==0) {
                    System.out.print("|"+"1"+","+"2"+",3"+"*");
                }else if (coordenadaX==9 && coordenadaY==9) {
                    System.out.print("|"+"$"+" "+" "+" "+"  ");
                }else{*/
                    System.out.print("|"+tablero[coordenadaX][coordenadaY].getContenido()+tablero[coordenadaX][coordenadaY].getJugador1()+tablero[coordenadaX][coordenadaY].getJugador2()+tablero[coordenadaX][coordenadaY].getJugador3());                
                //}
            }            
            System.out.print("|");
            System.out.print("\n-----------------------------------------------------------------------\n");
        }
    }

    private void movimiento() {
        switch(menu.menuMovimiento()){
            case 1:
                moverJugador(tirarDado());
                break;
            case 2:
                break;
            default:
                System.out.println("Seleccione alguna de las 3 opciones disponibles");
                movimiento();
        }  
    }

    private int tirarDado() {
        Random numeroAleatorio = new Random();
        return 1+numeroAleatorio.nextInt(12);
    }

    private void moverJugador(int movimiento) {
        
    }
    
    public static void inicializarMatriz() {
        for(int coordenadaX=0;coordenadaX<10;coordenadaX++){
            for(int coordenadaY=0;coordenadaY<10;coordenadaY++){
                if (coordenadaX==0 && coordenadaY==0) {
                    tablero[coordenadaX][coordenadaY]= new Casilla("*","1",",2",",3");
                }else if (coordenadaX==9 && coordenadaY==9) {
                    tablero[coordenadaX][coordenadaY]= new Casilla("$"," ","  ","  ");
                }else{
                    tablero[coordenadaX][coordenadaY]= new Casilla(" "," ","  ","  ");
                }
            }
        }
    }
}
