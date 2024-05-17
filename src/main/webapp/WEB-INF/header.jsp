<%--
  Created by IntelliJ IDEA.
  User: hedysom
  Date: 02/05/24
  Time: 12:26
  To change this template use File | Settings | File Templates.
--%>

<%@ page import="model.Customer" %>
<%@ page import="model.Product" %>
<%@ page import="model.Cart" %>
<% Customer customer = (Customer) session.getAttribute("customer"); %>
<% Cart cart = (Cart) request.getSession().getAttribute("cart"); %>
<body>
    <header>
        <nav class="nav">
            <ul>
                <li><a href="index.jsp">Home</a></li>
                <li><a href="#">Products</a></li>
                <li><a href="#">Contact</a></li>
                <li><a href="../about.jsp">About</a></li>
            </ul>
            <%if (customer == null){ %>
            <a id="logIn" href="login.jsp">Log In</a>
            <a id="register" href="registrationForm.jsp">Register</a>
               <%} else{ %>
            <a id="profile" href="profile.jsp"><%=customer.getFirstName()%>'s Profile</a>
            <a id="logOut" href="logOut">Log Out</a>
            <% } %>
            <a id="cart" href="cart">Cart (<%if(cart==null){%>
                <%=0%>
                <%} else{%>
                <%=cart.getItems().size()%>
                <%}%>)</a>
        </nav>
        <h1 class = "store-name">KnitJoy</h1>
    </header>
