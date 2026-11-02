package dominio;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Constancia {

    private String folio;
    private LocalDate fechaEmision;
    private Alumno alumno;
    private Inscripcion inscripcion;

    public Constancia(String folio, LocalDate fechaEmision, Alumno alumno, Inscripcion inscripcion) {
        this.folio = folio;
        this.fechaEmision = fechaEmision;
        this.alumno = alumno;
        this.inscripcion = inscripcion;
    }

    /**
     * Genera el texto de la constancia que se muestra al encargado.
     */
    public String generarTexto() {
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("d 'de' MMMM 'de' yyyy", Locale.forLanguageTag("es-MX"));
        return "INSTITUTO TECNOLÓGICO DE SONORA\n"
                + "Departamento de Servicios Escolares\n\n"
                + "CONSTANCIA DE ALUMNO INSCRITO\n"
                + "Folio: " + folio + "\n\n"
                + "A quien corresponda:\n\n"
                + "Por medio de la presente se hace constar que " + alumno.getNombreCompleto()
                + ", con ID " + alumno.getId() + ", es alumno(a) del programa de "
                + alumno.getCarrera() + " y se encuentra inscrito(a) en el periodo "
                + inscripcion.getPeriodo() + ", cursando el " + inscripcion.getSemestre()
                + "° semestre con " + inscripcion.getCantidadMaterias() + " materias ("
                + inscripcion.getTotalCreditos() + " créditos).\n\n"
                + "Se extiende la presente para los fines que al interesado convengan.\n\n"
                + "Ciudad Obregón, Sonora, a " + fechaEmision.format(formato) + ".\n\n\n"
                + "______________________________\n"
                + "Servicios Escolares";
    }

    public String getFolio() {
        return folio;
    }

    public LocalDate getFechaEmision() {
        return fechaEmision;
    }
}
