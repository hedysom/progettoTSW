<%@ page import="model.Address" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: hedysom
  Date: 13/05/24
  Time: 11:06
  To change this template use File | Settings | File Templates.
--%>
<%@include file="head.jsp"%>
<%@include file="header.jsp"%>
<main>
    <% List<Address> addresses = (List<Address>) request.getAttribute("addresses");
    if(addresses.isEmpty()) {%>
    <p>It seems like there are no shipment addresses associated with your profile.</p><br>
    <a href="addressForm.jsp">Add a new address</a>
    <% } else {
        for(Address a: addresses){%>
    <h2>Address: <%=a.getStreet()%></h2>
    <form action="modifyAddress" method="post">
        <input type="hidden" name="addressId" value="<%=a.getId()%>">
        <input type="hidden" name="customerId" value="<%=a.getCustomerId()%>">
        <table>
            <tr>
                <td>Street</td>
                <td><%=a.getStreet()%></td>
            </tr>
            <tr>
                <td>City</td>
                <td><%=a.getCity()%></td>
            </tr>
            <tr>
                <td>State</td>
                <td><%=a.getState()%></td>
            </tr>
            <tr>
                <td>Zip</td>
                <td><%=a.getZip()%></td>
            </tr>
            <tr>
                <td>Country</td>
                <td><%=a.getCountry()%></td>
            </tr>
        </table>
        <input type="submit" value="Modify address">
    </form>
    <%}}%>
</main>
<%@include file="footer.jsp"%>