# Título del Proyecto

Consulta el precio vigente en una fecha/hora determinada para un producto concreto

### Pre-requisitos

Java 17
Maven 3.9.5

### Instalación

Microservicio desarrollado con Spring-boot

## Ejecución de pruebas de integración

Ejecutar en entorno de test /ecommerce-price-capitole-boot/src/test/java/com/capitole/ecommerce/price/IntegrationTest.java

## Ejecución de pruebas end to end

Levantar el servicio (mvn spring-boot:run) y ejecutar las siguientes pruebas:

http://localhost:8080/brand/1/product/35455/price?selectedDate=2020-06-14T10:00:00Z
http://localhost:8080/brand/1/product/35455/price?selectedDate=2020-06-14T16:00:00Z
http://localhost:8080/brand/1/product/35455/price?selectedDate=2020-06-14T21:00:00Z
http://localhost:8080/brand/1/product/35455/price?selectedDate=2020-06-15T10:00:00Z
http://localhost:8080/brand/1/product/35455/price?selectedDate=2020-06-16T21:00:00Z

## Construido con

* [Java] 17
* [Spring-boot] 3.2.1
* [Maven] 3.9.5
* [Open-Api] 2.1.0
* [JUnit] 5