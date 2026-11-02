package dtos;

public class AlumnoDTO {

    private String id;
    private String nombreCompleto;
    private String carrera;

    public AlumnoDTO(String id, String nombreCompleto, String carrera) {
        this.id = id;
        this.nombreCompleto = nombreCompleto;
        this.carrera = carrera;
    }

    public String getId() {
        return id;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public String getCarrera() {
        return carrera;
    }

    @Override
    public String toString() {
        return id + " - " + nombreCompleto;
    }
}
