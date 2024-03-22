<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="styles.css">
    <title>Forgot Password</title>
     <style>
   body {
  
  background-image: url('image/ac2logo.jpg');
  
  background-position: center;
  background-repeat: no-repeat;
  background-size: cover;
  
}.container {
  padding: 10px;
  width: 35%; 
  margin: 0 auto; 
  border: 1px solid #ccc; 
  border-radius: 8px; 
  
  background-color: silver;
}

     input[type=text], input[type=email] {
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
    p
    {
  
  
    .imgcontainer {
  text-align: center;
  


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
    </style>
</head>
<body>
<center>
    <div class="container">
                
        <form action="forgot"  method="post" sendResetLink(); return false;">
            <div class="imgcontainer">
      <img src="image/aclogo.jpg" width="26%" alt="logo">
      <p style="font-family: serif; font-size: large;">Recover Password</p>
    </div>
            <p>Enter your Email and instructions will be sent to you!</p>
            
            <input type="email"  placeholder="Enter your Email"="email" name="email" required>
            <br><br>
            <button  style="background-color: red;" type="submit">Send Reset Link</button>
            <p class="login">Remember Password? <a href="login.jsp">Login</a></p>
          
        </form>
      
    </div>

    <script src="script.js"></script>
    </center>
</body>
</html>
