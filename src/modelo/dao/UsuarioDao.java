package modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modelo.conexion.Conexion;
import modelo.vo.UsuarioVo;
import controlador.Coordinador;

public class UsuarioDao {

    private Coordinador miCoordinador;

    public void setCoordinador(Coordinador miCoordinador) {
        this.miCoordinador = miCoordinador;
    }

    public String registrarUsuario(UsuarioVo miUsuarioVo) {
        String resultado = "";

        Connection connection = null;
        Conexion conexion = new Conexion();
        PreparedStatement preStatement = null;

        connection = conexion.getConnection();

        String consulta = "INSERT INTO usuario (documento, username, password, nombre, profesion, edad, direccion, telefono, tipo, estado)"
                + " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            preStatement = connection.prepareStatement(consulta);

            preStatement.setString(1, miUsuarioVo.getDocumento());
            preStatement.setString(2, miUsuarioVo.getUsername());
            preStatement.setString(3, miUsuarioVo.getPassword());
            preStatement.setString(4, miUsuarioVo.getNombre());
            preStatement.setString(5, miUsuarioVo.getProfesion());
            preStatement.setInt(6, miUsuarioVo.getEdad());
            preStatement.setString(7, miUsuarioVo.getDireccion());
            preStatement.setString(8, miUsuarioVo.getTelefono());
            preStatement.setInt(9, miUsuarioVo.getTipo());
            preStatement.setInt(10, miUsuarioVo.getEstado());

            // Convertir el rol en número antes de registrarlo
            int tipoUsuario = 0;
            String rol = miUsuarioVo.getRol();

            if (rol.equals("Administrador")) {
                tipoUsuario = 1;
            } else if (rol.equals("Usuario")) {
                tipoUsuario = 2;
            } else if (rol.equals("Secretaria")) {
                tipoUsuario = 3;
            }

            preStatement.setInt(9, tipoUsuario);

            preStatement.execute();
            resultado = "ok";

        } catch (SQLException e) {
            System.out.println("No se pudo registrar el dato: " + e.getMessage());
            resultado = "error";
        } finally {
            if (preStatement != null) {
                try {
                    preStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            conexion.desconectar();
        }

        return resultado;
    }

    public UsuarioVo consultarUsuario(String user, String pass) {
        Connection connection = null;
        Conexion miConexion = new Conexion();
        PreparedStatement statement = null;
        ResultSet result = null;

        UsuarioVo miUsuario = new UsuarioVo();

        connection = miConexion.getConnection();
        String consulta = "SELECT * FROM usuario where username = ? AND password = ?";
        ArrayList<UsuarioVo> listUser = new ArrayList<>();

        try {
            if (connection != null) {
                statement = connection.prepareStatement(consulta);
                statement.setString(1, user);
                statement.setString(2, pass);

                result = statement.executeQuery();

                while (result.next()) {
                    miUsuario = new UsuarioVo();
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
            } else {
                miUsuario = null;
            }

        } catch (SQLException e) {
            System.out.println("Error en la consulta del usuario: " + e.getMessage());
        }

        return miUsuario;
    }

    public UsuarioVo consultarUsuarioDoc(String doc) {
        Connection connection = null;
        Conexion miConexion = new Conexion();
        PreparedStatement statement = null;
        ResultSet result = null;

        UsuarioVo miUsuario = new UsuarioVo();

        connection = miConexion.getConnection();
        String consulta = "SELECT * FROM usuario where documento = ?";
        ArrayList<UsuarioVo> listUser = new ArrayList<>();

        try {
            if (connection != null) {
                statement = connection.prepareStatement(consulta);
                statement.setString(1, doc);

                result = statement.executeQuery();

                while (result.next()) {
                    miUsuario = new UsuarioVo();
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
            } else {
                miUsuario = null;
            }

        } catch (SQLException e) {
            System.out.println("Error en la consulta del usuario: " + e.getMessage());
        }

        return miUsuario;
    }

    public UsuarioVo actualizaUsuario(UsuarioVo miUsuarioVo, UsuarioVo usuarioActual) {
        UsuarioVo resultado = new UsuarioVo();
        Connection connection = null;
        PreparedStatement preStatement = null;
        Conexion miConexion = new Conexion();

        try {
            connection = miConexion.getConnection();
            String consulta;

            if (usuarioActual.getTipo() == 1) {
                consulta = "UPDATE usuario SET documento= ?, nombre = ?, profesion=?, edad=?, direccion=?, telefono=?, tipo=? WHERE documento= ?";
                preStatement = connection.prepareStatement(consulta);
                preStatement.setInt(7, miUsuarioVo.getTipo());
                preStatement.setString(8, miUsuarioVo.getDocumento());
            } else {
                if (!usuarioActual.getDocumento().equals(miUsuarioVo.getDocumento())) {
                    resultado.setMensaje("no modifica");
                    System.out.println("No puedes modificar un usuario que no seas tu");
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
        Connection connection = null;
        Conexion miConexion = new Conexion();
        String resp = "";

        try {
            connection = miConexion.getConnection();
            String sentencia = "UPDATE usuario SET tipo=4, estado = 0 WHERE documento = ?";
            PreparedStatement statement = connection.prepareStatement(sentencia);
            statement.setString(1, documento);

            int filasAfectadas = statement.executeUpdate();

            if (filasAfectadas > 0) {
                resp = "ok";
            }

        } catch (SQLException e) {
            System.out.println("Error al eliminar usuario: " + e.getMessage());
            resp = "error";
        } finally {
            if (connection != null) {
                miConexion.desconectar();
            }
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
