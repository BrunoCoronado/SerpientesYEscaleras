/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serpientesyescaleras.sistema;

import java.util.ArrayList;
/**
 *
 * @author bruno
 */
public class Juego {
    
    public void inicializar(){
        Menu menu = new Menu();
        Gestion gestion = new Gestion();
        
        switch(menu.menuPrincipal())
        {
            case 1:
                ArrayList<String> jugadores = gestion.ingresarJugadores();
                for(int i = 0;i<jugadores.size();i++){
                    System.out.println(jugadores.get(i));
                }
                //gestion.ingresarJugadores();
            case 2:
                
            case 3:
                System.exit(0);
            default:
            System.out.println("Seleccione alguna de las 3 opciones disponibles");
            menu.menuPrincipal();
        }
    }
}
