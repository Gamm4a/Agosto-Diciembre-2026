package vista;

import controlador.ControlConstancia;
import dtos.AlumnoDTO;
import dtos.ConstanciaDTO;
import dtos.InscripcionDTO;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import modelo.IModeloLectura;

public class FrmGenerarConstancia extends JFrame implements IObservador {

    private JTextField txtIdAlumno;
    private JList<AlumnoDTO> lstAlumnos;
    private JPanel pnlDatos;
    private JTextArea txtConstancia;
    private JButton btnGenerarConstancia;
    private ControlConstancia control;
    private IModeloLectura modelo;

    public FrmGenerarConstancia(ControlConstancia control, IModeloLectura modelo) {
        this.control = control;
        this.modelo = modelo;

        setTitle("Generar Constancia de Alumno Inscrito");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(920, 600);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        // Zona izquierda: captura del ID
        JPanel pnlCaptura = new JPanel();
        pnlCaptura.setLayout(new BoxLayout(pnlCaptura, BoxLayout.Y_AXIS));
        pnlCaptura.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 5));
        JLabel lblTitulo = new JLabel("Constancia de alumno inscrito");
        lblTitulo.setFont(lblTitulo.getFont().deriveFont(Font.BOLD, 16f));
        JLabel lblId = new JLabel("ID del alumno:");
        txtIdAlumno = new JTextField(14);
        txtIdAlumno.setMaximumSize(new Dimension(220, 30));
        txtIdAlumno.setFont(txtIdAlumno.getFont().deriveFont(15f));
        txtIdAlumno.setAlignmentX(LEFT_ALIGNMENT);
        txtIdAlumno.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent evt) {
                txtIdAlumnoKeyReleased(evt);
            }
        });

        pnlCaptura.add(lblTitulo);
        pnlCaptura.add(javax.swing.Box.createVerticalStrut(20));
        pnlCaptura.add(lblId);
        pnlCaptura.add(javax.swing.Box.createVerticalStrut(5));
        pnlCaptura.add(txtIdAlumno);
        pnlCaptura.add(javax.swing.Box.createVerticalStrut(10));
        add(pnlCaptura, BorderLayout.WEST);

        // Zona derecha arriba: coincidencias
        lstAlumnos = new JList<>(new DefaultListModel<>());
        lstAlumnos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        lstAlumnos.addListSelectionListener(this::lstAlumnosValueChanged);
        JScrollPane scrAlumnos = new JScrollPane(lstAlumnos);
        scrAlumnos.setBorder(BorderFactory.createTitledBorder("Alumnos que coinciden con el ID"));

        // Zona derecha abajo: datos de confirmación / constancia
        pnlDatos = new JPanel(new BorderLayout());
        pnlDatos.setBorder(BorderFactory.createTitledBorder("Datos de confirmación"));
        txtConstancia = new JTextArea();
        txtConstancia.setEditable(false);
        txtConstancia.setLineWrap(true);
        txtConstancia.setWrapStyleWord(true);
        txtConstancia.setFont(new Font(Font.SERIF, Font.PLAIN, 14));
        txtConstancia.setBorder(BorderFactory.createEmptyBorder(10, 15, 10, 15));
        btnGenerarConstancia = new JButton("Generar Constancia");
        btnGenerarConstancia.addActionListener(this::btnGenerarConstanciaActionPerformed);

        JSplitPane split = new JSplitPane(JSplitPane.VERTICAL_SPLIT, scrAlumnos, pnlDatos);
        split.setDividerLocation(180);
        split.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 10));
        add(split, BorderLayout.CENTER);

        actualizar();
    }

    private void txtIdAlumnoKeyReleased(KeyEvent evt) {
        control.buscarAlumnos(txtIdAlumno.getText().trim());
    }

    private void lstAlumnosValueChanged(ListSelectionEvent evt) {
        AlumnoDTO seleccionado = lstAlumnos.getSelectedValue();
        if (evt.getValueIsAdjusting() || seleccionado == null) {
            return;
        }
        try {
            control.seleccionarAlumno(seleccionado.getId());
        } catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Aviso", JOptionPane.WARNING_MESSAGE);
        }
    }

    private void btnGenerarConstanciaActionPerformed(ActionEvent evt) {
        try {
            control.generarConstancia();
        } catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Aviso", JOptionPane.WARNING_MESSAGE);
        }
    }


    @Override
    public void actualizar() {
        mostrarCoincidencias(modelo.getCoincidencias());
        if (modelo.getConstancia() != null) {
            mostrarConstancia(modelo.getConstancia());
        } else if (modelo.getDatosConfirmacion() != null) {
            mostrarDatosConfirmacion(modelo.getDatosConfirmacion());
        } else {
            pnlDatos.removeAll();
            pnlDatos.setBorder(BorderFactory.createTitledBorder("Datos de confirmación"));
            pnlDatos.revalidate();
            pnlDatos.repaint();
        }
    }

    private void mostrarCoincidencias(List<AlumnoDTO> alumnos) {
        // Si la lista no cambió se deja igual para no perder la selección actual
        ListModel<AlumnoDTO> actual = lstAlumnos.getModel();
        boolean igual = actual.getSize() == alumnos.size();
        for (int i = 0; igual && i < alumnos.size(); i++) {
            igual = actual.getElementAt(i) == alumnos.get(i);
        }
        if (igual) {
            return;
        }
        DefaultListModel<AlumnoDTO> nuevo = new DefaultListModel<>();
        for (AlumnoDTO alumno : alumnos) {
            nuevo.addElement(alumno);
        }
        lstAlumnos.setModel(nuevo);
    }

    private void mostrarDatosConfirmacion(InscripcionDTO datos) {
        JPanel pnlCampos = new JPanel(new GridLayout(0, 2, 10, 8));
        pnlCampos.setBorder(BorderFactory.createEmptyBorder(10, 15, 10, 15));
        String[][] campos = {
            {"ID:", datos.getIdAlumno()},
            {"Nombre:", datos.getNombreCompleto()},
            {"Carrera:", datos.getCarrera()},
            {"Periodo:", datos.getPeriodo()},
            {"Semestre inscrito:", datos.getSemestre() + "°"},
            {"Cantidad de materias:", String.valueOf(datos.getCantidadMaterias())},
            {"Créditos inscritos:", String.valueOf(datos.getTotalCreditos())}
        };
        for (String[] campo : campos) {
            JLabel etiqueta = new JLabel(campo[0]);
            etiqueta.setFont(etiqueta.getFont().deriveFont(Font.BOLD));
            pnlCampos.add(etiqueta);
            pnlCampos.add(new JLabel(campo[1]));
        }
        JPanel pnlBoton = new JPanel();
        pnlBoton.add(btnGenerarConstancia);

        pnlDatos.removeAll();
        pnlDatos.setBorder(BorderFactory.createTitledBorder("Datos de confirmación"));
        pnlDatos.add(pnlCampos, BorderLayout.NORTH);
        pnlDatos.add(pnlBoton, BorderLayout.SOUTH);
        pnlDatos.revalidate();
        pnlDatos.repaint();
    }

    private void mostrarConstancia(ConstanciaDTO constancia) {
        txtConstancia.setText(constancia.getTexto());
        txtConstancia.setCaretPosition(0);

        pnlDatos.removeAll();
        pnlDatos.setBorder(BorderFactory.createTitledBorder("Constancia  (folio " + constancia.getFolio()
                + ", emitida el " + constancia.getFechaEmision() + ")"));
        pnlDatos.add(new JScrollPane(txtConstancia), BorderLayout.CENTER);
        pnlDatos.revalidate();
        pnlDatos.repaint();
    }
}
