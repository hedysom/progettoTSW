<!DOCTYPE html>
<html lang="en">
<%@ include file="WEB-INF/head.jsp"%>
<body>
<%@ include file="WEB-INF/header.jsp" %>

<main>
    <section>
        <h1>Welcome to our Knitting Store!</h1>
        <p>Find all your knitting needs in one place.</p>
    </section>

    <section>
        <h2>Featured Products</h2>
        <!-- Product items would go here -->
    </section>
    <section>
        <h2>Categories</h2>
        <% //List<Category> categories = (List<Category>) request.getSession().getAttribute("categories"); %>
    </section>
</main>

<%@include file = "WEB-INF/footer.jsp" %>
</body>
</html>
