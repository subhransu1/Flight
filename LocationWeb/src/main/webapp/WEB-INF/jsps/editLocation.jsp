<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 <%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form action="updateLoc" method="post">
<pre>
Id :<input type="text" name="id" value="${loc.id}" readonly/>
Code:<input type="text" name="code" value="${loc.code}"/>
Name:<input type="text" name="name" value="${loc.name}"/>
Type: Urban <input type="radio" name="type" value="URBAN" ${loc.type=='URBAN'?'checked':''}/>
Type: Rural <input type="radio" name="type" value="RURAL" ${loc.type=='RURAL'?'checked':''}/>

<input type="submit" value="save">
</pre>
</form>
</body>
</html>