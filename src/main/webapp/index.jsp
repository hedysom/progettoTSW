<%@ page import="model.Category" %>
<%@ page import="java.util.List" %>
<%@ include file="WEB-INF/head.jsp"%>
<%@ include file="WEB-INF/header.jsp" %>

<main>
    <section class="content-section container">
        <h1>Welcome to our Knitting Store!</h1>
    </section>

    <section class="featured-section">
        <h2>Featured Products</h2>
    </section>
    <section class="categories-section">
        <h2>Categories</h2>
          <%ServletContext context = request.getServletContext();
            List<Category> categories = (List<Category>) context.getAttribute("categories");
            if(categories != null){
                for (Category c : categories){ %>
                <a class="categories-button" href="category?category=<%=c.getName()%>">
                     <img src="images/<%=c.getName()%>.jpg" alt="<%=c.getName()%>">
                    <span><%=c.getName()%></span>
                </a>
                <%}
            } %>
    </section>
</main>

<%@include file = "WEB-INF/footer.jsp" %>