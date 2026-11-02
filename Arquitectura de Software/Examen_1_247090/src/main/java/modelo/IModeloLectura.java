package modelo;

import dtos.AlumnoDTO;
import dtos.ConstanciaDTO;
import dtos.InscripcionDTO;
import java.util.List;
import vista.IObservador;

public interface IModeloLectura {

    List<AlumnoDTO> getCoincidencias();

    InscripcionDTO getDatosConfirmacion();

    ConstanciaDTO getConstancia();

    void agregarObservador(IObservador observador);
}
