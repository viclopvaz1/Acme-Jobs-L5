<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:form>

	<acme:form-textbox code="authenticated.authenticated.form.label.title" path="id" />
	<input name="threadId" id="threadId" type="hidden" value="${param.threadId}" />
<acme:menu-separator/>

<acme:form-submit test="${command == 'create' }"
		code="authenticated.authenticated.form.button.create" 
		action="/authenticated/paticipation/create"/>

<jstl:if test="${command == 'show' }">	
	<button type="button" onclick="javascript: pushReturnUrl('/authenticated/authenticated/show?id=${id}');
	redirect('/authenticated/authenticated/list?id=${id}')" class="btn btn-primary">
	<acme:message code="authenticated.authenticated.form.button.authenticated.añadir"/>
	</button>		
	</jstl:if>		
	<acme:form-return code="authenticated.authenticated.form.button.return" />
</acme:form>