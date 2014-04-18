<%@page import="com.paolobueno.tpa2.collections.UserManager"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"
%><%@taglib prefix="s" uri="/struts-tags"
%><jsp:include page="header.jsp"
/><h1>Mensagens</h1>
<section id="messages">
    <s:iterator value="messages">
    <article class="message">
        <p class="user"><s:property value="userName" /></p>
        <p class="text"><s:property value="message" /></p>
        <p class="date"><s:property value="date" /></p>
    </article>
    </s:iterator>
</section>
<% if(UserManager.isLoggedIn(session)) { %>
<!-- Adicionado por Junior, contador e limitador de caracteres 10/04/2014 -->

<form name="myform" method="POST" action="messages">
    <label for="message">Mensagem</label>
    
 <!-- Script by hscripts.com --> 
                <script type="text/javascript">
                var count = "255";  
                function limiter(){
                var tex = document.myform.message.value;
                var len = tex.length;
                if(len > count){
                        tex = tex.substring(0,count);
                        document.myform.message.value =tex;
                        return false;
                }
                document.myform.limit.value = count-len;
                }

                </script>
<!-- Script by hscripts.com -->
    

    <textarea wrap=physical rows="4" name="message"  onkeyup=limiter(); id="message"></textarea>
    
    <script type="text/javascript">
    document.write("<input type=text name=limit size=4 readonly value="+count+">");
    </script>
    
    <input type="submit" value="Enviar mensagem">
    
    <s:fielderror></s:fielderror>
</form>




<jsp:include page="footer.jsp" />
<% } %>
