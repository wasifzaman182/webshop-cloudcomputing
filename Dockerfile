FROM openjdk:8
EXPOSE 8080
ADD target/webshop.jar webshop.jar
ENTRYPOINT ["java","-jar","webshop.jar"]