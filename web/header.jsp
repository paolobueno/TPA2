<%@page import="com.paolobueno.tpa3.collections.UserCounter"%><!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Mackwitter</title>
        <s:head/>
    </head>
<p>Ol�, <%= session.getAttribute("usuario") %></p>
<p><%= UserCounter.getCount() %> usu�rios logados agora</p>
<p>
    <a href="logout.jsp">Logout</a>
</p>