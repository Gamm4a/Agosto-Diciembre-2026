/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;

import modelo.IConsultaModelo;
import utilerias.Observador;

import javax.swing.*;
import java.awt.*;

public class VistaIntentos extends JFrame implements Observador {

    private IConsultaModelo modelo;

    private JLabel lblExitosos;
    private JLabel lblFallidos;

    public VistaIntentos() {

        setTitle("Intentos");
        setSize(350, 180);
        // Al cerrar esta ventana NO termina la aplicación
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setLocationRelativeTo(null);

        crearComponentes();
    }

    private void crearComponentes() {

        JPanel panel = new JPanel(
                new GridLayout(2, 2, 10, 10)
        );

        panel.setBorder(
                BorderFactory.createTitledBorder(
                        "Resultados de los intentos"
                )
        );

        lblExitosos = new JLabel("0");
        lblFallidos = new JLabel("0");

        panel.add(new JLabel("Exitosos:"));
        panel.add(lblExitosos);

        panel.add(new JLabel("Fallidos:"));
        panel.add(lblFallidos);

        add(panel);
    }

    // -------------------------
    // Asociación con el modelo
    // -------------------------

    public void setModelo(IConsultaModelo modelo) {
        this.modelo = modelo;
    }

    // -------------------------
    // Observer
    // -------------------------

    @Override
    public void actualizar() {

        lblExitosos.setText(
                String.valueOf(modelo.getCorrectas())
        );

        lblFallidos.setText(
                String.valueOf(modelo.getIncorrectas())
        );
    }
}
