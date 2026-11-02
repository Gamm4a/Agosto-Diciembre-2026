package modelo;

import dtos.AlumnoDTO;
import dtos.ConstanciaDTO;
import dtos.InscripcionDTO;
import java.util.ArrayList;
import java.util.List;
import negocio.IFachadaNegocio;
import vista.IObservador;


public class ModeloConstancia implements IModeloLectura, IModeloEscritura {

    private List<IObservador> observadores;
    private IFachadaNegocio negocio;
    private List<AlumnoDTO> coincidencias;
    private String idAlumnoSeleccionado;
    private InscripcionDTO datosConfirmacion;
    private ConstanciaDTO constancia;

    public ModeloConstancia(IFachadaNegocio negocio) {
        this.negocio = negocio;
        this.observadores = new ArrayList<>();
        this.coincidencias = new ArrayList<>();
    }

    @Override
    public void buscarAlumnos(String idParcial) {
        coincidencias = negocio.buscarAlumnosPorIdParcial(idParcial);
        idAlumnoSeleccionado = null;
        datosConfirmacion = null;
        constancia = null;
        notificarObservadores();
    }

    @Override
    public void seleccionarAlumno(String idAlumno) {
        idAlumnoSeleccionado = idAlumno;
        datosConfirmacion = negocio.obtenerDatosConfirmacion(idAlumno);
        constancia = null;
        notificarObservadores();
    }

    @Override
    public void generarConstancia() {
        if (idAlumnoSeleccionado == null) {
            return;
        }
        constancia = negocio.generarConstancia(idAlumnoSeleccionado);
        notificarObservadores();
    }

    @Override
    public List<AlumnoDTO> getCoincidencias() {
        return coincidencias;
    }

    @Override
    public InscripcionDTO getDatosConfirmacion() {
        return datosConfirmacion;
    }

    @Override
    public ConstanciaDTO getConstancia() {
        return constancia;
    }

    @Override
    public void agregarObservador(IObservador observador) {
        observadores.add(observador);
    }

    private void notificarObservadores() {
        for (IObservador observador : observadores) {
            observador.actualizar();
        }
    }
}
