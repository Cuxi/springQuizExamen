<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML>
<html>
<head>
<title>Add Name Form</title>
<style type="text/css">@import url("<c:url value="/css/main.css"/>");</style>
</head>
<body>

<div id="global">
<form:form  modelAttribute="name" action="processForm" method="post">
    <fieldset>
        <legend>Add a name</legend>
        <p>
            <label for="name">Nombre: </label>
            <form:input id="name" path="name"/>
        </p>
        <p>
            <select name="trabajo" path="trabajo" >
              <c:forEach var="t" items="${trabajoList}">
                <option value="${t.trabajo_id}">${t.titulo}</option>
              </c:forEach>
            </select>
        </p>
        <p id="buttons">
            <input id="submit" type="submit" tabindex="5" 
                value="Add Name">
        </p>
    </fieldset>
</form:form>
</div>
</body>
</html>