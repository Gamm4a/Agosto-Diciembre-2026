/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author amacias
 */
public class ControlNombres {

    private Resultado ultimoResultado;
    private final Contador contador;
    

    public ControlNombres() {
        contador = new Contador();
        ultimoResultado = null;
    }

    public void procesarNombre(String cadena) {

        if (cadena == null || cadena.trim().isEmpty()) {

            ultimoResultado =
                    new Resultado(
                            false,
                            null,
                            "La cadena está vacía."
                    );

            contador.incrementarIncorrectas();
            return;
        }

        cadena = cadena.trim();

        if (cadena.contains(",")) {
            procesarConComa(cadena);
        } else {
            procesarSinComa(cadena);
        }

        if (ultimoResultado.isCorrecto()) {
            contador.incrementarCorrectas();
        } else {
            contador.incrementarIncorrectas();
        }
    }

    private void procesarSinComa(String cadena) {

        String[] partes = cadena.split("\\s+");

        if (partes.length != 3) {

            ultimoResultado =
                    new Resultado(
                            false,
                            null,
                            "El formato del nombre no es válido."
                    );

            return;
        }

        Persona persona =
                new Persona(
                        partes[0],
                        partes[1],
                        partes[2]
                );

        ultimoResultado =
                new Resultado(
                        true,
                        persona,
                        "Interpretación correcta."
                );
    }

    private void procesarConComa(String cadena) {

        String[] secciones = cadena.split(",");

        if (secciones.length != 2) {

            ultimoResultado =
                    new Resultado(
                            false,
                            null,
                            "El formato del nombre no es válido."
                    );

            return;
        }

        String[] apellidos =
                secciones[0].trim().split("\\s+");

        String[] nombres =
                secciones[1].trim().split("\\s+");

        if (apellidos.length != 2 ||
            nombres.length != 1) {

            ultimoResultado =
                    new Resultado(
                            false,
                            null,
                            "El formato del nombre no es válido."
                    );

            return;
        }

        Persona persona =
                new Persona(
                        nombres[0],
                        apellidos[0],
                        apellidos[1]
                );

        ultimoResultado =
                new Resultado(
                        true,
                        persona,
                        "Interpretación correcta."
                );
    }

    public Resultado getResultado() {
        return ultimoResultado;
    }

    public int getCorrectas() {
        return contador.getCorrectas();
    }

    public int getIncorrectas() {
        return contador.getIncorrectas();
    }
    
    public int getIntentosTotales(){
        return contador.getIntentosTotales();
    }
    
    public String getMesajeUltimoEstado(){
        if(this.ultimoResultado!=null){
            return this.ultimoResultado.getMensaje();
        }
        return "Sin interpretaciones";
    }
    
}
