<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>AUCA Registration form</title>

<style>

body {
  
  background-image: url('image/ac1logo.jpg');
  
  background-position: center;
  background-repeat: no-repeat;
  background-size: cover;
}

.container {
  padding: 10px;
  width: 35%; 
  margin: 0 auto; 
  border: 1px solid #ccc; 
  border-radius: 8px; 
  
  background-color: silver;
}


.imgcontainer {
  text-align: center;
}


input[type=text], input[type=password] {
  width: calc(100% - 30px); 
  padding: 10px;
  margin: 5px 0 22px 0;
  display: inline-block;
  border: none;
  background: #f1f1f1;
}

input[type=text]:focus, input[type=password]:focus {
  background-color: #ddd;
  outline: none;
}


hr {
  border: 1px solid #f1f1f1;
  margin-bottom: 25px;
}


.registerbtn {
  background-color: #04AA6D;
  color: white;
  padding: 16px 20px;
  margin: 8px 0;
  border: none;
  cursor: pointer;
  width: 100%;
  opacity: 0.9;
}

.registerbtn:hover {
  opacity: 1;
}


a {
  color: dodgerblue;
}


.signin {
  background-color: #f1f1f1;
  text-align: center;
}
</style>
</head>
<body>

<div class="container"> 
  <form action="createAccount" method="post">
  
    <div class="imgcontainer">
      <img src="image/aclogo.jpg" width="26%" alt="logo">
      <p style="font-family: serif; font-size: large;">Sign up to AUCA Portal</p>
    </div>
    <hr>

    <label for="email"><b>Email</b></label>
    <input type="text" placeholder="Enter Email" name="email" id="email" required>

    <label for="role">Role:</label><br>
    <select id="role" name="role" required>
        <option value="admin">Admin</option>
        <option value="student">Student</option>
        <option value="teacher">Teacher</option>
    </select><br><br>

    <label for="password"><b>Password</b></label>
    <input type="password" placeholder="Enter Password" name="psw" id="psw" required>

    <label for="confirmPassword"><b>Confirm Password</b></label>
<input type="password" placeholder="Confirm Password" name="confirmPassword" id="confirmPassword" required>
    <div class="form-check"><input type="checkbox" id="customCheck1" class="form-check-input"><label for="customCheck1" class="form-check-label">I agree to all <a href="javascript:void(0)">Terms</a></label></div>

    <button type="submit" class="registerbtn">Sign Up</button>
  </form>

  <div class="signin">
    <p>Already have an account? <a href="login.jsp">Sign in</a>.</p>
  </div>
</div>
<script>
    
    document.querySelector('form').addEventListener('submit', function (event) {
        var password = document.getElementById('password').value;
        var confirmPassword = document.getElementById('confirmPassword').value;
        if (password !== confirmPassword) {
            alert('Password and Confirm Password do not match.');
            event.preventDefault(); 
        }
    });
   
</script>

</body>
</html>
