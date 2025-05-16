<!DOCTYPE html>
<%@ page session="true" %>
<html>

<head>
    <title>Add New Workplace</title>
</head>
<body>
<h2>Add a New Workplace</h2>

    <form action="add-workplace" method="post">
        <label for="type">Type:</label><br/>
        <input type="text" id="type" name="type" required/><br/><br/>

        <label for="price">Price:</label><br/>
        <input type="number" step="0.01" id="price" name="price" required/><br/><br/>
        <button type="submit">Add</button>

    </form>
</body>
</html>