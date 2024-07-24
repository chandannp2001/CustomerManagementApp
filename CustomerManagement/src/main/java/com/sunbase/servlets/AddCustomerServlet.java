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

@WebServlet("/addCustomer")
public class AddCustomerServlet extends HttpServlet{

	private static CustomerDAOImpl cimpl;
	static private List<Customer> getAllCustomer;
	@Override
	public void init() throws ServletException {
		cimpl = new CustomerDAOImpl();
	}
	@Override
	protected void doPost (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		getAllCustomer = (List<Customer>) session.getAttribute("AllCustomers");
		
		if (session.getAttribute("Token") != null) {
			String id = req.getParameter("id").trim();
			String firstname = req.getParameter("firstname");
			String lastname = req.getParameter("lastname");
			String email = req.getParameter("email");
			String phonenumber = req.getParameter("phonenumber").trim();
			String street = req.getParameter("street");
			String Address = req.getParameter("Address");
			String city = req.getParameter("city");
			String state = req.getParameter("state");
			
			Customer c = new Customer(id,firstname, lastname, street, Address, city, state, email, phonenumber);
			if(cimpl.getCustomerById(id)== null) {
				cimpl.addCustomer(c);
				getAllCustomer = cimpl.getAllCustomer();
				session.setAttribute("AllCustomers", getAllCustomer);
				req.setAttribute("message", "Customer "+firstname+" "+lastname+" Successfully Added. ");
				req.getRequestDispatcher("Customerdetails.jsp").forward(req, resp);
				return;
				
			}else if(cimpl.getCustomerById(id)!= null) {
				req.setAttribute("existingCust", c);
				req.setAttribute("custMessage", "Customer Already Exist with given Customer Id ! Give Different Id.");
				req.getRequestDispatcher("AddCustomer.jsp").forward(req, resp);
				return;
			}
			
		}else {
			req.getRequestDispatcher("LogIn.jsp").forward(req, resp);
			return;
		}
		
	}
}
