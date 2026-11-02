package negocio;

import dominio.Inscripcion;
import persistencia.IInscripcionDAO;

public class InscripcionBO {

    private IInscripcionDAO inscripcionDAO;

    public InscripcionBO(IInscripcionDAO inscripcionDAO) {
        this.inscripcionDAO = inscripcionDAO;
    }

    public Inscripcion obtenerInscripcionActual(String idAlumno) {
        Inscripcion inscripcion = inscripcionDAO.buscarInscripcionActual(idAlumno);
        if (inscripcion == null) {
            throw new IllegalArgumentException("El alumno " + idAlumno + " no está inscrito en el periodo actual");
        }
        return inscripcion;
    }
}
