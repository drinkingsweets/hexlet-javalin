package org.example.hexlet;

import java.util.ArrayList;
import java.util.List;

public class CoursesPage {
    private List<Course> all; // Используем интерфейс List
    private String header;

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

    public String getHeader() {
        return header;
    }

    // Метод добавления курса с именем и описанием
    public void addCourse(Course course) {
        course.setId(all.size()); // Устанавливаем ID как индекс в списке
        all.add(course); // Добавляем в список
    }
}
