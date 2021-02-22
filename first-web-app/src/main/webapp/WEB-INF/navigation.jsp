<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

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

