<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>

<jsp:useBean id="client" scope="session"
	class="com.campusnumerique.vehiclerental.bean.ClientBean" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Home Page</title>

<!-- JQuery 3.3.1 -->
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>

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
		<li>User Connected: <%=client.getLogin()%></li>
	</ul>
	</nav>
	<div class="container" id="content">
		<div class="row">
			
				<form method="post" action="signup">
					<legend class="legend">Sign Up Form</legend>
					<div class="form-group">

						<label for="login">login</label> <input type="text"
							class="form-control" id="login" name="login"
							value="${param.login}"> <span class="erreur">${erreurs['login']}</span>
					
						<label for="firstName">First Name</label> <input type="text"
							class="form-control" id="firstName" name="firstName"
							value="${param.firstName}"> <span class="erreur">${erreurs['firstName']}</span>
			
						<label for="lastName">Last Name</label> <input type="text"
							class="form-control" id="lastName" name="lastName"
							value="${param.lastName}"> <span class="erreur">${erreurs['lastName']}</span>

			
						<label for="mail">E Mail</label> <input type="text"
								class="form-control" id="mail" name="mail"
								value="${param.mail}"> <span class="erreur">${erreurs['mail']}</span>

			
						<label for="birthDate">Birth Date</label> <input type="date"
								class="form-control" id="birthDate" name="birthDate"
								value="${param.birthDate}"> <span class="erreur">${erreurs['birthDate']}</span>
					
						<label for="licenceDate">Licence Date</label> <input type="date"
								class="form-control" id="licenceDate" name="licenceDate"
								value="${param.licenceDate}"> <span class="erreur">${erreurs['licenceDate']}</span>
					
						<label for="licenceNumber">Licence Number</label> <input type="text"
								class="form-control" id="licenceNumber" name="licenceNumber"
								value="${param.licenceNumber}"> <span class="erreur">${erreurs['licenceNumber']}</span>
			
			
			<div class="form-group">
				<label for="password">Password</label> <input type="password"
					class="form-control" id="password" name="password"
					value="${param.password}"> <span class="erreur">${erreurs['password']}</span>

			</div>

			<button type="submit" class="btn btn-primary button">Check</button>
			</form>
		</div>
	</div>
	</div>
</body>
</html>