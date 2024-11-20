package org.example.hexlet;

import io.javalin.http.Context;
import io.javalin.validation.ValidationException;
import java.util.HashMap;
import java.util.Map;

import static io.javalin.rendering.template.TemplateUtil.model;

public class CoursesController {

    public static void mainPage(Context ctx) {
        ctx.render("startPage.jte");
    }

    public static void coursesPage(Context ctx) {
        String term = ctx.queryParam("term");
        boolean visited = Boolean.valueOf(ctx.cookie("visited"));

        if (term != null) {
            Map<String, Object> data = new HashMap<>();
            data.put("all", CoursesPage.getCourses().stream().filter(course -> course.getName().contains(term)).toList());
            data.put("term", term);
            data.put("isVisited", visited);

            ctx.render("index.jte", data);
        } else {
            Map<String, Object> data = new HashMap<>();
            data.put("all", CoursesPage.getCourses());
            data.put("term", "");
            data.put("isVisited", visited);

            ctx.render("index.jte", data);
        }
        ctx.cookie("visited", String.valueOf(true));
    }

    public static void build(Context ctx) {
        ctx.render("addcourse.jte");
    }

    public static void addCourse(Context ctx) {
        String name = ctx.formParam("courseName");
            String desc = ctx.formParam("courseDes");
            try {
                name = ctx.formParamAsClass("courseName", String.class)
                        .check(value -> value.length() > 2, "Название курсов должно быть длиннее двух")
                        .get();

                desc = ctx.formParamAsClass("courseDes", String.class)
                        .check(value -> value.length() > 10, "Описание должно быть длиннее 10 символов")
                        .get();

                CoursesPage.addCourse(new Course(name, desc));

                ctx.redirect(Routes.coursesPath());
            }

            catch (ValidationException e) {
                CoursesPageBuild error = new CoursesPageBuild(name, desc, e.getErrors());
                ctx.render("addcourse.jte", model("pageBuild", error));
            }
    }

    public static void currentCourse(Context ctx) {
        long id = ctx.pathParamAsClass("id", Long.class).get();
        Course found = CoursesPage.find(id);
        ctx.render("currentCourse.jte", model("course", found));
        System.out.println(found.getName());

    }
}
