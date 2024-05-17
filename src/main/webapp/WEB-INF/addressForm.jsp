<%--
  Created by IntelliJ IDEA.
  User: hedysom
  Date: 14/05/24
  Time: 15:49
  To change this template use File | Settings | File Templates.
--%>
<%@include file="head.jsp"%>
<%@include file="header.jsp"%>
<main>
    <section class="form-container">
        <form action="addressForm" method="post">
            <label for="country">Country :</label><br>
            <input type="text" id="country" name="country" required><br>
            <label for="state">State:</label><br>
            <input type="text" id="state" name="state" required><br>
            <label for="city">City :</label><br>
            <input type="text" id="city" name="city" required><br>
            <label for="street">Street :</label><br>
            <input type="text" id="street" name = "street" required><br>
            <label for="zip">Zip :</label><br>
            <input type="text" id="zip" name="zip" required><br>
            <input type="submit" value="Add">

        </form>
    </section>
</main>
<%@include file="footer.jsp"%>