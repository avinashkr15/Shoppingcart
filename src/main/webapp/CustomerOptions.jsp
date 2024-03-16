


<%@page import="Com.jsp.shoopingcart.dto.Customer"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"

    pageEncoding="UTF-8" isELIgnored="false"%>

<!DOCTYPE html>

<html>

<head>

    <meta charset="UTF-8">

    <title>User Dashboard</title>

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

        

        .container {

            margin: 50px auto;

            width: 300px;

            padding: 20px;

            border: 1px solid #ccc;

            border-radius: 5px;

            background-color: #ffffff; 

            box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1);

        }

        

        .footer {

            background-color: #333;

            color: white;

            text-align: center;

            padding: 20px;

            width: 100%;

            position: fixed;

            bottom: 0;

        }

        

        h1 {

            margin-top: 50px;

            text-align: center;

        }

        

        h1 a {

            color: #333;

            text-decoration: none;

            padding: 10px 20px;

            background-color: #f2f2f2;

            border: 1px solid #ccc;

            border-radius: 5px;

            margin: 10px;

            display: inline-block;

            transition: background-color 0.3s;

        }

        

        h1 a:hover {

            background-color: #ddd;

        }

    </style>

</head>

<body>

    <div class="navbar">

        <a href="#">Home</a>

        <!-- Add more navbar links as needed -->

    </div>

    <% Customer c=(Customer)session.getAttribute("customerinfo"); 

    if(c!=null){ %>

    <h1 style=color:green>${msg}</h1>


    <h1><a href="displayproduct">Display All Products</a></h1>
    
     <h1>
  <a href="ReadBrandfromcustomer.jsp">Display Product By Brand</a>
  </h1>
  
  <h1>
  <a href="ReadCategoryfromcustomer.jsp">Display Product Category</a>
  </h1>

    <% } else { %>

    <h1><a href="CustomerLoginForm.jsp">Please Login</a></h1>

    <% } %>

    <div class="footer">

        <p>&copy; 2024 YourWebsite.com. All rights reserved.</p>

    </div>

</body>

</html>


































<%-- 

  <%@page import="Com.jsp.shoopingcart.dto.Customer"%>
<%@page import="Com.jsp.shoopingcart.dto.Merchant"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
body{
   background:   activeborder;
}
h1{
 
}

</style>
</head>
<body>
 <% Customer c=(Customer)session.getAttribute("customerinfo"); %>
<%if(c!=null){ %> 
<h1 style=color:green>${msg}</h1>
<h1>
  <a href="displayproduct">Display All Product</a>
</h1>
  <h1>
  <a href="ReadBrandfromcustomer.jsp">Display Product By Brand</a>
  </h1>
  
  <h1>
  <a href="ReadCategoryfromcustomer.jsp">Display Product Category</a>
  </h1>
  
  <h1>
  <a href="#">Display Product Range</a>
  </h1>
   <%} 
  else{%>
  <h1><a href="CustomerLoginForm.jsp">Please Login First</a></h1>
  
  <%} %>

</body>
</html> --%>