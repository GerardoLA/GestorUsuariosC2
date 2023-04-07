package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;

public class UsuarioModelo extends Conector {
	PreparedStatement pst ;
	
	
	public boolean crearUsuario(Usuario usuario) {
		try {
			
			pst = getConexion().prepareStatement("INSERT INTO usuarios (nombre,password,fecha_login,id_rol) VALUES (?,?,?,?)");
			pst.setString(1, usuario.getNombre());
			pst.setString(2, usuario.getPassword());
			pst.setDate(3, new Date(usuario.getFecha_login().getTime()));
			pst.setInt(4, usuario.getRol().getId());
			pst.execute();
			getConexion().close();
			return false;
		} catch (SQLException e) {
		
			e.printStackTrace();
			return true;
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
				usuario.setPassword(resultado.getString("password"));
				usuario.setFecha_login(resultado.getDate("fecha_login"));
				
				RolModelo rolMod = new RolModelo();
				usuario.setRol(rolMod.getRol(resultado.getInt("id_rol")));
				
				
				
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
			pst=getConexion().prepareStatement("UPDATE usuarios set nombre=?,password=?,fecha_login=?, rol=? where id =?");
			pst.setString(1, usuario.getNombre());
			pst.setString(2, usuario.getPassword());
			pst.setDate(3,new Date(usuario.getFecha_login().getTime()));
			pst.setInt(4, usuario.getRol().getId());
			
			pst.setInt(5, usuario.getId());
			
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
		usuario.setPassword(resultado.getString("password"));
		usuario.setFecha_login(resultado.getDate("fecha_login"));
		
		RolModelo rolMod = new RolModelo();
		
		usuario.setRol(rolMod.getRol(resultado.getInt("id_rol")));
			
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return usuario;
}
}
