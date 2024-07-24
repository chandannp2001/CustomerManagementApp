<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.sunbase.model.Customer"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Delete Customer</title>
<link rel="stylesheet" href="css/DeleteCustomer.css">
</head>
<body>
<%Customer customer = (Customer)request.getAttribute("DeletingCustomer");
if(customer!=null){%>
<header>
    <h1>Customer Details</h1>
    
    <a href="logout"><button style="margin-left: 1300px; background-color: red">Logout</button></a>
</header>

<div class="container">
    <div class="customer-card">
        <h2>Customer Details</h2>
        <p><strong>ID:</strong> <%=customer.getCustomerId() %></p>
        <p><strong>First Name:</strong> <%=customer.getFirst_name() %></p>
        <p><strong>Last Name:</strong> <%=customer.getLast_name() %></p>
        <p><strong>Street:</strong> <%=customer.getStreet() %></p>
        <p><strong>Address:</strong> <%=customer.getAddress() %></p>
        <p><strong>City:</strong> <%=customer.getCity() %></p>
        <p><strong>State:</strong> <%=customer.getState() %></p>
        <p><strong>Email:</strong> <%=customer.getEmail() %></p>
        <p><strong>Phone:</strong> <%=customer.getPhone_number() %></p>
    </div>

    <div class="confirmation">
        <p>Are you sure you want to delete this customer?</p>
        <form action="DeleteCustomer" method="get">
            <input type="hidden" name="customerId" value="<%=customer.getCustomerId() %>">
            <button type="submit"  class="delete-button">Delete</button>
            <a href="Customerdetails.jsp" class="back-button">Back</a>
        </form>
    </div>
</div>
<%} else{
%>
<h1>Customer Not Found </h1>
<%} %>

</body>
</html>


