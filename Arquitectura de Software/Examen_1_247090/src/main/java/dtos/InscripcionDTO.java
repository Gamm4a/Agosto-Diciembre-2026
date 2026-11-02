package dtos;

public class InscripcionDTO {

    private String idAlumno;
    private String nombreCompleto;
    private String carrera;
    private String periodo;
    private int semestre;
    private int cantidadMaterias;
    private int totalCreditos;

    public InscripcionDTO(String idAlumno, String nombreCompleto, String carrera, String periodo,
            int semestre, int cantidadMaterias, int totalCreditos) {
        this.idAlumno = idAlumno;
        this.nombreCompleto = nombreCompleto;
        this.carrera = carrera;
        this.periodo = periodo;
        this.semestre = semestre;
        this.cantidadMaterias = cantidadMaterias;
        this.totalCreditos = totalCreditos;
    }

    public String getIdAlumno() {
        return idAlumno;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public String getCarrera() {
        return carrera;
    }

    public String getPeriodo() {
        return periodo;
    }

    public int getSemestre() {
        return semestre;
    }

    public int getCantidadMaterias() {
        return cantidadMaterias;
    }

    public int getTotalCreditos() {
        return totalCreditos;
    }
}
