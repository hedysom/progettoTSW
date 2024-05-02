<!DOCTYPE html>
<html lang="en">
<%@ include file="WEB-INF/head.jsp"%>
<body>
<%@include file="WEB-INF/header.jsp"%>
    <main>
        <form action="registration" method="post">
            <label for="email">Email :</label>
            <input type="email"  placeholder="example@email.com" id="email" name="email" required><br>
            <label for="password">Password :</label>
            <input type="password" id="password" name="password" required><br>
            <label for="firstName">First Name :</label>
            <input type="text" id="firstName" name="firstName" required><br>
            <label for="lastName">Last Name :</label>
            <input type="text" id="lastName" name="lastName" required><br>
            <input type="submit" value="Register">
        </form>
    </main>
<%@include file = "WEB-INF/footer.jsp" %>
</body>
</html>