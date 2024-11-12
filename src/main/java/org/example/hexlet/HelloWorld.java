package org.example.hexlet;

import io.javalin.Javalin;

public class HelloWorld {
    public static void main(String[] args) {
        var app = Javalin.create(config -> {
            config.bundledPlugins.enableDevLogging();
        });
        app.get("/users/{id}/post/{postId}", ctx -> {
                var userId = ctx.pathParamAsClass("id", Integer.class).get();
                var postId = ctx.pathParamAsClass("postId", Integer.class).get();
                ctx.result("Your id is: " + userId.toString() + "\nThis post id: " + postId.toString());
        });
        app.start(7070);
    }
}