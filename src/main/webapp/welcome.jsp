<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" %>
<jsp:useBean id="authResult" scope="request" type="webapp.login.AuthorizationResult"
             class="webapp.login.AuthorizationResult"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Welcome Page</title>
</head>
<body>
<jsp:include page="login-result-box.jsp">
    <jsp:param name="msgValue" value="${authResult.value}"/>
    <jsp:param name="msgType" value="${authResult.type}"/>
</jsp:include>
<h2>Welcome!</h2>
<h3>There we have some secret info, available only for logged in user</h3>
<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Aperiam at autem consequuntur cum delectus, deserunt
    dolor eum, fugiat ipsam nisi numquam pariatur provident, quisquam reiciendis vel voluptas voluptate. Doloremque,
    optio.</p>
</body>
</html>