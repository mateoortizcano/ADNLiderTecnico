# ADNLiderTecnico
Este repositorio contiene la solución al problema expuesto a continuación:
Problema:
Implementar
- un api rest (GET, POST) de personas(id,nombre, apellido,edad)
- usando un framework de aplicaciones autocontenidas (Spring boot, play, vertx, )
- usando arquitectura hexagonal
- con principios de diseño Solid
- pruebas unitarias
- pruebas de integración
- pruebas de carga (50 usuarios concurrentes las peticiones)
- pruebas de seguridad
- pruebas funcionales
- visual vm con volcado de hilos y memoria / profiling
- con opciones de jvm para producción
- y un front sencillo en angular/react

Las personas mayores a 18 años deberán ser publicadas en un exchange de rabbit mq y las menores en otro
deberá tener un consumir de ambas colas que escriba los mensajes en disco
