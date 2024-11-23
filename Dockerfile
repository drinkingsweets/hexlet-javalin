# Используем официальный образ JDK
FROM openjdk:17

# Устанавливаем рабочую директорию внутри контейнера
WORKDIR /app

# Копируем весь проект в контейнер
COPY src/main/java/org/example/hexlet .

# Скачиваем зависимости и собираем проект
RUN ./gradlew build

# Запуск приложения (укажи название собранного jar-файла)
CMD ["java", "-jar", "build/libs/hexlet-javalin.jar"]
