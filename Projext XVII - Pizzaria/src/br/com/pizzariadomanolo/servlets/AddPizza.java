package br.com.pizzariadomanolo.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.pizzariadomanolo.DAO.PizzaDAO;
import br.com.pizzariadomanolo.DAO.POSTGRES.PizzaDAOPostgres;
import br.com.pizzariadomanolo.entidades.Pedido;
import br.com.pizzariadomanolo.entidades.Pizza;

/**
 * Servlet implementation class AddPizza
 */
@WebServlet("/AddPizza")
public class AddPizza extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddPizza() {
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
		PizzaDAO pizzaDAO = new PizzaDAOPostgres();
		
		String nomePizza = request.getParameter("pizza");
		String quantidade = request.getParameter("quantidade");
		
		Pizza pizza = new Pizza();
		pizza.setNomePizza(nomePizza);
		pizzaDAO.buscaPizza(pizza);
		
		HttpSession session = request.getSession();
		Pedido pedido = (Pedido) session.getAttribute("pedido");
		
		pedido.adicionarItem(pizza, Integer.parseInt(quantidade));
		
		session.setAttribute("pedido", pedido);
	}

}
