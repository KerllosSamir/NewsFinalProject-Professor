<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Article</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link rel="stylesheet" href="../assets/css/bootstrap.min.css">
    <script src="../assets/js/jquery.min.js"></script>
    <script src="../assets/js/bootstrap.min.js"></script>
</head>
<body>
<jsp:include page="menu.jsp"></jsp:include>
<div class="container">
        <%
    session=request.getSession(false);
    if(session.getAttribute("User_ID")==null)
    {
        response.sendRedirect("login.jsp");
    }%>
    <div class="alert alert-danger" style="display:${errorDispaly == null? 'none' : errorDispaly } ">
        <strong>Validation Error! </strong><br> ${articleError}
    </div>

    <c:choose>
    <c:when test="${param.update == 'true'}">
    <h2>Update article information</h2>
    <form method="post" action="../update-article" enctype="multipart/form-data">
        <c:forEach items="${articleById}" var="val">
            <input type="hidden" name="id" value="${val.key}">
            <div class="form-group">
                <label for="utitle">Title:</label>
                <input type="text" class="form-control" id="utitle" name="title" value="${val.value.title}">
            </div>
            <div class="form-group">
                <label for="ubody">Body:</label>
                <textarea class="form-control" id="ubody" name="body" rows="20">${val.value.body}</textarea>
            </div>
            <div class="form-group">
                <label for="ucategoryId">Category:</label>
                <select id="ucategoryId" name="categoryId" class="form-control">
                    <c:forEach items="${categoryList}" var="category">
                        <option value="${category.id}"
                                <c:if test="${category.id eq val.key}">selected="selected"</c:if>
                        >
                                ${category.name}
                        </option>
                    </c:forEach>
                </select>
            </div>

            <div class="form-group">
                <label for="umainImage">Main Image:</label>
                    <%-- <input type="text" class="form-control" id="umainImage" name="mainImage" value="${val.value.mainImage}"/>--%>
                <input type="file" name="mainImage" id="umainImage" class="form-control"/>
            </div>

            <div class="checkbox">
                <c:choose>
                    <c:when test="${val.value.isNaveBar}">
                        <label>
                            <input type="checkbox" name="isNaveBar" checked> Is
                            NavBar</label>
                    </c:when>
                    <c:otherwise>
                        <label>
                            <input type="checkbox" name="isNaveBar"> Is
                            NaveBar</label>
                    </c:otherwise>
                </c:choose>
            </div>

            <div class="checkbox">
                <c:choose>
                    <c:when test="${val.value.isRotating}">
                        <label>
                            <input type="checkbox" name="isRotating" checked> Is
                            Rotating</label>
                    </c:when>
                    <c:otherwise>
                        <label>
                            <input type="checkbox" name="isRotating"> Is
                            Rotating</label>
                    </c:otherwise>
                </c:choose>
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
    <h2>Add new article information</h2>
    <form method="post" action="../add-article" enctype="multipart/form-data" id="articleForm">
        <div class="form-group">
            <label for="title">Title:</label>
            <input type="text" class="form-control" id="title" name="title" placeholder="Enter title"/>
        </div>
        <div class="form-group">
            <label for="body">Body:</label>
            <textarea class="form-control" id="body" name="body" placeholder="Enter body" rows="20"></textarea>
        </div>
        <div class="form-group">
            <label for="categoryId">Category:</label>
            <select id="categoryId" name="categoryId" class="form-control">
                <c:forEach items="${categoryList}" var="category">
                    <option value="${category.id}"
                            <c:if test="${category.id eq selectedCatId}">selected="selected"</c:if>
                    >
                            ${category.name}
                    </option>
                </c:forEach>
            </select>
        </div>
        <div class="form-group">
            <label for="mainImage">Main Image:</label>
                <%--<input type="text" class="form-control" id="mainImage" name="mainImage" placeholder="Enter title"/>--%>
            <input type="file" name="mainImage" id="mainImage" class="form-control"/>
        </div>

        <div class="checkbox">
            <label><input type="checkbox" id="isNaveBar" name="isNaveBar"> is NaveBar</label>
        </div>
        <div class="checkbox">
            <label><input type="checkbox" id="isRotating" name="isRotating"> is Rotating</label>
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
            <th>Title</th>
            <th>Is active</th>
            <th>Edit</th>
            <th>Delete</th>
        </tr>
        </thead>
        <tbody>

        <c:forEach items="${articleList}" var="val">
            <tr>
                <td><c:out value="${val.value.title}"/></td>
                <td><c:out value="${val.value.isNaveBar}"/></td>
                <td><c:out value="${val.value.isRotating}"/></td>
                <td><c:out value="${val.value.isActive}"/></td>
                <td><a href="../update-article?id=${val.key}"
                       class="btn btn-info" role="button">Update</a></td>
                <td><a href="../delete-article?id=${val.key}"
                       class="btn btn-info" role="button">Delete</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>


</body>
</html>
