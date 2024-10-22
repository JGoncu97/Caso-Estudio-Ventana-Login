package modelo.conexion;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;
import java.io.FileInputStream;

import javax.swing.JOptionPane;



public class Conexion {
	
	Properties propiedades = new Properties();
	/*
	 * private String nombreBd="usuario_bd";
	private String usuario="root";
	private String password="1234";
	private String url="jdbc:mysql://localhost/"+nombreBd;*/
	
	private String nombreBd="";
	private String usuario="";
	private String password="";
	private String url="";

	Connection conn=null;
	//constructor de la clase
	public Conexion(){
		cargarCredenciales();
		
		try {
			
			//obtener el driver
			Class.forName("com.mysql.jdbc.Driver");

			//obtener la conexion
			conn=DriverManager.getConnection(url,usuario,password);
			if (conn!=null) {
				System.out.println("Conexion Exitosa  a la BD: "+nombreBd);
			}
		} catch (ClassNotFoundException e) {
			System.out.println("ocurre una ClassNotFoundException : "+e.getMessage());
		} catch (SQLException e) {
			System.out.println("ocurre una SQLException: "+e.getMessage());
		}
	}
	
	private void cargarCredenciales() {
		try {
			propiedades.load(
					new FileInputStream("C:\\Users\\SENA\\Desktop\\019\\Caso-Estudio-Ventana-Login\\properties\\credenciales.properties"));
			
			nombreBd=propiedades.getProperty("db.nombreBd");
			usuario=propiedades.getProperty("db.usuario");
			password=propiedades.getProperty("db.password");
			url = "jdbc:mysql://localhost:3306/" + nombreBd;

			
		}catch (FileNotFoundException e) {
			System.out.println("Error, El archivo no exite");
			e.printStackTrace();
		}catch (IOException e) {
			System.out.println("Error, No se puede leer el archivo");
			e.printStackTrace();
			}
	}
	
	
	
	public Connection getConnection(){
		return conn;
	}
	public void desconectar(){
		conn=null;
	}
}

