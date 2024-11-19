package org.example.hexlet;

import io.javalin.validation.ValidationError;

import java.util.List;
import java.util.Map;

public final class Course {
    private long id;
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

    public long getId() {
        return id;
    }


    private String name;
    private String description;

    public Course(String name, String description) {
        this.id = -1;
        this.name = name;
        this.description = description;
    }
    public void setId(long id) {
        this.id = id;
    }
}
