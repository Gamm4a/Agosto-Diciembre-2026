/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author amacias
 */
public class Contador {

    private int correctas;
    private int incorrectas;
    private int intentos;

    public Contador() {
        correctas = 0;
        incorrectas = 0;
        intentos = 0;
    }

    public void incrementarCorrectas() {
        correctas++;
        intentos++;
    }

    public void incrementarIncorrectas() {
        incorrectas++;
        intentos++;
    }

    public int getCorrectas() {
        return correctas;
    }

    public int getIncorrectas() {
        return incorrectas;
    }
    
    public int getIntentosTotales(){
        return intentos;
    }
}
