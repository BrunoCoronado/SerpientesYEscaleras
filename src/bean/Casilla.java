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
    private String jugadores;

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public String getJugadores() {
        return jugadores;
    }

    public void setJugadores(String jugadores) {
        this.jugadores = jugadores;
    }

    public Casilla() {
    }

    public Casilla(String contenido, String jugadores) {
        this.contenido = contenido;
        this.jugadores = jugadores;
    }  
}
