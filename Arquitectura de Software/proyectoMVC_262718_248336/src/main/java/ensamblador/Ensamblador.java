/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ensamblador;

import controlador.Controlador;
import modelo.FachadaModeloNombres;
import vista.VistaEstadisticas;
import vista.VistaIntentos;
import vista.VistaNombres;

public class Ensamblador {

    public void ensamblar() {

        // ========================================
        // 1. Crear los objetos
        // ========================================

        FachadaModeloNombres modelo =
                new FachadaModeloNombres();

        Controlador controlador =
                new Controlador();

        VistaNombres vistaNombres =
                new VistaNombres();

        VistaIntentos vistaIntentos =
                new VistaIntentos();
        
        VistaEstadisticas vistaEstadisticas =
                new VistaEstadisticas();


        // ========================================
        // 2. Establecer las asociaciones
        // ========================================

        // Controlador -> Modelo
        controlador.setModelo(modelo);

        // VistaNombres -> Controlador
        vistaNombres.setControlador(controlador);

        // Vistas -> Modelo
        vistaNombres.setModelo(modelo);
        vistaIntentos.setModelo(modelo);
        vistaEstadisticas.setModelo(modelo); 

        // Modelo -> Observadores
        modelo.agregarObservador(vistaNombres);
        modelo.agregarObservador(vistaIntentos);
        modelo.agregarObservador(vistaEstadisticas);


        // ========================================
        // 3. Mostrar las vistas
        // ========================================

        vistaNombres.setVisible(true);
        vistaIntentos.setVisible(true);
        vistaEstadisticas.setVisible(true);
    }
}