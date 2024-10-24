package vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

import modelo.vo.ProductoVo;

import controlador.Coordinador;

public class VentanaRegistroProducto extends JDialog implements ActionListener {
	
	/**
     * Creates new form VentanaRegistro
     */
    public VentanaRegistroProducto(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setSize(705,330);
        setResizable(false);
        setLocationRelativeTo(null);
    }

     private void initComponents() {

        panelRegistro = new javax.swing.JPanel();
        tituloRegistro = new javax.swing.JLabel();
        labelPrecio = new javax.swing.JLabel();
        labelTexto = new javax.swing.JLabel();
        labelIdProducto = new javax.swing.JLabel();
        labelCantidad = new javax.swing.JLabel();
        labelNombre = new javax.swing.JLabel();
        separadorInferior = new javax.swing.JSeparator();
        campoNombre = new javax.swing.JTextField();        
        campoPrecio = new javax.swing.JTextField();
        campoIdProducto = new javax.swing.JTextField();
        campoCantidad = new javax.swing.JTextField();
        separadorSuperior = new javax.swing.JSeparator();
        btonCancelar = new javax.swing.JButton();
        btonAceptar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
       // getContentPane().setLayout(null);

        panelRegistro.setBackground(new java.awt.Color(204, 204, 204));
        panelRegistro.setLayout(null);

        tituloRegistro.setFont(new java.awt.Font("Tempus Sans ITC", 1, 36)); // NOI18N
        tituloRegistro.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tituloRegistro.setText("Registro de Producto");
        tituloRegistro.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        panelRegistro.add(tituloRegistro);
        tituloRegistro.setBounds(20, 10, 660, 60);

        labelPrecio.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        labelPrecio.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labelPrecio.setText("Precio:");
        panelRegistro.add(labelPrecio);
        labelPrecio.setBounds(0, 170, 90, 20);

        labelTexto.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        labelTexto.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelTexto.setText("Diligencie el Formulario para registrar un Producto en el Sistema");
        panelRegistro.add(labelTexto);
        labelTexto.setBounds(20, 90, 550, 20);

        labelIdProducto.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        labelIdProducto.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labelIdProducto.setText("* Id Producto:");
        panelRegistro.add(labelIdProducto);
        labelIdProducto.setBounds(400, 140, 100, 20);

        labelCantidad.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        labelCantidad.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labelCantidad.setText("Cantidad:");
        panelRegistro.add(labelCantidad);
        labelCantidad.setBounds(400, 170, 100, 20);

        labelNombre.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        labelNombre.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labelNombre.setText("* Nombre:");
        
        panelRegistro.add(labelNombre);
        labelNombre.setBounds(0, 140, 90, 20);
        panelRegistro.add(separadorInferior);
        separadorInferior.setBounds(20, 240, 660, 10);
        panelRegistro.add(campoNombre);
        campoNombre.setBounds(100, 140, 300, 20);
        panelRegistro.add(campoPrecio);
        campoPrecio.setBounds(100, 170, 300, 20);
        panelRegistro.add(campoIdProducto);
        campoIdProducto.setBounds(510, 140, 170, 20);
        panelRegistro.add(campoCantidad);
        campoCantidad.setBounds(510, 170, 170, 20);
        panelRegistro.add(separadorSuperior);
        separadorSuperior.setBounds(20, 120, 660, 10);

        btonCancelar.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        btonCancelar.setText("Cancelar");
        panelRegistro.add(btonCancelar);
        btonCancelar.setBounds(570, 260, 110, 30);
        btonCancelar.addActionListener(this);

        btonAceptar.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        btonAceptar.setText("Aceptar");
        panelRegistro.add(btonAceptar);
        btonAceptar.setBounds(450, 260, 110, 30);
        btonAceptar.addActionListener(this);

        getContentPane().add(panelRegistro);
        panelRegistro.setBounds(0, 0, 690, 300);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btonAceptar;
    private javax.swing.JButton btonCancelar;
    private javax.swing.JTextField campoIdProducto;
    private javax.swing.JTextField campoCantidad;
    private javax.swing.JTextField campoNombre;
    private javax.swing.JTextField campoPrecio;
    private javax.swing.JLabel tituloRegistro;
    private javax.swing.JLabel labelIdProducto;
    private javax.swing.JLabel labelCantidad;
    private javax.swing.JLabel labelNombre;
    private javax.swing.JLabel labelPrecio;
    private javax.swing.JLabel labelTexto;
    private javax.swing.JPanel panelRegistro;
    private javax.swing.JSeparator separadorInferior;
    private javax.swing.JSeparator separadorSuperior;
	private Coordinador miCoordinador;

	
	public void setCoordinador(Coordinador miCoordinador) {
		this.miCoordinador=miCoordinador;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==btonAceptar) {
			registrarProducto();
		}
		if (e.getSource()==btonCancelar) {
			
			// dispose();
		}
	}
	
	private void registrarProducto() {
		boolean datosValidos = true;
		
		if (campoIdProducto.getText().isEmpty() || campoNombre.getText().isEmpty() ||
				campoPrecio.getText().isEmpty() || campoCantidad.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Todos los campos deben estar diligenciados obligatoriamente");
			
		} else {
			ProductoVo miProductoVo = new ProductoVo();
			miProductoVo.setIdProducto(campoIdProducto.getText());
			miProductoVo.setNombre(campoNombre.getText());	
			try {
				double precio = Double.parseDouble(campoPrecio.getText());
				miProductoVo.setPrecio(precio);
				
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, ("Por favor introduce un valor númerico valido "
			+ e.getMessage()));
				datosValidos = false;
				
			}
			try {
				int cantidad = Integer.parseInt(campoCantidad.getText());
				miProductoVo.setCantidad(cantidad);				
				
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, ("Por favor introduce un valor númerico valido "
			+ e.getMessage()));
				datosValidos = false;
				
			}
			
			if(datosValidos) {
				String mensaje = miCoordinador.registrarProducto(miProductoVo);
				JOptionPane.showMessageDialog(null, mensaje);
				
			}			
			
		}
	}

}
