package modelo;

import javax.swing.JOptionPane;

import modelo.vo.UsuarioVo;
import controlador.Coordinador;

public class Logica {
	
	final int SELECCION=0;
	final int ADMINISTRADOR=1;
	final int USUARIO=2;
	final int SECRETARIA=3;
	
//	final String PASS_ADMIN="admin";
//	final String PASS_USER="1234";
	
	   private Coordinador miCoordinador;
	    // End of variables declaration               
	    
		public void setCoordinador(Coordinador miCoordinador) {
			this.miCoordinador=miCoordinador;
		}
		
		public UsuarioVo validarIngreso(int index, String user,String pass){
			
			UsuarioVo retorno=null;
			
			if (index==SELECCION) {//seleccion es 1
				JOptionPane.showInputDialog(null,"Por favor selecciona un tipo de usuario.");
			}else{
				retorno=validarPass(index, user,pass);
			}
				
			
			return retorno;
		}
		
		//Agregamos el user name a la validacion
		private UsuarioVo validarPass(int index, String user,String pass) {
			UsuarioVo miUsuarioVo=miCoordinador.consultarUsuario(pass);
			int retorno=0;

			if (miUsuarioVo!=null) {
				if ( (index==ADMINISTRADOR && index==miUsuarioVo.getTipo() )|| (index==USUARIO && index==miUsuarioVo.getTipo() ) || (index==SECRETARIA && index==miUsuarioVo.getTipo() )) {
					if (pass.equals(miUsuarioVo.getPassword()) && user.equals(miUsuarioVo.getUsername())) {
						miCoordinador.abrirVentanaPrincipal(miUsuarioVo);
						miCoordinador.cerrarVentanaLogin();
						return miUsuarioVo;
						
					}else{
						 JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos");
					}
				}else{
					JOptionPane.showMessageDialog(null, "Tipo de usuario no coincide");
				}
			}else{
				JOptionPane.showMessageDialog(null, "Usuario no encontrado");
			}
			   return null;
		}

		public boolean validarCampos(UsuarioVo miUsuarioVo) {
			boolean validarNombre=false;
			boolean validarDocumento=false;
			
			String documento=miUsuarioVo.getDocumento();
			String nombre=miUsuarioVo.getNombre();
			
			if (documento!=null && !documento.equals("")) {
				validarDocumento=true;
			}
			
			if (nombre!=null && !nombre.equals("")) {
				validarNombre=true;
			}
			
			if (validarDocumento==true && validarNombre==true) {
				return true;
			}else{
				return false;	
			}
		}

		public Integer validarEdad(String edadIngresada) {
			Integer edad=null;
			try {
				edad=Integer.parseInt(edadIngresada);
			} catch (Exception e) {
				edad=null;
			}			
			return edad;
		}



}
