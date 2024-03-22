<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>AUCA LOGIN FORM</title>

<style>
body {
  background-image: url('image/ac2logo.jpg');
  background-position: center;
  background-repeat: no-repeat;
  background-size: cover;
}

input[type=text], input[type=password] {
  width: calc(100% - 30px); 
  padding: 10px;
  margin: 5px 0 22px 0;
  display: inline-block;
  border: none;
  background: #f1f1f1;
}

button {
  background-color: #04AA6D;
  color: white;
  padding: 14px 20px;
  margin: 8px 0;
  border: none;
  cursor: pointer;
  width: 100%;
}

button:hover {
  opacity: 0.8;
}

.cancelbtn {
  width: auto;
  padding: 10px 18px;
  background-color: #f44336;
}

.imgcontainer {
  text-align: center;
}

img.avatar {
  width: 40%;
  border-radius: 50%;
}

.container {
  padding: 10px;
  width: 35%; 
  margin: 0 auto; 
  border: 1px solid #ccc; 
  border-radius: 8px; 
  background-color: silver;
}

span.psw {
  float: right;
  padding-top: 16px;
}

span.fpassword {
  float: right;
}

.signup {
  background-color: #f1f1f1;
  text-align: center;
}

@media screen and (max-width: 300px) {
  span.psw {
    display: block;
    float: none;
  }
  .cancelbtn {
    width: 100%;
  }
}
</style>
</head>
<body>
<div class="container"> 
  <form action="login" method="post">
    <div class="imgcontainer">
      <img src="image/aclogo.jpg" width="26%" alt="logo">
      <p style="font-family: serif; font-size: large;">Login to AUCA Portal</p>
    </div>
    <hr>

    <label for="email"><b>Email*</b></label>
    <input type="text" placeholder="Enter Your Email" name="email" required>

    <label for="password"><b>Password *</b></label>
    <input type="password" placeholder="Enter Password" name="password" required>

    <button type="submit">Login</button>
    <label>
      <input type="checkbox" checked="checked" name="remember"> Remember me
      <span class="fpassword"><a href="forgetpassword.jsp">Forget Password?</a></span>
    </label>
    <div class="signup">
      <span class="password">Don't have an account? <a href="signup.jsp">Sign up here</a></span>
    </div>
  </form>
</div>
</body>
</html>
