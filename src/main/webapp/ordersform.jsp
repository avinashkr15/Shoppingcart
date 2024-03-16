<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://www.springframework.org/tags/form"  prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form:form action="saveorders" modelAttribute="ordersobj">
Enter Name : <form:input path="name"/> <br>
Enter Address : <form:input path="address"/><br>
 Enter Mobile : <form:input path="mobilenumber"/><br>
 
 <input type="submit"> 

</form:form>


</body>
</html>