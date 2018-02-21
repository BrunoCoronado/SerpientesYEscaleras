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
    
    public int menuPrincipal(){
        
        System.out.println("1. Iniciar Juego");
        System.out.println("2. Regresar al Juego");
        System.out.println("3. Salir");
        
        Scanner scanner = new Scanner(System.in);
        
        try {
            return scanner.nextInt();
        } catch (Exception e) {
            System.out.println("Ingrese solo numeros.");
            menuPrincipal();
        }
        return 0;
    }    
}
