package org.example.hexlet;

import io.javalin.validation.ValidationError;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CoursesPage {
    // Статические поля
    private static List<Course> all = new ArrayList<>(); // Инициализируем список сразу
    private static String header;
    private static Map<String, List<ValidationError<Object>>> errors;

    // Геттеры для статических полей
    public static List<Course> getCourses() {
        return all;
    }


    public static Map<String, List<ValidationError<Object>>> getErrors() {
        return errors;
    }

    public static String getHeader() {
        return header;
    }

    public static Course find(long id) {
        for(Course course: all) {
            if (course.getId() == id) {
                return course;
            }
        }
        return null;
    }

    // Сеттеры для обновления статических полей
    public static void setHeader(String newHeader) {
        header = newHeader;
    }

    public static void setErrors(Map<String, List<ValidationError<Object>>> newErrors) {
        errors = newErrors;
    }

    // Метод добавления курса с именем и описанием
    public static void addCourse(Course course) {
        course.setId(all.size()); // Устанавливаем ID как индекс в списке
        all.add(course); // Добавляем в список
    }
}
