package dominio;

public class Alumno {

    private String id;
    private String nombreCompleto;
    private String carrera;

    public Alumno(String id, String nombreCompleto, String carrera) {
        this.id = id;
        this.nombreCompleto = nombreCompleto;
        this.carrera = carrera;
    }

    /**
     * Indica si el ID del alumno empieza con el ID parcial tecleado.
     */
    public boolean coincideConId(String idParcial) {
        return idParcial != null && !idParcial.isEmpty() && id.startsWith(idParcial);
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
}
