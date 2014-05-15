<%@page import="com.paolobueno.tpa2.collections.UserManager"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
%><%@taglib prefix="s" uri="/struts-tags"
%><jsp:include page="header.jsp"
/><div class="secao_miolo">
    <h1>Mensagens por usuário</h1>
    <section id="messages">
        <hr />
        <div id="miolo2">
            <s:iterator value="groups">
            <h3>Usuário: <s:property value="key" /></h3>
                <s:iterator value="items">
                    <article class="message">
                        <p class="text"><s:property value="message" /></p>
                        <p class="date"><s:property value="date" /></p><hr />
                    </article>
                </s:iterator>
            </s:iterator>
        </div>
    </section>
</div>
<% if(UserManager.isLoggedIn(session)) { 
    %><jsp:include page="messagesForm.jsp"/><%
} %>
<jsp:include page="footer.jsp" />