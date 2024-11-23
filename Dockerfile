# Используем официальный образ JDK
FROM openjdk:17

# Устанавливаем рабочую директорию внутри контейнера
WORKDIR /app

# Копируем весь проект в контейнер
COPY src/main/java/org/example/hexlet .

RUN chmod +x ./gradlew

# Скачиваем зависимости и собираем проект
RUN ./gradlew run

# Запуск приложения (укажи название собранного jar-файла)
CMD ["java", "-jar", "build/libs/hexlet-javalin.jar"]
