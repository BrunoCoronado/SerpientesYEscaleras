/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serpientesyescaleras.sistema;

import bean.Casilla;
import java.util.ArrayList;
/**
 *
 * @author bruno
 */
public class Juego {
    
    public void inicializar(){
        Menu menu = new Menu();
        Gestion gestion = new Gestion();
        ArrayList<String> jugadores;
        ArrayList<String> escalerasYSerpientes;
        
        switch(menu.menuPrincipal())
        {
            case 1:
                jugadores = gestion.ingresarJugadores();
                //escalerasYSerpientes = gestion.ingresarEscalerasYSerpientes();
                iniciarJuego(gestion.ingresarEscalerasYSerpientes());
                break;
            case 2:
                
            case 3:
                System.exit(0);
            default:
            System.out.println("Seleccione alguna de las 3 opciones disponibles");
            menu.menuPrincipal();
        }
    }

    private void iniciarJuego(ArrayList<String> escalerasYSerpientes) {
        String[][] tablero = new String[10][10];
        
        for(int i=0;i<10;i++){
            for(int j=0;j<10;j++){
                tablero[i][j]=" ";                
                tablero[i][j]=" ";
            }
        }
        
        System.out.println("Turno del jugador\tRonda:");
        System.out.println("-----------------------------------------------------------------------");
        for (int coordenadaX=0;coordenadaX<10;coordenadaX++) {                        
            for (int coordenadaY=0;coordenadaY<10;coordenadaY++) {
                if (coordenadaX==0 && coordenadaY==0) {
                    System.out.print("|"+"*"+"1"+","+"2"+",3");
                }else if (coordenadaX==9 && coordenadaY==9) {
                    System.out.print("|"+" "+" "+" "+"  "+"$");
                }else{
                    System.out.print("|"+" "+tablero[coordenadaX][coordenadaY]+" "+tablero[coordenadaX][coordenadaY]+" "+tablero[coordenadaX][coordenadaY]);                
                }
            }            
            System.out.print("|");
            System.out.print("\n-----------------------------------------------------------------------\n");
        }
    }
}
