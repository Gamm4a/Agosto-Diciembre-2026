package negocio;

import dominio.Alumno;
import dominio.Constancia;
import dominio.Inscripcion;
import dtos.AlumnoDTO;
import dtos.ConstanciaDTO;
import dtos.InscripcionDTO;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import persistencia.AlumnoDAO;
import persistencia.InscripcionDAO;

public class FachadaNegocio implements IFachadaNegocio {

    private AlumnoBO alumnoBO;
    private InscripcionBO inscripcionBO;
    private ConstanciaBO constanciaBO;

    public FachadaNegocio() {
        AlumnoDAO alumnoDAO = new AlumnoDAO();
        InscripcionDAO inscripcionDAO = new InscripcionDAO(alumnoDAO);
        this.alumnoBO = new AlumnoBO(alumnoDAO);
        this.inscripcionBO = new InscripcionBO(inscripcionDAO);
        this.constanciaBO = new ConstanciaBO();
    }

    @Override
    public List<AlumnoDTO> buscarAlumnosPorIdParcial(String idParcial) {
        List<AlumnoDTO> coincidencias = new ArrayList<>();
        for (Alumno alumno : alumnoBO.buscarPorIdParcial(idParcial)) {
            coincidencias.add(aAlumnoDTO(alumno));
        }
        return coincidencias;
    }

    @Override
    public InscripcionDTO obtenerDatosConfirmacion(String idAlumno) {
        Inscripcion inscripcion = inscripcionBO.obtenerInscripcionActual(idAlumno);
        return aInscripcionDTO(inscripcion);
    }

    @Override
    public ConstanciaDTO generarConstancia(String idAlumno) {
        Alumno alumno = alumnoBO.obtenerPorId(idAlumno);
        Inscripcion inscripcion = inscripcionBO.obtenerInscripcionActual(idAlumno);
        Constancia constancia = constanciaBO.generar(alumno, inscripcion);
        return aConstanciaDTO(constancia);
    }

    private AlumnoDTO aAlumnoDTO(Alumno alumno) {
        return new AlumnoDTO(alumno.getId(), alumno.getNombreCompleto(), alumno.getCarrera());
    }

    private InscripcionDTO aInscripcionDTO(Inscripcion inscripcion) {
        Alumno alumno = inscripcion.getAlumno();
        return new InscripcionDTO(alumno.getId(), alumno.getNombreCompleto(), alumno.getCarrera(),
                inscripcion.getPeriodo(), inscripcion.getSemestre(),
                inscripcion.getCantidadMaterias(), inscripcion.getTotalCreditos());
    }

    private ConstanciaDTO aConstanciaDTO(Constancia constancia) {
        String fecha = constancia.getFechaEmision().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        return new ConstanciaDTO(constancia.getFolio(), fecha, constancia.generarTexto());
    }
}
