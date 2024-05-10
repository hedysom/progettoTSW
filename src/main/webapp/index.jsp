<%@ page import="model.Category" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html lang="en">
<%@ include file="WEB-INF/head.jsp"%>
<body>
<%@ include file="WEB-INF/header.jsp" %>

<main>
    <section class="content-section container">
        <h1>Welcome to our Knitting Store!</h1>
        <h2>About us</h2>
        <p>
            Welcome to KnitJoy, your one-stop shop for all things knitting!
            Founded in 2024, KnitJoy is a family-owned business with a passion for knitting and a commitment
            to providing our customers with high-quality knitting supplies. We believe that knitting is more
            than just a hobby - it's a way to express creativity, relieve stress, and even bond with loved ones.
            At KnitJoy, we offer a wide range of products to suit all your knitting needs. From various types of
            yarns in a rainbow of colors, to knitting needles of different sizes and types, to intricate knitting
            patterns for all levels, we've got you covered. We also provide knitting accessories like stitch
            markers and row counters, as well as complete knitting kits for specific projects.
            Our team is made up of experienced knitters who are always ready to help, whether you're a beginner
            looking for guidance or an expert seeking new inspiration. We pride ourselves on our friendly customer
            service and our deep knowledge of our products.
            So whether you're knitting your first scarf, crafting a cozy blanket, or creating a unique garment,
            KnitJoy is here to help you every stitch of the way.
            Happy knitting!
        </p>
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
</body>
</html>