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
    private Menu menu = new Menu();
    private Gestion gestion = new Gestion();
    private ArrayList<String> jugadores;
    private ArrayList<String> escalerasYSerpientes;
    
    public void inicializar(){     
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
            inicializar();
        }
    }

    private void iniciarJuego(String[][] tablero) {
        System.out.println("Turno del jugador\tRonda:");
        System.out.println("-----------------------------------------------------------------------");
        for (int coordenadaX=9;coordenadaX>-1;coordenadaX--) {                        
            for (int coordenadaY=9;coordenadaY>-1;coordenadaY--) {
                if (coordenadaX==0 && coordenadaY==0) {
                    System.out.print("|"+"1"+","+"2"+",3"+"*");
                }else if (coordenadaX==9 && coordenadaY==9) {
                    System.out.print("|"+"$"+" "+" "+" "+"  ");
                }else{
                    System.out.print("|"+" "+tablero[coordenadaX][coordenadaY]+" "+tablero[coordenadaX][coordenadaY]+" "+tablero[coordenadaX][coordenadaY]);                
                }
            }            
            System.out.print("|");
            System.out.print("\n-----------------------------------------------------------------------\n");
        }
    }
}
