<!DOCTYPE html>
<html lang="en">
<%@ include file="WEB-INF/head.jsp"%>
<body>
<%@ include file="WEB-INF/header.jsp" %>
    <main>
        <form action="login" method="post">
            <label for="email">Email :</label>
            <input type="email"  placeholder="example@email.com" id="email" name="email" required>
            <label for="password">Password :</label>
            <input type="password" id="password" name="password" required>
            <input type="submit" value="Login">
        </form>
        <p>
            New to Knitting Store? <a href="registrationForm.jsp">Register</a>
        </p>
    </main>
<%@include file = "WEB-INF/footer.jsp" %>
</body>
</html>