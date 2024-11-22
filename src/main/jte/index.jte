@import org.example.hexlet.Course
@import org.example.hexlet.Routes
@import java.util.List
@param String term
@param List<Course> all
@param boolean isVisited
@param String flash


<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8"/>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<a href="${Routes.addCoursesPath()}"> Add course</a>
<h1>Courses: ${all.size()}</h1>
<form action="${Routes.coursesPath()}" method="get">
    <input type="search" required name="term" value="${term}">
    <input type="submit" value="Искать">
</form>
@if (!isVisited)
    This message appears only when you visited site for the first time.
@endif
@if (flash != null)
    <div class="alert alert-success" role="alert">
        ${flash}
    </div>
@endif

<a>
    @for (Course course: all)
        <li><a href="/courses/${course.getId()}">${course.getName()}</a></li>
    @endfor

</a>
</body>
</html>