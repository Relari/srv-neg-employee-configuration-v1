# Documentación del API

**Componente:** business-api-employee-v1

## Descripción
Este API proporciona servicios para gestionar la información de empleados en una empresa.
Está desarrollado utilizando programación reactiva con `RxJava2` para mejorar la escalabilidad y la eficiencia en el manejo de solicitudes concurrentes.
Además, se han incluido pruebas unitarias con `JUnit` para garantizar la calidad del código y la funcionalidad de los endpoints.
La documentación `Swagger` facilita el acceso y la comprensión de los endpoints disponibles.

## Pre Requisitos

Debes tener instalado la base de datos de `postgresql` o tambien puedes utilizar el siguiente comando `Docker`

```
docker run -p 5432:5432 --name db_demo -e POSTGRES_PASSWORD=123456 -e POSTGRES_DB=DB_LOCAL_DEFAULT -d postgres:alpine
```

## Pruebas Unitarias
Se han incluido pruebas unitarias para verificar el correcto funcionamiento de los endpoints de empleados.
Puedes ejecutar estas pruebas utilizando el entorno de desarrollo de tu preferencia con soporte para JUnit.

## Documentación Swagger
La documentación completa de la API se encuentra disponible en Swagger.
Puedes acceder a ella ejecutando el API y visitando la URL http://localhost:8081/business/api/v1/employees/swagger-ui.html.

## Pruebas en Postman
Para probar los endpoints de este API utilizando Postman, sigue estos pasos:

* Descarga e instala Postman desde https://www.postman.com/downloads/.
* Abre Postman e importa la colección de pruebas proporcionada en el archivo API_Postman_Collection.json.
* Configura el entorno de Postman con la URL base del API (http://localhost:8081).
* Ejecuta las pruebas en la colección de Postman para verificar el funcionamiento de los endpoints.
