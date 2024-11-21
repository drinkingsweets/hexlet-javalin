package org.example.hexlet;

public class Routes {

    public static String toCourses() {
        return "/";
    }

    public static String coursesPath() {
        return "/courses";
    }

    public static String addCoursesPath() {
        return "/courses/add";
    }

    public static String currentCourse() {
        return "/courses/{id}";
    }

    public static String loginPath() {
        return "/courses/login";
    }

}
