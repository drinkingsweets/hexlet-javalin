package org.example.hexlet;

import io.javalin.validation.ValidationError;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CoursesPage {
    private List<Course> all; // Используем интерфейс List
    private String header;
    private Map<String, List<ValidationError<Object>>> errors;

    public CoursesPage(List<Course> courses, String header) {
        this.all = new ArrayList<>();
        for (Course course : courses) {
            this.addCourse(course);
        }
        this.header = header;
    }

    public List<Course> getCourses() {
        return all;
    }

    public Map<String, List<ValidationError<Object>>> getErrors() {
        return errors;
    }

    public String getHeader() {
        return header;
    }

    // Метод добавления курса с именем и описанием
    public void addCourse(Course course) {
        course.setId(all.size()); // Устанавливаем ID как индекс в списке
        all.add(course); // Добавляем в список
    }
}
