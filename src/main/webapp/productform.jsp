
<%@ page language="java" contentType="text/html; charset=UTF-8"

 pageEncoding="UTF-8"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 

<!DOCTYPE html>

<html>

<head>

<meta charset="UTF-8">

<title>Add Product</title>

<style>

 body {

 font-family: Arial, sans-serif;

 background-color: #f2f2f2;

 margin: 0;

 padding: 0;

 }

 .navbar {

 background-color: #333;

 overflow: hidden;

 }

 .navbar a {

 float: right;

 display: block;

 color: #f2f2f2;

 text-align: center;

 padding: 14px 20px;

 text-decoration: none;

 }

 .navbar a:hover {

 background-color: #ddd;

 color: black;

 }

 form {

 width: 300px;

 margin: 50px auto;

 padding: 20px;

 background-color: #fff;

 border-radius: 5px;

 box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);

 position: relative;

 z-index: 1;

 }

 input[type="text"] {

 width: calc(100% - 20px);

 padding: 10px;

 margin-bottom: 20px;

 border: 1px solid #ccc;

 border-radius: 4px;

 box-sizing: border-box;

 }

 input[type="submit"] {

 width: calc(100% - 40px); /* Adjusted width */

 background-color: #4CAF50;

 color: white;

 padding: 10px 0;

 border: none;

 border-radius: 4px;

 cursor: pointer;

 margin-top: 10px; /* Added margin */

 }

 input[type="submit"]:hover {

 background-color: #45a049;

 }

 h1 {

 color:red;

 text-align: center;

 }

 /* Footer styles */

 .footer {

 background-color: #333;

 color: white;

 text-align: center;

 padding: 20px;

 width: 100%;

 z-index: 0;

 }

</style>

</head>

<body>

<div class="navbar">

 <a href="#">Home</a>

 <!-- Add more navbar links as needed -->

</div>



<h1>Add Product</h1>

<form:form modelAttribute="productobj" action="saveproduct">

 <label for="brand">Enter Brand:</label>

 <form:input path="brand" id="brand"/>

 <br><br>

 <label for="category">Enter Category:</label>

 <form:input path="category" id="category"/>

 <br><br>

 <label for="model">Enter Model:</label>

 <form:input path="model" id="model"/>

 <br><br>

 <label for="price">Enter Price:</label>

 <form:input path="price" id="price"/>

 <br><br>

 <label for="stock">Enter Stock:</label>

 <form:input path="stock" id="stock"/>

 <br><br>

 <input type="submit" value="Submit">

</form:form>



<!-- Footer -->

<div class="footer">

 <p>&copy; 2024 YourWebsite.com. All rights reserved.</p>

</div>

</body>

</html>



<%-- <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://www.springframework.org/tags/form"  prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Product_Add</title>
<style>
       body{
       background: #212121;
       }
      .form {
        display: flex;
        margin-top: 100px;
        margin-left: 600px;
        flex-direction: column;
        gap: 10px;
        max-width: 350px;
        padding: 20px;
        border-radius: 20px;
        position: relative;
        background-color: #1a1a1a;
        color: #fff;
        border: 1px solid #333;
      }
      .title {
        font-size: 28px;
        font-weight: 600;
        letter-spacing: -1px;
        position: relative;
        display: flex;
        align-items: center;
        padding-left: 30px;
        color: #00bfff;
      }
      .title::before {
        width: 18px;
        height: 18px;
      }
      .title::after {
        width: 18px;
        height: 18px;
        animation: pulse 1s linear infinite;
      }
      .title::before,
      .title::after {
        position: absolute;
        content: "";
        height: 16px;
        width: 16px;
        border-radius: 50%;
        left: 0px;
        background-color: #00bfff;
      }
      .message,
      .signin {
        font-size: 14.5px;
        color: rgba(255, 255, 255, 0.7);
      }
      .signin {
        text-align: center;
      }
      .signin a:hover {
        text-decoration: underline royalblue;
      }
      .signin a {
        color: #00bfff;
      }
      .flex {
        display: flex;
        width: 100%;
        gap: 6px;
      }
      .form label {
        position: relative;
      }
      .form label .input {
        background-color: #333;
        color: #fff;
        width: 100%;
        padding: 20px 05px 05px 10px;
        outline: 0;
        border: 1px solid rgba(105, 105, 105, 0.397);
        border-radius: 10px;
      }
      .form label .input + span {
        color: rgba(255, 255, 255, 0.5);
        position: absolute;
        left: 10px;
        top: 0px;
        font-size: 0.9em;
        cursor: text;
        transition: 0.3s ease;
      }
      .form label .input:placeholder-shown + span {
        top: 12.5px;
        font-size: 0.9em;
      }
      .form label .input:focus + span,
      .form label .input:valid + span {
        color: #00bfff;
        top: 0px;
        font-size: 0.7em;
        font-weight: 600;
      }
      .input {
        font-size: medium;
      }
      .submit {
        border: none;
        outline: none;
        padding: 10px;
        border-radius: 10px;
        color: #fff;
        font-size: 16px;
        transform: 0.3s ease;
        background-color: #00bfff;
      }
      .submit:hover {
        background-color: #00bfff96;
      }
      @keyframes pulse {
        from {
          transform: scale(0.9);
          opacity: 1;
        }
        to {
          transform: scale(1.8);
          opacity: 0;
        }
      }
    </style>
</head>
<body>
<form:form action="saveproduct" modelAttribute="productobj" method="post">
Brand : <form:input path="brand"/>
Category: <form:input path="category"/>
Model: <form:input path="model"/>
Price:<form:input path="price"/>
Stock:<form:input path="stock"/>
<input type="submit">
</form:form>
 
<form:form action="saveproduct" modelAttribute="productobj" class="form">
      <p class="title">Add Product</p>
      
      <div class="flex">
        <label>
          <input class="input" type="text" placeholder="" required="" name="brand" />
          <span>Brand</span>
        </label>
      </div>
      <label>
        <input class="input" type="text" placeholder="" required=""  name="model"/>
        <span>Model</span>
      </label>

      <label>
        <input class="input" type="text" placeholder="" required="" name="category"/>
        <span>Category</span>
      </label>

      <label>
        <input class="input" type="number" placeholder="" required=""  name="price"/>
        <span>Price</span>
      </label>
      
      <label>
        <input class="input" type="number" placeholder="" required=""  name="stock"/>
        <span>Stock</span>
      </label>
      
      <button class="submit">Submit</button>
      </form:form>
    
 
 </body>
</html>

 --%>