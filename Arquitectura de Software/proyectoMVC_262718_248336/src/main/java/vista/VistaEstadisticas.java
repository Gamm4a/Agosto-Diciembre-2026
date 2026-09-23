
package vista;

import modelo.IConsultaModelo;
import utilerias.Observador;

import javax.swing.*;
import java.awt.*;

/**
 *
 * @author piña
 */
public class VistaEstadisticas extends JFrame implements Observador{
    
    private IConsultaModelo modelo;
    
    private JLabel lblTotales;
    private JLabel lblExitosos;
    private JLabel lblFallidos;
    private JLabel lblPorcentaje;
    private JLabel lblUltimoResultado;
    
    public void setModelo(IConsultaModelo modelo){
        this.modelo = modelo;
    }
    
    public VistaEstadisticas(){
        initComponents();
       
        setTitle("Vista de Estadisticas - Interpretacion");
        setSize(900,200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(5,1,5,5));
        
        
        
    }
    
    private void initComponents(){
       
        lblTotales=new JLabel("Total de intentos: 0", SwingConstants.CENTER);
        lblExitosos= new JLabel("Interpretaciones exitosas: 0", SwingConstants.CENTER);
        lblFallidos= new JLabel("Interpretaciones fallidad: 0", SwingConstants.CENTER);
        lblPorcentaje= new JLabel("Porcentaje de exito 0.0%", SwingConstants.CENTER);
        lblUltimoResultado= new JLabel("Ultimo estado: Sin interpretacion", SwingConstants.CENTER);
        
        add(lblTotales);
        add(lblExitosos);
        add(lblFallidos);
        add(lblPorcentaje);
        add(lblUltimoResultado);
    }

    @Override
    public void actualizar() {
        if(modelo != null){
            lblTotales.setText("Total de intentos: "+ modelo.getIntentosTotales());
            lblExitosos.setText("Interpretaciones exitosas: "+modelo.getCorrectas());
            lblFallidos.setText("Interpretaciones fallidad: "+modelo.getIncorrectas());
            lblPorcentaje.setText(String.format("Porcentaje de exito: %.1f%%", modelo.getPorcentajeEfectividad()));
            lblUltimoResultado.setText("Ultimo estado: "+modelo.getMensajeUltimoEstado());
        }
    }
    
    
    
}
