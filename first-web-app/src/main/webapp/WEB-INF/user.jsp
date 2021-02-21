<%@ include file="menu.jsp" %>

<body>

<h1>User</h1>

<div class="container">
    <div class="row py-2">
        <div class="col-12">
            <c:url value="/user/create" var="userCreateUrl"/>
            <a class="btn btn-primary" href="${userCreateUrl}">Add User</a>
        </div>

        <div class="col-12">
            <table class="table table-bordered my-2">
                <thead>
                <tr>
                    <th scope="col">Id</th>
                    <th scope="col">FirstName</th>
                    <th scope="col">LastName</th>
                    <th scope="col">Email</th>
                    <th scope="col">Birthday</th>
                    <th scope="col">Phone</th>
                    <th scope="col">Actions</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="user" items="${requestScope.users}">
                    <tr>
                        <th scope="row"><c:out value="${user.id}"/></th>
                        <td><c:out value="${user.firstname}"/></td>
                        <td><c:out value="${user.lastname}"/></td>
                        <td><c:out value="${user.email}"/></td>
                        <td><c:out value="${user.birthday}"/></td>
                        <td><c:out value="${user.phone}"/></td>
                        <td>
                            <c:url value="/user/edit" var="userEditUrl">
                                <c:param name="id" value="${user.id}"/>
                            </c:url>
                            <a class="btn btn-success" href="${userEditUrl}"><i class="fas fa-edit"></i></a>
                            <c:url value="/user/delete" var="userDeleteUrl">
                                <c:param name="id" value="${user.id}"/>
                            </c:url>
                            <a class="btn btn-danger" href="${userDeleteUrl}"><i class="far fa-trash-alt"></i></a>
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