package org.example.hexlet;

import io.javalin.validation.ValidationError;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class CoursesPage extends Flash {
    private static String header;
    private static Map<String, List<ValidationError<Object>>> errors;

    public static List<Course> getCourses() {
        List<Course> courses = new ArrayList<>();
        String query = "SELECT id, name, description FROM courses";

        try (PreparedStatement statement = BaseRepository.dataSource.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                long id = resultSet.getLong("id");
                String name = resultSet.getString("name");
                String description = resultSet.getString("description");
                courses.add(new Course(id, name, description));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error fetching courses from database", e);
        }

        return courses;
    }

    public static Map<String, List<ValidationError<Object>>> getErrors() {
        return errors;
    }

    public static String getHeader() {
        return header;
    }

    public static Course find(long id) {
        String query = "SELECT id, name, description FROM courses WHERE id = ?";
        try (PreparedStatement statement = BaseRepository.dataSource.prepareStatement(query)) {
            statement.setLong(1, id);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    long id2 = resultSet.getLong("id");
                    String name = resultSet.getString("name");
                    String description = resultSet.getString("description");
                    return new Course(id2, name, description);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error fetching course by ID from database", e);
        }
        return null;
    }

    public static void setHeader(String newHeader) {
        header = newHeader;
    }

    public static void setErrors(Map<String, List<ValidationError<Object>>> newErrors) {
        errors = newErrors;
    }

     public static void addCourse(Course course) {
        long nextId = nextIndex();
        String query = "INSERT INTO courses (id, name, description) VALUES (?, ?, ?)";

        try (PreparedStatement statement = BaseRepository.dataSource.prepareStatement(query)) {
            statement.setLong(1, nextId);
            statement.setString(2, course.getName());
            statement.setString(3, course.getDescription());
            statement.executeUpdate();

            course.setId(nextId);
        } catch (SQLException e) {
            throw new RuntimeException("Error adding course to database", e);
        }
    }

    public static long nextIndex() {
        String query = "SELECT COALESCE(MAX(id), 0) + 1 AS next_id FROM courses";

        try (PreparedStatement statement = BaseRepository.dataSource.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {

            if (resultSet.next()) {
                return resultSet.getLong("next_id");
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error fetching next course index", e);
        }

        throw new RuntimeException("Unable to determine next course index");
    }
}
