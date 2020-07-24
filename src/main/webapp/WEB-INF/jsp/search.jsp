<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">

    <script type='text/javascript' src='https://code.jquery.com/jquery-2.1.4.js'></script>

    <script type='text/javascript' src='http://ajax.aspnetcdn.com/ajax/knockout/knockout-3.1.0.js'></script>

    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.css">

    <!-- Optional theme -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap-theme.css">

    <!-- Latest compiled and minified JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.js"></script>

    <%--  <script type='text/javascript' src='/static/js/ProjectViewModel.js'></script>--%>

    <title><spring:message code="application.title"/></title>
</head>

<body>

<div class="container">
    <div class="form-horizontal" role="form">
        <h2>${message}</h2>
        <form action="/query" method="post">
            <div class="form-group">
                <label class="control-label col-sm-2">Project name:</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="prjName" name="prjName"
                           placeholder="Enter project name" value="${prjName}" required/>
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                    <button type="submit" class="btn btn-default">Query</button>
                </div>
            </div>
        </form>

        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <div class="col-sm-10">
                    <table class="table table-striped form-group">
                        <thead>
                        <tr>
                            <th>Project ID</th>
                            <th>Project Name</th>
                            <th>Finishing Date</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:if test="${empty projects}">
                            <tr>
                                <td>No data available...</td>
                                <td></td>
                                <td></td>
                            </tr>
                        </c:if>
                        <c:forEach var="project" items="${projects}">
                            <tr>
                                <td><a href="/detail/${project.id}">${project.id}</a></td>
                                <td>${project.name}</td>
                                <td><fmt:formatDate value="${project.finishingDate}" pattern="yyyy-MM-dd"/></td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</div>

</body>

</html>