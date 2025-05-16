<!DOCTYPE html>
<html>

<head>
    <title>Register</title>
</head>
<body>
    <p>Lets register:</p>
    <form action="register" method="post">
        <label for="name">Username:</label><br/>
        <input type="text" id="name" name="name" required/><br/><br/>

        <label for="email">Email:</label><br/>
        <input type="text" id="email" name="email" required/><br/><br/>

        <label for="role">Role (admin/customer):</label><br/>
        <input type="text" id="role" name="role" required/><br/><br/>

        <button type="submit">Register</button>

    </form>
</body>
</html>