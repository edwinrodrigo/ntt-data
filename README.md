
# Prueba tecnica Microservicios - NTT - DATA

Creacion de ambiente bancario para gestionar clientes, cuentas y movimientos de las cuentas.

## Objetivo
Desarrollar una API RESTful utilizando Spring Boot que gestione la creacion clientes, cuentas de ahorro, corriente y a su vez los movimientos de la misma. El proyecto debe seguir buenas prácticas de desarrollo, aplicar principios SOLID, y utilizar las siguientes indicaciones: 

• Aplique todas las buenas prácticas, patrones Repository, etc que considere necesario 
(se tomará en cuenta este punto para la calificación).
• El manejo de entidades se debe manejar JPA / Entity Framework Core
• Se debe manejar mensajes de excepciones.
• Se debe realizar como mínimo dos pruebas unitarias de los endpoints.
• La solución se debe desplegar en Docker.
• Posterior a la entrega de este ejercicio, se estará agendando una entrevista técnica
donde el candidato deberá defender la solución planteada.

## Requisitos Técnicos

### Java
- Utilizar **Java 17** para la implementación.
- Aprovechar las características avanzadas de Java 17, como lambdas y streams, cuando sea apropiado.
- Utilizar **Maven** como gestor de dependencias.

### Spring Boot
- Construir la aplicación utilizando la version mas actual y estable disponible de Spring Boot.

### Base de Datos
- Utilizar una base de datos **POSTGRES** para almacenar la data
- Crear 3 tablas tablas: `clientes`, `cuentas` y `movimientos`.

### JPA
- Implementar una capa de persistencia utilizando **JPA** para manejar el almacenamiento y la recuperación la data.

## Funcionalidades

Se puede verificar las funcionalidades en el entorno de pruebas de swagger

Implementar en 2 microservicios, agrupando (Cliente, Persona) y (Cuenta, Movimientos) donde se contemple una comunicación asincrónica entre los 2 microservicios.

Cumplir las funcionalidades F1, F2, F3, F4, F5, F6, F7.
La solución debe contemplar (no necesariamente implementado) factores como: rendimiento, 
escalabilidad, resiliencia


## Documentación
- Se utilizo **OpenAPI** y **Swagger** para documentar de manera clara la API.

## Entregables

### Aplicacion BackEnd Repositorio en GitHub
-El proyecto esta compartido la siguiente ubicacion de Github

## Estructura del proyecto
Se crearon dos microservicios:
 -Microservicio Gestion Cliente: Este microservicios esta destinado a darle mantenimiento al cliente y exponer sus funcionalidades mediante el siguiente endpoint
    http://localhost:8081/nttdata-manager-api

 -Microservicio Transaccional: Este microservicio esta destinado a gestionar las cuentas de ahorros y corrientes de los clientes y tambien a darle funcionalidad a los movimientos de las mismas. Este microservicios ofrece su servicio en el siguiente endpoint
    http://localhost:8082/ntt-data-transactional-api

La estructura del proyecto es la siguiente

    ntt-data-repo
        |
        |__ ntt-data-manager-api  (Microservicio para mantener el cliente)
        |__ ntt-data-transactional-api  (Microservicio para mantener cuentas y movimientos)
        |__ docker-compose.yaml
        |__ NTT-Data.postman_collection (Archivo para importar en el postman)
        |__ script-dump-ntt-data
        |__ README.md

Para correr el proyecto con docker. Solo ejecutar el comando docker componse up --build en la raiz del proyecto