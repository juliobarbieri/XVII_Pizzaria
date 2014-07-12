package br.com.pizzariadomanolo.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.pizzariadomanolo.DAO.POSTGRES.ClienteDAOPostgres;
import br.com.pizzariadomanolo.entidades.Cliente;
import br.com.pizzariadomanolo.entidades.Pedido;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public Login() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		ClienteDAOPostgres cadastro = new ClienteDAOPostgres();
		
		String usuario = request.getParameter("usuario");
		String senha = request.getParameter("senha");
		
		Cliente cliente = new Cliente();
		Pedido pedido = new Pedido();
		cliente.criaCliente(null, usuario, null, null);
		pedido.criaPedido(usuario);
		
		if (cadastro.validaCliente(cliente, senha)) {
			HttpSession session = request.getSession();
			session.setAttribute("cliente", cliente);
			session.setAttribute("pedido", pedido);
			response.sendRedirect("index.jsp");
		}
		else {
			RequestDispatcher rs = request.getRequestDispatcher("login.jsp");
			out.println("<font color=red>Nome de usuário ou senha incorretos!</font>");
			rs.include(request, response);
		}
	}

}
