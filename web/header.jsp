<%@page import="com.paolobueno.tpa3.collections.UserCounter"%><!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Mackwitter</title>
        <s:head/>
    </head>
<p>Olá, <%= session.getAttribute("usuario") %></p>
<p><%= UserCounter.getCount() %> usuários logados agora</p>
<p>
    <a href="logout.jsp">Logout</a>
</p>