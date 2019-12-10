<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:list>
	
<acme:list-column code="employer.application.list.label.referenceNumber" path="referenceNumber" width="30%"/>
<acme:list-column code="employer.application.list.label.moment" path="moment" width="20%"/>
Agregar en Umbind List el atriburo status

<acme:list-column code="employer.application.list.label.status" path="status" width="20%"/>

</acme:list>