package controlador;

import modelo.IModeloEscritura;

public class ControlConstancia {

    private IModeloEscritura modelo;

    public ControlConstancia(IModeloEscritura modelo) {
        this.modelo = modelo;
    }

    public void buscarAlumnos(String idParcial) {
        modelo.buscarAlumnos(idParcial);
    }

    public void seleccionarAlumno(String idAlumno) {
        modelo.seleccionarAlumno(idAlumno);
    }

    public void generarConstancia() {
        modelo.generarConstancia();
    }
}
