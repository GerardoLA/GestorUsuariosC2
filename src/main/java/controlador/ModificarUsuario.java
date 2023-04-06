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

/**
 * Servlet implementation class ModificarUsuario
 */
@WebServlet("/ModificarUsuario")
public class ModificarUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModificarUsuario() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Usuario usuario = new Usuario();
		usuario.setId(Integer.parseInt(request.getParameter("id")));
		usuario.setNombre(request.getParameter("nombre"));
		usuario.setPassword(request.getParameter("password"));
		Date fecha_login=null;
		try {
			fecha_login = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("fecha_login"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		usuario.setFecha_login(fecha_login);
		UsuarioModelo usuarioMod = new UsuarioModelo();
		usuarioMod.modificarUsuario(usuario);
		System.out.println("Modificado");
		
		try {
			
			usuarioMod.getConexion().close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//request.getRequestDispatcher("ModificarUsuario.jsp").forward(request, response);
		response.sendRedirect("VerUsuarios");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Usuario usuario = new Usuario();
		usuario.setId(Integer.parseInt(request.getParameter("id")));
		usuario.setNombre(request.getParameter("nombre"));
		usuario.setPassword(request.getParameter("password"));
		Date fecha_login = null;
		
		try {
			fecha_login = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("fecha_login"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		usuario.setFecha_login(fecha_login);
		UsuarioModelo usuarioMod = new UsuarioModelo();
		usuarioMod.modificarUsuario(usuario);
		
		
		
	}

}



