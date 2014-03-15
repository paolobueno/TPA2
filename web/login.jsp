<%@taglib prefix="s" uri="/struts-tags"%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
        <s:head/>
    </head>
    <body>
        <h2>Login</h2>
        <s:actionerror/>
        <form action="login" method="POST">
            <label for="login">Login</label>
            <input id="login" type="text" name="login"/>
            
            <label for="password">Login</label>
            <input id="password" type="password" name="senha"/>
            
            <input type="submit" value="Entrar" />
        </form>
    </body>
</html>