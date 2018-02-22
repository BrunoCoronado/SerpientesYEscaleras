package bean;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author bruno
 */
public class Casilla {
    private String contenido;
    private String jugador1;
    private String jugador2;
    private String jugador3;

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public String getJugador1() {
        return jugador1;
    }

    public void setJugador1(String jugador1) {
        this.jugador1 = jugador1;
    }

    public String getJugador2() {
        return jugador2;
    }

    public void setJugador2(String jugador2) {
        this.jugador2 = jugador2;
    }

    public String getJugador3() {
        return jugador3;
    }

    public void setJugador3(String jugador3) {
        this.jugador3 = jugador3;
    }

    public Casilla(String contenido, String jugador1, String jugador2, String jugador3) {
        this.contenido = contenido;
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;
        this.jugador3 = jugador3;
    }

    public Casilla() {
    }
    
    
}
