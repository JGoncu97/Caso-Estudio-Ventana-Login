package controlador;
import modelo.Logica;
import modelo.dao.CompraDao;
import modelo.dao.ProductoDao;
import modelo.dao.UsuarioDao;
import vista.VentanaConsultaIndividual;
import vista.VentanaConsultaProducto;
import vista.VentanaLogin;
import vista.VentanaPrincipal;
import vista.VentanaRegistro;
import vista.VentanaRegistroProducto;

public class Aplicacion {
	
	public void iniciarSistema(){
		
		//Instanciamos las clases unicas
		VentanaPrincipal miVentana=new VentanaPrincipal();
		VentanaLogin miLogin=new VentanaLogin(miVentana, true);
		Coordinador miCoordinador=new Coordinador();
		Logica miLogica=new Logica();
		VentanaRegistro miVentanaRegistro=new VentanaRegistro(miVentana, true);
		VentanaConsultaIndividual miVentanaConsultaIndividual=new VentanaConsultaIndividual(miVentana, true);
		UsuarioDao miUsuarioDao=new UsuarioDao();
		VentanaRegistroProducto miVentanaRegistroProducto = new VentanaRegistroProducto(miVentana, true);
		ProductoDao miProductoDao = new ProductoDao();
		VentanaConsultaProducto miVentanaConsultaProducto = new VentanaConsultaProducto(miVentana, true);
		CompraDao miCompraDao = new CompraDao();
		
		
		//Relacionamos las clases con el coordinador				
		miVentana.setCoordinador(miCoordinador);
		miLogin.setCoordinador(miCoordinador);
		miLogica.setCoordinador(miCoordinador);
		miVentanaRegistro.setCoordinador(miCoordinador);
		miVentanaConsultaIndividual.setCoordinador(miCoordinador);
		miUsuarioDao.setCoordinador(miCoordinador);
		miVentanaRegistroProducto.setCoordinador(miCoordinador);
		miProductoDao.setCoordinador(miCoordinador);
		miVentanaConsultaProducto.setCoordinador(miCoordinador);
		miCompraDao.setCoordinador(miCoordinador);
		
		//Relacionamos el Coordinador con las Clases
		miCoordinador.setVentanaPrincipal(miVentana);
		miCoordinador.setVentanaLogin(miLogin);
		miCoordinador.setLogica(miLogica);
		miCoordinador.setVentanaRegistro(miVentanaRegistro);
		miCoordinador.setVentanaConsultaIndividual(miVentanaConsultaIndividual);
		miCoordinador.setUsuarioDao(miUsuarioDao);
		miCoordinador.setVentanaRegistroProducto(miVentanaRegistroProducto);
		miCoordinador.setProductoDao(miProductoDao);
		miCoordinador.setVentanaConsultaproducto(miVentanaConsultaProducto);
		miCoordinador.setCompraDao(miCompraDao);
		
		miLogin.setVisible(true);
	}

}
