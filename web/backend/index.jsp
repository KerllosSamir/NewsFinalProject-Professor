<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>WAP News backend</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link rel="stylesheet" href="../assets/css/bootstrap.min.css">
    <script src="../assets/js/jquery.min.js"></script>
    <script src="../assets/js/bootstrap.min.js"></script>
</head>
<body>
<%
    session=request.getSession(false);
    if(session.getAttribute("User_ID")==null)
    {
        response.sendRedirect("login.jsp");
    }

%>
<jsp:include page="menu.jsp"></jsp:include>

</body>
</html>
