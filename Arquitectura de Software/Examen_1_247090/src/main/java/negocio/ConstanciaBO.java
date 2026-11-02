package negocio;

import dominio.Alumno;
import dominio.Constancia;
import dominio.Inscripcion;
import java.time.LocalDate;

public class ConstanciaBO {

    private int consecutivo;

    public Constancia generar(Alumno alumno, Inscripcion inscripcion) {
        return new Constancia(generarFolio(), LocalDate.now(), alumno, inscripcion);
    }

    private String generarFolio() {
        consecutivo++;
        return String.format("CONST-%d-%04d", LocalDate.now().getYear(), consecutivo);
    }
}
