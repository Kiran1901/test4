<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
<title>Login</title>
<link href="/css/bootstrap.min.css" rel="stylesheet">
<script type="text/javascript" src="/js/jquery.min.js"></script>
<script type="text/javascript" src="/js/login_validate.js"></script>
</head>
<body>

<form method="POST" name="loginForm" action="/processLogin" class="form-signin">
	<table>
	    <tr>
	      <td>Email:</td>
	      <td><input type="email" name="email" class="form-control" id="email"> </td>
	      <td><span id="email_err" class="message">Email is not valid</span></td>
	    </tr>
	    <tr>
	      <td>Password:</td>
	      <td><input type="password" name="password" class="form-control" id="password"></td>
	      <td><span id="pass_len_err" class="message">Password length should be greater than 6</span></td>
	    </tr>
	</table>	
	  <button type="submit" name="submit" class="btn btn-lg btn-primary" id="submit">Submit</button>
	  <h5 class="text"><a href="/register">Register</a></h5>
	  <c:if test="${not empty invalid}">
	  	<h3 style="color: red">Email or Password is incorrect</h3>
	  </c:if>
	</form>
</body>
</html>
