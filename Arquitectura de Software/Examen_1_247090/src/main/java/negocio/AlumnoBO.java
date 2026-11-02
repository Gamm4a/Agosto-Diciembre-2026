package negocio;

import dominio.Alumno;
import java.util.ArrayList;
import java.util.List;
import persistencia.IAlumnoDAO;

public class AlumnoBO {

    private IAlumnoDAO alumnoDAO;

    public AlumnoBO(IAlumnoDAO alumnoDAO) {
        this.alumnoDAO = alumnoDAO;
    }

    /**
     * Regresa los alumnos cuyo ID empieza con lo tecleado. Si no se ha tecleado nada, la lista va vacía.
     */
    public List<Alumno> buscarPorIdParcial(String idParcial) {
        if (idParcial == null || idParcial.isBlank()) {
            return new ArrayList<>();
        }
        return alumnoDAO.buscarPorPrefijoId(idParcial.trim());
    }

    public Alumno obtenerPorId(String idAlumno) {
        Alumno alumno = alumnoDAO.buscarPorId(idAlumno);
        if (alumno == null) {
            throw new IllegalArgumentException("No existe un alumno con ID " + idAlumno);
        }
        return alumno;
    }
}
