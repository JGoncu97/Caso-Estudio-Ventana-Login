package modelo.vo;

import java.util.Date;

public class CompraVo {
	
	private int idCompras;
	private String idProducto;
	private String idUsuario;
	private Date fecha;
	private double precioTotal;
	
	public CompraVo(int idCompras, String idProducto, String idUsuario, Date fecha, double precioTotal) {
		this.idCompras = idCompras;
		this.idProducto = idProducto;
		this.idUsuario = idUsuario;
		this.fecha = fecha;
		this.precioTotal = precioTotal;
	}
	
	public CompraVo() {	
	}

	public int getIdCompras() {
		return idCompras;
	}

	public void setIdCompras(int idCompras) {
		this.idCompras = idCompras;
	}

	public String getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(String idProducto) {
		this.idProducto = idProducto;
	}

	public String getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(String idUsuario) {
		this.idUsuario = idUsuario;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public double getPrecioTotal() {
		return precioTotal;
	}

	public void setPrecioTotal(double precioTotal) {
		this.precioTotal = precioTotal;
	}

	@Override
	public String toString() {
		return "CompraVo [idCompras=" + idCompras + ", idProducto=" + idProducto + ", idUsuario=" + idUsuario
				+ ", fecha=" + fecha + ", precioTotal=" + precioTotal + "]";
	}
	
}
