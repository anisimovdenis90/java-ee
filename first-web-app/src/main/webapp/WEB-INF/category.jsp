<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!doctype html>
<html lang="en">

<jsp:include page="head.jsp">
    <jsp:param name="header" value="Categories List"/>
</jsp:include>

<body>

<jsp:include page="navigation.jsp"/>

<h1>Categories List</h1>

<div class="container">
    <div class="row py-2">
        <div class="col-12">
            <c:url value="/category/create" var="categoryCreateUrl"/>
            <a class="btn btn-primary" href="${categoryCreateUrl}">Add Category</a>
        </div>

        <div class="col-12">
            <table class="table table-bordered my-2">
                <thead>
                <tr>
                    <th scope="col">Id</th>
                    <th scope="col">Name</th>
                    <th scope="col">Actions</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="category" items="${requestScope.categories}">
                    <tr>
                        <th scope="row"><c:out value="${category.id}"/></th>
                        <td><c:out value="${category.name}"/></td>
                        <td>
                            <c:url value="/category/edit" var="categoryEditUrl">
                                <c:param name="id" value="${category.id}"/>
                            </c:url>
                            <a class="btn btn-success" href="${categoryEditUrl}"><i class="fas fa-edit"></i></a>
                            <c:url value="/category/delete" var="categoryDeleteUrl">
                                <c:param name="id" value="${category.id}"/>
                            </c:url>
                            <a class="btn btn-danger" href="${categoryDeleteUrl}"><i class="far fa-trash-alt"></i></a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>
<jsp:include page="script.jsp"/>
</body>
</html>
