<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>@{title}</title>
</head>
<body>
    <!-- Верхнее меню -->
    <header>
        <h1>@{title}</h1>
        <nav>
            <a href="/">Главная страница</a>
        </nav>
    </header>

    <!-- Основной контент -->
    <main>
        @content
    </main>

    <!-- Футер -->
    <footer>
        <p>Создано вами | <a href="https://github.com/your-github-username">GitHub</a></p>
    </footer>
</body>
</html>
