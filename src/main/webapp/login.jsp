<%@ include file="WEB-INF/head.jsp"%>
<%@ include file="WEB-INF/header.jsp" %>
    <main>
        <% if(request.getAttribute("error") != null) { %>
        <p style="color: red;"><%= request.getAttribute("error") %></p>
        <% } %>
        <section class="form-container">
            <h2>Login</h2>
        <form action="login" method="post">
            <section class="input-box">
                <label for="email"></label>
                <input type="email"  placeholder="Email" id="email" name="email" required>
            </section>
            <section class="input-box">
                <label for="password"></label>
                <input type="password" placeholder="Password" id="password" name="password" required><br>
            </section>
            <input type="submit" value="Login">
        </form>
        <p>
            New to KnitJoy? <a href="registrationForm.jsp">Register</a>
        </p>
        </section>
    </main>
<%@include file = "WEB-INF/footer.jsp" %>