<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!doctype html>
<html lang="en">

<jsp:include page="head.jsp">
    <jsp:param name="header" value="Product Form"/>
</jsp:include>

<body>

<jsp:include page="navigation.jsp"/>

<h1>Product Form</h1>

<div class="container">
    <div class="row py-2">
        <div class="col-12">
            <c:url value="/product" var="productSubmitUrl"/>
            <form action="${productSubmitUrl}" method="post">
                <input type="hidden" id="id" name="id" value="${product.id}">
                <div class="form-group">
                    <label>Name</label>
                    <input type="text" class="form-control" id="name" name="name" value="${product.name}"
                           placeholder="Enter name">
                </div>
                <div class="form-group">
                    <label>Description</label>
                    <input type="text" class="form-control" id="description" name="description"
                           value="${product.description}" placeholder="Enter description">
                </div>
                <div class="form-group">
                    <label>Price</label>
                    <input type="number" class="form-control" id="price" name="price" value="${product.price}"
                           placeholder="Enter price">
                </div>

                <div class="form-group">
                    <label>Category</label>
                    <select class="form-control" id="categoryId" name="categoryId">
                        <c:forEach var="category" items="${requestScope.categories}">
                            <option value="${category.id}">${category.name}</option>
                        </c:forEach>
                    </select>
                </div>

                <button type="submit" class="btn btn-primary">Submit</button>
            </form>
        </div>
    </div>
</div>
<jsp:include page="script.jsp"/>
</body>
</html>