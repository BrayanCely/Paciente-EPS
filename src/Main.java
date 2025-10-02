import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

// Se crean las listas donde se guarden los datos

public class Main {
    private static ArrayList<Usuario> usuarios = new ArrayList<>();
    private static ArrayList<Cita> citas = new ArrayList<>();
    private static ArrayList<Medico> medicos = new ArrayList<>();
    private static Usuario usuarioLogueado;
    private static final Color COLOR_NARANJA = new Color(255, 165, 0);
    private static final Color COLOR_NARANJA_CLARO = new Color(255, 200, 100);

    // Damos la bienvenida

    public static void main(String[] args) {
        cargarDatosEjemplo();
        mostrarVentanaBienvenida();
    }

    // Se muestran los medicos y la informacion del ususario registrado

    private static void cargarDatosEjemplo() {
    
        medicos.add(new Medico("GIOVANNI A. BRICEÑO", "Medicina familiar", "10:00 AM - 1:00 PM"));
        medicos.add(new Medico("MILLER LOZANO RIVERA", "Cardiologia", "7:00 AM - 10:00 PM"));
        medicos.add(new Medico("JULIO DAVID GIL", "Optometria", "2:00 PM - 4:00 PM"));
        medicos.add(new Medico("CARLOS ANDRES PLAZAS", "Radiografías", "4:00 PM - 6:00 PM"));
        medicos.add(new Medico("RODRIGO CASTRO", "Pediatra", "6:00 PM - 8:00 PM"));

        
        usuarios.add(new Usuario("BRAYAN ANDRES CELY SILVA", "1990-01-01", "1029143933", "12345", "AC 26 66 A 48 TO A P 6 CS 616", "1234567", "brayan@email.com"));
    }

        // Damos una introduccion a nuestro programa

    private static void mostrarVentanaBienvenida() {
        JFrame frame = new JFrame("EPS");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 400);
        frame.setLayout(new BorderLayout());
        frame.getContentPane().setBackground(Color.WHITE);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        panel.setBackground(Color.WHITE);

        JLabel titulo = new JLabel("EPS", SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 24));
        titulo.setForeground(COLOR_NARANJA);
        titulo.setAlignmentX(Component.CENTER_ALIGNMENT);

        JTextArea textoBienvenida = new JTextArea();
        textoBienvenida.setText("¡Descubre nuestro Plan Ideal y elige la modalidad que más se adapte a ti!\n\n" +
                "Más de 10 años brindando ayudas\n" +
                "4 sedes prestando la atención al cliente\n" +
                "Manejamos los mejores especialistas\n\n" +
                "Variedad de centros médicos\n" +
                "Utilizamos la última tecnología");
        textoBienvenida.setEditable(false);
        textoBienvenida.setBackground(Color.WHITE);
        textoBienvenida.setFont(new Font("Arial", Font.PLAIN, 14));
        textoBienvenida.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton btnContinuar = new JButton("CONTINUAR");
        btnContinuar.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnContinuar.setBackground(COLOR_NARANJA);
        btnContinuar.setForeground(Color.WHITE);
        btnContinuar.setFont(new Font("Arial", Font.BOLD, 14));

        btnContinuar.addActionListener(e -> {
            frame.dispose();
            mostrarVentanaInicio();
        });

        panel.add(titulo);
        panel.add(Box.createRigidArea(new Dimension(0, 20)));
        panel.add(textoBienvenida);
        panel.add(Box.createRigidArea(new Dimension(0, 20)));
        panel.add(btnContinuar);

        frame.add(panel, BorderLayout.CENTER);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    // El registro

    private static void mostrarVentanaInicio() {
        JFrame frame = new JFrame("EPS");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new BorderLayout());
        frame.getContentPane().setBackground(Color.WHITE);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 1, 10, 10));
        panel.setBackground(Color.WHITE);

        JLabel titulo = new JLabel("EPS", SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 24));
        titulo.setForeground(COLOR_NARANJA);

        JButton btnLogin = new JButton("INICIAR SESIÓN");
        JButton btnRegistro = new JButton("REGISTRO");

        
        estiloBotonNaranja(btnLogin);
        estiloBotonNaranja(btnRegistro);

        btnLogin.addActionListener(e -> {
            frame.dispose();
            mostrarLogin();
        });

        btnRegistro.addActionListener(e -> {
            frame.dispose();
            mostrarRegistro();
        });

        panel.add(titulo);
        panel.add(btnLogin);
        panel.add(btnRegistro);

        frame.add(panel, BorderLayout.CENTER);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    // Hacemos una personalizacion de colores para que se adecue más al prototipo planteado

    private static void estiloBotonNaranja(JButton boton) {
        boton.setBackground(COLOR_NARANJA);
        boton.setForeground(Color.WHITE);
        boton.setFont(new Font("Arial", Font.BOLD, 14));
        boton.setFocusPainted(false);
        boton.setBorder(BorderFactory.createRaisedBevelBorder());
    }

    // Mostrar el inicio de sesion

    private static void mostrarLogin() {
        JFrame frame = new JFrame("EPS");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 350);
        frame.setLayout(new BorderLayout());
        frame.getContentPane().setBackground(Color.WHITE);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        panel.setBackground(Color.WHITE);

        JLabel titulo = new JLabel("INICIO SESIÓN", SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 20));
        titulo.setForeground(COLOR_NARANJA);
        titulo.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel lblTipoDocumento = new JLabel("Tipo de documento:");
        lblTipoDocumento.setAlignmentX(Component.LEFT_ALIGNMENT);

        JComboBox<String> comboTipoDocumento = new JComboBox<>(new String[]{"Cédula de Ciudadanía"});
        comboTipoDocumento.setAlignmentX(Component.LEFT_ALIGNMENT);

        JLabel lblDocumento = new JLabel("Número de documento:");
        lblDocumento.setAlignmentX(Component.LEFT_ALIGNMENT);

        JTextField txtDocumento = new JTextField();
        txtDocumento.setAlignmentX(Component.LEFT_ALIGNMENT);

        JLabel lblPassword = new JLabel("Contraseña:");
        lblPassword.setAlignmentX(Component.LEFT_ALIGNMENT);

        JPasswordField txtPassword = new JPasswordField();
        txtPassword.setAlignmentX(Component.LEFT_ALIGNMENT);

        JButton btnLogin = new JButton("INICIAR SESIÓN");
        btnLogin.setAlignmentX(Component.CENTER_ALIGNMENT);
        estiloBotonNaranja(btnLogin);

        JButton btnRegistro = new JButton("REGISTRO");
        btnRegistro.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnRegistro.setBackground(Color.LIGHT_GRAY);
        btnRegistro.setFont(new Font("Arial", Font.PLAIN, 12));

        btnLogin.addActionListener(e -> {
            String documento = txtDocumento.getText();
            String password = new String(txtPassword.getPassword());

            if (autenticarUsuario(documento, password)) {
                JOptionPane.showMessageDialog(frame, "¡Bienvenido " + usuarioLogueado.getNombreCompleto() + "!");
                frame.dispose();
                mostrarMenuPrincipal();
            } else {
                JOptionPane.showMessageDialog(frame, "Documento o contraseña incorrectos");
            }
        });

        btnRegistro.addActionListener(e -> {
            frame.dispose();
            mostrarRegistro();
        });

        panel.add(titulo);
        panel.add(Box.createRigidArea(new Dimension(0, 20)));
        panel.add(lblTipoDocumento);
        panel.add(comboTipoDocumento);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        panel.add(lblDocumento);
        panel.add(txtDocumento);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        panel.add(lblPassword);
        panel.add(txtPassword);
        panel.add(Box.createRigidArea(new Dimension(0, 20)));
        panel.add(btnLogin);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        panel.add(btnRegistro);

        frame.add(panel, BorderLayout.CENTER);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    // Buscamos en la lista, si se encuentra se asigna usuarioLogueado, si no se retorna 

    private static boolean autenticarUsuario(String documento, String password) {
        for (Usuario usuario : usuarios) {
            if (usuario.getNumeroIdentificacion().equals(documento) &&
                    usuario.getContrasena().equals(password)) {
                usuarioLogueado = usuario;
                return true;
            }
        }
        return false;
    }

    // Mostramos el registro con informacion  del paciente 

    private static void mostrarRegistro() {
        JFrame frame = new JFrame("EPS");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 500);
        frame.setLayout(new BorderLayout());
        frame.getContentPane().setBackground(Color.WHITE);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        panel.setBackground(Color.WHITE);

        JLabel titulo = new JLabel("REGISTRO", SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 20));
        titulo.setForeground(COLOR_NARANJA);
        titulo.setAlignmentX(Component.CENTER_ALIGNMENT);

    
        JLabel lblNombre = new JLabel("Nombre completo:");
        JTextField txtNombre = new JTextField();

        JLabel lblFecha = new JLabel("Fecha de nacimiento:");
        JTextField txtFecha = new JTextField();

        JLabel lblDocumento = new JLabel("No. identificación:");
        JTextField txtDocumento = new JTextField();

        JLabel lblPassword = new JLabel("Crea la contraseña: (Mínimo 5 caracteres)");
        JPasswordField txtPassword = new JPasswordField();

        JLabel lblBarrio = new JLabel("Barrio:");
        JTextField txtBarrio = new JTextField();

        JLabel lblTelefono = new JLabel("Teléfono:");
        JTextField txtTelefono = new JTextField();

        JLabel lblEmail = new JLabel("Correo:");
        JTextField txtEmail = new JTextField();

        JButton btnRegistrar = new JButton("REGISTRARME");
        btnRegistrar.setAlignmentX(Component.CENTER_ALIGNMENT);
        estiloBotonNaranja(btnRegistrar);

        btnRegistrar.addActionListener(e -> {
            if (validarRegistro(txtNombre.getText(), txtDocumento.getText(), new String(txtPassword.getPassword()))) {
                Usuario nuevoUsuario = new Usuario(
                        txtNombre.getText(),
                        txtFecha.getText(),
                        txtDocumento.getText(),
                        new String(txtPassword.getPassword()),
                        txtBarrio.getText(),
                        txtTelefono.getText(),
                        txtEmail.getText()
                );
                usuarios.add(nuevoUsuario);
                JOptionPane.showMessageDialog(frame, "¡Registro exitoso!");
                frame.dispose();
                mostrarVentanaInicio();
            }
        });

        panel.add(titulo);
        panel.add(Box.createRigidArea(new Dimension(0, 20)));

        panel.add(lblNombre);
        panel.add(txtNombre);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));

        panel.add(lblFecha);
        panel.add(txtFecha);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));

        panel.add(lblDocumento);
        panel.add(txtDocumento);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));

        panel.add(lblPassword);
        panel.add(txtPassword);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));

        panel.add(lblBarrio);
        panel.add(txtBarrio);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));

        panel.add(lblTelefono);
        panel.add(txtTelefono);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));

        panel.add(lblEmail);
        panel.add(txtEmail);
        panel.add(Box.createRigidArea(new Dimension(0, 20)));

        panel.add(btnRegistrar);

        frame.add(new JScrollPane(panel), BorderLayout.CENTER);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    //  Pedimos los pasos y las restricciones para el registro

    private static boolean validarRegistro(String nombre, String documento, String password) {
        if (nombre.isEmpty() || documento.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nombre y documento son obligatorios");
            return false;
        }
        if (password.length() < 5) {
            JOptionPane.showMessageDialog(null, "La contraseña debe tener mínimo 5 caracteres");
            return false;
        }
        return true;
    }

    // Damos la bienvenida y mostramos las opciones principales 

    private static void mostrarMenuPrincipal() {
        JFrame frame = new JFrame("EPS - " + usuarioLogueado.getNombreCompleto());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 350);
        frame.setLayout(new BorderLayout());
        frame.getContentPane().setBackground(Color.WHITE);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 1, 10, 10));
        panel.setBackground(Color.WHITE);

        JLabel lblBienvenida = new JLabel("Bienvenido: " + usuarioLogueado.getNombreCompleto(), SwingConstants.CENTER);
        lblBienvenida.setFont(new Font("Arial", Font.BOLD, 16));
        lblBienvenida.setForeground(COLOR_NARANJA);

        JButton btnSolicitarCita = new JButton("SOLICITAR CITA");
        JButton btnVerCitas = new JButton("VER MIS CITAS");
        JButton btnCancelarCita = new JButton("CANCELAR CITA");
        JButton btnCerrarSesion = new JButton("CERRAR SESIÓN");

        
        estiloBotonNaranja(btnSolicitarCita);
        estiloBotonNaranja(btnVerCitas);
        estiloBotonNaranja(btnCancelarCita);
        btnCerrarSesion.setBackground(Color.RED);
        btnCerrarSesion.setForeground(Color.WHITE);
        btnCerrarSesion.setFont(new Font("Arial", Font.BOLD, 14));

        btnSolicitarCita.addActionListener(e -> {
            frame.dispose();
            mostrarCitasDisponibles();
        });

        btnVerCitas.addActionListener(e -> {
            frame.dispose();
            mostrarMisCitas();
        });

        btnCancelarCita.addActionListener(e -> {
            frame.dispose();
            mostrarSeleccionCancelarCita();
        });

        btnCerrarSesion.addActionListener(e -> {
            usuarioLogueado = null;
            frame.dispose();
            mostrarVentanaInicio();
        });

        panel.add(lblBienvenida);
        panel.add(btnSolicitarCita);
        panel.add(btnVerCitas);
        panel.add(btnCancelarCita);
        panel.add(btnCerrarSesion);

        frame.add(panel, BorderLayout.CENTER);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    // Damos informacion de los doctores y las citas que se encuentran disponibles 

    private static void mostrarCitasDisponibles() {
        JFrame frame = new JFrame("EPS - Citas Disponibles");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(600, 500);
        frame.setLayout(new BorderLayout());
        frame.getContentPane().setBackground(Color.WHITE);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        panel.setBackground(Color.WHITE);

        JLabel titulo = new JLabel("CITAS DISPONIBLES", SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 20));
        titulo.setForeground(COLOR_NARANJA);
        titulo.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel subtitulo = new JLabel("(Citas disponibles desde las 7:00 am hasta las 8:00 pm)");
        subtitulo.setAlignmentX(Component.CENTER_ALIGNMENT);

        panel.add(titulo);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        panel.add(subtitulo);
        panel.add(Box.createRigidArea(new Dimension(0, 20)));


        for (Medico medico : medicos) {
            JPanel panelMedico = new JPanel(new BorderLayout());
            panelMedico.setBorder(BorderFactory.createLineBorder(COLOR_NARANJA));
            panelMedico.setBackground(COLOR_NARANJA_CLARO);
            panelMedico.setMaximumSize(new Dimension(500, 60));

            JLabel lblEspecialidad = new JLabel(medico.getEspecialidad());
            lblEspecialidad.setFont(new Font("Arial", Font.BOLD, 14));
            lblEspecialidad.setForeground(Color.BLACK);

            JLabel lblMedico = new JLabel("Médico asignado: " + medico.getNombre());
            JLabel lblHorario = new JLabel("Horario: " + medico.getHorarioAtencion());

            JPanel panelInfo = new JPanel(new GridLayout(2, 1));
            panelInfo.setBackground(COLOR_NARANJA_CLARO);
            panelInfo.add(lblMedico);
            panelInfo.add(lblHorario);

            JButton btnSeleccionar = new JButton("SELECCIONAR");
            btnSeleccionar.setBackground(COLOR_NARANJA);
            btnSeleccionar.setForeground(Color.WHITE);

            btnSeleccionar.addActionListener(e -> {
               
                Cita nuevaCita = new Cita(
                        usuarioLogueado,
                        medico,
                        "jueves, 18 de sep. de 2025 11:00 a.m",
                        "CONSULTA ANUAL FAMILIAR"
                );
                citas.add(nuevaCita);
                JOptionPane.showMessageDialog(frame,
                        "¡Cita agendada exitosamente con " + medico.getNombre() + "!\n" +
                                "Se envió confirmación por email."
                );
                frame.dispose();
                mostrarDetallesCita(nuevaCita);
            });

            panelMedico.add(lblEspecialidad, BorderLayout.NORTH);
            panelMedico.add(panelInfo, BorderLayout.CENTER);
            panelMedico.add(btnSeleccionar, BorderLayout.EAST);

            panel.add(panelMedico);
            panel.add(Box.createRigidArea(new Dimension(0, 10)));
        }

        JButton btnRegresar = new JButton("REGRESAR");
        btnRegresar.setAlignmentX(Component.CENTER_ALIGNMENT);
        estiloBotonNaranja(btnRegresar);
        btnRegresar.addActionListener(e -> {
            frame.dispose();
            mostrarMenuPrincipal();
        });

        panel.add(btnRegresar);

        frame.add(new JScrollPane(panel), BorderLayout.CENTER);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    // Se muestran datos de la cita - doctor - paciente

    private static void mostrarDetallesCita(Cita cita) {
        JFrame frame = new JFrame("EPS - Detalles de Cita");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(500, 450);
        frame.setLayout(new BorderLayout());
        frame.getContentPane().setBackground(Color.WHITE);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        panel.setBackground(Color.WHITE);

        JLabel titulo = new JLabel("Detalles de la cita médica", SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 18));
        titulo.setForeground(COLOR_NARANJA);
        titulo.setAlignmentX(Component.CENTER_ALIGNMENT);

       
        String detalles =
                "Paciente: " + cita.getPaciente().getNombreCompleto() + "\n\n" +
                        "Identificación: " + cita.getPaciente().getNumeroIdentificacion() + "\n\n" +
                        "Dr. Asignado: " + cita.getMedico().getNombre() + "\n\n" +
                        "Motivo: " + cita.getMotivo() + "\n\n" +
                        "Fecha y hora: " + cita.getFechaHora() + "\n\n" +
                        "Lugar: " + cita.getPaciente().getBarrio() + "\n\n" +
                        "Costo de la cita: $0\n\n" +
                        "Requisitos Obligatorios:\nDocumento de identificación\n\n" +
                        "Llegar con 15 minutos de anticipación\n\n" +
                        "CANCELAR\n(Permitido 3 horas antes de la cita programada)";

        JTextArea textArea = new JTextArea(detalles);
        textArea.setEditable(false);
        textArea.setBackground(panel.getBackground());
        textArea.setFont(new Font("Arial", Font.PLAIN, 12));

        JButton btnAceptar = new JButton("ACEPTAR");
        btnAceptar.setAlignmentX(Component.CENTER_ALIGNMENT);
        estiloBotonNaranja(btnAceptar);
        btnAceptar.addActionListener(e -> {
            frame.dispose();
            mostrarMenuPrincipal();
        });

        panel.add(titulo);
        panel.add(Box.createRigidArea(new Dimension(0, 20)));
        panel.add(textArea);
        panel.add(Box.createRigidArea(new Dimension(0, 20)));
        panel.add(btnAceptar);

        frame.add(new JScrollPane(panel), BorderLayout.CENTER);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    
    //Muestra las citas ya agendadas

    private static void mostrarMisCitas() {
        JFrame frame = new JFrame("EPS - Mis Citas");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(500, 400);
        frame.setLayout(new BorderLayout());
        frame.getContentPane().setBackground(Color.WHITE);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        panel.setBackground(Color.WHITE);

        JLabel titulo = new JLabel("MIS CITAS PROGRAMADAS", SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 18));
        titulo.setForeground(COLOR_NARANJA);
        titulo.setAlignmentX(Component.CENTER_ALIGNMENT);

        panel.add(titulo);
        panel.add(Box.createRigidArea(new Dimension(0, 20)));

        boolean tieneCitas = false;
        for (Cita cita : citas) {
            if (cita.getPaciente().equals(usuarioLogueado)) {
                tieneCitas = true;

                JPanel panelCita = new JPanel(new BorderLayout());
                panelCita.setBorder(BorderFactory.createLineBorder(COLOR_NARANJA));
                panelCita.setBackground(COLOR_NARANJA_CLARO);
                panelCita.setMaximumSize(new Dimension(400, 100));

                String infoCita =
                        "Médico: " + cita.getMedico().getNombre() + "\n" +
                                "Especialidad: " + cita.getMedico().getEspecialidad() + "\n" +
                                "Fecha: " + cita.getFechaHora() + "\n" +
                                "Motivo: " + cita.getMotivo();

                JTextArea textArea = new JTextArea(infoCita);
                textArea.setEditable(false);
                textArea.setBackground(COLOR_NARANJA_CLARO);

                panelCita.add(textArea, BorderLayout.CENTER);
                panel.add(panelCita);
                panel.add(Box.createRigidArea(new Dimension(0, 10)));
            }
        }

        if (!tieneCitas) {
            JLabel lblNoCitas = new JLabel("No tiene citas programadas");
            lblNoCitas.setAlignmentX(Component.CENTER_ALIGNMENT);
            panel.add(lblNoCitas);
        }

        JButton btnRegresar = new JButton("REGRESAR");
        btnRegresar.setAlignmentX(Component.CENTER_ALIGNMENT);
        estiloBotonNaranja(btnRegresar);
        btnRegresar.addActionListener(e -> {
            frame.dispose();
            mostrarMenuPrincipal();
        });

        panel.add(Box.createRigidArea(new Dimension(0, 20)));
        panel.add(btnRegresar);

        frame.add(new JScrollPane(panel), BorderLayout.CENTER);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    //Muestra la cancelacion de las citas ya agendadas

    private static void mostrarSeleccionCancelarCita() {
        JFrame frame = new JFrame("EPS - Seleccionar Cita a Cancelar");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(500, 400);
        frame.setLayout(new BorderLayout());
        frame.getContentPane().setBackground(Color.WHITE);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        panel.setBackground(Color.WHITE);

        JLabel titulo = new JLabel("SELECCIONE LA CITA A CANCELAR", SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 18));
        titulo.setForeground(COLOR_NARANJA);
        titulo.setAlignmentX(Component.CENTER_ALIGNMENT);

        panel.add(titulo);
        panel.add(Box.createRigidArea(new Dimension(0, 20)));

        ArrayList<Cita> citasUsuario = new ArrayList<>();
        for (Cita cita : citas) {
            if (cita.getPaciente().equals(usuarioLogueado)) {
                citasUsuario.add(cita);
            }
        }

        if (citasUsuario.isEmpty()) {
            JLabel lblNoCitas = new JLabel("No tiene citas programadas para cancelar");
            lblNoCitas.setAlignmentX(Component.CENTER_ALIGNMENT);
            panel.add(lblNoCitas);
        } else {
            for (int i = 0; i < citasUsuario.size(); i++) {
                Cita cita = citasUsuario.get(i);

                JPanel panelCita = new JPanel(new BorderLayout());
                panelCita.setBorder(BorderFactory.createLineBorder(COLOR_NARANJA));
                panelCita.setBackground(COLOR_NARANJA_CLARO);
                panelCita.setMaximumSize(new Dimension(400, 80));

                String infoCita =
                        "Cita " + (i + 1) + ":\n" +
                                "Médico: " + cita.getMedico().getNombre() + " - " +
                                cita.getMedico().getEspecialidad() + "\n" +
                                "Fecha: " + cita.getFechaHora();

                JTextArea textArea = new JTextArea(infoCita);
                textArea.setEditable(false);
                textArea.setBackground(COLOR_NARANJA_CLARO);

                JButton btnCancelar = new JButton("CANCELAR ESTA CITA");
                btnCancelar.setBackground(Color.RED);
                btnCancelar.setForeground(Color.WHITE);

                final int index = i;
                btnCancelar.addActionListener(e -> {
                    frame.dispose();
                    mostrarCancelarCita(citasUsuario.get(index));
                });

                panelCita.add(textArea, BorderLayout.CENTER);
                panelCita.add(btnCancelar, BorderLayout.EAST);

                panel.add(panelCita);
                panel.add(Box.createRigidArea(new Dimension(0, 10)));
            }
        }

        JButton btnRegresar = new JButton("REGRESAR");
        btnRegresar.setAlignmentX(Component.CENTER_ALIGNMENT);
        estiloBotonNaranja(btnRegresar);
        btnRegresar.addActionListener(e -> {
            frame.dispose();
            mostrarMenuPrincipal();
        });

        panel.add(Box.createRigidArea(new Dimension(0, 20)));
        panel.add(btnRegresar);

        frame.add(new JScrollPane(panel), BorderLayout.CENTER);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    //Se pide motivo de cancelacion y da opcion de cancelar cita agendada

    private static void mostrarCancelarCita(Cita citaACancelar) {
        JFrame frame = new JFrame("EPS - Cancelar Cita");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new BorderLayout());
        frame.getContentPane().setBackground(Color.WHITE);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        panel.setBackground(Color.WHITE);

        JLabel titulo = new JLabel("CANCELACION DE CITA", SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 18));
        titulo.setForeground(Color.RED);
        titulo.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel lblInfoCita = new JLabel(
                "<html>Cancelando cita con:<br>" +
                        citaACancelar.getMedico().getNombre() + "<br>" +
                        citaACancelar.getMedico().getEspecialidad() + "<br>" +
                        citaACancelar.getFechaHora() + "</html>"
        );
        lblInfoCita.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel lblMotivo = new JLabel("Motivo de tu cancelación: (Obligatorio)");
        lblMotivo.setAlignmentX(Component.LEFT_ALIGNMENT);

        JTextArea txtMotivo = new JTextArea(5, 30);
        JScrollPane scrollPane = new JScrollPane(txtMotivo);

        JButton btnConfirmar = new JButton("CONFIRMAR CANCELACIÓN");
        btnConfirmar.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnConfirmar.setBackground(Color.RED);
        btnConfirmar.setForeground(Color.WHITE);
        btnConfirmar.setFont(new Font("Arial", Font.BOLD, 14));

        JButton btnRegresar = new JButton("REGRESAR");
        btnRegresar.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnRegresar.setBackground(Color.LIGHT_GRAY);

        btnConfirmar.addActionListener(e -> {
            String motivo = txtMotivo.getText();
            if (!motivo.isEmpty()) {
                citas.remove(citaACancelar);
                JOptionPane.showMessageDialog(frame,
                        "Cita cancelada exitosamente\n" +
                                "Motivo: " + motivo
                );
                frame.dispose();
                mostrarMenuPrincipal();
            } else {
                JOptionPane.showMessageDialog(frame, "Debe escribir el motivo de cancelación");
            }
        });

        btnRegresar.addActionListener(e -> {
            frame.dispose();
            mostrarSeleccionCancelarCita();
        });

        panel.add(titulo);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        panel.add(lblInfoCita);
        panel.add(Box.createRigidArea(new Dimension(0, 20)));
        panel.add(lblMotivo);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        panel.add(scrollPane);
        panel.add(Box.createRigidArea(new Dimension(0, 20)));
        panel.add(btnConfirmar);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        panel.add(btnRegresar);

        frame.add(panel, BorderLayout.CENTER);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
