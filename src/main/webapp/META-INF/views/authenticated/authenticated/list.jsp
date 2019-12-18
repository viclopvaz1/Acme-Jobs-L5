

<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:list>
	<input name="threadId" id="threadId" type="hidden" value="${param.threadId}" />
	
	<acme:list-column code="authenticated.authenticated.list.label.title" path="id" width="20%" />



</acme:list>
