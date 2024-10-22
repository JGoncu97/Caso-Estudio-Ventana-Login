package vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import modelo.vo.UsuarioVo;

import controlador.Coordinador;


/**
 *
 * @author User
 */
public class VentanaConsultaIndividual extends JDialog implements ActionListener{

    private JLabel LabelDireccion,TituloConsulta, labelDocumento,labelEdad, labelNombre, labelProfesion, labelTelefono,labelTexto;
    private JButton btonCancelar,btonConsultar,btonActualizar,btonEliminar,btonConsultarList;
    private JTextField campoTelefono,campoDireccion,campoConsultaDocumento, campoDocumento,campoEdad,campoNombre,campoProfesion;
    private javax.swing.JPanel panelConsulta;
    private javax.swing.JComboBox comboUsuarios;
    private JLabel labelTipo;
    private Map<String, Integer> tipoUsuariosMap;
    private javax.swing.JSeparator separadorInferior,separadorSuperior;

    private javax.swing.JTable tablaUsuarios;
    private javax.swing.JScrollPane scrollPaneUsuarios;

    private Coordinador miCoordinador;

    /**
     * Creates new form VentanaConsultaIndividual
     */
    public VentanaConsultaIndividual(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setSize(710,720);
        setResizable(false);
        setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelConsulta = new javax.swing.JPanel();
        TituloConsulta = new javax.swing.JLabel();
        labelProfesion = new javax.swing.JLabel();
        labelTelefono = new javax.swing.JLabel();
        labelTexto = new javax.swing.JLabel();
        labelDocumento = new javax.swing.JLabel();
        labelEdad = new javax.swing.JLabel();
        LabelDireccion = new javax.swing.JLabel();
        labelNombre = new javax.swing.JLabel();
        separadorInferior = new javax.swing.JSeparator();
        campoNombre = new javax.swing.JTextField();
        campoDireccion = new javax.swing.JTextField();
        campoTelefono = new javax.swing.JTextField();
        campoProfesion = new javax.swing.JTextField();
        campoConsultaDocumento = new javax.swing.JTextField();
        campoEdad = new javax.swing.JTextField();
        separadorSuperior = new javax.swing.JSeparator();
        btonCancelar = new javax.swing.JButton();
        btonConsultar = new javax.swing.JButton();
        campoDocumento = new javax.swing.JTextField();
        comboUsuarios = new javax.swing.JComboBox();
        labelTipo = new javax.swing.JLabel();
        btonConsultarList = new javax.swing.JButton();
        tablaUsuarios= new javax.swing.JTable();


        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        //getContentPane().setLayout(null);

        panelConsulta.setBackground(new java.awt.Color(204, 204, 204));
        panelConsulta.setLayout(null);

        TituloConsulta.setFont(new java.awt.Font("Tempus Sans ITC", 1, 36)); // NOI18N
        TituloConsulta.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        TituloConsulta.setText("Consultar Usuario");
        TituloConsulta.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        panelConsulta.add(TituloConsulta);
        TituloConsulta.setBounds(20, 10, 660, 60);

        labelProfesion.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        labelProfesion.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labelProfesion.setText("Profesion:");
        panelConsulta.add(labelProfesion);
        labelProfesion.setBounds(0, 170, 90, 20);

        labelTelefono.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        labelTelefono.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labelTelefono.setText("Telefono:");
        panelConsulta.add(labelTelefono);
        labelTelefono.setBounds(400, 200, 100, 20);

        labelTexto.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        labelTexto.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labelTexto.setText("Ingrese el documento del usuario a consultar");
        panelConsulta.add(labelTexto);
        labelTexto.setBounds(0, 90, 380, 20);

        labelDocumento.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        labelDocumento.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labelDocumento.setText("*Documento:");
        panelConsulta.add(labelDocumento);
        labelDocumento.setBounds(400, 140, 100, 20);

        labelEdad.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        labelEdad.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labelEdad.setText("Edad:");
        panelConsulta.add(labelEdad);
        labelEdad.setBounds(400, 170, 100, 20);

        LabelDireccion.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        LabelDireccion.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        LabelDireccion.setText("Direccion:");
        panelConsulta.add(LabelDireccion);
        LabelDireccion.setBounds(0, 200, 90, 20);

        labelNombre.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        labelNombre.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labelNombre.setText("*Nombre:");
        panelConsulta.add(labelNombre);
        labelNombre.setBounds(0, 140, 90, 20);


        labelTipo.setFont(new java.awt.Font("Verdana", 0, 12));
        labelTipo.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labelTipo.setText("Tipo");
        panelConsulta.add(labelTipo);
        labelTipo.setBounds(0, 230, 90, 20);

        comboUsuarios.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione", "Administrador", "Usuario","Secretaria"}));
        panelConsulta.add(comboUsuarios);
        comboUsuarios.setBounds(100, 230, 190, 20);
        comboUsuarios.addActionListener(this);

        panelConsulta.add(separadorInferior);
        separadorInferior.setBounds(20, 260, 660, 10);

        panelConsulta.add(campoNombre);
        campoNombre.setBounds(100, 140, 300, 20);

        panelConsulta.add(campoDireccion);
        campoDireccion.setBounds(100, 200, 300, 20);

        panelConsulta.add(campoTelefono);
        campoTelefono.setBounds(510, 200, 170, 20);

        panelConsulta.add(campoProfesion);
        campoProfesion.setBounds(100, 170, 300, 20);

        panelConsulta.add(campoConsultaDocumento);
        campoConsultaDocumento.setBounds(390, 90, 120, 20);

        panelConsulta.add(campoEdad);
        campoEdad.setBounds(510, 170, 170, 20);

        panelConsulta.add(separadorSuperior);
        separadorSuperior.setBounds(20, 120, 660, 10);

        btonActualizar = new javax.swing.JButton();
        btonEliminar = new javax.swing.JButton();

        btonCancelar.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        btonCancelar.setText("Cancelar");
        panelConsulta.add(btonCancelar);
        btonCancelar.setBounds(460, 260, 170, 30);
        btonCancelar.addActionListener(this);

        btonConsultar.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        btonConsultar.setText("Buscar");
        btonConsultar.addActionListener(this);
        panelConsulta.add(btonConsultar);
        btonConsultar.setBounds(520, 90, 110, 20);

        btonActualizar.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        btonActualizar.setText("Actualizar");
        panelConsulta.add(btonActualizar);
        btonActualizar.setBounds(100, 260, 170, 30);
        btonActualizar.addActionListener(this);

        btonEliminar.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        btonEliminar.setText("Eliminar");
        panelConsulta.add(btonEliminar);
        btonEliminar.setBounds(280, 260, 170, 30);
        btonEliminar.addActionListener(this);

        btonConsultarList.setFont(new java.awt.Font("Verdana", 0, 14));
        btonConsultarList.setText("Consultar Lista");
        panelConsulta.add(btonConsultarList);
        btonConsultarList.setBounds(250, 300, 210, 30);
        btonConsultarList.addActionListener(this);

        panelConsulta.add(campoDocumento);
        campoDocumento.setBounds(510, 140, 170, 20);

        tipoUsuariosMap = new HashMap<>();
        tipoUsuariosMap.put("Administrador", 1);
        tipoUsuariosMap.put("Usuario", 2);
        tipoUsuariosMap.put("Secretaria", 3);
        tipoUsuariosMap.put("N/A", 4);

        String[] columnas = {"Documento", "Nombre", "Edad", "Profesión", "Dirección", "Teléfono", "Tipo"};
        DefaultTableModel modeloTabla = new DefaultTableModel(null, columnas);
        tablaUsuarios = new JTable(modeloTabla);
        scrollPaneUsuarios = new javax.swing.JScrollPane(tablaUsuarios);


        scrollPaneUsuarios.setBounds(20, 340, 660, 150);
        panelConsulta.add(scrollPaneUsuarios);

        getContentPane().add(panelConsulta);
        panelConsulta.setBounds(0, 0, 710, 420);

        pack();
    }

    public void asignarPrivilegios(UsuarioVo usuario) {

        for (String key : tipoUsuariosMap.keySet()) {
            if (tipoUsuariosMap.get(key).equals(usuario.getTipo())) {
                switch (key) {
                    case "Administrador":
                        comboUsuarios.setVisible(true);
                        labelTipo.setVisible(true);
                        break;
                    case "Usuario":
                        comboUsuarios.setVisible(false);
                        labelTipo.setVisible(false);
                        break;
                    case "Secretaria":
                        comboUsuarios.setVisible(false);
                        labelTipo.setVisible(false);
                        break;
                    default:

                        JOptionPane.showMessageDialog(this, "Tipo de usuario desconocido", "Error", JOptionPane.ERROR_MESSAGE);
                }
                break;
            }
        }



    }

    public void setCoordinador(Coordinador miCoordinador) {
        this.miCoordinador=miCoordinador;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==btonCancelar) {
            limpiarVentana();
            dispose();
        }

        if (e.getSource()==btonConsultar) {
            consultarUsuario();
        }

        if (e.getSource()==btonActualizar) {
            actualizaUsuario();
        }

        if (e.getSource()==btonEliminar) {
            eliminaUsuario();
        }
        if (e.getSource() == btonConsultarList) {
            cargarListaUsuarios();
        }

    }

    private void cargarListaUsuarios() {

        DefaultTableModel modeloTabla = (DefaultTableModel) tablaUsuarios.getModel();
        modeloTabla.setRowCount(0);
        UsuarioVo usuarioActual = miCoordinador.obtenerUsuarioActual();


        List<UsuarioVo> listaUsuarios = miCoordinador.consultarTodosLosUsuarios(usuarioActual);


        for (UsuarioVo usuario : listaUsuarios) {
            Object[] fila = {
                    usuario.getDocumento(),
                    usuario.getNombre(),
                    usuario.getEdad(),
                    usuario.getProfesion(),
                    usuario.getDireccion(),
                    usuario.getTelefono(),


                    obtenerTipoUsuario(usuario.getTipo())
            };
            modeloTabla.addRow(fila);
        }
    }


    private String obtenerTipoUsuario(int tipo) {
        for (Map.Entry<String, Integer> entry : tipoUsuariosMap.entrySet()) {
            if (entry.getValue().equals(tipo)) {
                return entry.getKey();
            }
        }
        return "N/A";


    }

    private void limpiarVentana() {
        campoConsultaDocumento.setText("");
        campoNombre.setText("");
        campoDocumento.setText("");
        campoProfesion.setText("");
        campoDireccion.setText("");
        campoTelefono.setText("");
        campoEdad.setText("");
    }

    private void consultarUsuario() {
        UsuarioVo usuarioVO=miCoordinador.consultarUsuarioDoc(campoConsultaDocumento.getText().trim());

        if (usuarioVO!=null) {

            campoNombre.setText(usuarioVO.getNombre());
            campoDocumento.setText(usuarioVO.getDocumento());
            campoProfesion.setText(usuarioVO.getProfesion());
            campoDireccion.setText(usuarioVO.getDireccion());
            campoTelefono.setText(usuarioVO.getTelefono());
            campoEdad.setText(usuarioVO.getEdad()+"");

            for (String key : tipoUsuariosMap.keySet()) {
                if (tipoUsuariosMap.get(key).equals(usuarioVO.getTipo())) {
                    comboUsuarios.setSelectedItem(key);
                    break;
                }
            }

        }else{
            JOptionPane.showMessageDialog(null, "El usuario no se encuentra registrado en el sistema",
                    "Datos Inexistentes",JOptionPane.WARNING_MESSAGE);
        }

    }

    /**
     * metodo que permite actualizar un usuario, se envia el numero de documento del usuario
     * obtenido del campo de texto especifico de la ventana
     */
    private void actualizaUsuario() {

        Integer edad = miCoordinador.validarEdad(campoEdad.getText().trim());
        UsuarioVo actualiza = new UsuarioVo();
        if (edad != null) {
            UsuarioVo usuarioActual = miCoordinador.obtenerUsuarioActual();

            if (usuarioActual.getTipo() == 1) {
                UsuarioVo miUsuarioVo = new UsuarioVo();
                miUsuarioVo.setDocumento(campoDocumento.getText().trim());
                miUsuarioVo.setNombre(campoNombre.getText().trim());
                miUsuarioVo.setEdad(edad);
                miUsuarioVo.setProfesion(campoProfesion.getText().trim());
                miUsuarioVo.setTelefono(campoTelefono.getText().trim());
                miUsuarioVo.setDireccion(campoDireccion.getText().trim());


                String tipoSeleccionado = comboUsuarios.getSelectedItem().toString();
                Integer tipoUsuario = tipoUsuariosMap.get(tipoSeleccionado);

                if (tipoUsuario == null) {
                    JOptionPane.showMessageDialog(null, "Tipo de usuario no encontrado", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                System.out.println("Tipo seleccionado: " + tipoSeleccionado);
                System.out.println("Tipo mapeado: " + tipoUsuario);

                miUsuarioVo.setTipo(tipoUsuario);


                if (miCoordinador.validarCampos(miUsuarioVo)) {
                    actualiza = miCoordinador.actualizaUsuario(miUsuarioVo,usuarioActual);
                } else {
                    actualiza.setMensaje("mas_datos");
                }

                if (actualiza.getMensaje().equals("ok")) {
                    JOptionPane.showMessageDialog(null, "Se ha Modificado Correctamente", "Confirmación", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    if (actualiza.getMensaje().equals("mas_datos")) {
                        JOptionPane.showMessageDialog(null, "Debe Ingresar los campos obligatorios", "Faltan Datos", JOptionPane.WARNING_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, "Error al Modificar", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            } else if (usuarioActual.getTipo() != 1)  {
                UsuarioVo miUsuarioVo = new UsuarioVo();
                miUsuarioVo.setDocumento(campoDocumento.getText().trim());
                miUsuarioVo.setNombre(campoNombre.getText().trim());
                miUsuarioVo.setEdad(edad);
                miUsuarioVo.setProfesion(campoProfesion.getText().trim());
                miUsuarioVo.setTelefono(campoTelefono.getText().trim());
                miUsuarioVo.setDireccion(campoDireccion.getText().trim());


                if (miCoordinador.validarCampos(miUsuarioVo)) {
                    actualiza = miCoordinador.actualizaUsuario(miUsuarioVo,usuarioActual);
                } else {
                    actualiza.setMensaje("mas_datos");
                }

                if (actualiza.getMensaje().equals("ok")) {
                    JOptionPane.showMessageDialog(null, "Se ha Modificado Correctamente", "Confirmación", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    if (actualiza.getMensaje().equals("mas_datos")) {
                        JOptionPane.showMessageDialog(null, "Debe Ingresar los campos obligatorios", "Faltan Datos", JOptionPane.WARNING_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, "Error al Modificar", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }

            } else {
                JOptionPane.showMessageDialog(null, "No tiene privilegios para realizar esta acción.", "Acceso Denegado", JOptionPane.WARNING_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Debe ingresar una edad válida!!!", "Advertencia", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void eliminaUsuario() {
        String documento=campoDocumento.getText().trim();
        String elimina="";
        if (!documento.equals("")) {

            int resp=JOptionPane.showConfirmDialog(null,"Esta seguro de eliminar el usuario "+documento+"?");
            if (JOptionPane.OK_OPTION == resp){
                elimina=miCoordinador.eliminarUsuario(documento);

                if (elimina.equals("ok")) {
                    JOptionPane.showMessageDialog(null, " Se ha Eliminado" +
                            " Correctamente","Informaci�n",JOptionPane.INFORMATION_MESSAGE);
                    limpiarVentana();
                }else{
                    JOptionPane.showMessageDialog(null, "No se pudo eliminar ","Informaci�n",JOptionPane.WARNING_MESSAGE);
                }

            }else{
                JOptionPane.showMessageDialog(null, "Ingrese un documento ","Informaci�n",JOptionPane.WARNING_MESSAGE);
            }

        }
    }


}