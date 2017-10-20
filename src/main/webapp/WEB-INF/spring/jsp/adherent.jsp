<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script type="text/javascript">
 function control(form) {
	alert("je fais un traitement de surface ... !");
	return true;
}

</script>
<title>livres</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<hr/>
<%@include file="menu.jsp" %>
<hr/>
<!-- corps de la page courante ... -->
<h2>Edition 
	<c:choose>
		<c:when test="${adherent != null }">de l'adhérent ${adherent.id}</c:when>
		<c:otherwise>d'un nouvel adhérent</c:otherwise>
	</c:choose>
</h2>
<form:form action="action?id=${adherent.id }" method="get" onsubmit="return control(this);" modelAttribute="adherent">
Nom &nbsp;&nbsp;: <form:input type="text" path="nom"/> <br/>
Prénom &nbsp;: <form:input type="text" path="prenom"/><br/>
tel : <form:input type="text" path="tel"/><br/>
email : <form:input type="text" path="email"/><br/>
<c:choose>
		<c:when test="${adherent != null }">
			<button type="submit" name="action" value="update">Modifier</button>
			<button type="submit" name="action" value="delete">Supprimer</button>
			<form:input type="hidden" path="id" /> <br/>
		</c:when>
		<c:otherwise><button type="submit" name="action" value="create">Créer</button></c:otherwise>
	</c:choose>

<button type="submit" name="action" value="return">Retour</button>
</form:form>

<hr/>
<%@include file="footer.jsp" %>

</body>
</html>