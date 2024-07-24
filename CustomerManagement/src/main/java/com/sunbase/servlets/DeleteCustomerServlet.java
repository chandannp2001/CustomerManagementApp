package com.sunbase.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sunbase.daoImpl.CustomerDAOImpl;
import com.sunbase.model.Customer;

@WebServlet("/DeleteCustomer")
public class DeleteCustomerServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	static private CustomerDAOImpl cimpl;
	static private HttpSession session; 
	static private List<Customer> getAllCustomer;
	
	@Override
	public void init() throws ServletException {
		cimpl = new CustomerDAOImpl();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		session = req.getSession();
		String token = (String)session.getAttribute("Token");
		
		if ( token == null || token.isBlank()) {
			resp.sendRedirect("LogIn.jsp");
			return;
		}else {
			String customerId = req.getParameter("customerId");
			Customer customerById;
			if((customerById = cimpl.getCustomerById(customerId))!=null) {
				cimpl.deleteCustomer(customerId);
				
				getAllCustomer = cimpl.getAllCustomer();
				req.setAttribute("message", "Customer "+customerById.getFirst_name()+" "+customerById.getLast_name()+" Deleted Sucessfully. ");

			}
			session.setAttribute("AllCustomers", cimpl.getAllCustomer());
			req.getRequestDispatcher("Customerdetails.jsp").forward(req, resp);
			return;
		}
		
		
	}
}
