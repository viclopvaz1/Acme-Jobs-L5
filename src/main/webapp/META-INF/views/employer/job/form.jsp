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

	<acme:form-textbox code="employer.job.form.label.reference" 
		placeholder="employer.job.form.placeolder.reference" path="reference"/>
	<acme:form-textbox code="employer.job.form.label.title" path="title"/>
	<acme:form-moment code="employer.job.form.label.deadline" path="deadline"/>
	<acme:form-money code="employer.job.form.label.salary" path="salary"/>
	<acme:form-textarea code="employer.job.form.label.description" path="description"/>
	<acme:form-url code="employer.job.form.label.moreInfo" path="moreInfo"/>
	<acme:form-textbox code="employer.job.form.label.employer" path="employer.identity.fullName" />	
	<acme:form-textbox code="employer.job.form.label.auditor" path="auditor.identity.fullName" />

	
	<acme:form-submit code="employer.job.form.button.audit-record" action="/authenticated/audit-record/list-mine?jobid=${id}"  method="get"/>
	<acme:form-submit code="employer.job.form.button.duty" action="/authenticated/duty/list-mine?jobid=${id}"  method="get"/>
  	<acme:form-return code="employer.job.form.button.return"/>
</acme:form>