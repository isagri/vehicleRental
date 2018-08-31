<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*"%>
<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  



<jsp:useBean id="client" scope="session"
	class="com.campusnumerique.vehiclerental.bean.ClientBean" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
  	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Booking</title>
	
	<!-- JQuery 3.3.1 -->
	<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
	
	<!-- Bootstrap 4.1.3 -->
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
	
	<!-- General -->
	<link rel="stylesheet" href="./resources/css/global.css" />
</head>
<body>
	<nav class="navbar navbar-light " id="header">
	 <a class="navbar-brand" href="#">
		<img  src="./resources/images/delorean.png"/>
	 </a>
	  <ul class="nav nav-pills">
	    <li class="nav-item">
	      <a class="nav-link" href="./clients.jsp">Client List</a>
	    </li>
	    <li class="nav-item">
	      <a class="nav-link" href="./cars.jsp">Car List</a>
	    </li>
	    <li>
	      <a class="nav-link" href="./booking">Booking</a>
	    </li>
	    <li>
	      <a class="nav-link" href="./homePage">Home page</a>
	    </li>
	   </ul>
		<ul class="nav navbar-nav navbar-right">
			<li>User Connected: <%= client.getLogin() %></li>
		</ul>
	</nav>
	<div class="container" id="content">
		<div class="row">
			<h2 class ="col-md-4">Available vehicles</h2>
			<h3 class ="col-md-5 col-md-offset-3">Price displayed with your distance</h3>
			<table id="carTable" class="table table-striped">
				<thead>
					<tr>
						<th>Brand</th>
						<th>Model</th>
						<th>Color</th>
						<th>Horsepower</th>
						<th>Plate number</th>
						<th>Price</th>
						<th>Kilometer Rate</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${cars}" var="car">
						<tr>
							<td>${car.brand}</td>
							<td>${car.model}</td>
							<td>${car.color}</td>
							<td>${car.horsePower}</td>
							<td>${car.plateNumber}</td>
							<td>${car.price}</td>
							<td>${car.kilometerRate}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>