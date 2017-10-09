<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">
.error{
   color:red 
}
.valid{
   border:2px solid blue
}
</style>
</head>
<body>
<form method="post" action="/Spring2/process">
<table align="center">
<tr><td>User:</td><td><input type="text" name="username"></td></tr>
<tr><td>Password:</td><td><input type="password" name="password"></td></tr>
<tr><td>Email:</td><td><input type="text" name="email"></td></tr>
<tr><td>Address:</td><td><input type="text" name="address"></td></tr>
<tr><td>Phone:</td><td><input type="text" name="phone"></td></tr>
<tr><td><input type="submit" value="Register"></td></tr>
</table>
</form>
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="https://cdn.jsdelivr.net/npm/jquery-validation@1.17.0/dist/jquery.validate.js"></script>  
<script type="text/javascript">
$(document).ready(function(){
   $("form").validate({
	  rules:{
		  username:{
			  required:true,
			  minlength:5
		  },
		  password:{
			 required:true,
			 minlength:5
		  },
		  email:{
			  required:true
		  },
		  address:{
			  required:true
		  },
		  phone:{
			  required:true,
			  minlength:10
		  }
	  },
	  messages:{
		  username:{
			  required:"Please enter name",
			  minlength:"Please enter atleast 5 characters"
		  },
		  password:{
			 required:"Please enter password",
			 minlength:"Please enter atleast 5 characters"}  
	  },
	  email:{
		  required:"Please enter valid email"
	  },
	  address:{
		  required:"Please Enter Your Address"
	  },
	  phone:{
		  required:"please Enter Your Phone No",
		  minlength:"Please Enter 10 nos"
	  }
   });	
});
</script>
</body>
</html>