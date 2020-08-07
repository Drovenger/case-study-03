<%--
  Created by IntelliJ IDEA.
  User: stpdm
  Date: 8/6/2020
  Time: 9:04 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
    <link rel="stylesheet" href="css/index-style.css">
</head>
<body>
<h1 style="text-align: center">Login</h1>
<form action="${pageContext.request.contextPath}/login" method="post">
    <div class="imgcontainer">
        <img src="imgLogin/img_avatar.png" alt="Avatar" class="avatar">
    </div>

    <div class="container">
        <label class="form-control"><b>Username</b></label><br/>
        <input type="text" placeholder="Enter Username" name="email" required><br/>

        <label><b>Password</b></label><br/>
        <input type="password" placeholder="Enter Password" name="password" required>

        <button type="submit">Login</button>
        <br/>
        <label>
            <input type="checkbox" checked="checked" name="remember"> Remember me
        </label>
    </div>

    <div class="container" style="background-color:#f1f1f1">
        <button type="button" class="cancelbtn">Cancel</button>
        <span class="psw">Forgot <a href="#">password?</a></span>
    </div>
</form>
</body>
</html>