<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
</body>

