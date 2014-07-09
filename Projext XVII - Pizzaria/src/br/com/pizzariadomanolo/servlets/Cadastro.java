package br.com.pizzariadomanolo.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.pizzariadomanolo.entidades.Cliente;

/**
 * Servlet implementation class Cadastro
 */
@WebServlet("/Cadastro")
public class Cadastro extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Cadastro() {
        super();
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
		
		String telefone = request.getParameter("telefone");
		String nome = request.getParameter("nome");
		String endereco = request.getParameter("endereco");
		String senha = request.getParameter("senha");
		String confirmarSenha = request.getParameter("confirmarSenha");
		
		Cliente cliente = new Cliente();
		if ("".equals(telefone.trim()) || "".equals(nome.trim()) || "".equals(endereco.trim())) {
			out.println("<font color=red>Telefone, Nome ou Endereço vazios!</font>");
			RequestDispatcher rs = request.getRequestDispatcher("cadastro.jsp");
			rs.include(request, response);
		}
		else if (("".equals(senha) && "".equals(confirmarSenha)) || !senha.equals(confirmarSenha)) {
			out.println("<font color=red>Senhas não conferem!</font>");
			RequestDispatcher rs = request.getRequestDispatcher("cadastro.jsp");
			rs.include(request, response);
		}
		else if (cliente.verificaExistenciaCliente(telefone)) {
			out.println("<font color=red>Telefone já cadastrado!</font>");
			RequestDispatcher rs = request.getRequestDispatcher("cadastro.jsp");
			rs.include(request, response);
		}
		else {
			cliente.setEndereco(endereco);
			cliente.setNome(nome);
			cliente.setSenha(senha);
			cliente.setTelefone(telefone);
			
			cliente.cadastrarCliente();
			
			response.sendRedirect("index.jsp");
			//RequestDispatcher rs = request.getRequestDispatcher("index.jsp");
			//rs.forward(request, response);
		}
	}

}
