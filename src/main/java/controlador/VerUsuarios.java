package controlador;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Usuario;
import modelo.UsuarioModelo;
import modelo.RolModelo;
import modelo.Rol;
/**
 * Servlet implementation class VerUsuarios
 */
@WebServlet("/VerUsuarios")
public class VerUsuarios extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VerUsuarios() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//datuak lortu
		UsuarioModelo usuarioMod = new UsuarioModelo();
		ArrayList<Usuario> usuarios=new  ArrayList<Usuario>();
		try {
			usuarios = usuarioMod.getUsuarios();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		RolModelo rolMod = new RolModelo(); 
		ArrayList<Rol>roles = new ArrayList<>();
		
		//vistarako prestatu
		request.setAttribute("roles", roles);
		request.setAttribute("usuarios", usuarios);
		
		
		request.getRequestDispatcher("ventanaPrincipal.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
