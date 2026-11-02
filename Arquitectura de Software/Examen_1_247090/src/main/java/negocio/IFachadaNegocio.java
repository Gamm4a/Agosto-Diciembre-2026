package negocio;

import dtos.AlumnoDTO;
import dtos.ConstanciaDTO;
import dtos.InscripcionDTO;
import java.util.List;


public interface IFachadaNegocio {

    List<AlumnoDTO> buscarAlumnosPorIdParcial(String idParcial);

    InscripcionDTO obtenerDatosConfirmacion(String idAlumno);

    ConstanciaDTO generarConstancia(String idAlumno);
}
