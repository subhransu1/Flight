<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 <%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Upload Document</title>
</head>
<body>
<form action="upload" method="post" enctype="multipart/form-data">
ID :<input type="text" name="id"/>
Document :<input type="file" name="document"/>

<input type="submit" name="submit" value="Upload"/>
</form>

<table>
<tr>
<th>ID</th>
<th>Name</th>
<th>Link</th>
</tr>

<c:forEach items="${document}" var="doc">
<tr>
<td>${doc.id}</td>
<td>${doc.name}</td>
<td><a href="download?id=${doc.id}">Download</a></td>
</tr>
</c:forEach>
</table>
</body>
</html>