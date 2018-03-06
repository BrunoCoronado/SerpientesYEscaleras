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
        private int valor;
    public int menuPrincipal(){
        System.out.println("1. Iniciar Juego\n2. Regresar al Juego\n3. Salir");        
        try {
            Scanner scanner = new Scanner(System.in);
            valor = scanner.nextInt();
            return valor;
        } catch (Exception e) {
            System.out.println("Ingrese solo numeros.");
            menuPrincipal();
        }
        return valor;
    }

    public int menuMovimiento(){
        try {
            System.out.println("1. Tirar dado\t\t ***ingrese 'p' para pausar juego.\n2. movimiento libre\t\t ***ingrese 'j' para terminar turno.");
            Scanner scanner = new Scanner(System.in);
            String  opcion = scanner.nextLine();
            switch(opcion){
                case "j":
                    valor= 0;
                    break;
                case "J":
                    valor= 0;
                    break;
                case "p":
                    valor= -1;
                    break;
                case "P":
                    valor= -1;
                    break;
                case "1":
                    valor= 1;
                    break;
                case "2":
                    valor= 2;
                    break;
                default:
                    System.out.println("Seleccione alguna de las opciones disponibles");
                    menuMovimiento(); 
            }
        } catch (Exception e) {
            System.out.println("Ingrese solo numeros, ò terminar turno");
            menuMovimiento();
        }
        return valor;
    }

    public int ingresarMovimiento() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Ingrese el movimiento:");
            valor = scanner.nextInt();
            if(valor<0){
                valor=0;
                ingresarMovimiento();
            }
            return valor;
        } catch (Exception e) {
            System.out.println("Ingrese solo numeros.");
            ingresarMovimiento();
        }
        return valor;
    }
}
