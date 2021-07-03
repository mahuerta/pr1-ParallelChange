# pr1-ParallelChange
Práctica 1. Parallel change

#Ejemplos
https://github.com/spring-cloud-samples/zero-downtime-deployment

https://spring.io/blog/2016/05/31/zero-downtime-deployment-with-a-database

##Pasos a seguir
    1 - Primero de todo preparamos el InitialCode a v1


V2: cambiamos los test también para que funcionen.
Lanzamos ambas aplicaciones simultáneamente con
mvn spring-boot:run

y lanzamos un curl:
curl http://localhost:8081/api/books/1




mvn -B -Dtest=RestTest test

mvn -B -Dtest=SeleniumTest test

mvn -B -Dtest=BookServiceUnitaryTest test


mvn spring-boot:run