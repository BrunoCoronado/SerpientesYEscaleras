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
        try {
            String opcion = "";
            System.out.println("1. Tirar dado\n2. movimiento libre\t\t ***ingrese 'j' para terminar turno.");
            opcion = scanner.nextLine();            
            opcion = (opcion.equals(""))?scanner.nextLine():opcion;            
            if(opcion.equals("j")){
                return 0;
            }
            return Integer.parseInt(opcion);
        } catch (Exception e) {
            System.out.println("Ingrese solo numeros, ò terminar turno");
            menuMovimiento();
        }
        return 0;
    }
}
