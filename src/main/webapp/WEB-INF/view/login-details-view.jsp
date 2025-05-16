<!DOCTYPE html>
<html>

<head>
    <title>Login</title>
</head>
<body>
    <p>Enter Username and Email:</p>
    <form action="login" method="post">
        <label for="name">Username:</label><br/>
        <input type="text" id="name" name="name" required/><br/><br/>

        <label for="email">Email:</label><br/>
        <input type="text" id="email" name="email" required/><br/><br/>
        <button type="submit">Login</button>

    </form>
</body>
</html>