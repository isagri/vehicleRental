<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*"%>
<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>



<jsp:useBean id="client" scope="session"
	class="com.campusnumerique.vehiclerental.bean.ClientBean" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Booking</title>


<!-- Bootstrap 4.1.3 -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>

<!-- General -->
<link rel="stylesheet" href="./resources/css/global.css" />
</head>
<body>
	<nav class="navbar navbar-light " id="header"> <a
		class="navbar-brand" href="#"> <img
		src="./resources/images/delorean.png" />
	</a>
	<ul class="nav nav-pills">
		<li class="nav-item"><a class="nav-link" href="./clients">Client
				List</a></li>
		<li class="nav-item"><a class="nav-link" href="./cars">Car
				List</a></li>
		<li><a class="nav-link" href="./booking">Booking</a></li>
		<li><a class="nav-link" href="./homePage">Home page</a></li>
	</ul>
	<ul class="nav navbar-nav navbar-right">
		<li>User Connected: <%=client.getLogin()%></li>
	</ul>
	</nav>
	<div class="container" id="content">
		<div class="row">
			<h1>Confirmation de reservation</h1>
		</div>
		<div class="row">
			<div class = "col-lg-4">Numero de reservation : ${booking.id}</div>
			<div class = "col-lg-4">Nom du conducteur : ${booking.client.firstName} ${booking.client.lastName}</div>
		</div>
		
		<div class="row">
			
				<table id="bookingTable" class="table table-striped">
					<thead>
						<tr>
							<th>Brand</th>
							<th>Model</th>
							<th>Color</th>
							<th>Horsepower</th>
							<th>Plate number</th>
							<th>Estimated Price</th>
							<th>From</th>
							<th>To</th>
						</tr>
					</thead>
					<tbody>
							<tr>
								<td>${booking.car.brand}</td>
								<td>${booking.car.model}</td>
								<td>${booking.car.color}</td>
								<td>${booking.car.horsePower}</td>
								<td>${booking.car.plateNumber}</td>
								<td>${booking.estimatedPrice}</td>
								<td><fmt:formatDate value="${booking.startDate}" pattern = "dd-MM-yyyy"/></td>
								<td><fmt:formatDate value="${booking.endDate}" pattern = "dd-MM-yyyy"/></td>
							</tr>
					</tbody>
				</table>
		</div>
	</div>
</body>
</html>