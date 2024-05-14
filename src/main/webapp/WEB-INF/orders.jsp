<%@ page import="model.Order" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: hedysom
  Date: 14/05/24
  Time: 10:25
  To change this template use File | Settings | File Templates.
--%>




<%@include file="head.jsp"%>
<%@include file="header.jsp"%>
<% if (customer == null) {%>
<jsp:forward page="../login.jsp"/>
<% } %>
<main>
    <% List<Order> orders = (List<Order>) request.getAttribute("orders");
        if(orders.isEmpty()) {%>
    <p>It seems like you have no orders associated with your profile.</p><br>
    <a href="index.jsp">Go back to the main page</a>
    <% } else {
        for(Order o: orders) { %>
        <section>
            <h3>Order: <%=o.getId()%></h3>
            <table>

                <tr>
                    <td>Order date</td>
                    <td><%=o.getDate()%></td>
                </tr>
                <tr>
                    <td>Order total</td>
                    <td><%=o.getTotal()%></td>
                </tr>
            </table>
            <form action="orderDetails" method="post">
                <input type="hidden" name="orderId" value="<%=o.getId()%>">
                <input type="submit" value="Order details">
            </form>
        </section>
    <%}
    }%>

</main>
<%@include file="footer.jsp"%>