


<%@page import="Com.jsp.shoopingcart.dto.Items"%>
<%@page import="java.util.List"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>

<html>

<head>

<meta charset="UTF-8">

<title>Shopping Cart</title>

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
}

.card-container {
	display: flex;
	flex-wrap: wrap;
	justify-content: space-between;
	margin: 0 auto;
	max-width: 1200px; /* Adjust max-width as needed */
}

.card {
	background-color: white;
	box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2);
	transition: 0.3s;
	width: calc(25% - 20px); /* Adjust card width as needed */
	margin-bottom: 20px;
	border-radius: 5px;
}

.card:hover {
	box-shadow: 0 8px 16px 0 rgba(0, 0, 0, 0.2);
}

.container {
	padding: 20px;
}

a.button {
	background-color: #333;
	color: white;
	padding: 10px 20px;
	text-align: center;
	text-decoration: none;
	display: inline-block;
	border-radius: 5px;
}

a.buttonRed {
	background-color: Green;
	color: white;
	padding: 10px 20px;
	text-align: center;
	text-decoration: none;
	display: inline-block;
	border-radius: 5px;
}

h1 {
	text-align: center;
	color: red;
}
</style>

</head>

<body>

	<div class="navbar">

		<a href="#">Home</a>

		<!-- Add more navbar links as needed -->

	</div>

	<h1>My Cart</h1>



	<div class="card-container">

		<%
		List<Items> items = (List<Items>) request.getAttribute("itemslist");

		double totalPrice = (double) request.getAttribute("totalprice");

		for (Items item : items) {
		%>

		<div class="card">

			<div class="container">

				<h4>
					<b>Brand:</b>
					<%=item.getBrand()%></h4>

				<p>
					<b>Model:</b>
					<%=item.getModel()%></p>

				<p>
					<b>Category:</b>
					<%=item.getCategory()%></p>

				<p>
					<b>Quantity:</b>
					<%=item.getQuantity()%></p>

				<p>
					<b>Price:</b>
					<%=item.getPrice()%></p>

				<div class="button-container">

					<a href="#" class="button">Buy</a> <a
						href="removeItemFromCart?id=<%=item.getId()%>" class="button">Remove</a>

				</div>

			</div>

		</div>

		<%
		}
		%>

	</div>



	<h1>
		Total Price: Rs.
		<%=totalPrice%>
		<a href="addorder" class="buttonred">Buy Now</a>

		<!-- <a href="addorder" class="buttonRed">Buy Now</a> -->
	</h1>



	<div class="footer">

		<p>&copy; 2024 YourWebsite.com. All rights reserved.</p>

	</div>

</body>

</html>





















<%-- <%@page import="Com.jsp.shoopingcart.dto.Items"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
List<Items>items=(List<Items>)request.getAttribute("itemslist");
double totalprice=(double)request.getAttribute("totalprice");

%>
<table cellPadding="20px" border="1">

<th>Brand</th>
<th>Model</th>
<th>Category</th>
<th>Price</th>
<th>Quantity</th>
<%for(Items i:items)
	{%>
	<tr>
	<td><%=i.getBrand() %></td>
	<td><%=i.getModel() %></td>
	<td><%=i.getCategory() %></td>
	<td><%=i.getPrice() %></td>
	<td><%=i.getQuantity() %></td>
	</tr>
	<%} %>
	
</table>	
	<h2>Total Price:<%=totalprice%></h2>
	<br>
	

<a href="addorder">Buy Now</a>

</body>
</html> --%>