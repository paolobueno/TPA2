<%@page import="com.paolobueno.tpa2.collections.UserManager"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
%><%@taglib prefix="s" uri="/struts-tags"
%><jsp:include page="header.jsp"
/><div class="secao_miolo">
    <h1>Mensagens</h1>
    <s:if test="%{#order=='desc'}">
        <a href="/TPA2/?order=asc">Ordenar da mais nova à mais antiga</a>
    </s:if>
    <s:else>
        <a href="/TPA2/?order=desc">Ordenar da mais antiga à mais nova</a>
    </s:else>
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
    <a href="grouping">Visualizar mensagens por usuário</a>
</div>
<% if(UserManager.isLoggedIn(session)) { 
    %><jsp:include page="messagesForm.jsp"/><%
} %>
<jsp:include page="footer.jsp" />