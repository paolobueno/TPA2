<%@page import="com.paolobueno.tpa2.collections.UserManager"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
%><%@taglib prefix="s" uri="/struts-tags"
%><jsp:include page="header.jsp"
/>
<div class="secao_miolo">

    <h1>Mensagens</h1>
    <section id="messages">
        <hr />
        <div id="miolo2">
        <s:iterator value="messages">
        <article class="message">
            <p class="user"><s:property value="userName"/></p>
            <p class="text"><s:property value="message" /></p>
            <p class="date"><s:property value="date" /></p><hr />
        </article>
        </s:iterator>
        </div>
    </section>
</div>
<% if(UserManager.isLoggedIn(session)) { %>
<div class="secao_miolo">
    
    
    <form id="theForm" method="POST" action="messages">
        <label for="message">Mensagem</label>
        <textarea rows="4" name="message" id="message"></textarea>
        <input type="text" id="limit" size="4" readonly="readonly">
        <input type="submit" value="Enviar mensagem">

        <s:fielderror></s:fielderror>
    </form>
</div>
<% } %>
<script type="text/javascript">
var count = 255;
var limitEl = document.getElementById("limit");
var messageEl = document.getElementById("message");
function limiter(){
    var tex = messageEl.value;
    var len = tex.length;
    if(len > count){
            tex = tex.substring(0,count);
            messageEl.value = tex;
            return false;
    }
    limitEl.value = count-len;
}
messageEl.onkeyup = limiter;
limitEl.value = count;
</script>
<jsp:include page="footer.jsp" />