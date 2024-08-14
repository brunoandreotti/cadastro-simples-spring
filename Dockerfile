#Define o inicio do build de uma nova imagem
FROM gradle:8.8-jdk21-alpine AS build

#Cria um novo diretório de trabalho
WORKDIR /app

#Copia as arquivos da raiz do projeto para o caminho definido no workdir
COPY build.gradle settings.gradle gradlew ./

#Copia a pasta para o caminho definido no workdir
COPY gradle/ gradle/

#Copia a pasta "src" do projeto que contém todo o código do projeto para uma pasta "src" dentro do workdir
COPY src/ src/


#Executa o buildo do projeto com o Gradle dentro do workdir
RUN ./gradlew clean build

#Informa que será utilizado o Java 21
FROM openjdk:21-jdk-slim

#Informa que a porta utilizada pela aplifcação será a 8080
EXPOSE 8080

#Copia de dentro do build, o .jar gerado pelo gradle e renomeia para "app.jar"
COPY --from=build /app/build/libs/*.jar app.jar

#Executa o comando para rodar o .jar utilizando o java
ENTRYPOINT ["java", "-jar", "app.jar" ]
