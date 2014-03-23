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
<jsp:include page="footer.jsp" />