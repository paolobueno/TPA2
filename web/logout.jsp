<%@page import="com.paolobueno.tpa3.collections.UserCounter"%>
<%
    session.invalidate();
    UserCounter.logOut();
   
    response.sendRedirect("login.jsp");
%>