<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
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
<c:forEach items="${ requestScope.posts }" var="post">
    <div class="wrap">
        <div class="article-title"> ${ post.title }</div>
        <span class="author">
                ${post.author}
        </span>
        <link async href="http://fonts.googleapis.com/css?family=Passero%20One"
              data-generated="http://enjoycss.com"
              rel="stylesheet" type="text/css"/>
        <link async href="http://fonts.googleapis.com/css?family=Nova%20Flat"
              data-generated="http://enjoycss.com"
              rel="stylesheet" type="text/css"/>
        <div class="article-content">
                ${ post.content }
        </div>
    </div>
</c:forEach>
</body>
</html>
