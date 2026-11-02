package persistencia;

import dominio.Inscripcion;
import dominio.Materia;
import java.util.ArrayList;
import java.util.List;

public class InscripcionDAO implements IInscripcionDAO {

    private static final String PERIODO_ACTUAL = "Agosto-Diciembre 2026";

    private List<Inscripcion> inscripciones;

    public InscripcionDAO(IAlumnoDAO alumnoDAO) {
        Materia disenoSoftware = new Materia("ISW301", "Diseño de Software", 8);
        Materia baseDatos = new Materia("ISW302", "Bases de Datos Avanzadas", 8);
        Materia moviles = new Materia("ISW303", "Aplicaciones Móviles", 8);
        Materia empotrados = new Materia("ISW304", "Sistemas Empotrados", 6);
        Materia ingles = new Materia("ING200", "Inglés Intermedio", 4);
        Materia calculo = new Materia("MAT101", "Cálculo Diferencial", 8);
        Materia programacion = new Materia("ISW101", "Programación I", 8);
        Materia dibujo = new Materia("DG201", "Dibujo Digital", 6);
        Materia admin = new Materia("ADM301", "Administración Financiera", 8);

        inscripciones = new ArrayList<>();
        inscripciones.add(new Inscripcion(alumnoDAO.buscarPorId("247001"), PERIODO_ACTUAL, 5,
                List.of(disenoSoftware, baseDatos, moviles, empotrados, ingles)));
        inscripciones.add(new Inscripcion(alumnoDAO.buscarPorId("247015"), PERIODO_ACTUAL, 5,
                List.of(disenoSoftware, baseDatos, moviles, ingles)));
        inscripciones.add(new Inscripcion(alumnoDAO.buscarPorId("247023"), PERIODO_ACTUAL, 5,
                List.of(baseDatos, ingles, admin)));
        inscripciones.add(new Inscripcion(alumnoDAO.buscarPorId("247088"), PERIODO_ACTUAL, 5,
                List.of(disenoSoftware, moviles, empotrados)));
        inscripciones.add(new Inscripcion(alumnoDAO.buscarPorId("247102"), PERIODO_ACTUAL, 5,
                List.of(dibujo, ingles)));
        inscripciones.add(new Inscripcion(alumnoDAO.buscarPorId("247130"), PERIODO_ACTUAL, 5,
                List.of(empotrados, calculo, ingles)));
        inscripciones.add(new Inscripcion(alumnoDAO.buscarPorId("248004"), PERIODO_ACTUAL, 3,
                List.of(programacion, calculo, ingles)));
        inscripciones.add(new Inscripcion(alumnoDAO.buscarPorId("248056"), PERIODO_ACTUAL, 3,
                List.of(calculo, ingles)));
        inscripciones.add(new Inscripcion(alumnoDAO.buscarPorId("239110"), PERIODO_ACTUAL, 9,
                List.of(disenoSoftware, empotrados)));
        inscripciones.add(new Inscripcion(alumnoDAO.buscarPorId("239145"), PERIODO_ACTUAL, 9,
                List.of(admin)));
    }

    @Override
    public Inscripcion buscarInscripcionActual(String idAlumno) {
        for (Inscripcion inscripcion : inscripciones) {
            if (inscripcion.getAlumno().getId().equals(idAlumno)) {
                return inscripcion;
            }
        }
        return null;
    }
}
