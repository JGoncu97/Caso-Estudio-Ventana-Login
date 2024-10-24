package vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import modelo.vo.UsuarioVo;
import controlador.Coordinador;

public class VentanaRegistro extends JDialog implements ActionListener {


    private javax.swing.JTextField campoUsername;
    private javax.swing.JPasswordField campoPassword;
    private javax.swing.JLabel labelUsername;
    private javax.swing.JLabel labelPassword;
    private javax.swing.JTextField campoNombre;
    private javax.swing.JTextField campoDireccion;
    private javax.swing.JTextField campoTelefono;
    private javax.swing.JTextField campoProfesion;
    private javax.swing.JTextField campoDocumento;
    private javax.swing.JTextField campoEdad;
    private Coordinador miCoordinador;
    private javax.swing.JButton btonAceptar;
    private javax.swing.JButton btonCancelar;
    private javax.swing.JPanel panelRegistro;
    private javax.swing.JLabel tituloRegistro;
    private javax.swing.JLabel labelDocumento;
    private javax.swing.JLabel labelEdad;
    private javax.swing.JLabel labelNombre;
    private javax.swing.JLabel labelProfesion;
    private javax.swing.JLabel labelTelefono;
    private javax.swing.JLabel labelTexto;
    private javax.swing.JLabel labelDireccion;

    // Agregado para seleccionar el tipo de usuario
    private javax.swing.JComboBox<String> comboTipo; // ComboBox para el tipo de usuario
    private javax.swing.JLabel labelTipo; // Etiqueta para el tipo de usuario

    public VentanaRegistro(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setSize(705, 430); // Ajuste del tamaño para incluir los nuevos campos
        setResizable(false);
        setLocationRelativeTo(null);
    }

    private void initComponents() {
        panelRegistro = new javax.swing.JPanel();
        tituloRegistro = new javax.swing.JLabel();
        labelProfesion = new javax.swing.JLabel();
        labelTelefono = new javax.swing.JLabel();
        labelTexto = new javax.swing.JLabel();
        labelDocumento = new javax.swing.JLabel();
        labelEdad = new javax.swing.JLabel();
        labelNombre = new javax.swing.JLabel();
        labelUsername = new javax.swing.JLabel();
        labelPassword = new javax.swing.JLabel();
        labelDireccion = new javax.swing.JLabel();


        labelTipo = new javax.swing.JLabel();
        comboTipo = new javax.swing.JComboBox<>(new String[]{"Seleccione", "Administrador", "Secretaria", "Usuario"});

        campoNombre = new javax.swing.JTextField();
        campoDireccion = new javax.swing.JTextField();
        campoTelefono = new javax.swing.JTextField();
        campoProfesion = new javax.swing.JTextField();
        campoDocumento = new javax.swing.JTextField();
        campoEdad = new javax.swing.JTextField();
        campoUsername = new javax.swing.JTextField();
        campoPassword = new javax.swing.JPasswordField();
        btonCancelar = new javax.swing.JButton();
        btonAceptar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        panelRegistro.setBackground(new java.awt.Color(204, 204, 204));
        panelRegistro.setLayout(null);

        tituloRegistro.setFont(new java.awt.Font("Tempus Sans ITC", 1, 36));
        tituloRegistro.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tituloRegistro.setText("Registro de Usuario");
        panelRegistro.add(tituloRegistro);
        tituloRegistro.setBounds(20, 10, 660, 60);

        labelTexto.setFont(new java.awt.Font("Verdana", 1, 14));
        labelTexto.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labelTexto.setText("Diligencie el Formulario para registrar el Usuario en el Sistema");
        panelRegistro.add(labelTexto);
        labelTexto.setBounds(0, 90, 510, 20);


        labelTipo.setFont(new java.awt.Font("Verdana", 0, 12));
        labelTipo.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labelTipo.setText("Tipo de Usuario:");
        panelRegistro.add(labelTipo);
        labelTipo.setBounds(0, 110, 120, 20);
        panelRegistro.add(comboTipo);
        comboTipo.setBounds(130, 110, 200, 20);

        labelUsername.setFont(new java.awt.Font("Verdana", 0, 12));
        labelUsername.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labelUsername.setText("* Username:");
        panelRegistro.add(labelUsername);
        labelUsername.setBounds(0, 140, 90, 20);
        panelRegistro.add(campoUsername);
        campoUsername.setBounds(100, 140, 300, 20);

        labelPassword.setFont(new java.awt.Font("Verdana", 0, 12));
        labelPassword.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labelPassword.setText("* Contraseña:");
        panelRegistro.add(labelPassword);
        labelPassword.setBounds(400, 140, 100, 20);
        panelRegistro.add(campoPassword);
        campoPassword.setBounds(510, 140, 170, 20);

        labelNombre.setFont(new java.awt.Font("Verdana", 0, 12));
        labelNombre.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labelNombre.setText("* Nombre:");
        panelRegistro.add(labelNombre);
        labelNombre.setBounds(0, 170, 90, 20);
        panelRegistro.add(campoNombre);
        campoNombre.setBounds(100, 170, 300, 20);

        labelDocumento.setFont(new java.awt.Font("Verdana", 0, 12));
        labelDocumento.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labelDocumento.setText("* Documento:");
        panelRegistro.add(labelDocumento);
        labelDocumento.setBounds(400, 170, 100, 20);
        panelRegistro.add(campoDocumento);
        campoDocumento.setBounds(510, 170, 170, 20);

        labelEdad.setFont(new java.awt.Font("Verdana", 0, 12));
        labelEdad.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labelEdad.setText("Edad:");
        panelRegistro.add(labelEdad);
        labelEdad.setBounds(400, 200, 100, 20);
        panelRegistro.add(campoEdad);
        campoEdad.setBounds(510, 200, 170, 20);

        labelDireccion.setFont(new java.awt.Font("Verdana", 0, 12));
        labelDireccion.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labelDireccion.setText("* Dirección:");
        panelRegistro.add(labelDireccion);
        labelDireccion.setBounds(0, 230, 90, 20);
        panelRegistro.add(campoDireccion);
        campoDireccion.setBounds(100, 230, 300, 20);

        labelProfesion.setFont(new java.awt.Font("Verdana", 0, 12));
        labelProfesion.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labelProfesion.setText("Profesión:");
        panelRegistro.add(labelProfesion);
        labelProfesion.setBounds(0, 260, 90, 20);
        panelRegistro.add(campoProfesion);
        campoProfesion.setBounds(100, 260, 300, 20);

        labelTelefono.setFont(new java.awt.Font("Verdana", 0, 12));
        labelTelefono.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labelTelefono.setText("Teléfono:");
        panelRegistro.add(labelTelefono);
        labelTelefono.setBounds(400, 230, 100, 20);
        panelRegistro.add(campoTelefono);
        campoTelefono.setBounds(510, 230, 170, 20);

        btonCancelar.setFont(new java.awt.Font("Verdana", 0, 14));
        btonCancelar.setText("Cancelar");
        btonCancelar.addActionListener(this);
        panelRegistro.add(btonCancelar);
        btonCancelar.setBounds(570, 300, 110, 30);

        btonAceptar.setFont(new java.awt.Font("Verdana", 0, 14));
        btonAceptar.setText("Aceptar");
        btonAceptar.addActionListener(this);
        panelRegistro.add(btonAceptar);
        btonAceptar.setBounds(450, 300, 110, 30);

        getContentPane().add(panelRegistro);
        panelRegistro.setBounds(0, 0, 690, 350);

        pack();
    }

    public void setCoordinador(Coordinador miCoordinador) {
        this.miCoordinador = miCoordinador;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btonAceptar) {
            registrar();
        }
        if (e.getSource() == btonCancelar) {
            dispose();
        }
    }

    private void registrar() {

        Integer edad = miCoordinador.validarEdad(campoEdad.getText().trim());

        if (edad != null) {
            UsuarioVo miUsuarioVo = new UsuarioVo();
            miUsuarioVo.setUsername(campoUsername.getText().trim());
            miUsuarioVo.setPassword(campoPassword.getText().trim());
            miUsuarioVo.setDocumento(campoDocumento.getText().trim());
            miUsuarioVo.setNombre(campoNombre.getText().trim());
            miUsuarioVo.setEdad(edad);
            miUsuarioVo.setProfesion(campoProfesion.getText().trim());
            miUsuarioVo.setDireccion(campoDireccion.getText().trim()); // Asignación de la dirección
            miUsuarioVo.setTelefono(campoTelefono.getText().trim());



            String rol =comboTipo.getSelectedItem().toString();

            if (!rol.equals("Seleccione")) {
                miUsuarioVo.setRol(rol); // Asegúrate de que UsuarioVo tiene un método setRol
            } else {
                JOptionPane.showMessageDialog(null, "Debe seleccionar un tipo de usuario", "Advertencia", JOptionPane.WARNING_MESSAGE);
                return;
            }

            String retorno = "";
            if (miCoordinador.validarCampos(miUsuarioVo)) {
                retorno = miCoordinador.registrarUsuario(miUsuarioVo);
            } else {
                retorno = "mas_datos";
            }

            if (retorno.equals("ok")) {
                JOptionPane.showMessageDialog(null, "El usuario fue registrado con éxito!!!");
                limpiarCampos(); //funcion limpiar campos
            } else {
                if (retorno.equals("error")) {
                    JOptionPane.showMessageDialog(null, "El usuario no pudo ser registrado, verifique la traza del error!!!");
                } else {
                    JOptionPane.showMessageDialog(null, "Se necesitan diligenciar los campos obligatorios (*) !!!", "Advertencia", JOptionPane.WARNING_MESSAGE);
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Debe ingresar una edad válida!!!", "Advertencia", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void limpiarCampos() {
        campoUsername.setText("");
        campoPassword.setText("");
        campoNombre.setText("");
        campoDocumento.setText("");
        campoEdad.setText("");
        campoDireccion.setText("");
        campoProfesion.setText("");
        campoTelefono.setText("");
        comboTipo.setSelectedIndex(0);
}
}
