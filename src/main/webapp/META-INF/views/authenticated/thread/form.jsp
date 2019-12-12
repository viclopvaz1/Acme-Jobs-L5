<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:form>

	<acme:form-textbox code="authenticated.thread.form.label.title" path="title" />

	<acme:form-moment code="authenticated.thread.form.label.moment" path="moment" />

<acme:menu-separator/>


<button type="button" onclick="javascript: pushReturnUrl('/authenticated/thread/show?id=${id}');
	redirect('/authenticated/message/list?id=${id}')" class="btn btn-primary">
	<acme:message code="authenticated.thread.form.button.message"/>
	</button>				
	<acme:form-return code="authenticated.thread.form.button.return" />
</acme:form>