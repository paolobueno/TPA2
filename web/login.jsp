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
        <s:form action="login" method="POST">
            <s:textfield name="login" label="Login "/>
            <s:password name="senha" label="Senha "/>
            <s:submit value="Entrar"/>
        </s:form>
    </body>
</html>