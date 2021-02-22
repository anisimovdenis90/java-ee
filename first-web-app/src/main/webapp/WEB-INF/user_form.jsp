<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!doctype html>
<html lang="en">

<jsp:include page="head.jsp">
    <jsp:param name="header" value="User Form"/>
</jsp:include>

<body>

<jsp:include page="navigation.jsp"/>

<h1>User Form</h1>

<div class="container">
    <div class="row py-2">
        <div class="col-12">
            <c:url value="/user" var="userSubmitUrl"/>
            <form action="${userSubmitUrl}" method="post">
                <input type="hidden" id="id" name="id" value="${user.id}">
                <div class="form-group">
                    <label>First Name</label>
                    <input type="text" class="form-control" id="firstname" name="firstname" value="${user.firstname}"
                           placeholder="Enter firstname">
                </div>
                <div class="form-group">
                    <label>Last Name</label>
                    <input type="text" class="form-control" id="lastname" name="lastname" value="${user.lastname}"
                           placeholder="Enter lastname">
                </div>
                <div class="form-group">
                    <label>Email</label>
                    <input type="text" class="form-control" id="email" name="email" value="${user.email}"
                           placeholder="Enter email">
                </div>
                <div class="form-group">
                    <label>Birthday</label>
                    <input type="text" class="form-control" id="birthday" name="birthday" value="${user.birthday}"
                           placeholder="Enter birthday">
                </div>
                <div class="form-group">
                    <label>Phone</label>
                    <input type="text" class="form-control" id="phone" name="phone" value="${user.phone}"
                           placeholder="Enter phone">
                </div>
                <button type="submit" class="btn btn-primary">Submit</button>
            </form>
        </div>
    </div>
</div>
<jsp:include page="script.jsp"/>
</body>
</html>