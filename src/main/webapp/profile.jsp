<%--
  Created by IntelliJ IDEA.
  User: hedysom
  Date: 12/05/24
  Time: 11:30
  To change this template use File | Settings | File Templates.
--%>
<%@include file="WEB-INF/head.jsp"%>
<%@include file="WEB-INF/header.jsp"%>
<% if (customer == null) { %>
    <jsp:forward page="/login.jsp"/>
<% } else { %>
<main>
    <section class="profile-section">
    <h2>Welcome back, <%=customer.getFirstName()%>!</h2>
    <a class = "profile-button" href="orders">
    <img src="images/profile/orders.png" alt="orders">
        <h4>View Orders</h4>
    </a>
    <a class = "profile-button" href="address">
        <img src="images/profile/addresses.png" alt="addresses">
        <h4>Addresses</h4>
    </a>
    </section>
</main>

<% } %>
<%@include file="WEB-INF/footer.jsp"%>