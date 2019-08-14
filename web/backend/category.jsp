<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Category</title>
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
    }%>
<jsp:include page="menu.jsp"></jsp:include>
<div class="container">
    <div class="alert alert-danger" style="display:${catErrorDispaly == null? 'none' : catErrorDispaly } ">
        <strong>Validation Error! </strong><br> ${categoryError}
    </div>

    <c:choose>
    <c:when test="${param.update == 'true'}">
    <h2>Update category information</h2>
    <form method="post" action="../update-category">
        <c:forEach items="${categoryById}" var="val">
            <input type="hidden" name="id" value="${val.key}">
            <div class="form-group">
                <label for="uname">Name:</label>
                <input type="text" class="form-control" id="uname" name="name" value="${val.value.name}">
            </div>
            <div class="checkbox">
                <c:choose>
                    <c:when test="${val.value.isActive}">
                        <label>
                            <input type="checkbox" name="isActive" checked> Is
                            active</label>
                    </c:when>
                    <c:otherwise>
                        <label>
                            <input type="checkbox" name="isActive"> Is
                            active</label>
                    </c:otherwise>
                </c:choose>
            </div>

            <button type="submit" class="btn btn-default" value="Update">Update</button>
        </c:forEach>
    </form>
    </c:when>

    <c:otherwise>
    <h2>Add new category information</h2>
    <form method="post" action="../add-category">
        <div class="form-group">
            <label for="name">Name:</label>
            <input type="text" class="form-control" id="name" name="name" placeholder="Enter name">
        </div>
        <div class="checkbox">
            <label><input type="checkbox" id="isActive" name="isActive"> Is active</label>
        </div>

        <button type="submit" class="btn btn-default">Submit</button>
    </form>
    </c:otherwise>
    </c:choose>


    <table class="table table-striped">
        <thead>
        <tr>
            <th>Name</th>
            <th>Is active</th>
            <th>Edit</th>
            <th>Delete</th>
        </tr>
        </thead>
        <tbody>

        <c:forEach items="${categoryList}" var="val">
            <tr>
                <td><c:out value="${val.value.name}"/></td>
                <td><c:out value="${val.value.isActive}"/></td>
                <td><a href="../update-category?id=${val.key}"
                       class="btn btn-info" role="button">Update</a></td>
                <td><a href="../delete-category?id=${val.key}"
                       class="btn btn-info" role="button">Delete</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>


</body>
</html>
