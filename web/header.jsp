<%@page import="com.paolobueno.tpa2.collections.UserManager"%><!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="stylePage.css" type="text/css" media="screen">
        
        <meta charset="UTF-8">
        <title>Mackwitter</title>
    </head>
 <div id="todo">
        <div id="meio">

		<div id="miolo">
			<div class="secao_miolo">
                            
                                <% if(UserManager.isLoggedIn(session)) { %>
                                <p class="boavindanome">Ol&aacute;, <%= session.getAttribute("usuario") %></p>
                                <p class="boavinda"><%= UserManager.getCount() %> usu&aacute;rios logados agora</p>
                                <p class="boavindadir">
                                    <a href="logout">Logout</a>
                                </p>
                                <% } else { %>
                                <h2>Login</h2>
                                <s:actionerror/>
                                <form action="login" method="POST">
                                    <label for="login">Login</label>
                                    <input id="login" type="text" name="login"/>

                                    <label for="password">Senha</label>
                                    <input id="password" type="password" name="senha"/>

                                    <input type="submit" value="Entrar" />
                                </form>
                        </div>
                                
                         <% } %>       
                        

