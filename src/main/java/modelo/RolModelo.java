package modelo;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.ResultSet;

public class RolModelo extends Conector {
	PreparedStatement pst;
	
	public void crearRol(Rol rol) {
		try {
			pst=getConexion().prepareStatement("INSERT INTO roles (nombre)VALUES(?)");
			pst.setString(1, rol.getNombre());
			
			pst.execute();
			getConexion().close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Rol getRol(int id) {
		Rol rol = new Rol();
		try {
			pst = getConexion().prepareStatement("SELECT* FROM roles where id=?");
			ResultSet resultado=pst.executeQuery();
			resultado.next();
			rol.setId(resultado.getInt("id"));
			rol.setNombre(resultado.getString("nombre"));
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	return rol;	
	}
	
	public ArrayList<Rol> getRoles() throws SQLException {
		ArrayList<Rol>roles = new ArrayList<>();
		
		try {
			pst = getConexion().prepareStatement("SELECT * from roles");
			ResultSet resultado = pst.executeQuery();
			while(resultado.next()) {
				Rol rol = new Rol();
				rol.setId(resultado.getInt("id_rol"));
				rol.setNombre(resultado.getString("nombre"));
				
				roles.add(rol);	
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		getConexion().close();
		return roles;
		}

}
