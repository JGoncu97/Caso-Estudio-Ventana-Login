package controlador;
import java.util.List;

import modelo.Logica;
import modelo.dao.UsuarioDao;
import modelo.vo.UsuarioVo;
import vista.VentanaConsultaIndividual;
import vista.VentanaLogin;
import vista.VentanaPrincipal;
import vista.VentanaRegistro;

public class Coordinador {

	private VentanaPrincipal miVentana;
	private VentanaLogin miLogin;
	private Logica miLogica;
	private VentanaRegistro miVentanaRegistro;
	private VentanaConsultaIndividual miVentanaConsultaIndividual;
	private UsuarioDao miUsuarioDao;

	private UsuarioVo usuarioActual;


	public void setVentanaPrincipal(VentanaPrincipal miVentana) {
		this.miVentana=miVentana;
	}

	public void setVentanaLogin(VentanaLogin miLogin) {
		this.miLogin=miLogin;
	}

	public void setLogica(Logica miLogica) {
		this.miLogica=miLogica;
	}

	//Modificacion para recibir un nombre de usuario
	public UsuarioVo validarIngreso(int index,String user ,String pass) {
		return miLogica.validarIngreso(index,user,pass);
	}

	public void cerrarVentanaLogin() {
		miLogin.dispose();
	}

	public void asignarPrivilegios(UsuarioVo usuario) {
		miVentana.asignarPrivilegios(usuario);
		miVentanaConsultaIndividual.asignarPrivilegios(usuario);

	}

	public void mostrarLogin() {
		miLogin.limpiar();
		miLogin.setVisible(true);
	}

	public void setVentanaRegistro(VentanaRegistro miVentanaRegistro) {
		this.miVentanaRegistro=miVentanaRegistro;
	}

	public void setVentanaConsultaIndividual(	VentanaConsultaIndividual miVentanaConsultaIndividual) {
		this.miVentanaConsultaIndividual=miVentanaConsultaIndividual;
	}

	public void mostrarVentanaRegistro() {
		miVentanaRegistro.setVisible(true);
	}

	public void mostrarVentanaConsulta() {
		miVentanaConsultaIndividual.setVisible(true);
	}

	public void setUsuarioDao(UsuarioDao miUsuarioDao) {
		this.miUsuarioDao=miUsuarioDao;
	}

	public String registrarUsuario(UsuarioVo miUsuarioVo) {
		return miUsuarioDao.registrarUsuario(miUsuarioVo);
	}

	public boolean validarCampos(UsuarioVo miUsuarioVo) {
		return miLogica.validarCampos(miUsuarioVo);
	}

	public Integer validarEdad(String edadIngresada) {
		// TODO Auto-generated method stub
		return miLogica.validarEdad(edadIngresada);
	}

	//Modificamos el argumento para enviar la password
	public UsuarioVo consultarUsuario(String user, String pass) {

		return miUsuarioDao.consultarUsuario(user,pass);
	}

	public UsuarioVo actualizaUsuario(UsuarioVo miUsuarioVo, UsuarioVo usuarioActual) {
		return miUsuarioDao.actualizaUsuario(miUsuarioVo, usuarioActual);
	}

	public String eliminarUsuario(String documento) {
		return miUsuarioDao.eliminarUsuario(documento);
	}

	public void abrirVentanaPrincipal(UsuarioVo miUsuarioVo) {
		this.usuarioActual = miUsuarioVo;
		miVentana.setVisible(true);

	}

	public UsuarioVo obtenerUsuarioActual() {
		return usuarioActual;
	}

	public UsuarioVo consultarUsuarioDoc(String doc) {
		return miUsuarioDao.consultarUsuarioDoc(doc);
	}

	public List<UsuarioVo> consultarTodosLosUsuarios(UsuarioVo usuarioActual) {
		return miUsuarioDao.obtenerTodosLosUsuarios(usuarioActual);
	}


	// Método para establecer el usuario actual al iniciar sesión
	public void setUsuarioActual(UsuarioVo usuario) {
		this.usuarioActual = usuario;
	}

	// Método para obtener el usuario actual
	public UsuarioVo getUsuarioActual() {
		return usuarioActual;
	}

}