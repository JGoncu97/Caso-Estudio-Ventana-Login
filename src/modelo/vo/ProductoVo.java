package modelo.vo;

public class ProductoVo {
	
	private String idProducto;
	private String nombre;
	private double precio;
	private int cantidad;
	
	public ProductoVo(String idProducto, String nombre, double precio, int cantidad) {
		this.idProducto = idProducto;
		this.nombre = nombre;
		this.precio = precio;
		this.cantidad = cantidad;
		
	}
	
	public ProductoVo() {
		
	}

	public String getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(String idProducto) {
		this.idProducto = idProducto;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	@Override
	public String toString() {
		return "IdProducto = " + idProducto + "\n" +
				"Nombre = " + nombre + "\n" +
				"Precio = " + precio + "\n" +
				"Cantidad = " + cantidad;
		
	}
	

}
