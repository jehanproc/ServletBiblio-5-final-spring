
<%@page import="java.util.List"%>
<%@page import="entity.Livre"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>livres</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<hr/>
<%@include file="menu.jsp" %>
<hr/>
<!-- corps de la page courante ... -->
<h2>Edition du livre ${livre.id}</h2>
<form action="action?id=${livre.id }" method="get">
<input type="hidden" name="id" value="${livre.id }"> <br/>
Titre &nbsp;&nbsp;: <input type="text" name="titre" value="${livre.titre }"> <br/>
Auteur &nbsp;: <input type="text" name="auteur" value="${livre.auteur }"><br/>
Parution : <input type="text" name="parution" value="${livre.parution }"><br/>
<button type="submit" name="action" value="update">Modifier</button>
<button type="submit" name="action" value="delete">Supprimer</button>
<button type="submit" name="action" value="return">Retour</button>
</form>

<hr/>
<%@include file="footer.jsp" %>

</body>
</html>