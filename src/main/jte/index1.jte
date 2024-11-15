@import gg.jte.Content
@param Content content
@param Content footer = null

<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Верхнее меню</title>
    <style>
        body {
            font-family: Arial, sans-serif;
        }
        header {
            background-color: #333;
            color: white;
            padding: 10px 20px;
            text-align: center;
        }
        nav {
            text-align: center;
            margin-top: 10px;
        }
        nav a {
            color: white;
            text-decoration: none;
            padding: 10px 20px;
            margin: 0 15px;
            font-size: 18px;
        }
        nav a:hover {
            background-color: #555;
            border-radius: 5px;
        }
    </style>
</head>
<body>

<header>
    <h1>Мой сайт</h1>
</header>

<nav>
    <a href="/">Главная страница</a>
</nav>

<!-- Отображаем переданный контент -->
<h1>${content}</h1>

<!-- Отображаем футер, если он был передан -->
${footer}


</body>
</html>
