<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="com.sunbase.model.Customer" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>New Customer</title>
    <link rel="stylesheet" href="css/newCustomer.css">
</head>
<body>

    <header>
        <h1>New Customer</h1>
        <a href="Customerdetails.jsp"><button  style="margin-left: 100px; margin-top: -20px">Home</button></a>
    </header>

	<%Customer c = (Customer)request.getAttribute("existingCust"); %>
    <div class="container">
        <form action="addCustomer" method="post">

            <div class="personal-details">
                <h2>Personal Details</h2>
              
                <label for="id">Customer ID:</label>
                <input type="text" id="id" name="id" placeholder="Customer ID" value="<%=c!=null?c.getCustomerId():"" %>" required>
                <%
                    String errorMessage = (String) request.getAttribute("custMessage");
                    if (errorMessage != null && !errorMessage.isEmpty()) {
                %>
                    <div style="color: red; font-size: 12px; text-align: center; padding-left: 110px;">
                        <%= errorMessage %>
                    </div>
                <%
                	request.setAttribute("custMessage", null);
                    }
                %>
                
                <label for="firstname">First Name:</label>
                <input type="text" id="firstname" name="firstname" value="<%=c!=null?c.getFirst_name():"" %>" placeholder="First Name" required value="<%  %>">

                <label for="lastname">Last Name:</label>
                <input type="text" id="lastname" name="lastname" placeholder="Last Name" value="<%=c!=null?c.getLast_name():"" %>" required>

                <label for="email">Email:</label>
                <input type="email" id="email" name="email" placeholder="Email" value="<%=c!=null?c.getEmail():"" %>" required>

                <label for="phonenumber">Phone Number:</label>
                <input type="tel" id="phonenumber" name="phonenumber" placeholder="Phone Number" value="<%=c!=null?c.getPhone_number():"" %>" required>
            </div>

            <div class="address">
                <h2>Address</h2>
                <label for="street">Street:</label>
                <input type="text" id="street" name="street" placeholder="Street" value="<%=c!=null?c.getStreet():"" %>"required>
                
                <label for="Address">Address:</label>
                <input type="text" id="Address" name="Address" placeholder="Address" value="<%=c!=null?c.getAddress():"" %>" required>

                <label for="city">City:</label>
                <input type="text" id="city" name="city" placeholder="City" value="<%=c!=null?c.getCity():"" %>" required>

                <label for="state">State:</label>
                <input type="text" id="state" name="state" placeholder="State" value="<%=c!=null?c.getState():"" %>" required>
                
            </div>

            <button type="submit" name="action" value="Add">Create Customer</button>

        </form>
    </div>

</body>
</html>
