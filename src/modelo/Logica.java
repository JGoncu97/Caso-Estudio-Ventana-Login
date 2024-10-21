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
			
			UsuarioVo retorno = new UsuarioVo();
			
			if (index==SELECCION) {
				retorno.setMensaje("error");
			}else{
				retorno=validarPass(index, user,pass);
			}
				
			
			return retorno;
		}
		
		//Agregamos el user name a la validacion
		private UsuarioVo validarPass(int index, String user,String pass) {
			UsuarioVo miUsuarioVo=miCoordinador.consultarUsuario(user ,pass);
			  UsuarioVo retorno = new UsuarioVo();
			
			 if (miUsuarioVo != null) {
			        // Validamos primero si el estado es 1 (activo)
			        if (miUsuarioVo.getEstado() != 1) {
			            JOptionPane.showMessageDialog(null, "El usuario está inactivo.");
			            return null;
			        }
			
			if (miUsuarioVo!=null) {
				if ( (index==ADMINISTRADOR && index==miUsuarioVo.getTipo() )|| (index==USUARIO && index==miUsuarioVo.getTipo() ) || (index==SECRETARIA && index==miUsuarioVo.getTipo() )) {
					if (pass.equals(miUsuarioVo.getPassword()) && user.equals(miUsuarioVo.getUsername())) {
						miCoordinador.abrirVentanaPrincipal(miUsuarioVo);
						miCoordinador.cerrarVentanaLogin();
						return miUsuarioVo;
						
					  } else {
		                    retorno.setMensaje("invalido");
		                }
		            } else {
		                retorno.setMensaje("invalido");
		            }
		        } else {
		            retorno.setMensaje("desconectado");
		        }
		    }
		    return retorno; // Aquí se devuelve el objeto retorno
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
