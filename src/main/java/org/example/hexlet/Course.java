package org.example.hexlet;

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
