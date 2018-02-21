/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serpientesyescaleras.sistema;

import java.util.Scanner;

/**
 *
 * @author bruno
 */
public class Menu {
    
    public void menuPrincipal(){
        
        System.out.println("1. Iniciar Juego");
        System.out.println("2. Regresar al Juego");
        System.out.println("1. Salir");
        
        Scanner scanner = new Scanner(System.in);
        
        try {
            switch(scanner.nextInt())
            {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    System.exit(0);
                default:
                    System.out.println("Seleccione alguna de las 3 opciones disponibles");
                    menuPrincipal();
            }
        } catch (Exception e) {
            System.out.println("Ingrese solo numeros.");
            menuPrincipal();
        }
    }    
}
