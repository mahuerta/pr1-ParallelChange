<h1 align="center"> Práctica 1. Parallel change 👨🏻‍💻 </h1>

<p align="center">
  <a href="/docs" target="_blank">
    <img alt="Documentation" src="https://img.shields.io/badge/documentation-yes-brightgreen.svg" />
  </a>
  <a href="#" target="_blank">
    <img alt="License: MIT" src="https://img.shields.io/badge/License-MIT-yellow.svg" />
  </a>
</p>

Proyecto para realizar cambios en una aplicación en caliente, sin parada de servicio.

## Authors

👤 **JuanCBM**: Juan Carlos Blázquez Muñoz

* Github: [@JuanCBM](https://github.com/JuanCBM)

👤 **mahuerta**: Miguel Ángel Huerta Rodríguez

* Github: [@mahuerta](https://github.com/mahuerta)

## Sobre la aplicación
Hemos ido ejecutando y actualizando los test en cada versión.

Para ejecutar la aplicación necesitamos una versión de mysql8, en nuestro caso la lanzamos en un contenedor docker: 
> docker run --rm --name mysql -d -e MYSQL_ROOT_PASSWORD=pass -e MYSQL_DATABASE=test -p 3306:3306 mysql:8

## V1
Versión inicial de la aplicación.
Se desea cambiar el atributo description por preface.
Se trata de un cambio incompatible, debemos dividirlo en fases.

## V2
#### BBDD:
- Añadimos la nueva columna de preface con la misma longitud que description.
- Copiamos la información de description en esta nueva columna preface.

#### Java:
- Actualizamos la entidad preface que debe protegerse ante valores vacíos. Al obtener el dato devolvemos description en caso de no existir preface.
- Al guardar el preface debe guardar también en description.

Así los datos introducidos en la versión 1 también serán consultables por la versión 2 y al revés.
Se tratan de versiones compatibles entre sí.

Hemos aprovechado para actualizar los test de Selenium y los templates del front.

## V3
#### BBDD:
- Copiamos la información de description en esta nueva columna preface porque pueden haberse dado de alta datos desde la V1 antes de pasar a este cambio.
- Quitamos la restricción de no nulo a description.

#### Java:
- Eliminamos el uso de description.
- Esta versión ya no es compatible con V1 por poder tener nulos en descripción.

## V4
#### BBDD:
- Eliminamos description.
- Actualizamos preface para que los datos que fueran nulos tengan cadena vacía.
- Añadimos not null a preface.

#### Java:
- Ya no se utilizaba description.

## V5
#### BBDD:
- Añadimos el campo price de tipo int.

#### Java:
- Añadimos el uso del campo price, no hemos actualizado la parte front de la aplicación al no ser necesaria.

## V6
Hemos considerado que se trata de un cambio compatible, al dar de alta integers en un campo float no hay problemas.
#### BBDD:
- Hacemos el cambio del campo de tipo int a tipo float.

#### Java:
- Actualizamos los tipos de Integer a Float.

