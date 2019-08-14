<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>ContactUs</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link rel="stylesheet" href="../assets/css/bootstrap.min.css">
    <script src="../assets/js/jquery.min.js"></script>
    <script src="../assets/js/bootstrap.min.js"></script>
</head>
<body>
<jsp:include page="menu.jsp"></jsp:include>
<div class="container">
    <h2>Contact us information</h2>

    <table class="table table-striped">
        <thead>
        <tr>
            <th>Name</th>
            <th>Email</th>
            <th>Message</th>
        </tr>
        </thead>
        <tbody>

        <c:forEach items="${contactList}" var="val">
            <tr>
                <td><c:out value="${val.value.name}"/></td>
                <td><c:out value="${val.value.email}"/></td>
                <td><c:out value="${val.value.message}"/></td>

            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
