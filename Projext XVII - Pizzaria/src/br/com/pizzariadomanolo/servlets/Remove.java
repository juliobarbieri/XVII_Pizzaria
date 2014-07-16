package br.com.pizzariadomanolo.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.pizzariadomanolo.entidades.Pedido;

/**
 * Servlet implementation class Remove
 */
@WebServlet("/Remove")
public class Remove extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Remove() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nomePizza = request.getParameter("pizza");
		String quantidade = request.getParameter("qnt");
		
		HttpSession session = request.getSession();
		Pedido pedido = (Pedido) session.getAttribute("pedido");
		
		pedido.removerItem(nomePizza, Integer.parseInt(quantidade));
		
		session.setAttribute("pedido", pedido);
		
		response.sendRedirect("/WEB-INF/pedido.jsp");
	}

}
