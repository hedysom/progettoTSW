<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: hedysom
  Date: 07/05/24
  Time: 16:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="head.jsp"%>
<%@include file="header.jsp"%>
<main>
    <section class="products-section">
        <h2>Here are products from <%=(String) request.getAttribute("category")%> category </h2>
<% List<Product> products = (List<Product>) request.getAttribute("products");
    for(Product p : products){%>
        <section class="product">
        <form action="" method="post">
            <input type="hidden" name="id" value="<%=p.getId()%>"/>
            <img src="images/products/<%=p.getId()%>.jpg" alt="<%=p.getName()%>"/>
            <h2><%=p.getName()%></h2>
            <p><%=p.getDescription()%></p>
            <p><%=p.getPrice()%> €</p>
            <input type="submit" value="Add to cart"/>
        </form>
        </section>
    <%}%>
    </section>
</main>
<%@include file="footer.jsp"%>