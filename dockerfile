# Menggunakan image OpenJDK sebagai base image
FROM openjdk:17-jdk-slim

# Menentukan direktori kerja di dalam kontainer
WORKDIR /app

# Menyalin file JAR hasil build ke dalam kontainer
COPY target/product_management.jar product_management.jar

# Menentukan command untuk menjalankan aplikasi saat kontainer dijalankan
ENTRYPOINT ["java", "-jar", "product_management.jar"]