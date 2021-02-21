<%@ include file="menu.jsp" %>

<h1>Category</h1>

<body>
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
</html>