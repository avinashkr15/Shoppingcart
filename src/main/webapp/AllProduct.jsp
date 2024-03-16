


<%@page import="Com.jsp.shoopingcart.dto.Product"%>
<%@page import="java.util.List"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"

 pageEncoding="UTF-8"%>

<!DOCTYPE html>

<html>

<head>

 <meta charset="UTF-8">

 <title>Product List</title>

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



 .search-form {

 display: inline-block;

 }



 .search-form input[type="text"],

 .search-form button[type="submit"] {

 padding: 8px;

 border: 1px solid #ccc;

 border-radius: 4px;

 box-sizing: border-box;

 }



 .search-form button[type="submit"] {

 background-color: #4CAF50;

 color: white;

 border: none;

 border-radius: 4px;

 cursor: pointer;

 transition: background-color 0.3s;

 }



 .search-form button[type="submit"]:hover {

 background-color: #45a049;

 }



 .container {

 margin: 50px auto;

 width: 80%;

 background-color: white;

 border: 1px solid #ccc;

 border-radius: 5px;

 padding: 20px;

 box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1);

 }



 table {

 width: 100%;

 border-collapse: collapse;

 margin-top: 20px;

 }



 th, td {

 padding: 10px;

 border: 1px solid #ddd;

 text-align: left;

 }



 th {

 background-color: #333;

 color: white;

 }



 td a.button {

 display: inline-block;

 padding: 8px 12px;

 background-color: #007bff;

 color: white;

 text-decoration: none;

 border-radius: 4px;

 cursor: pointer;

 }



 td a.button:hover {

 background-color: #0056b3;

 }



 .footer {

 background-color: #333;

 color: white;

 text-align: center;

 padding: 20px;

 }

 </style>

</head>

<body>

 <div class="navbar">

 <a href="AllProduct">Home</a>

 <form class="search-form" action="displayproductbybrand">

 <input type="text" name="brand" placeholder="Enter Brand">

 <button type="submit">Search</button>

 </form>

 </div>

 <h1>

 <a href="fetchitemsfromcart">View Cart</a>

 </h1>

 <div class="container">

 <% List<Product> products = (List<Product>) request.getAttribute("productlist"); %>

 <h1>Product List</h1>

 <table border="1">

 <tr>

 <th>Brand</th>

 <th>Model</th>

 <th>Category</th>

 <th>Price</th>

 <th>Add To Cart</th>

 </tr>

 <% for (Product p : products) { %>

 <tr>

 <td><%= p.getBrand() %></td>

 <td><%= p.getModel() %></td>

 <td><%= p.getCategory() %></td>

 <td><%= p.getPrice() %></td>

 <td><a href="additem?id=<%= p.getId() %>" class="button">Add to Cart</a></td>

 </tr>

 <% } %>

 </table>

 </div>

 <div class="footer">
<div class="copyright">
        <p>CopyRights:&copy;Avinash. Made with <i class="fa fa-heart"></i> by Java Devloper</p>

    </div>
 </div>

</body>

</html>
