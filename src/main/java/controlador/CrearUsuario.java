package controlador;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Usuario;
import modelo.UsuarioModelo;
import modelo.Rol;
import modelo.RolModelo;
import java.util.ArrayList;

/**
 * Servlet implementation class CrearUsuario
 */
@WebServlet("/CrearUsuario")
public class CrearUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CrearUsuario() {
        super();
      
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		RolModelo rolMod = new RolModelo();
		ArrayList<Rol>roles= new ArrayList<>();
		
		try {
			roles = rolMod.getRoles();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.setAttribute("roles", roles);
		request.getRequestDispatcher("CrearUsuario.jsp").forward(request, response);
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		Usuario usuario = new Usuario();
		UsuarioModelo usuarioMod = new UsuarioModelo();
		RolModelo rolMod = new RolModelo();
		String rol = request.getParameter("rol");
		
		usuario.setNombre(request.getParameter("nombre"));
		usuario.setPassword(request.getParameter("password"));
	
		Date fecha_login = null;
		
		
		try {
			fecha_login=new SimpleDateFormat("yyyy-mm-dd").parse(request.getParameter("fecha_login"));
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			usuario.setFecha_login(fecha_login);
			
			usuario.setRol(rolMod.getRol(rol));
			
			usuarioMod.crearUsuario(usuario);
			try {
				usuarioMod.getConexion().close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			response.sendRedirect("Principal");
		

		
		
		
		
	}

}
