<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<meta charset="utf-8">

<script type='text/javascript' src='https://code.jquery.com/jquery-2.1.4.js'></script>

<script type='text/javascript' src='http://ajax.aspnetcdn.com/ajax/knockout/knockout-3.1.0.js'></script>

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.css">

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap-theme.css">

<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.js"></script>

<style>
    .error {
        color: #ff0000;
    }
</style>

<head>
    <title>Project Detail</title>
</head>
<body>
<div class="container">
    <div class="col-8 offset-2 my-4">
        <h2>Project Detail</h2>
        <form:form action="/save" method="post" modelAttribute="project">
            <div class="form-group">
                <form:input path="id" type="hidden" value="${project.id}"/>
            </div>
            <div class="form-group">
                <form:label path="name">Project name</form:label>
<%--                            minlength="3" maxlength="100" required="true"--%>
                <form:input path="name" type="text" class="form-control"
                            placeholder="Enter title" value="${project.name}"/>
                <form:errors path="name" cssClass="error"/>
            </div>
            <div class="form-group">
                <form:label path="finishingDate">Finishing Date</form:label>
                <fmt:formatDate value="${project.finishingDate}"
                                type="date"
                                pattern="yyyy-MM-dd"
                                var="theFormattedDate"/>
<%--                            min='2000-01-01' max='2050-12-31' required="true"--%>
                <form:input type="date" class="form-control" path="finishingDate"
                            value="${theFormattedDate}"/>
                <form:errors path="finishingDate" cssClass="error"/>
            </div>
            <button type="submit" class="btn btn-primary">Submit</button>
            <a href="/" class="btn btn-secondary text-white">Cancel</a>
        </form:form>
    </div>
</div>
</body>
</html>
