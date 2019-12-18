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

 <jstl:if test="${status == 'false'}">
	  
	 
	  <input name="firmId" value="${param.firmId}" readonly="true"/>
	  <input name="responsabilityStatementId" value="${param.responsabilityStatementId}" readonly="true"/>

	      
  </jstl:if>
 <jstl:if test="${status == 'true'}">


	<acme:form-textarea code="authenticated.auditor-request.form.label.firm" path="firm" />
	<acme:form-textarea code="authenticated.auditor-request.form.label.responsabilityStatement" path="responsabilityStatement" />

	<acme:form-submit test="${command == 'create'}" code="authenticated.auditor-request.form.button.create" action="/authenticated/auditor-request/create"/>
	<acme:form-return code="authenticated.auditor-request.form.button.return" />
	  </jstl:if>
	
</acme:form>
