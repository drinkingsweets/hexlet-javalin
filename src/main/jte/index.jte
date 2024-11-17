@import org.example.hexlet.Course
@import java.util.List
@param String term
@param List<Course> all

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
    </head>
<body>
<a href = "/courses/add"> Add course</a>
<h1>Courses: ${all.size()}</h1>
<form action="/courses" method="get">
  <input type="search" required name="term" value="${term}">
  <input type="submit" value="Искать">
</form>
<a> 
    @for (Course course: all)
        <h2>${course.getName()}</h2>
    @endfor

</a>
</body>
</html>