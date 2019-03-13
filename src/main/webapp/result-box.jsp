<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html lang="en">

<head>
    <style>
        .ERROR {
            -webkit-box-sizing: content-box;
            -moz-box-sizing: content-box;
            box-sizing: content-box;
            width: 250px;
            padding: 20px;
            overflow: hidden;
            border: none;
            -webkit-border-radius: 25px;
            border-radius: 25px;
            font: normal 19px/1 "acme", Helvetica, sans-serif;
            color: rgb(255, 255, 255);
            text-align: center;
            -o-text-overflow: ellipsis;
            text-overflow: ellipsis;
            letter-spacing: 2px;
            background: rgba(242, 113, 113, 1);
            -webkit-box-shadow: 1px 1px 1px 0 rgb(104, 70, 70), 1px 1px 1px 0 rgb(104, 70, 70);
            box-shadow: 1px 1px 1px 0 rgb(104, 70, 70), 1px 1px 1px 0 rgb(104, 70, 70);
            text-shadow: 1px 1px 1px rgba(90, 90, 90, 1), 1px 1px 1px rgba(0, 0, 0, 0.2);

        }
        .SUCCESS {
            -webkit-box-sizing: content-box;
            -moz-box-sizing: content-box;
            box-sizing: content-box;
            width: 250px;
            padding: 20px;
            overflow: hidden;
            border: none;
            -webkit-border-radius: 25px;
            border-radius: 25px;
            font: normal 19px/1 "acme", Helvetica, sans-serif;
            color: rgb(255, 255, 255);
            text-align: center;
            -o-text-overflow: ellipsis;
            text-overflow: ellipsis;
            letter-spacing: 2px;
            background: rgba(134, 237, 132, 1);
            -webkit-box-shadow: 1px 1px 1px 0 rgb(104, 70, 70), 1px 1px 1px 0 rgb(104, 70, 70);
            box-shadow: 1px 1px 1px 0 rgb(104, 70, 70), 1px 1px 1px 0 rgb(104, 70, 70);
            text-shadow: 1px 1px 1px rgba(90, 90, 90, 1), 1px 1px 1px rgba(0, 0, 0, 0.2);
        }
    </style>
</head>
<body>
<div class="${param.msgType}">${param.msgValue}</div>
<h1></h1>
</body>
</html>
