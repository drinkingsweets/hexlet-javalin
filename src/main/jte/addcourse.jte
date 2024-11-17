<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8" />
    <title>Add Course</title>
</head>
<body>
<h1>Add Course</h1>
<form action="/courses/add" method="post">
    <label for="courseName">Название курса:</label>
    <input type="text" id="courseName" name="courseName" required />
    <br />

    <label for="courseDes">Описание курса:</label>
    <textarea id="courseDes" name="courseDes" required></textarea>
    <br />

    <button type="submit">Добавить курс</button>
</form>
</body>
</html>
