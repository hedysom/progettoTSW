<%--
  Created by IntelliJ IDEA.
  User: hedysom
  Date: 02/05/24
  Time: 12:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="model.Customer" %>
<%@ page import="model.Product" %>
<% Customer customer = (Customer) session.getAttribute("customer"); %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <header>
        <nav>
            <ul>
                <li><a href="index.jsp">Home</a></li>
                <li><a href="#">Products</a></li>
                <li><a href="#">Contact</a></li>
            </ul>
            <%if (customer == null){ %>
            <a id="logIn" href="login.jsp">Log In</a>
            <a id="register" href="registrationForm.jsp">Register</a>
               <%} else{ %>
            <a id="profile" href="profile.jsp">Hello, <%=customer.getFirstName()%> Profile</a>
            <a id="logOut" href="logOut">Log Out</a>
            <% } %>
            <a id="cart" href="#">Cart</a>
        </nav>
    </header>
