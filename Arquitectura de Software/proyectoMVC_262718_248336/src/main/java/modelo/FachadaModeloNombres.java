/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import utilerias.SujetoObservado;

public class FachadaModeloNombres extends SujetoObservado
        implements IOperacionesModelo, IConsultaModelo {

    private final ControlNombres control;
    
    
    

    public FachadaModeloNombres() {
        control = new ControlNombres();
    }

    // Operaciones del modelo

    @Override
    public void procesarNombre(String cadena) {

        control.procesarNombre(cadena);

        notificarObservadores();
    }

    // Consultas al modelo

    @Override
    public Resultado getResultado() {
        return control.getResultado();
    }

    @Override
    public int getCorrectas() {
        return control.getCorrectas();
    }

    @Override
    public int getIncorrectas() {
        return control.getIncorrectas();
    }

    // Administración de observadores

    @Override
    public int getIntentosTotales() {
        return control.getIntentosTotales();
    }

    @Override
    public double getPorcentajeEfectividad() {
        if(getIntentosTotales()==0) return 0.0;
        return ((double) getCorrectas()/getIntentosTotales())*100.0;
    }

    @Override
    public String getMensajeUltimoEstado() {
        return control.getMesajeUltimoEstado();
    }



   
}
