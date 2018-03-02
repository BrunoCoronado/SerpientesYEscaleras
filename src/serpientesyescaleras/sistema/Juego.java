/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serpientesyescaleras.sistema;

import bean.Casilla;
import java.util.Random;
import serpientesyescaleras.Main;
/**
 *
 * @author bruno
 */
public class Juego {
    private Menu menu = new Menu();
    private Gestion gestion = new Gestion();
    private Random numeroAleatorio = new Random();
    private static int ronda = 1;
    private String jugador = "";    
    private String[] jugadores;
    public static Casilla[][] tablero = new Casilla[10][10]; 
    
    public void inicializar(){
        switch(menu.menuPrincipal()){
            case 1:
                //jugadores = gestion.ingresarJugadores();
                AsignarTurno(gestion.ingresarJugadores());
                gestion.ejemploTablero();
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
        for(int fila=0;fila<10;fila++){
            for(int columna=0;columna<10;columna++){
                if (fila==9 && columna==9) {
                    tablero[fila][columna]= new Casilla("*","1",",2",",3","123");
                }else if (fila==0 && columna==0) {
                    tablero[fila][columna]= new Casilla("$"," ","  ","  ","");
                }else{
                    tablero[fila][columna]= new Casilla(" "," ","  ","  ","");
                }
            }
        }
    }

    public void iniciarJuego() {        
        //generarTablero();        
        movimiento(generarTablero());
    }
    
    private void AsignarTurno(String[] jugadoresIngresados) {
        /*switch(1+numeroAleatorio.nextInt(3)){
            case 1:
                jugador = jugadores.get(0);1
                return 1;
            case 2:
                jugador = jugadores.get(1);
                return 2;
            case 3:
                jugador = jugadores.get(2);
                return 3;
        }
        return 0;*/
        int j1=0;
        int j2=0;
        int j3=0;
        
        if(jugadoresIngresados.length==2){
            j1=numeroAleatorio.nextInt(2);
            j2=(j1==0)?1:0;      
            jugadores = new String[2];
            jugadores[0]=jugadoresIngresados[j1];
            jugadores[1]=jugadoresIngresados[j2];
        }else{
            jugadores = new String[3];
            j1=numeroAleatorio.nextInt(3);
            switch(j1){
                case 0:
                    j2=1+numeroAleatorio.nextInt(2);
                    j3=(j2==1)?2:1;
                    break;
                case 1:
                    j2=(numeroAleatorio.nextInt(2)==1)?0:2;
                    j3=(j2==0)?2:0;
                    break;
                case 2:
                    j2=(numeroAleatorio.nextInt(2)==2)?0:1;
                    j3=(j2==0)?1:0;
                    break;
            }
            jugadores[0]=jugadoresIngresados[j1];
            jugadores[1]=jugadoresIngresados[j2];
            jugadores[2]=jugadoresIngresados[j3];
        }
        
        
        System.out.println("Orden de los turnos:");
        
        
        
        
        for(int i=0;i<jugadoresIngresados.length;i++){  
            System.out.println((i+1)+") "+jugadores[i]+" ficha " +(i+1));
        }
        jugador = jugadores[0];
    }
    
    private int generarTablero(){
        /*Integer turno=null;
        if(ronda==1){
            turno = AsignarTurno();
        } */       
        System.out.println("\nTurno del jugador:"+jugador+"\t\t\t\t\tRonda:"+ronda);
        System.out.println("-----------------------------------------------------------------------");
        for(int fila=0;fila<10;fila++){
            for(int columna=0;columna<10;columna++){
                    System.out.print("|"+tablero[fila][columna].getContenido()+tablero[fila][columna].getJugador1()+
                                     tablero[fila][columna].getJugador2()+tablero[fila][columna].getJugador3());
            }            
            System.out.print("|");
            System.out.print("\n-----------------------------------------------------------------------\n");
        }        
        
        /*if(turno!=null){
            return turno;
        }*/
       // return 1;
       return ordenTurnos(ronda);
    }
    
    
    
    private int ordenTurnos(int ronda) {
        int turno=1;
        if(ronda>3){
          ronda=1;  
        }
        switch(ronda){
            case 1:
                return turno;
            case 2:
                return turno+1;
            case 3:
                return turno+2;
        }  
        return 0;
    }

    private void movimiento(int jugador) {
        ronda = ronda + 1;
        switch(menu.menuMovimiento()){
            case 0:
                int siguienteJugador = cambiarParametros(jugador);
                generarTablero();      
                movimiento(siguienteJugador);   
            case 1:
                moverJugador(tirarDado(), jugador);
                break;
            case 2:              
                moverJugador(menu.ingresarMovimiento(), jugador);
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
                this.jugador=jugadores[1];
                break;
            case 2:
                jugadorMovido = ",2";
                jugadoresParados = "  ";
                if(jugadores.length==3){
                    siguienteJugador = 3;                
                    this.jugador=jugadores[2];
                }else{
                    siguienteJugador = 1;                
                    this.jugador=jugadores[0];
                }
                
                break;
            case 3:
                jugadorMovido = ",3";
                jugadoresParados = "  ";
                siguienteJugador = 1;
                this.jugador=jugadores[0];
                break;
        }
        
        end:
            for (int fila = 0; fila < 10; fila++) {
                for (int columna = 0; columna < 10; columna++) {
                    if (tablero[fila][columna].getGeneral().contains(String.valueOf(jugador))){                                                      
                        algoritmoMovimiento(columna,fila,movimiento,jugador,jugadorMovido,jugadoresParados);
                        organizarCasilla(columna, fila, jugadoresParados, jugador);
                        break end;
                    }
                }
            }
        
        generarTablero();      
        movimiento(siguienteJugador);        
    }
    
    public void algoritmoMovimiento(int columna, int fila,int movimiento,int jugador,String jugadorMovido, String jugadoresParados){
        int distanciaAlBorde = columna;
        //int subir = columna+1;
        int col = 0;
        int fil = 0;                    
        if(distanciaAlBorde<movimiento){
            if(distanciaAlBorde==1){
                if(movimiento>11){
                    col=9;
                    fil=fila-2;
                    //hacer ciclo con recursividad para movimiento mayor a 12
                    //ejecutarMovimiento(movimiento-10, subir+1,jugadorMovido,jugador);
                    //organizarCasilla(fila, columna, jugadoresParados, jugador);
                   // break end;
                }else{
                    col=columna-(movimiento-10);
                    fil=fila-1;
                    //ejecutarMovimiento(fila+(movimiento-10), subir,jugadorMovido,jugador);
                    //organizarCasilla(fila, columna, jugadoresParados, jugador);
                    //break end;
                }  
            }else if(distanciaAlBorde==0){
                if (movimiento>10) {        
                    col=10-(movimiento-10);
                    fil=fila-2;//revisar1
                    //algoritmoMovimiento(0, col+1, movimiento-1, jugador, jugadorMovido, jugadoresParados);
                    //hacer ciclo con recursividad para movimiento mayor a 12
                    //ejecutarMovimiento(movimiento-10, columna+2,jugadorMovido,jugador);                                    
                    //organizarCasilla(fila, columna, jugadoresParados, jugador);
                }else{  
                    col=9-(movimiento-1);
                    fil=fila-1;
                    //ejecutarMovimiento(movimiento-1, subir,jugadorMovido,jugador);
                    //organizarCasilla(fila, columna, jugadoresParados, jugador);
                    //break end;
                }
            }else{
                col=10-(movimiento-distanciaAlBorde);
                fil=fila-1;
                //ejecutarMovimiento((movimiento-distanciaAlBorde)-1, columna+1,jugadorMovido,jugador);
                //organizarCasilla(fila, columna, jugadoresParados, jugador);
                //break end;
            }
        }
        if(distanciaAlBorde>=movimiento){
            col=columna-movimiento;
            fil=fila;
            //ejecutarMovimiento(fila+movimiento, columna,jugadorMovido,jugador);
            //organizarCasilla(fila, columna, jugadoresParados, jugador);
            //break end;
        }    
        end:
        ejecutarMovimiento(col, fil,jugadorMovido,jugador);
    }
    
    public void ejecutarMovimiento(int columna, int fila,String jugadorMovido,int jugador){
        verificarVictoria(columna,fila);
        int desplazamiento = verificarEscalerasOSerpientes(columna, fila);
        tablero[fila+desplazamiento][columna].setMoverJugador(jugadorMovido, jugador);
        tablero[fila+desplazamiento][columna].setGeneral(tablero[fila][columna].getGeneral()+""+String.valueOf(jugador));  
    }
    
    public void organizarCasilla(int columna, int fila,String jugadorParado,int jugador){
        tablero[fila][columna].setMoverJugador(jugadorParado, jugador);
        tablero[fila][columna].setGeneral((tablero[fila][columna].getGeneral()).replace(String.valueOf(jugador), " "));  
    }

    private int cambiarParametros(int jugador) {
       switch(jugador){
            case 1:
                this.jugador = jugadores[1];
                return 2;
            case 2:
                if(jugadores.length==3){
                    this.jugador = jugadores[2];
                    return 3;
                }else{
                    this.jugador = jugadores[0];
                    return 1;
                }
            case 3:
                this.jugador = jugadores[0];
                return 1;
        }
        return 0;
    }

    private int verificarEscalerasOSerpientes(int fila, int columna) {
        switch(tablero[fila][columna].getContenido()){
            case "S":
                return +1;
            case "E":
                return -1;
            default:
                return 0;
        }
    }

    private void verificarVictoria(int columna, int fila) {
        try {
            if(tablero[fila][columna].getContenido().contains("$")){
                System.out.println("victoria");
                inicializarMatriz();
                inicializar();
            }  
        } catch (Exception e) {
            System.out.println("victoria");
            inicializarMatriz();
            inicializar();
        }
    }

    
}
