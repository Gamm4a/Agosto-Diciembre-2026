package persistencia;

import dominio.Inscripcion;

public interface IInscripcionDAO {

    Inscripcion buscarInscripcionActual(String idAlumno);
}
