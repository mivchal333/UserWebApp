<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--@elvariable id="addResult" type="webapp.util.ValidateResult"--%>


<html lang="en">
<head>
    <title>Post Add - UserWebApp</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="icon" type="image/png" href="images/icons/favicon.ico"/>
    <link rel="stylesheet" type="text/css" href="vendor/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="fonts/font-awesome-4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" type="text/css" href="vendor/animate/animate.css">
    <link rel="stylesheet" type="text/css" href="vendor/css-hamburgers/hamburgers.min.css">
    <link rel="stylesheet" type="text/css" href="vendor/select2/select2.min.css">
    <link rel="stylesheet" type="text/css" href="css/util.css">
    <link rel="stylesheet" type="text/css" href="css/add_page.css">
    <link rel="stylesheet" type="text/css" href="css/main.css">
</head>
<body>
<div class="limiter">
    <div class="container-login100">
        <div class="wrap-login100">
            <form class="addpost-form validate-form" method="post" action="add-post">
                <span class="login100-form-title">
                    <c:choose>
                        <c:when test="${not empty addResult.value }">
                            <jsp:include page="result-box.jsp">
                                <jsp:param name="msgValue" value="${addResult.value}"/>
                                <jsp:param name="msgType" value="${addResult.type}"/>
                            </jsp:include>
                        </c:when>
                        <c:otherwise>
                            Add Post
                        </c:otherwise>
                    </c:choose>
					</span>
                <div class="wrap-input50 validate-input" data-validate="Title must be over 20 characters">
                    <input class="input50" type="text" name="title" placeholder="Title">
                    <span class="focus-input50"></span>
                </div>
                <div class="wrap-input-200 validate-input" data-validate="Content must be over 120 characters">
                    <input class="input200" type="text" name="content" placeholder="Content">
                    <span class="focus-input100"></span>
                </div>
                <div class="container-login100-form-btn">
                    <button class="login100-form-btn">
                        Submit
                    </button>
                </div>
            </form>
            <c:if test="${ addResult.type eq 'SUCCESS' }">
                <div class="container-login-btn">
                    <button  class="login-btn" onclick="location.href='/posts'">
                    Go to posts
                    </button>
                </div>
            </c:if>
        </div>
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