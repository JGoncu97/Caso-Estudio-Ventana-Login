package modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import controlador.Coordinador;
import modelo.conexion.Conexion;
import modelo.vo.ProductoVo;

public class ProductoDao {

	private Coordinador miCoordinador;
	
	public String registrarProducto(ProductoVo miProductoVo) {
		String resultado = "";
		
		Connection connection = null;
		Conexion conexion=Conexion.getInstancia();
		PreparedStatement preStatement = null;
		
		connection = conexion.getConnection();
		String consulta = "INSERT INTO productos (id_producto, nombre, precio, cantidad) VALUES (?,?,?,?)";
		
		try {
			preStatement = connection.prepareStatement(consulta);
			preStatement.setString(1, miProductoVo.getIdProducto());
			preStatement.setString(2, miProductoVo.getNombre());
			preStatement.setDouble(3, miProductoVo.getPrecio());
			preStatement.setInt(4, miProductoVo.getCantidad());
			preStatement.execute();
			
			resultado = "Registro de Producto exitoso";
			
		} catch (SQLException e) {
			resultado = "Error, No se pudo registrar el producto correctamente " + e.getMessage();
			
		} finally {
			try {
				if (preStatement != null) preStatement.close();
				conexion.desconectar();
				System.out.println("Todos los recursos han sido cerrados");
				
			} catch (SQLException e) {
				throw new RuntimeException("Error al cerrar los recursos: " + e.getMessage());
				
			}
		}		
		
		return resultado;
		
	}
	
	public ProductoVo consultarProducto(String idProducto) {
		Connection connection = null;
		Conexion conexion=Conexion.getInstancia();
		PreparedStatement preStatement = null;
		ResultSet result = null;
		ProductoVo miProductoVo = null;
		
		connection = conexion.getConnection();
		String consulta = "SELECT id_producto, nombre, precio, cantidad FROM productos WHERE id_producto =?";
		
		try {
			if (connection != null) {
				preStatement = connection.prepareStatement(consulta);
				preStatement.setString(1, idProducto);
				result = preStatement.executeQuery();
				
				if (result.next()) {
					miProductoVo = new ProductoVo();
					miProductoVo.setIdProducto(result.getString("id_producto"));
					miProductoVo.setNombre(result.getString("nombre"));
					miProductoVo.setPrecio(result.getDouble("precio"));
					miProductoVo.setCantidad(result.getInt("cantidad"));
					
				}
				
			}			
				
		} catch (SQLException e) {
			throw new RuntimeException("Error en la consulta del producto " + e.getMessage());
			
		} finally {
			
			try {
				if (result != null) result.close();
				if (preStatement != null) preStatement.close();
				conexion.desconectar();
				System.out.println("Todos los recursos han sido cerrados");
				
			} catch (SQLException e) {
				throw new RuntimeException("Error al cerrar los recursos: " + e.getMessage());
				
			}
			
		}
		return miProductoVo;
	}
	
	public List<ProductoVo> consultarProductos() {
		List<ProductoVo> miListaProductos = new ArrayList<ProductoVo>();
		
		Connection connection = null;
		Conexion conexion=Conexion.getInstancia();
		PreparedStatement preStatement = null;
		ResultSet result = null;
		
		connection = conexion.getConnection();
		String consulta = "SELECT id_producto, nombre, precio, cantidad FROM productos";
		
		try {
			if (connection != null) {
				preStatement = connection.prepareStatement(consulta);
				result = preStatement.executeQuery();
				
				while (result.next()) {
					ProductoVo miProductoVo = new ProductoVo();
					miProductoVo.setIdProducto(result.getString("id_producto"));
					miProductoVo.setNombre(result.getString("nombre"));
					miProductoVo.setPrecio(result.getDouble("precio"));
					miProductoVo.setCantidad(result.getInt("cantidad"));				
					
					miListaProductos.add(miProductoVo);
					
				}
				
			}			
				
		} catch (SQLException e) {
			throw new RuntimeException("Error en la consulta de los productos " + e.getMessage());
			
		} finally {
			
			try {
				if (result != null) result.close();
				if (preStatement != null) preStatement.close();
				conexion.desconectar();
				System.out.println("Todos los recursos han sido cerrados");
				
			} catch (SQLException e) {
				throw new RuntimeException("Error al cerrar los recursos: " + e.getMessage());
				
			}
			
		}
		return miListaProductos;
		
	}
	
	public String actualizarProducto(ProductoVo miProductoVo) {
		String resultado = "";
		String idProducto = miProductoVo.getIdProducto();
		
		Connection connection = null;
		Conexion conexion=Conexion.getInstancia();
		PreparedStatement preStatement = null;
		ResultSet result = null;
		
		connection = conexion.getConnection();
		
		try {
			String consulta = "SELECT * FROM productos WHERE id_producto = ?";
			if (connection != null) {
				preStatement = connection.prepareStatement(consulta);
				preStatement.setString(1, idProducto);
				result = preStatement.executeQuery();
				
				if (result.next()) {
					consulta = "UPDATE productos SET id_producto = ?, nombre = ?, precio = ?, cantidad = ? WHERE id_producto = ?";
					preStatement = connection.prepareStatement(consulta);
					preStatement.setString(1, miProductoVo.getIdProducto());
					preStatement.setString(2, miProductoVo.getNombre());
					preStatement.setDouble(3, miProductoVo.getPrecio());
					preStatement.setInt(4, miProductoVo.getCantidad());
					preStatement.setString(5, miProductoVo.getIdProducto());
					preStatement.executeUpdate();
					
					resultado = "El producto " + miProductoVo.getNombre() + " Ha sido actualizado";
					
				} else {
					resultado = "El producto que intenta actualizar no ha sido registrado";
					
				}
				
			}
			
		} catch (SQLException e) {
			resultado = "Error: " + e.getMessage();
			
		} finally {
			try {
				if (result != null) result.close();
				if (preStatement != null) preStatement.close();
				conexion.desconectar();
				System.out.println("Todos los recursos han sido cerrados");
				
			} catch (SQLException e) {
				throw new RuntimeException("Error al cerrar los recursos: " + e.getMessage());
				
			}
			
		}		
		return resultado;
				
	}
	
	public String eliminarProducto(String idProducto) {
		String resultado = "";
		
		Connection connection = null;
		Conexion conexion=Conexion.getInstancia();
		PreparedStatement preStatement = null;
		ResultSet result = null;
		
		connection = conexion.getConnection();
		
		try {
			String consulta = "SELECT * FROM productos WHERE id_producto = ?";
			if (connection != null) {
				preStatement = connection.prepareStatement(consulta);
				preStatement.setString(1, idProducto);
				result = preStatement.executeQuery();
				
				if (result.next()) {
					consulta = "DELETE FROM productos WHERE id_producto = ?";
					preStatement = connection.prepareStatement(consulta);
					preStatement.setString(1, idProducto);
					preStatement.executeUpdate();
					resultado = "El producto ha sido eliminada satisfactoriamente";
					
				} else {
					resultado = "El producto que intenta eliminar no ha sido registrado";
					
				}
			}
										
		} catch (SQLException e) {
			resultado = "Error";
			throw new RuntimeException(e.getMessage());
			
		} finally {
			try {
				if (result != null) result.close();
				if (preStatement != null) preStatement.close();
				conexion.desconectar();
				System.out.println("Todos los recursos han sido cerrados");
				
			} catch (SQLException e) {
				throw new RuntimeException("Error al cerrar los recursos: " + e.getMessage());
			
			}
			
		}
		return resultado;
		
	}
	
	
	public void setCoordinador(Coordinador miCoordinador) {
		this.miCoordinador = miCoordinador;
		
	}
	
	

}
