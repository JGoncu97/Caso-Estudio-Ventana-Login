package modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;

import modelo.conexion.Conexion;
import modelo.vo.UsuarioVo;

import controlador.Coordinador;

public class UsuarioDao {
	
	private Coordinador miCoordinador;

	public void setCoordinador(Coordinador miCoordinador) {
		this.miCoordinador=miCoordinador;
	}

	public String registrarUsuario(UsuarioVo miUsuarioVo) {
		String resultado="";
			
		Connection connection=null;
		Conexion conexion=new Conexion();
		PreparedStatement preStatement=null;
		
		connection=conexion.getConnection();
		String consulta="INSERT INTO usuario (documento,nombre,profesion,edad,direccion,telefono,tipo)" +
				" VALUES (?,?,?,?,?,?,?)";
		
		try {
			preStatement = connection.prepareStatement(consulta);
			preStatement.setString(1, miUsuarioVo.getDocumento());
			preStatement.setString(2,miUsuarioVo.getNombre());
			preStatement.setString(3,miUsuarioVo.getProfesion());
			preStatement.setInt(4, miUsuarioVo.getEdad());
			preStatement.setString(5, miUsuarioVo.getDireccion());
			preStatement.setString(6, miUsuarioVo.getTelefono());
			preStatement.setInt(7, miUsuarioVo.getTipo());
			preStatement.execute();
			
			resultado="ok";
			
		} catch (SQLException e) {
			System.out.println("No se pudo registrar el dato: "+e.getMessage());
			resultado="error";
		}
		
		conexion.desconectar();
		   
		return resultado;
	}
	//Modificamos el argumento para recibir la pass en vez del doc
	public UsuarioVo consultarUsuario(String user,String pass) {
		Connection connection=null;
		Conexion miConexion=new Conexion();
		PreparedStatement statement=null;
		ResultSet result=null;
		
		UsuarioVo miUsuario=new UsuarioVo();
		
		connection=miConexion.getConnection();
		//Cambiamos la consulta SQL para validar la existencia del password y mandar el usuario
		String consulta="SELECT * FROM usuario where username = ? AND password = ?";
		ArrayList<UsuarioVo> listUser=new ArrayList<UsuarioVo>();
		try {
			if (connection!=null) {
				statement=connection.prepareStatement(consulta);
				statement.setString(1, user);
				statement.setString(2, pass);
				
				result=statement.executeQuery();
				
				while(result.next()==true){
					miUsuario=new UsuarioVo();
					miUsuario.setDocumento(result.getString("documento"));
					miUsuario.setUsername(result.getString("username"));
					miUsuario.setPassword(result.getString("password"));
					miUsuario.setNombre(result.getString("nombre"));
					miUsuario.setProfesion(result.getString("profesion"));
					miUsuario.setEdad(result.getInt("edad"));
					miUsuario.setDireccion(result.getString("direccion"));
					miUsuario.setTelefono(result.getString("telefono"));		
					miUsuario.setTipo(result.getInt("tipo"));
					
					listUser.add(miUsuario);
				}		
				   miConexion.desconectar();
			}else{
				miUsuario=null;
			}
			
			   
		} catch (SQLException e) {
			System.out.println("Error en la consulta del usuario: "+e.getMessage());
		}
		
		return miUsuario;
	}
	
	public UsuarioVo consultarUsuarioDoc(String doc) {
		Connection connection=null;
		Conexion miConexion=new Conexion();
		PreparedStatement statement=null;
		ResultSet result=null;
		
		UsuarioVo miUsuario=new UsuarioVo();
		
		connection=miConexion.getConnection();
		//Cambiamos la consulta SQL para validar la existencia del password y mandar el usuario
		String consulta="SELECT * FROM usuario where documento = ?";
		ArrayList<UsuarioVo> listUser=new ArrayList<UsuarioVo>();
		try {
			if (connection!=null) {
				statement=connection.prepareStatement(consulta);
				statement.setString(1, doc);
				
				result=statement.executeQuery();
				
				while(result.next()==true){
					miUsuario=new UsuarioVo();
					miUsuario.setDocumento(result.getString("documento"));
					miUsuario.setUsername(result.getString("username"));
					miUsuario.setPassword(result.getString("password"));
					miUsuario.setNombre(result.getString("nombre"));
					miUsuario.setProfesion(result.getString("profesion"));
					miUsuario.setEdad(result.getInt("edad"));
					miUsuario.setDireccion(result.getString("direccion"));
					miUsuario.setTelefono(result.getString("telefono"));		
					
					miUsuario.setTipo(result.getInt("tipo"));
					
					listUser.add(miUsuario);
				}		
				   miConexion.desconectar();
			}else{
				miUsuario=null;
			}
			
			   
		} catch (SQLException e) {
			System.out.println("Error en la consulta del usuario: "+e.getMessage());
		}
		
		return miUsuario;
	}

	public UsuarioVo actualizaUsuario(UsuarioVo miUsuarioVo,UsuarioVo usuarioActual) {
		 	UsuarioVo resultado = new UsuarioVo();
		    Connection connection = null;
		    PreparedStatement preStatement = null;
		    Conexion miConexion = new Conexion();

		    try {
		        connection = miConexion.getConnection();
		        String consulta;

		        
		        if (usuarioActual.getTipo() == 1) { 
		        	System.out.println("Entra en la condicion de usuarioActual");
		         
		            consulta = "UPDATE usuario SET documento= ?, nombre = ?, profesion=?, edad=?, direccion=?, telefono=?, tipo=? WHERE documento= ?";
		            preStatement = connection.prepareStatement(consulta);
		            preStatement.setInt(7, miUsuarioVo.getTipo());
		            System.out.println("Tipo de usuario a actualizar: " + miUsuarioVo.getTipo());

		            preStatement.setString(8, miUsuarioVo.getDocumento());
		        } else {
		           
		            if (!usuarioActual.getDocumento().equals(miUsuarioVo.getDocumento())) {
		                resultado.setMensaje("error: no tienes permiso para actualizar los datos de otro usuario");
		            }
		            consulta = "UPDATE usuario SET documento= ?, nombre = ?, profesion=?, edad=?, direccion=?, telefono=? WHERE documento= ?";
		            preStatement = connection.prepareStatement(consulta);
		            preStatement.setString(7, usuarioActual.getDocumento());
		        }

		        
		        preStatement.setString(1, miUsuarioVo.getDocumento());
		        preStatement.setString(2, miUsuarioVo.getNombre());
		        preStatement.setString(3, miUsuarioVo.getProfesion());
		        preStatement.setInt(4, miUsuarioVo.getEdad());
		        preStatement.setString(5, miUsuarioVo.getDireccion());
		        preStatement.setString(6, miUsuarioVo.getTelefono());

		     
		        preStatement.executeUpdate();
		        System.out.println(preStatement.toString());
		        resultado.setMensaje("ok");

		    } catch (SQLException e) {
		        System.out.println("Error al actualizar el usuario: " + e.getMessage());
		        resultado.setMensaje("error");
		    } finally {
		     
		        try {
		            if (preStatement != null) {
		                preStatement.close();
		            }
		            if (connection != null) {
		                miConexion.desconectar();
		            }
		        } catch (SQLException e) {
		            System.out.println("Error al cerrar recursos: " + e.getMessage());
		        }
		    }
		    return resultado;
	}

	public String eliminarUsuario(String documento) {
		Connection connection=null;
		Conexion miConexion=new Conexion();
		connection=miConexion.getConnection();
		
		String resp="";
		try {
			String sentencia="Update usuario SET tipo=4, estado = 0 WHERE documento = ? ";

			PreparedStatement statement = connection.prepareStatement(sentencia);
			statement.setString(1, documento);
			
			statement.executeUpdate();
						
			resp="ok";
            statement.close();
            miConexion.desconectar();
			
		} catch (SQLException e) {
            System.out.println(e.getMessage());
			resp="error";
		}
		return resp;
	}

	public List<UsuarioVo> obtenerTodosLosUsuarios(UsuarioVo usuarioActual) {
		List<UsuarioVo> listaUsuarios = new ArrayList<>();
	    Connection connection = null;
	    Conexion miConexion=new Conexion();
	    PreparedStatement statement = null;
	    ResultSet resultSet = null;

	    String consulta;
	    if (usuarioActual.getTipo() == 1) { 
	        consulta = "SELECT * FROM usuario"; 
	    } else {
	        consulta = "SELECT * FROM usuario WHERE estado = 1"; 
	    }


	    try {
	    	connection=miConexion.getConnection();
	        statement = connection.prepareStatement(consulta);
	        resultSet = statement.executeQuery();

	        while (resultSet.next()) {
	            UsuarioVo miUsuario = new UsuarioVo();
	            miUsuario.setDocumento(resultSet.getString("documento"));
	            miUsuario.setUsername(resultSet.getString("username"));
	            miUsuario.setPassword(resultSet.getString("password"));
	            miUsuario.setNombre(resultSet.getString("nombre"));
	            miUsuario.setProfesion(resultSet.getString("profesion"));
	            miUsuario.setEdad(resultSet.getInt("edad"));
	            miUsuario.setDireccion(resultSet.getString("direccion"));
	            miUsuario.setTelefono(resultSet.getString("telefono"));
	            miUsuario.setTipo(resultSet.getInt("tipo"));
	            listaUsuarios.add(miUsuario);
	        }
	    } catch (SQLException e) {
	        System.out.println("Error al obtener todos los usuarios: " + e.getMessage());
	    } finally {
	    	  try {
		            if (statement != null) {
		            	statement.close();
		            }
		            if (connection != null) {
		                miConexion.desconectar();
		            }
		        } catch (SQLException e) {
		            System.out.println("Error al cerrar recursos: " + e.getMessage());
		        }
	    }

	    return listaUsuarios;
	}
	
		

}
