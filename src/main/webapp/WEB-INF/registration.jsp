<%--
  Created by IntelliJ IDEA.
  User: hedysom
  Date: 02/05/24
  Time: 16:17
  To change this template use File | Settings | File Templates.
--%>
<%@include file="head.jsp"%>
<%@include file="header.jsp"%>
<% boolean result= (Boolean)request.getAttribute("registrationResult");
    if(result){ %>
        <h1>Registration Successful</h1>
        <p>Thank you for registering with us. You can now <a href="../login.jsp">login</a> to your account.</p>
    <%}else{%>
        <h1>Registration Failed</h1>
        <p>There was an error processing your registration. Please try again.</p>
    <%}
%>
<%@include file="footer.jsp"%>
