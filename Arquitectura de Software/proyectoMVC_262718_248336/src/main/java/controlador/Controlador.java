/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;



import modelo.IOperacionesModelo;

/**
 *
 * @author amacias
 */

public class Controlador {

    private IOperacionesModelo modelo;

    public Controlador() {
    }

    public void setModelo(IOperacionesModelo modelo) {
        this.modelo = modelo;
    }

    public void procesarNombre(String cadena) {
        modelo.procesarNombre(cadena);
    }
}