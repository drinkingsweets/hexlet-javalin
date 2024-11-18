@import org.example.hexlet.CoursesPageBuild
@param CoursesPageBuild pageBuild

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8" />
    <title>Add Course</title>
</head>
<body>
<h1>Add Course</h1>
@if (pageBuild != null && pageBuild.getErrors() != null)
    @for(var validator: pageBuild.getErrors().values())
        @for(var error : validator)
                  <li>${error.getMessage()}</li>
              @endfor
    @endfor
@endif
<form action="/courses/add" method="post">
    <label for="courseName">Название курса:</label>
    <input type="text" id="courseName" name="courseName" value="${pageBuild != null ? pageBuild.getName() : ""}" required />
    <br />

    <label for="courseDes">Описание курса:</label>
    <textarea id="courseDes" name="courseDes" value="${pageBuild != null ? pageBuild.getDescription() : ""}" required></textarea>
    <br />

    <button type="submit">Добавить курс</button>
</form>
</body>
</html>
