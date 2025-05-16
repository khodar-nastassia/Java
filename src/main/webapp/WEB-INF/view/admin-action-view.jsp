<!DOCTYPE html>
<%@ page session="true" %>
<html>

<head>
    <title>Admin Dashboard</title>
</head>
<body>
    <h2>Welcome in Admin Area, ${user.name}!</h2>
    <h3>Choose an action:</h3>

    <form action="admin/add-workplace" method="get" >
        <button type="submit">1. Add a new coworking space</button>
    </form>

    <form action="admin/remove-workplace" method="get">
            <button type="submit">2. Remove a coworking space</button>
        </form>

        <form action="admin/reservations" method="get">
            <button type="submit">3. View all reservations</button>
        </form>

        <form action="logout" method="get">
            <button type="submit">4. Exit</button>
        </form>
</body>
</html>