package org.example.hexlet;

import io.javalin.Javalin;
import io.javalin.rendering.template.JavalinJte;
import org.apache.commons.lang3.StringEscapeUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.javalin.rendering.template.TemplateUtil.model;
import static javax.swing.UIManager.put;

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

        CoursesPage coursesPage = new CoursesPage(all, "courses");

        app.get("/", ctx -> {
             ctx.result("Hello");
        });

        app.get("/courses", ctx ->
        {
        String term = ctx.queryParam("term");
        if (term != null) {
            Map<String, Object> data = new HashMap<>();
            data.put("all", coursesPage.getCourses().stream().filter(course -> course.getName().contains(term)).toList());
            data.put("term", term);

            ctx.render("index.jte", data);
        } else {
            Map<String, Object> data = new HashMap<>();
            data.put("all", coursesPage.getCourses());
            data.put("term", "");

            ctx.render("index.jte", data);
        }

        });

        app.get("/courses/add", ctx -> {
            ctx.render("addcourse.jte");
        });

        app.post("/courses/add", ctx -> {
            String name = ctx.formParam("courseName");
            String desc = ctx.formParam("courseDes");

            coursesPage.addCourse(new Course(name, desc));

            ctx.redirect("/courses");
        });

        app.start(7070);
    }
}