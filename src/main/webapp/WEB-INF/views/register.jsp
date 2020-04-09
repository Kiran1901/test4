
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
<title>Register</title>
<link href="/css/bootstrap.min.css" rel="stylesheet">
<script type="text/javascript" src="/js/jquery.min.js"></script>
<script type="text/javascript" src="/js/register_validate.js" ></script>
</head>
<body>
	<form method="POST" name="registrationForm" action="/processRegister" class="form-signup">
  <table>
    <tr>
      <td>Name:</td>
      <td><input type="text" name="name" class="form-control" id="name"></td>
      <td><span id="name_err" class="message">Name is not valid</span></td>
    </tr>
    <tr>
      <td>Email:</td>
      <td><input type="email" name="email" class="form-control" id="email"></td>
      <td><span id="email_err" class="message">Email is not
          valid</span></td>
    </tr>
    <tr>
      <td>Password:</td>
      <td><input type="password" name="password" class="form-control" id="password"></td>
      <td><span id="pass_len_err" class="message">Password
          length should be greater than 6</span></td>
    </tr>
    <tr>
      <td>Confirm Password:</td>
      <td><input type="password" name="conf_password" class="form-control" id="conf_password"></td>
      <td><span id="password_mismatch" class="message">Confirm
          Password doesn't match with Password</span></td>
    </tr>
  </table>
  <button type="submit" name="submit" class="btn btn-lg btn-primary" id="submit">Submit</button>
	<h5 class="text"><a href="/login">Login here</a></h5>
</form>


</body>
</html>
