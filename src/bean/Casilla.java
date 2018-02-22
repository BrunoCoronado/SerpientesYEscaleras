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
    private String jugador;

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public String getJugador() {
        return jugador;
    }

    public void setJugador(String jugador) {
        this.jugador = jugador;
    }

    public Casilla(String contenido, String jugador) {
        this.contenido = contenido;
        this.jugador = jugador;
    }    

    public Casilla() {
    }
    
    
}
