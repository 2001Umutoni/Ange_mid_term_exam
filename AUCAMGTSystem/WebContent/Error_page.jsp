<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Error page</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f2f2f2;
            text-align: center;
            margin: 0;
            padding: 0;
        }
        h1 {
            color: #333;
        }
        p {
            font-size: 16px;
            color: #555;
        }
        a {
            text-decoration: none;
            color: #0078d4;
        }
        a:hover {
            text-decoration: underline;
        }
        .container {
            background-color: #fff;
            border-radius: 5px;
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
            padding: 20px;
            max-width: 400px;
            margin: 0 auto;
            margin-top: 50px;
        }
    </style>
</head>
<body>
<h1>Error 😒</h1>
    ${message}
<p><a href="DashBoard.jsp">Return to the  Dashboard</a></p>
</body>
</html>
