<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!doctype html>
<html lang="en">

<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css"/>
    <title>EShop application</title>
</head>

<body>

<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
                <c:url value="/main" var="MainUrl"/>
                <a class="nav-link" href="${MainUrl}">Main</a>
            </li>
            <li class="nav-item active">
                <c:url value="/catalog" var="CatalogUrl"/>
                <a class="nav-link" href="${CatalogUrl}">Catalog</a>
            </li>
            <li class="nav-item active">
                <c:url value="/cart" var="CartUrl"/>
                <a class="nav-link" href="${CartUrl}">Cart</a>
            </li>
            <li class="nav-item active">
                <c:url value="/order" var="OrderUrl"/>
                <a class="nav-link" href="${OrderUrl}">Order</a>
            </li>
            <li class="nav-item active">
                <c:url value="/product" var="ProductUrl"/>
                <a class="nav-link" href="${ProductUrl}">Product</a>
            </li>
            <li class="nav-item active">
                <c:url value="/user" var="UserUrl"/>
                <a class="nav-link" href="${UserUrl}">User</a>
            </li>
            <li class="nav-item active">
                <c:url value="/category" var="CategoryUrl"/>
                <a class="nav-link" href="${CategoryUrl}">Category</a>
            </li>
        </ul>
    </div>
</nav>

<h1>Edit Product</h1>

<div class="container">
    <div class="row py-2">
        <div class="col-12">
        <c:url value="/category" var="categorySubmitUrl"/>
            <form action="${categorySubmitUrl}" method="post">
                <input type="hidden" id="id" name="id" value="${category.id}">
                <div class="form-group">
                    <label>Name</label>
                    <input type="text" class="form-control" id="name" name="name" value="${category.name}" placeholder="Enter name">
                </div>
                <button type="submit" class="btn btn-primary">Submit</button>
            </form>
        </div>
    </div>
</div>

<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
        integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
        integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous"></script>

</body>