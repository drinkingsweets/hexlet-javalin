package org.example.hexlet;

import io.javalin.validation.ValidationError;

import java.util.List;
import java.util.Map;

public class CoursesPageBuild {
    private String name;
    private String description;
    private Map<String, List<ValidationError<Object>>> errors;

    public CoursesPageBuild(String name, String description, Map<String, List<ValidationError<Object>>> errors) {
        this.name = name;
        this.description = description;
        this.errors = errors;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Map<String, List<ValidationError<Object>>> getErrors() {
        return errors;
    }

    public void setErrors(Map<String, List<ValidationError<Object>>> errors) {
        this.errors = errors;
    }
}
