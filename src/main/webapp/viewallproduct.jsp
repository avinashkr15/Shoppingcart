

<%@page import="Com.jsp.shoopingcart.dto.Product"%>
<%@page import="java.util.List"%>
<%@page import="Com.jsp.shoopingcart.dto.Merchant"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"

 pageEncoding="UTF-8" isELIgnored="false"%>

<!DOCTYPE html>

<html>

<head>

 <meta charset="UTF-8">

 <title>Merchant Dashboard</title>

 <style>

 body {

 margin: 0;

 padding: 0;

 font-family: Arial, sans-serif;

 background-color: #f2f2f2;

 }



 .navbar {

 background-color: #333;

 overflow: hidden;

 padding: 10px;

 }



 .navbar a {

 color: white;

 text-decoration: none;

 padding: 10px 20px;

 float: right;

 }



 .navbar a:hover {

 background-color: #ddd;

 color: black;

 }



 .content {

 margin: 50px auto;

 width: 80%;

 }



 .card-container {

 display: flex;

 flex-wrap: wrap;

 justify-content: space-between;

 }



 .card {

 width: 23%;

 background-color: white;

 border: 1px solid #ccc;

 border-radius: 5px;

 margin-bottom: 20px;

 box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1);

 }



 .card-content {

 padding: 20px;

 }



 .card-content h2 {

 color: red;

 margin-top: 0;

 }



 .button {

 display: inline-block;

 padding: 8px 12px;

 background-color: #007bff;

 color: white;

 border: none;

 border-radius: 4px;

 text-decoration: none;

 cursor: pointer;

 margin-top: 10px;

 }



 .button:hover {

 background-color: #0056b3;

 }

 </style>

</head>

<body>

 <div class="navbar">

 <a href="logout">Logout</a>

 <!-- Add more navbar links as needed -->

 </div>

 <h1>${message}</h1>

 <div class="content">

 <h1 style="text-align: center;">Product List</h1>

 <div class="card-container">

 <% 

 Merchant merchant = (Merchant) session.getAttribute("merchantinfo");

 List<Product> products = merchant.getProduct();

 for (Product p : products) {

 %>

 <div class="card">

 <div class="card-content">

 <h2><%= p.getBrand() %> <%= p.getModel() %></h2>

 <p><b>ID:</b> <%= p.getId() %></p>

 <p><b>Category:</b> <%= p.getCategory() %></p>

 <p><b>Price:</b> <%= p.getPrice() %></p>

 <p><b>Stock:</b> <%= p.getStock() %></p>

 <a href="updateproduct?id=<%= p.getId()%>" class="button">Update</a>

 <a href="deleteproduct?id=<%= p.getId()%>" class="button">Delete</a>

 </div>

 </div>

 <% } %>

 </div>

 </div>

 <div class="footer">

 <p>&copy; 2024 YourWebsite.com. All rights reserved.</p>

 </div>

</body>

</html>




<%-- <%@page import="Com.jsp.shoopingcart.dto.Merchant"%>
<%@page import="Com.jsp.shoopingcart.dto.Product"%>
<%@page import="java.util.List"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
  body{
  background: black;
  color: white;
  align-items: center;
  }
  
</style>

</head>
<body>
<%Merchant merchant=(Merchant)session.getAttribute("merchantinfo");
 List<Product>products=merchant.getProduct();

%>
<table cellPadding="20px" border="1">
<th>Id</th>
<th>Brand</th>
<th>Model</th>
<th>Category</th>
<th>Price</th>
<th>Stock</th>
<th>Update</th>
<th>delete</th>
<%
for(Product p: products){
	%>
<tr>
<td> <%=p.getId()%></td>
<td><%=p.getBrand() %></td>
<td><%=p.getModel() %></td>
<td><%=p.getCategory() %></td>
<td><%=p.getPrice() %></td>
<td><%=p.getStock() %></td>
<td><a href="updateproduct">update</a></td>
<td><a href="deleteproduct?id=<%=p.getId()%>">delete</a></td>
</tr>
<%}%>

</body>
</html> --%>