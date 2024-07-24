package com.sunbase.daoImpl;

import java.util.List;

import com.sunbase.model.Customer;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		CustomerDAOImpl impl = new CustomerDAOImpl();
//		Customer c = new Customer("2", "chandan", "N P", "Janatha colony", "anaji", "Anaji", "Karnataka", "chandannp@gmail.com", "7353106540");
//		impl.addCustomer(c);
		impl.deleteCustomer("2");
		Customer c1 = impl.getCustomerById("2");
		System.out.println(c1);
//		c1.setAddress("#16b");
//		impl.updateCustomer(c1);
	}

}
