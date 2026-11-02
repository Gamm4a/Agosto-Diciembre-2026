package dominio;

import java.util.ArrayList;
import java.util.List;

public class Inscripcion {

    private Alumno alumno;
    private String periodo;
    private int semestre;
    private List<Materia> materias;

    public Inscripcion(Alumno alumno, String periodo, int semestre, List<Materia> materias) {
        this.alumno = alumno;
        this.periodo = periodo;
        this.semestre = semestre;
        this.materias = new ArrayList<>(materias);
    }

    public int getCantidadMaterias() {
        return materias.size();
    }

    public int getTotalCreditos() {
        int total = 0;
        for (Materia materia : materias) {
            total += materia.getCreditos();
        }
        return total;
    }

    public String getPeriodo() {
        return periodo;
    }

    public int getSemestre() {
        return semestre;
    }

    public Alumno getAlumno() {
        return alumno;
    }
}
