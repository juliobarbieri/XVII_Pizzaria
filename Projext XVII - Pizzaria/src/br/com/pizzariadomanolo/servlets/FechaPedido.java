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

import br.com.pizzariadomanolo.DAO.PedidoDAO;
import br.com.pizzariadomanolo.DAO.POSTGRES.PedidoDAOPostgres;
import br.com.pizzariadomanolo.entidades.Cliente;
import br.com.pizzariadomanolo.entidades.Pedido;
import br.com.pizzariadomanolo.util.FormaPagamento;

/**
 * Servlet implementation class Pedido
 */
@WebServlet("/FechaPedido")
public class FechaPedido extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FechaPedido() {
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
		String formaPagamento = request.getParameter("formaPagamento");
		String troco = request.getParameter("troco");
		
		HttpSession session = request.getSession();
		Pedido pedido = (Pedido) session.getAttribute("pedido");
		
		pedido.setFormaPagamento(formaPagamento);
		
		if (pedido.getItens().isEmpty()) {
			RequestDispatcher rs = request.getRequestDispatcher("/WEB-INF/fecharPedido.jsp");
			PrintWriter out = response.getWriter();
			out.println("<font color=red>Não há itens em seu pedido!</font>");
			rs.include(request, response);
		}
		else if (formaPagamento.equals(FormaPagamento.DINHTRC.toString())) {
			try {
				Float trocoFloat = Float.parseFloat(troco);
				pedido.setTroco(trocoFloat);
				salvaPedido(session, response, pedido);
			} catch (NumberFormatException e) {
				RequestDispatcher rs = request.getRequestDispatcher("/WEB-INF/fecharPedido.jsp");
				PrintWriter out = response.getWriter();
				out.println("<font color=red>Troco em formato errado!</font>");
				rs.include(request, response);
			}
		}
		else {
			pedido.setTroco((float) 0.0);
			salvaPedido(session, response, pedido);
		}
	}
	private void salvaPedido(HttpSession session, HttpServletResponse response, Pedido pedido) throws IOException {
		PedidoDAO pedidoDAO = new PedidoDAOPostgres();
		pedidoDAO.cadastrarPedido(pedido);
		
		String telefone = ((Cliente) session.getAttribute("cliente")).getTelefone();
		
		pedido = new Pedido();
		pedido.criaPedido(telefone);
		session.setAttribute("pedido", pedido);
		
		response.sendRedirect("index.jsp");
		PrintWriter out = response.getWriter();
		out.println("<font color=red>Pedido realizado com sucesso!</font>");

	}

}
