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
Disponible en el puerto 8881
Versión inicial de la aplicación.
Se desea cambiar el atributo description por preface.
Se trata de un cambio incompatible, debemos dividirlo en fases.

## V2
Disponible en el puerto 8882
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
Disponible en el puerto 8883
#### BBDD:
- Copiamos la información de description en esta nueva columna preface porque pueden haberse dado de alta datos desde la V1 antes de pasar a este cambio.
- Quitamos la restricción de no nulo a description.

#### Java:
- Eliminamos el uso de description.
- Esta versión ya no es compatible con V1 por poder tener nulos en descripción.

## V4
Disponible en el puerto 8884
#### BBDD:
- Eliminamos description.
- Actualizamos preface para que los datos que fueran nulos tengan cadena vacía.
- Añadimos not null a preface.

#### Java:
- Ya no se utilizaba description.

## V5
Disponible en el puerto 8885
#### BBDD:
- Añadimos el campo price de tipo int.

#### Java:
- Añadimos el uso del campo price, no hemos actualizado la parte front de la aplicación al no ser necesaria.

## V6
Disponible en el puerto 8886
En la primera versión que hemos realizado hemos considerado que se trata de un cambio compatible, al dar de alta integers en un campo float no hay problemas.
Hemos hecho el cambio directamente en un único paso.
Al leer slack hemos visto que había que aplicar el enfoque de parallel change también en este cambio por lo que lo hemos aplicado en los siguientes pasos.

#### BBDD:
- Añadimos la nueva columna de new_price de tipo float.
- Copiamos la información de price en esta nueva columna float.

#### Java:
- Actualizamos la entidad new_price. 
  Al meter en el dato price, hacemos un Round del valor float.
  Devolvemos price en float en caso de no existir new_price.
- Al guardar el price debe guardar también en new_price.

## V7
#### BBDD:
- Copiamos la información de price en esta nueva columna float.

#### Java:
- Sólo usamos new_price

## V8
#### BBDD:
- Eliminamos la columna de price.

#### Java:
- Seguimos sólo usando new_price.

## V9
Queremos conseguir que el nombre del campo sea el mismo, es decir, que se llame price.

#### BBDD:
- Añadimos la columna de price con los datos de new_price.
- Actualizamos los datos en price de new_price.

#### Java:
- Guardamos en ambos, retornamos new_price en caso de no existir price.

## V10
En esta versión sólo usamos price.

#### BBDD:
- Añadimos la columna de price con los datos de new_price.

#### Java:
- Sólo usamos price

## V11
En esta versión sólo usamos price.

#### BBDD:
- Eliminamos la columna de new_price.
