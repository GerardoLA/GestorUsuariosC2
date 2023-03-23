package modelo;

import java.util.Date;

public class Usuario {
	private int id;
	private String nombre;
	private String password;
	private Date fecha_login;
	
	
	public Date getFecha_login() {
		return fecha_login;
	}
	public void setFecha_login(Date fecha_login) {
		this.fecha_login = fecha_login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public Usuario() {
		super();
	}
	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nombre=" + nombre + ", password=" + password + ", fecha_login=" + fecha_login
				+ "]";
	}
	public Usuario(int id, String nombre, String password, Date fecha_login) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.password = password;
		this.fecha_login = fecha_login;
	}
	

}
