<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>

<jsp:useBean id="client" scope="session"
	class="com.campusnumerique.vehiclerental.bean.ClientBean" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
  	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Vehicle Rental</title>
	
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
	    <li>
	      <a class="nav-link" href="./homePage">Home page</a>
	    </li>
	    <li class="nav-item">
	      <a class="nav-link" href="./clients">Client List</a>
	    </li>
	    <li class="nav-item">
	      <a class="nav-link" href="./cars">Car List</a>
	    </li>  
	    <li>
	      <a class="nav-link" href="./login">Sign In</a>
	    </li>
	    <li>
	      <a class="nav-link" href="./signup">Sign up</a>
	    </li>
	   </ul>
		<ul class="nav navbar-nav navbar-right">
			<li>User Connected: <%= client.getLogin() %></li>
		</ul>
	</nav>
	<div class="container" id="content">
		<div class="row">  
		    <div class="col-md-8"> 
        <form method="post" action="login">
            <legend class="legend">Vehicle Rental</legend>
  			<div class="form-group">
    			<label for="firstName">First Name</label>
   				 <input type="text" class="form-control" id="firstName" name="firstName" value="${param.firstName}">
   				     <span class="erreur">${erreurs['firstName']}</span>
   				 
  			</div>
  			<div class="form-group">
    			<label for="lastName">Last Name</label>
   				 <input type="text" class="form-control" id="lastName" name="lastName" value="${param.lastName}">
   					 <span class="erreur">${erreurs['lastName']}</span>
   				 
  			</div>
  			<div class="form-group">
    			<label for="password">Password</label>
   				 <input type="text" class="form-control" id="password" name="password" value="${param.password}">
   					 <span class="erreur">${erreurs['password']}</span>
   				 
  			</div>

  <button type="submit" class="btn btn-primary button">Check</button>
</form>
		</div>
		</div>
	</div>
</body>
</html>