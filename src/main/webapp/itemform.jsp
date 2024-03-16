
<%@page import="Com.jsp.shoopingcart.dto.Product"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>

<html>

<head>

<meta charset="UTF-8">

<title>Add Item to Cart</title>

<style>
body {
	font-family: Arial, sans-serif;
	margin: 0;
	padding: 0;
	background-color: #f2f2f2;
}

.navbar {
	background-color: #333;
	overflow: hidden;
	padding: 10px;
	text-align: center;
	margin-bottom: 20px;
}

.navbar a {
	color: white;
	text-decoration: none;
	padding: 10px 20px;
}

.navbar a:hover {
	background-color: #ddd;
	color: black;
}

.footer {
	background-color: #333;
	color: white;
	text-align: center;
	padding: 20px;

	/* width: 100%;

 position: fixed;

 bottom: 0; */
}

form {
	margin: 20px auto;
	width: 300px;
	padding: 20px;
	border: 1px solid #ccc;
	border-radius: 5px;
	background-color: #ffffff;
	box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1);
}

input[type="text"], input[type="submit"] {
	width: 100%;
	padding: 10px;
	margin: 5px 0;
	display: inline-block;
	border: 1px solid #ccc;
	border-radius: 4px;
	box-sizing: border-box;
}

input[type="submit"] {
	background-color: #333;
	color: white;
	border: none;
	cursor: pointer;
}

h1 {
	color: red;
}
</style>

</head>

<body>

	<div class="navbar">

		<a href="#">Home</a>

		<!-- Add more navbar links as needed -->

	</div>



	<%
	Product p = (Product) request.getAttribute("prodobj");
	%>

	<h1>Details of Item</h1>

	<form action="saveitemtocart">

		<input type="hidden" name="id" value=<%=p.getId()%> readonly="true"><br>
		<br> Brand: <input type="text" name="brand"
			value=<%=p.getBrand()%> readonly="true"><br> <br>
		Model: <input type="text" name="model" value=<%=p.getModel()%>
			readonly="true"><br> <br> Category: <input
			type="text" name="category" value=<%=p.getCategory()%>
			readonly="true"><br> <br> Price: <input type="text"
			name="price" value=<%=p.getPrice()%> readonly="true"><br>
		<br> Quantity: <input type="text" name="quantity"><br>
		<br> <input type="submit" value="Add To Cart">

	</form>



	<div class="footer">

		<p>&copy; 2024 YourWebsite.com. All rights reserved.</p>

	</div>

</body>

</html>



