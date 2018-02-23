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
    private static int ronda = 1;
    private String jugador = "";
        
    public static Casilla[][] tablero = new Casilla[10][10]; 
    
    public void inicializar(){
        
        switch(menu.menuPrincipal())
        {
            case 1:
                jugadores = gestion.ingresarJugadores();
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
    
    public static void inicializarMatriz() {
        for(int coordenadaX=0;coordenadaX<10;coordenadaX++){
            for(int coordenadaY=0;coordenadaY<10;coordenadaY++){
                if (coordenadaX==0 && coordenadaY==0) {
                    tablero[coordenadaX][coordenadaY]= new Casilla("*","1",",2",",3","123");
                }else if (coordenadaX==9 && coordenadaY==9) {
                    tablero[coordenadaX][coordenadaY]= new Casilla("$"," ","  ","  ","");
                }else{
                    tablero[coordenadaX][coordenadaY]= new Casilla(" "," ","  ","  ","");
                }
            }
        }
    }

    private void iniciarJuego() {        
        //generarTablero();        
        movimiento(generarTablero());
    }
    
    private int AsignarTurno() {
        switch(1+numeroAleatorio.nextInt(3)){
            case 1:
                jugador = jugadores.get(0);
                return 1;
            case 2:
                jugador = jugadores.get(1);
                return 2;
            case 3:
                jugador = jugadores.get(2);
                return 3;
        }
        return 0;
    }
    
    private int generarTablero(){
        Integer turno=null;
        if(ronda==1){
            turno = AsignarTurno();
        }        
        System.out.println("\nTurno del jugador:"+jugador+"\t\t\t\t\tRonda:"+ronda);
        System.out.println("-----------------------------------------------------------------------");
        for (int coordenadaX=9;coordenadaX>-1;coordenadaX--) {                        
            for (int coordenadaY=9;coordenadaY>-1;coordenadaY--) {
                    System.out.print("|"+tablero[coordenadaX][coordenadaY].getContenido()+tablero[coordenadaX][coordenadaY].getJugador1()+
                                     tablero[coordenadaX][coordenadaY].getJugador2()+tablero[coordenadaX][coordenadaY].getJugador3());
            }            
            System.out.print("|");
            System.out.print("\n-----------------------------------------------------------------------\n");
        }
        ronda = ronda + 1;
        if(turno!=null){
            return turno;
        }
        return 0;
    }

    private void movimiento(int jugador) {
        switch(menu.menuMovimiento()){
            case 0:
                int siguienteJugador = cambiarParametros(jugador);
                generarTablero();      
                movimiento(siguienteJugador);   
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
        System.out.println("\nMovimiento: "+movimiento+" casillas para "+this.jugador);
        switch(jugador){
            case 1:
                jugadorMovido = "1";
                jugadoresParados = " ";
                siguienteJugador = 2;
                this.jugador=jugadores.get(1);
                break;
            case 2:
                jugadorMovido = ",2";
                jugadoresParados = "  ";
                siguienteJugador = 3;                
                this.jugador=jugadores.get(2);
                break;
            case 3:
                jugadorMovido = ",3";
                jugadoresParados = "  ";
                siguienteJugador = 1;
                this.jugador=jugadores.get(0);
                break;
        }
        algoritmoMovimientoAleatorio(movimiento,jugador,jugadorMovido,jugadoresParados);
        generarTablero();      
        movimiento(siguienteJugador);        
    }
    
    public void DatosCasilla(){
    
    }
    
    public void algoritmoMovimientoAleatorio(int movimiento,int jugador,String jugadorMovido, String jugadoresParados){
        end:
            for (int coordenadaY = 0; coordenadaY < 10; coordenadaY++) {
                for (int coordenadaX = 0; coordenadaX < 10; coordenadaX++) {
                    if (tablero[coordenadaY][coordenadaX].getGeneral().contains(String.valueOf(jugador))){                              
                        int distanciaAlBorde = 9-coordenadaX;
                        int subir = coordenadaY+1;
                        if(distanciaAlBorde==0){
                            if (movimiento>10) {                                                   
                                ejecutarMovimiento(movimiento-10, subir+1,jugadorMovido,jugador);                                    
                                organizarCasilla(coordenadaX, coordenadaY, jugadoresParados, jugador);
                                break end;
                            }else{                                        
                                ejecutarMovimiento(movimiento-1, subir,jugadorMovido,jugador);
                                organizarCasilla(coordenadaX, coordenadaY, jugadoresParados, jugador);
                                break end;
                            }
                        }                    
                        if(distanciaAlBorde<movimiento){
                            if(distanciaAlBorde==1){
                                if(movimiento>11){
                                    ejecutarMovimiento(movimiento-10, subir+1,jugadorMovido,jugador);
                                    organizarCasilla(coordenadaX, coordenadaY, jugadoresParados, jugador);
                                    break end;
                                }else{
                                    ejecutarMovimiento(coordenadaX+(movimiento-10), subir,jugadorMovido,jugador);
                                    organizarCasilla(coordenadaX, coordenadaY, jugadoresParados, jugador);
                                    break end;
                                }  
                            }else{
                                ejecutarMovimiento((movimiento-distanciaAlBorde)-1, coordenadaY+1,jugadorMovido,jugador);
                                organizarCasilla(coordenadaX, coordenadaY, jugadoresParados, jugador);
                                break end;
                            }
                        }
                        if(distanciaAlBorde>=movimiento){
                            ejecutarMovimiento(coordenadaX+movimiento, coordenadaY,jugadorMovido,jugador);
                            organizarCasilla(coordenadaX, coordenadaY, jugadoresParados, jugador);
                            break end;
                        }
                    }
                }
            }
                        
    }
    
    public void ejecutarMovimiento(int coordenadaX, int coordenadaY,String jugadorMovido,int jugador){
        tablero[coordenadaY][coordenadaX].setMoverJugador(jugadorMovido, jugador);
        tablero[coordenadaY][coordenadaX].setGeneral(tablero[coordenadaY][coordenadaX].getGeneral()+""+String.valueOf(jugador));  
    }
    
    public void organizarCasilla(int coordenadaX, int coordenadaY,String jugadorParado,int jugador){
        tablero[coordenadaY][coordenadaX].setMoverJugador(jugadorParado, jugador);
        tablero[coordenadaY][coordenadaX].setGeneral((tablero[coordenadaY][coordenadaX].getGeneral()).replace(String.valueOf(jugador), " "));  
    }

    private int cambiarParametros(int jugador) {
       switch(jugador){
            case 1:
                this.jugador = jugadores.get(1);
                return 2;
            case 2:
                this.jugador = jugadores.get(2);
                return 3;
            case 3:
                this.jugador = jugadores.get(0);
                return 1;
        }
        return 0;
    }
}
