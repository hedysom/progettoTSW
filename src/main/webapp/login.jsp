<%@ include file="WEB-INF/head.jsp"%>
<%@ include file="WEB-INF/header.jsp" %>
    <main>
        <% if(request.getAttribute("error") != null) { %>
        <p style="color: red;"><%= request.getAttribute("error") %></p>
        <% } %>
        <section class="content-section container">
        <form action="login" method="post">
            <label for="email">Email :</label><br>
            <input type="email"  placeholder="example@email.com" id="email" name="email" required><br>
            <label for="password">Password :</label><br>
            <input type="password" id="password" name="password" required><br>
            <input type="submit" value="Login">
        </form>
        <p>
            New to KnitJoy? <a href="registrationForm.jsp">Register</a>
        </p>
        </section>
    </main>
<%@include file = "WEB-INF/footer.jsp" %>