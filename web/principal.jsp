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
    <% if(UserManager.isLoggedIn(session)) { %>
    <!-- Adicionado por Junior, contador e limitador de caracteres 10/04/2014 -->
</div>
    
<div class="secao_miolo">
    
    
    <form id="theForm" method="POST" action="messages">
        <label for="message">Mensagem</label>
        <textarea rows="4" name="message" id="message"></textarea>
        <input type="text" id="limit" size="4" readonly="readonly">
        <input type="submit" value="Enviar mensagem">

        <s:fielderror></s:fielderror>
    </form>
 </div> 
<jsp:include page="footer.jsp" />
<% } %>
        </div>
    </div>    
    
    
    
 

	<div style="clear: both;"></div>	
     <div id="rodape">
		<div id="rodape_direita">
                    <strong>Universidade Presbiteriana Mackenzie</strong><br/>
			TPA 2 - Prof Leandro<br/>
			Alunos: Anisio Junior, Carlos Bragatto, Paolo Haji, Paulo Henrique Oliveira
		</div>
     </div>

</div>

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