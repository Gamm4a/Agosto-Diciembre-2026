package persistencia;

import dominio.Alumno;
import java.util.List;

public interface IAlumnoDAO {

    List<Alumno> buscarPorPrefijoId(String prefijo);

    Alumno buscarPorId(String id);
}
