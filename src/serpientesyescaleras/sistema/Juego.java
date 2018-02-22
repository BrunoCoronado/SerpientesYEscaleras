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
    private Random numeroAleatorio = new Random();
        
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
        movimiento(AsignarTurno());
    }
    
    private void generarTablero(){
        System.out.println("\nTurno del jugador\tRonda:");
        System.out.println("-----------------------------------------------------------------------");
        for (int coordenadaX=9;coordenadaX>-1;coordenadaX--) {                        
            for (int coordenadaY=9;coordenadaY>-1;coordenadaY--) {
                    System.out.print("|"+tablero[coordenadaX][coordenadaY].getContenido()+tablero[coordenadaX][coordenadaY].getJugador());
            }            
            System.out.print("|");
            System.out.print("\n-----------------------------------------------------------------------\n");
        }
    }

    private void movimiento(int jugador) {
        switch(menu.menuMovimiento()){
            case 1:
                moverJugador(tirarDado(), jugador);
                break;
            case 2:
                break;
            default:
                System.out.println("Seleccione alguna de las 3 opciones disponibles");
                movimiento(jugador);
        }  
    }

    private int tirarDado() {
        return 1+numeroAleatorio.nextInt(12);
    }

    private void moverJugador(int movimiento, int jugador) {
        String jugadoresParados = "";
        String jugadorMovido = "";        
        int siguienteJugador = 0;
        
        switch(jugador){
            case 1:
                jugadorMovido = "1    ";
                jugadoresParados = ",2,3";
                siguienteJugador = 2;
                break;
            case 2:
                jugadorMovido = " 2   ";
                jugadoresParados = "1,3  ";
                siguienteJugador = 3;
                break;
            case 3:
                jugadorMovido = " 3   ";
                jugadoresParados = "1,2  ";
                siguienteJugador = 1;
                break;
        }
        end:
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (tablero[i][j].getJugador().contains(String.valueOf(jugador))){
                    if ((i+movimiento)>=9) {                        
                        tablero[i+1][i+(movimiento-10)].setJugador(jugadorMovido);
                    }else{
                        tablero[i][j+movimiento].setJugador(jugadorMovido);
                    }
                    tablero[j][i].setJugador(jugadoresParados);
                    
                    System.out.println(movimiento + " "+jugador+" "+i+" "+j);
                    break end;
                }
            }
        }
        generarTablero();      
        movimiento(siguienteJugador);        
    }
    
    public static void inicializarMatriz() {
        for(int coordenadaX=0;coordenadaX<10;coordenadaX++){
            for(int coordenadaY=0;coordenadaY<10;coordenadaY++){
                if (coordenadaX==0 && coordenadaY==0) {
                    tablero[coordenadaX][coordenadaY]= new Casilla("*","1,2,3");
                }else if (coordenadaX==9 && coordenadaY==9) {
                    tablero[coordenadaX][coordenadaY]= new Casilla("$","     ");
                }else{
                    tablero[coordenadaX][coordenadaY]= new Casilla(" ","     ");
                }
            }
        }
    }

    private int AsignarTurno() {
        return (1+numeroAleatorio.nextInt(3));
    }
}
