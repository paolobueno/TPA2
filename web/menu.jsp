<%@page import="com.paolobueno.tpa3.collections.UserCounter"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<p>Olá, <%= session.getAttribute("usuario") %></p>
<p><%= UserCounter.getCount() %> usuários logados agora</p>
<p>
    <a href="logout.jsp">Logout</a>
</p>