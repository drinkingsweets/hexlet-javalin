package org.example.hexlet;

import io.javalin.Javalin;
import io.javalin.rendering.template.JavalinJte;

import java.util.ArrayList;


import static io.javalin.rendering.template.TemplateUtil.model;

public class HelloWorld {
    public static void main(String[] args) {
        var app = Javalin.create(config -> {
            config.bundledPlugins.enableDevLogging();
            config.fileRenderer(new JavalinJte());
        });
        ArrayList<Course> courses = new ArrayList<>();

            courses.add(new Course(1, "course1", "it is course1"));
            courses.add(new Course(2, "course2", "it is course2"));
            courses.add(new Course(3, "course3", "it is course3"));
            courses.add(new Course(4, "course4", "it is course4"));
            courses.add(new Course(5, "course5", "it is course5"));
        app.get("/courses", ctx -> {


            var page = new CoursesPage(courses, "Курсы по программированию");
            ctx.render("courses/index.jte", model("page", page));
        });
        app.get("/courses/{id}", ctx -> {
            long id = ctx.pathParamAsClass("id", Long.class).get();
            for(Course course: courses){
                if (course.getId() == id){
                    ctx.result("Course: " + course.getName() + "\n" + course.getDescription());
                }
            }
        });

        app.start(7070);
    }
}