<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!doctype html>
<html lang="en">

<jsp:include page="head.jsp">
    <jsp:param name="header" value="Categories List"/>
</jsp:include>

<body>

<jsp:include page="navigation.jsp"/>

<h1>Category Form</h1>

<div class="container">
    <div class="row py-2">
        <div class="col-12">
            <c:url value="/category" var="categorySubmitUrl"/>
            <form action="${categorySubmitUrl}" method="post">
                <input type="hidden" id="id" name="id" value="${category.id}">
                <div class="form-group">
                    <label>Name</label>
                    <input type="text" class="form-control" id="name" name="name" value="${category.name}"
                           placeholder="Enter name">
                </div>
                <button type="submit" class="btn btn-primary">Submit</button>
            </form>
        </div>
    </div>
</div>
<jsp:include page="script.jsp"/>
</body>
</html>