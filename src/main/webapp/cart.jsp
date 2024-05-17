<%@ page import="model.*" %><%--
  Created by IntelliJ IDEA.
  User: hedysom
  Date: 17/05/24
  Time: 14:36
  To change this template use File | Settings | File Templates.
--%>
<%@include file="WEB-INF/head.jsp"%>
<%@include file="WEB-INF/header.jsp"%>
<main>
   <section class="content-section container">
      <% if(cart.isEmpty()){%>
         <h1>Your cart is empty</h1>
         <a href="index.jsp">Main page</a>
        <%} else {%>
            <h1>Your Cart</h1>
            <%for(CartItem cartItem : cart.getItems()){%>
            <section class="cart-item section">
               <img src="images/<%=cartItem.getProduct().getId()%>.jpg" alt="<%=cartItem.getProduct().getName()%>">
                <h2><%=cartItem.getProduct().getName()%></h2><br>
                <p><%=cartItem.getProduct().getDescription()%></p><br>
                <p>Quantity: <%=cartItem.getQuantity()%></p>
                <p>Total: <%=cartItem.getTotalPrice()%></p>
                <form action="removeCartItem" method="post">
                    <input type="hidden" name="productId" value="<%=cartItem.getProduct().getId()%>">
                    <input type="submit" value="Remove">
                </form>
            </section>
            <%}}%>
   </section>
</main>
<%@include file="WEB-INF/footer.jsp"%>