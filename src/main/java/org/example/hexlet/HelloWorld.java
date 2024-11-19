package org.example.hexlet;

import io.javalin.Javalin;
import io.javalin.rendering.template.JavalinJte;
import io.javalin.validation.ValidationError;
import io.javalin.validation.ValidationException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.javalin.rendering.template.TemplateUtil.model;

public class HelloWorld {
    public static void main(String[] args) {
        var app = Javalin.create(config -> {
            config.bundledPlugins.enableDevLogging();
            config.fileRenderer(new JavalinJte());
        });

        List<Course> all = new ArrayList<>();
        all.add(new Course("sql1", "12121"));
        all.add(new Course("sql2python", "12313"));
        all.add(new Course("python1", "12122131231"));
        all.add(new Course("python sql js bebube", "12122311"));

        for(Course course: all) {
            CoursesPage.addCourse(course);
        }

        app.get(Routes.toCourses(), CoursesController::mainPage);
        app.get(Routes.coursesPath(), CoursesController::coursesPage);
        app.get(Routes.addCoursesPath(), CoursesController::build);
        app.get(Routes.currentCourse(), CoursesController::currentCourse);
        app.post(Routes.addCoursesPath(), CoursesController::addCourse);

        app.start(7070);
    }
}