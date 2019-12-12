<%--
- form.jsp
-
- Copyright (c) 2019 Rafael Corchuelo.
-
- In keeping with the traditional purpose of furthering education and research, it is
- the policy of the copyright owner to permit non-commercial use and redistribution of
- this software. It has been tested carefully, but it is not guaranteed for any particular
- purposes.  The copyright owner does not offer any warranties or representations, nor do
- they accept any liabilities with respect to them.
--%>

<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:form>

	<acme:form-textbox code="authenticated.duty.form.label.title" path="title"/>
	<acme:form-textarea code="authenticated.duty.form.label.description" path="description"/>
	<acme:form-double code="authenticated.duty.form.label.percentage" path="percentage"/>	
	<acme:form-hidden path="jobid"/>

	<acme:form-submit test="${command == 'show' }"
		code="authenticated.duty.form.button.update" 
		action="/authenticated/duty/update"/>
		
	<acme:form-submit test="${command == 'show' }"
		code="authenticated.duty.form.button.delete" 
		action="/authenticated/duty/delete"/>
		
	<acme:form-submit test="${command == 'create' }"
		code="authenticated.duty.form.button.create" 
		action="/authenticated/duty/create"/>
		
	<acme:form-submit test="${command == 'update' }"
		code="authenticated.duty.form.button.update" 
		action="/authenticated/duty/update"/>
		
	<acme:form-submit test="${command == 'delete' }"
		code="authenticated.duty.form.button.delete" 
		action="/authenticated/duty/delete"/>
		
	<acme:form-return code="authenticated.duty.form.button.return"/>
</acme:form> 