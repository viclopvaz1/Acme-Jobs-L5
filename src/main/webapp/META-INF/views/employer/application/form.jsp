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
	<jstl:if test="${command!='update'}">
		<acme:form-textbox code="employer.application.form.label.referenceNumber" path="referenceNumber"/>
		<acme:form-moment code="employer.application.form.label.moment" path="moment"/>
		<acme:form-textbox code="employer.application.form.label.skills" path="skills"/>
		<acme:form-textbox code="employer.application.form.label.qualifications" path="qualifications"/>
		<acme:form-textbox code="employer.application.form.label.job" path="job.reference"/>
		<acme:form-textbox code="employer.application.form.label.worker" path="worker.identity.fullName"/>
	</jstl:if>
	<acme:form-textbox  code="employer.application.form.label.status" path="status"/>
	<jstl:if test="${status=='rejected' || command=='update'}">
		<acme:form-textarea code="employer.application.form.label.reason" path="reason"/>
	</jstl:if>
	<acme:form-submit test="${command == 'show'}" code="employer.job.form.button.status" action="/employer/application/update?id=${id}" method = "get"/>
	<acme:form-submit test="${command == 'update'}" code="employer.job.form.button.reason" action="/employer/application/update"/>
  	<acme:form-return code="employer.application.form.button.return"/>
</acme:form>