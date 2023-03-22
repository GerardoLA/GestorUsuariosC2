package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UsuarioModelo extends Conector {
	PreparedStatement pst ;
	
	
	public void crearUsuario(Usuario usuario) {
		try {
			
			pst = getConexion().prepareStatement("INSERT INTO usuarios (nombre,password) VALUES (?,?)");
			pst.setString(1, usuario.getNombre());
			pst.setString(2, usuario.);
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
			pst=getConexion().prepareStatement("UPDATE usuarios set nombre=? where id =?");
			pst.setString(1, usuario.getNombre());
			pst.setInt(2, usuario.getId());
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
		usuario.setNombre(resultado.getString("nombre"));
		usuario.setId(resultado.getInt("id"));
		
		
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return usuario;
}
}
