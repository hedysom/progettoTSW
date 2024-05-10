<!DOCTYPE html>
<html lang="en">
<%@ include file="WEB-INF/head.jsp"%>
<body>
<%@include file="WEB-INF/header.jsp"%>
    <main>
        <section class="content-section container">
        <h2>Create an account</h2>
        <form action="registration" method="post">
            <label for="email">Email :</label><br>
            <input type="email"  placeholder="example@email.com" id="email" name="email" required><br>
            <label for="password">Password :</label><br>
            <input type="password" id="password" name="password" required><br>
            <label for="firstName">First Name :</label><br>
            <input type="text" id="firstName" name="firstName" required><br>
            <label for="lastName">Last Name :</label><br>
            <input type="text" id="lastName" name="lastName" required><br>
            <input type="submit" value="Register">
        </form>
        </section>
    </main>
<%@include file = "WEB-INF/footer.jsp" %>
</body>
</html>