package org.example.hexlet;

public final class Course {
    private long id;

    public long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Course(Long id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    private String name;
    private String description;

    public Course(long id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }
}
