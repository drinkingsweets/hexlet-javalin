@import org.example.hexlet.Routes

<!DOCTYPE html>
<html>
<body>
<meta charset="utf-8" />
<h2>Войти в аккаунт</h2>
<form action="${Routes.loginPath()}" method="post">
    <input type="login" required name="login">
    <input type="password" required name="password">
    <input type="submit" value="Войти">
</form>
</body>
</html>
