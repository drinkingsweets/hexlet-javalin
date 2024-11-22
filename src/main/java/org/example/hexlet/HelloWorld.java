package org.example.hexlet;

import io.javalin.Javalin;
import io.javalin.rendering.template.JavalinJte;
import io.javalin.validation.ValidationError;
import io.javalin.validation.ValidationException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.javalin.rendering.template.TemplateUtil.model;
import static org.example.hexlet.BaseRepository.dataSource;

public class HelloWorld {
    public static void main(String[] args) throws SQLException {

        try {
            // Step 4: Connect to the newly created database
            dataSource = DriverManager.getConnection("jdbc:postgresql://localhost:5432/hexlet", "postgres", "1601");
            // Step 5: Create the table in the new database
            dataSource.createStatement().executeUpdate("DROP TABLE IF EXISTS courses");
            dataSource.createStatement().executeUpdate("CREATE TABLE courses(id INT PRIMARY KEY, name TEXT, description TEXT);");
            System.out.println("Table created successfully.");
        } catch (SQLException e) {
            e.printStackTrace(); // Print the stack trace for debugging
        }


        var app = Javalin.create(config -> {
            config.bundledPlugins.enableDevLogging();
            config.fileRenderer(new JavalinJte());
        });

        List<Course> all = new ArrayList<>();
        all.add(new Course(CoursesPage.nextIndex(), "sql1", "12121"));
        all.add(new Course(CoursesPage.nextIndex(), "sql2python", "12313"));
        all.add(new Course(CoursesPage.nextIndex(), "python1", "12122131231"));
        all.add(new Course(CoursesPage.nextIndex(), "python sql js bebube", "12122311"));

        for(Course course: all) {
            CoursesPage.addCourse(course);
        }

        UserRepository.add(new User("test", "test"));

        app.get(Routes.toCourses(), CoursesController::mainPage);
        app.get(Routes.loginPath(), CoursesController::renderLoginPage);
        app.post(Routes.loginPath(), CoursesController::authentication);
        app.get(Routes.coursesPath(), CoursesController::coursesPage);
        app.get(Routes.addCoursesPath(), CoursesController::build);
        app.get(Routes.currentCourse(), CoursesController::currentCourse);
        app.post(Routes.addCoursesPath(), CoursesController::addCourse);


        app.start(7070);
    }
}