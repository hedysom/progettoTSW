<%@ page import="model.Address" %><%--
  Created by IntelliJ IDEA.
  User: hedysom
  Date: 15/05/24
  Time: 14:59
  To change this template use File | Settings | File Templates.
--%>
<%@include file="head.jsp"%>
<%@include file="header.jsp"%>
<main>
    <section class="form-container">
        <% Address address = (Address) request.getAttribute("address"); %>
        <form action="modifyAddress" method="post">
            <input type="hidden" name="addressId" value="<%=address.getId()%>">
            <label for="country">Country :</label><br>
            <input type="text" id="country" name="country" value="<%=address.getCountry()%>"><br>
            <label for="state">State:</label><br>
            <input type="text" id="state" name="state" value="<%=address.getState()%>"><br>
            <label for="city">City :</label><br>
            <input type="text" id="city" name="city" value="<%=address.getCity()%>"><br>
            <label for="street">Street :</label><br>
            <input type="text" id="street" name = "street" value="<%=address.getStreet()%>"><br>
            <label for="zip">Zip :</label><br>
            <input type="text" id="zip" name="zip" value="<%=address.getZip()%>"><br>
            <input type="submit"  name="action" value="Modify address">
            <input type="submit" id="deleteButton" name="action"  value="Delete address">
        </form>
    </section>
</main>
<script>
    document.getElementById('deleteButton').addEventListener('click', function(event) {
        var confirmation = confirm('Are you sure you want to delete this address?');
        if (!confirmation) {
            event.preventDefault();
        }
    });
</script>
<%@include file="footer.jsp"%>
