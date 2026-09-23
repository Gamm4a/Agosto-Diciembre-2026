/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author amacias
 */
public final class Resultado {

    private final boolean correcto;
    private final Persona persona;
    private final String mensaje;

    public Resultado(boolean correcto, Persona persona, String mensaje) {
        this.correcto = correcto;
        this.persona = persona;
        this.mensaje = mensaje;
    }

    public boolean isCorrecto() {
        return correcto;
    }

    public Persona getPersona() {
        return persona;
    }

    public String getMensaje() {
        return mensaje;
    }
}
