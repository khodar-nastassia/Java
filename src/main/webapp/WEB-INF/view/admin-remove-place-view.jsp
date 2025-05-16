<html>
<head><title>Remove Workplace</title></head>
<body>
    <h2>Remove a Workplace</h2>

    <c:forEach var="wp" items="${workplaces}">
        <p>
            ${wp.name} (${wp.price} PLN)
            <form action="${pageContext.request.contextPath}/admin/delete-space" method="post" style="display:inline">
                <input type="hidden" name="id" value="${wp.id}" />
                <button type="submit">Delete</button>
            </form>
        </p>
    </c:forEach>
</body>
</html>