<%@ include file="menu.jsp" %>

<body>

<h1>Edit User</h1>

<div class="container">
    <div class="row py-2">
        <div class="col-12">
        <c:url value="/user" var="userSubmitUrl"/>
            <form action="${userSubmitUrl}" method="post">
                <input type="hidden" id="id" name="id" value="${user.id}">
                <div class="form-group">
                    <label>First Name</label>
                    <input type="text" class="form-control" id="firstname" name="firstname" value="${user.firstname}" placeholder="Enter firstname">
                </div>
                <div class="form-group">
                    <label>Last Name</label>
                    <input type="text" class="form-control" id="lastname" name="lastname" value="${user.lastname}" placeholder="Enter lastname">
                </div>
                <div class="form-group">
                    <label>Email</label>
                    <input type="text" class="form-control" id="email" name="email" value="${user.email}" placeholder="Enter email">
                </div>
                <div class="form-group">
                    <label>Birthday</label>
                    <input type="text" class="form-control" id="birthday" name="birthday" value="${user.birthday}" placeholder="Enter birthday">
                </div>
                <div class="form-group">
                    <label>Phone</label>
                    <input type="text" class="form-control" id="phone" name="phone" value="${user.phone}" placeholder="Enter phone">
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