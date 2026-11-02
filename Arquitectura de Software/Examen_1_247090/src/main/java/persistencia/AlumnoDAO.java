package persistencia;

import dominio.Alumno;
import java.util.ArrayList;
import java.util.List;

public class AlumnoDAO implements IAlumnoDAO {

    private List<Alumno> alumnos;

    public AlumnoDAO() {
        alumnos = new ArrayList<>();
        alumnos.add(new Alumno("247001", "Ana Sofía Valenzuela Ruiz", "Ingeniería en Software"));
        alumnos.add(new Alumno("247015", "Luis Fernando Castro Ochoa", "Ingeniería en Software"));
        alumnos.add(new Alumno("247023", "María José Félix Armenta", "Ingeniería en Sistemas de Información"));
        alumnos.add(new Alumno("247088", "Carlos Iván Mendívil López", "Ingeniería en Software"));
        alumnos.add(new Alumno("247102", "Daniela Moreno Espinoza", "Licenciatura en Diseño Gráfico"));
        alumnos.add(new Alumno("247130", "Jesús Alberto Leyva Soto", "Ingeniería Mecatrónica"));
        alumnos.add(new Alumno("248004", "Paola Guadalupe Ibarra Torres", "Ingeniería en Software"));
        alumnos.add(new Alumno("248056", "Ricardo Esquer Navarro", "Ingeniería Industrial"));
        alumnos.add(new Alumno("239110", "Fernanda Yocupicio Bojórquez", "Ingeniería en Software"));
        alumnos.add(new Alumno("239145", "Óscar Manuel Salazar Gil", "Licenciatura en Administración"));
    }

    @Override
    public List<Alumno> buscarPorPrefijoId(String prefijo) {
        List<Alumno> encontrados = new ArrayList<>();
        for (Alumno alumno : alumnos) {
            if (alumno.coincideConId(prefijo)) {
                encontrados.add(alumno);
            }
        }
        return encontrados;
    }

    @Override
    public Alumno buscarPorId(String id) {
        for (Alumno alumno : alumnos) {
            if (alumno.getId().equals(id)) {
                return alumno;
            }
        }
        return null;
    }
}
