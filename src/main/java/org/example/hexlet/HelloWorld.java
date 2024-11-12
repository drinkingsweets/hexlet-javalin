package org.example.hexlet;

import io.javalin.Javalin;

public class HelloWorld {
    public static void main(String[] args) {
        var app = Javalin.create(config -> {
            config.bundledPlugins.enableDevLogging();
        });
        app.get("/hello", ctx -> ctx.result("Hello, "+ ctx.queryParamAsClass("name", String.class)
                .getOrDefault("World") + "!"));
        app.start(7070);
    }
}