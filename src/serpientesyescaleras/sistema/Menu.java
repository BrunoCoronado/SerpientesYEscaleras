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
    Scanner scanner = new Scanner(System.in);
    
    public int menuPrincipal(){
        System.out.println("1. Iniciar Juego\n2. Regresar al Juego\n3. Salir");        
        try {
            return scanner.nextInt();
        } catch (Exception e) {
            System.out.println("Ingrese solo numeros.");
            menuPrincipal();
        }
        return 0;
    }

    public int menuMovimiento(){
        System.out.println("1. Tirar dado\n2. movimiento libre");
        
        try {
            return scanner.nextInt();
        } catch (Exception e) {
            System.out.println("Ingrese solo numeros.");
            menuMovimiento();
        }
        return 0;
    }
}
