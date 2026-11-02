package main;

import controlador.ControlConstancia;
import javax.swing.SwingUtilities;
import modelo.ModeloConstancia;
import negocio.FachadaNegocio;
import vista.FrmGenerarConstancia;

public class Main {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            FachadaNegocio negocio = new FachadaNegocio();
            ModeloConstancia modelo = new ModeloConstancia(negocio);
            ControlConstancia control = new ControlConstancia(modelo);
            FrmGenerarConstancia frm = new FrmGenerarConstancia(control, modelo);
            modelo.agregarObservador(frm);
            frm.setVisible(true);
        });
    }
}
