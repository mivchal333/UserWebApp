<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" %>
<jsp:useBean id="userObj" scope="session" type="webapp.model.User" class="webapp.model.User"/>


<html lang="en">
<head>
    <title>Login - UserWebApp</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="icon" type="image/png" href="images/icons/favicon.ico"/>
    <link rel="stylesheet" type="text/css" href="vendor/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="fonts/font-awesome-4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" type="text/css" href="vendor/animate/animate.css">
    <link rel="stylesheet" type="text/css" href="vendor/css-hamburgers/hamburgers.min.css">
    <link rel="stylesheet" type="text/css" href="vendor/select2/select2.min.css">
    <link rel="stylesheet" type="text/css" href="css/util.css">
    <link rel="stylesheet" type="text/css" href="css/posts.css">
</head>
<body>
<div class="limiter">
    <div class="container">
        <c:choose>
            <c:when test="${not empty sessionScope.userObj.login }">
                <div class="container-add-button">
                    <button class="add-button" onclick="location.href='/add_post.jsp'">
                        Add Post
                    </button>
                </div>
                <div class="container-login-btn">
                    <button class="login-btn" onclick="location.href='/logout'">
                        Logout
                    </button>
                </div>
            </c:when>
            <c:otherwise>
                <div class="container-login-btn">
                    <button class="login-btn" onclick="location.href='/'">
                        Login
                    </button>
                </div>
            </c:otherwise>
        </c:choose>
        <jsp:include page="posts.jsp"/>
    </div>
</div>

<script src="vendor/jquery/jquery-3.2.1.min.js"></script>
<script src="vendor/bootstrap/js/popper.js"></script>
<script src="vendor/bootstrap/js/bootstrap.min.js"></script>
<script src="vendor/select2/select2.min.js"></script>
<script src="vendor/tilt/tilt.jquery.min.js"></script>
<script src="js/main.js"></script>
</body>
</html>