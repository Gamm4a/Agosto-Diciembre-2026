/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;

import controlador.Controlador;
import modelo.IConsultaModelo;
import modelo.Persona;
import modelo.Resultado;
import utilerias.Observador;

import javax.swing.*;
import java.awt.*;

public class VistaNombres extends JFrame implements Observador {

    private Controlador controlador;
    private IConsultaModelo modelo;

    private JTextField txtEntrada;

    private JTextField txtNombre;
    private JTextField txtApellido1;
    private JTextField txtApellido2;

    private JLabel lblMensaje;

    private JButton btnProcesar;

    public VistaNombres() {

        setTitle("Separador de nombres");
        setSize(500, 320);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        crearComponentes();
    }

    private void crearComponentes() {

        setLayout(new BorderLayout(10, 10));

        // -------------------------
        // Captura
        // -------------------------

        JPanel pnlEntrada = new JPanel(new BorderLayout(5, 5));

        pnlEntrada.setBorder(
                BorderFactory.createTitledBorder("Nombre")
        );

        txtEntrada = new JTextField();
        btnProcesar = new JButton("Procesar");

        pnlEntrada.add(txtEntrada, BorderLayout.CENTER);
        pnlEntrada.add(btnProcesar, BorderLayout.EAST);

        add(pnlEntrada, BorderLayout.NORTH);

        // -------------------------
        // Resultado
        // -------------------------

        JPanel pnlResultado = new JPanel(new GridLayout(3, 2, 5, 5));

        pnlResultado.setBorder(
                BorderFactory.createTitledBorder("Nombre separado")
        );

        txtNombre = new JTextField();
        txtApellido1 = new JTextField();
        txtApellido2 = new JTextField();

        // La vista solamente muestra estos datos
        txtNombre.setEditable(false);
        txtApellido1.setEditable(false);
        txtApellido2.setEditable(false);

        pnlResultado.add(new JLabel("Nombre:"));
        pnlResultado.add(txtNombre);

        pnlResultado.add(new JLabel("Primer apellido:"));
        pnlResultado.add(txtApellido1);

        pnlResultado.add(new JLabel("Segundo apellido:"));
        pnlResultado.add(txtApellido2);

        add(pnlResultado, BorderLayout.CENTER);

        // -------------------------
        // Mensaje
        // -------------------------

        lblMensaje = new JLabel(" ");

        add(lblMensaje, BorderLayout.SOUTH);

        // -------------------------
        // Evento
        // -------------------------

        btnProcesar.addActionListener(e -> procesarNombre());
    }

    private void procesarNombre() {

        String cadena = txtEntrada.getText();

        controlador.procesarNombre(cadena);
    }

    // -------------------------
    // Asociaciones
    // -------------------------

    public void setControlador(Controlador controlador) {
        this.controlador = controlador;
    }

    public void setModelo(IConsultaModelo modelo) {
        this.modelo = modelo;
    }

    // -------------------------
    // Observer
    // -------------------------

    @Override
    public void actualizar() {

        Resultado resultado = modelo.getResultado();

        if (resultado == null) {
            return;
        }

        if (resultado.isCorrecto()) {

            Persona persona = resultado.getPersona();

            txtNombre.setText(persona.getNombre());
            txtApellido1.setText(persona.getApellido1());
            txtApellido2.setText(persona.getApellido2());

        } else {

            txtNombre.setText("");
            txtApellido1.setText("");
            txtApellido2.setText("");
        }

        lblMensaje.setText(resultado.getMensaje());
    }
}