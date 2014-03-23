<%@page import="com.paolobueno.tpa2.collections.UserManager"%><!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Mackwitter</title>
    </head>
<% if(UserManager.isLoggedIn(session)) { %>
<p>Olá, <%= session.getAttribute("usuario") %></p>
<p><%= UserManager.getCount() %> usuários logados agora</p>
<p>
    <a href="/TPA2/logout">Logout</a>
</p>
<% } else { %>
<h2>Login</h2>
<s:actionerror/>
<form action="login" method="POST">
    <label for="login">Login</label>
    <input id="login" type="text" name="login"/>

    <label for="password">Login</label>
    <input id="password" type="password" name="senha"/>

    <input type="submit" value="Entrar" />
</form>
<% } %>