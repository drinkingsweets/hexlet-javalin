FROM gradle:7.4.0-jdk17

WORKDIR /app

COPY /app .

RUN gradle installDist

CMD src/main/java/org/example/hexlet/HelloWorld.java