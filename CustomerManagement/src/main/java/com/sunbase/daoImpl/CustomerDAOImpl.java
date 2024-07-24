package com.sunbase.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.sunbase.dao.CustomerDAO;
import com.sunbase.model.Customer;
import com.sunbase.util.DatabaseUtil;

public class CustomerDAOImpl implements CustomerDAO{

	
	private static final String INSERT_QUERY = "INSERT INTO `customer` (`customerId`,`first_name`, `last_name`, `street`, `address`, `city`, `state`, `email`, `phone_number`) VALUES (?,?,?,?,?,?,?,?,?)";
	private static final String UPDATE_QUERY = "UPDATE `customer` SET  `first_name`=?, `last_name`=?, `street`=?, `address`=?, `city`=?, `state`=?,  `email`=?,  `phone_number`=? WHERE (`customerId`=?)";
	private static final String DELETE_QUERY = "DELETE FROM `customer` WHERE (`customerId`=?)";
	private static final String SELECT_BY_FIRSTNAME= "SELECT * FROM `customer` WHERE (`first_name` LIKE ?)";
	private static final String SELECT_BY_CITY = "SELECT * FROM `customer` WHERE (`city` LIKE ?)";
	private static final String SELECT_BY_EMAIL = "SELECT * FROM `customer` WHERE (`email` LIKE ?)";
	private static final String SELECT_BY_PHONE = "SELECT * FROM `customer` WHERE (`phone_number` LIKE ?)";
	private static final String SELECT_BY_ID = "SELECT * FROM `customer` WHERE (`customerId` = ?)";
	private static final String SELECT_ALL = "SELECT * FROM `customer`";
	
	 private DatabaseUtil dbUtil;
	 private static Connection connection;
	 private static PreparedStatement prepareStatement;
	 private static Statement statement;
	 private static ResultSet res;
	
	public CustomerDAOImpl() {
		dbUtil = new DatabaseUtil();
	     connection = dbUtil.getConnection();
	}
	
	public Customer extractCustomerFromResultSet(ResultSet res) throws SQLException {
		
		if(res!=null) {
			return new Customer(res.getString("customerId"), res.getString("first_name"),
					res.getString("last_name"), res.getString("street"), res.getString("address"),
					res.getString("city"), res.getString("state"), res.getString("email"),
					res.getString("phone_number"));
		}
		return null;
	}
	
	
	@Override
	public void addCustomer(Customer customer) {
		try {
			if (getCustomerById(customer.getCustomerId()) == null) {
				prepareStatement = connection.prepareStatement(INSERT_QUERY);

				prepareStatement.setString(1, customer.getCustomerId().trim());
				prepareStatement.setString(2, customer.getFirst_name().trim());
				prepareStatement.setString(3, customer.getLast_name().trim());
				prepareStatement.setString(4, customer.getStreet().trim());
				prepareStatement.setString(5, customer.getAddress().trim());
				prepareStatement.setString(6, customer.getCity().trim());
				prepareStatement.setString(7, customer.getState().trim());
				prepareStatement.setString(8, customer.getEmail().trim());
				prepareStatement.setString(9, customer.getPhone_number());

				int i = prepareStatement.executeUpdate();
			} else {

				updateCustomer(customer);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Customer> getCustomerByFirst_name(String first_name) {
		try {
			prepareStatement = connection.prepareStatement(SELECT_BY_FIRSTNAME);
			prepareStatement.setString(1, "%"+ first_name.trim() + "%");

			res = prepareStatement.executeQuery();

			List<Customer> list = new ArrayList<Customer>();
			
			while (res.next()) {
				list.add(extractCustomerFromResultSet(res));
			}

			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Customer> getCustomerByEmail(String email) {
		try {
			prepareStatement = connection.prepareStatement(SELECT_BY_EMAIL);
			prepareStatement.setString(1, "%"+ email.trim() + "%");

			res = prepareStatement.executeQuery();

			List<Customer> list = new ArrayList<Customer>();
			
			while (res.next()) {
				list.add(extractCustomerFromResultSet(res));
			}

			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Customer> getCustomerByCity(String city) {
		try {
			prepareStatement = connection.prepareStatement(SELECT_BY_CITY);
			prepareStatement.setString(1, "%"+city.trim() + "%");

			res = prepareStatement.executeQuery();
			

			List<Customer> list = new ArrayList<Customer>();
			
			while (res.next()) {

				list.add(extractCustomerFromResultSet(res));
			}

			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Customer> getCustomerByPhone_number(String phone_number) {
		try {
			prepareStatement = connection.prepareStatement(SELECT_BY_PHONE);
			prepareStatement.setString(1, "%"+phone_number+"%");

			res = prepareStatement.executeQuery();

			List<Customer> list = new ArrayList<Customer>();
			
			while (res.next()) {
				list.add(extractCustomerFromResultSet(res));
			}

			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Customer getCustomerById(String customerId) {
		try {
			prepareStatement = connection.prepareStatement(SELECT_BY_ID);
			prepareStatement.setString(1, customerId.trim());
			res = prepareStatement.executeQuery();

			while (res.next()) {
				Customer c = new Customer(res.getString("customerId"), res.getString("first_name"),
						res.getString("last_name"), res.getString("street"), res.getString("address"),
						res.getString("city"), res.getString("state"), res.getString("email"),
						res.getString("phone_number"));
				return c;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void updateCustomer(Customer customer) {
		try {
			prepareStatement = connection.prepareStatement(UPDATE_QUERY);

			prepareStatement.setString(1, customer.getFirst_name().trim());
			prepareStatement.setString(2, customer.getLast_name().trim());
			prepareStatement.setString(3, customer.getStreet().trim());
			prepareStatement.setString(4, customer.getAddress().trim());
			prepareStatement.setString(5, customer.getCity().trim());
			prepareStatement.setString(6, customer.getState().trim());
			prepareStatement.setString(7, customer.getEmail().trim());
			prepareStatement.setString(8, customer.getPhone_number());
			prepareStatement.setString(9, customer.getCustomerId().trim());

			int i = prepareStatement.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void deleteCustomer(String customerId) {
		try {
			prepareStatement = connection.prepareStatement(DELETE_QUERY);

			prepareStatement.setString(1, customerId.trim());

			int executeUpdate = prepareStatement.executeUpdate();
			//System.out.println(executeUpdate);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Customer> getAllCustomer() {
		try {
			statement = connection.createStatement();
			res = statement.executeQuery(SELECT_ALL);

			List<Customer> list = new ArrayList<Customer>();
			
			while (res.next()) {
				
				list.add(extractCustomerFromResultSet(res));

			}

			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

}
