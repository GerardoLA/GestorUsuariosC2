package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;

public class UsuarioModelo extends Conector {
	PreparedStatement pst ;
	
	
	public void crearUsuario(Usuario usuario) {
		try {
			
			pst = getConexion().prepareStatement("INSERT INTO usuarios (nombre,password,fecha_login) VALUES (?,?,?)");
			pst.setString(1, usuario.getNombre());
			pst.setString(2, usuario.getContrasena());
			pst.setDate(3, new Date(usuario.getFecha_login().getTime()));
			
			
			pst.execute();
			getConexion().close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public ArrayList<Usuario>getUsuarios() throws SQLException{
		ArrayList<Usuario>usuarios=new ArrayList<>();
		
		try {
			pst=getConexion().prepareStatement("SELECT* FROM usuarios");
			ResultSet resultado=pst.executeQuery();
			
			while (resultado.next()) {
				Usuario usuario = new Usuario();
				usuario.setId(resultado.getInt("id"));
				usuario.setNombre(resultado.getString("nombre"));
				usuario.setContrasena(resultado.getString("contrasena"));
				
				
				usuarios.add(usuario);

			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		getConexion().close();
		return usuarios;
	}
	
	public boolean modificarUsuario(Usuario usuario) {
		
		try {
			pst=getConexion().prepareStatement("UPDATE usuarios set nombre=?,password=?,fecha_login=? where id =?");
			pst.setString(1, usuario.getNombre());
			pst.setString(2, usuario.getContrasena());
			pst.setDate(3, new Date(usuario.getFecha_login().getTime()));
			pst.setInt(4, usuario.getId());
			pst.execute();
			getConexion().close();
			return true;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
	}
	
public boolean eliminarUsuario(int id) {
	try {
		pst=getConexion().prepareStatement("DELETE from usuarios where id=?");
		pst.setInt(1,id);
		pst.execute();
		getConexion().close();
		return true;
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return false;
}
public Usuario getUsuario(int id) {
	Usuario usuario = new Usuario();
	try {
		pst = getConexion().prepareStatement("SELECT* from usuarios where id=?");
		pst.setInt(1, id);
		ResultSet resultado=pst.executeQuery();
		resultado.next();
		
		usuario.setId(resultado.getInt("id"));
		usuario.setNombre(resultado.getString("nombre"));
		usuario.setContrasena(resultado.getString("contrasena"));
		usuario.setFecha_login(resultado.getDate("fecha_login"));
		
		
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return usuario;
}
}
